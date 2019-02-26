package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.core.model.Project;
import com.servinglynk.hmis.warehouse.service.ProjectService;
import com.servinglynk.hmis.warehouse.service.converter.ProjectConverter;
import com.servinglynk.hmis.warehouse.core.model.Projects;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.service.exception.OrganizationNotFoundException;
import com.servinglynk.hmis.warehouse.service.exception.ProjectNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.converter.AccountConverter;


public class ProjectServiceImpl extends ServiceBase implements ProjectService  {

   @Transactional
   public Project createProject(Project project,String caller){
	   HmisUser user = daoFactory.getAccountDao().findByUsername(caller);
       com.servinglynk.hmis.warehouse.model.v2014.Project pProject = ProjectConverter.modelToEntity(project, null);
       if(project.getOrganizationId()!=null) {
    	   com.servinglynk.hmis.warehouse.model.v2014.Organization pOrganization = daoFactory.getOrganizationDao().getOrganizationById(project.getOrganizationId());
    	   	if(pOrganization==null) throw new OrganizationNotFoundException();
    	   pProject.setOrganizationid(pOrganization);
       }
       pProject.setDateCreated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
       pProject.setUserId(user.getId());       
       pProject.setProjectGroupCode(user.getProjectGroupEntity().getProjectGroupCode());
       boolean projectExists = false;
       com.servinglynk.hmis.warehouse.model.v2014.Project cProject =null;
       if(project.getSourceSystemId()!=null) {
    	    cProject =  daoFactory.getProjectDao().checkProjectExists(project.getProjectName(),project.getSourceSystemId());
    	   if(cProject!=null) projectExists = true;
       }
       
       if(!projectExists) {
       daoFactory.getProjectDao().createProject(pProject);
       project.setProjectId(pProject.getId());
       
       BaseProject baseProject = new BaseProject();
       BeanUtils.copyProperties(project, baseProject);
       baseProject.setSchemaYear(2014);
       project.setProjectId(pProject.getId());
       }else {
          project.setProjectId(cProject.getId());
       }
       serviceFactory.getGlobalProjectService().manageGlobalProjects(ProjectConverter.modelToGlobalProject(project), "2014", AccountConverter.convertToAccount(user));
     //  serviceFactory.getBaseProjectService().createProject(baseProject, project.getOrganizationId(), caller);
       return project;

   }

   @Transactional
   public Project updateProject(Project project,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Project pProject = daoFactory.getProjectDao().getProjectById(project.getProjectId());
       if(pProject==null) throw new ProjectNotFoundException();

       ProjectConverter.modelToEntity(project, pProject);
       pProject.setDateUpdated((new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
   //    pProject.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
       daoFactory.getProjectDao().updateProject(pProject);
       project.setProjectId(pProject.getId());
       return project;
   }

   @Transactional
   public Project deleteProject(UUID projectId,String caller){
       com.servinglynk.hmis.warehouse.model.v2014.Project pProject = daoFactory.getProjectDao().getProjectById(projectId);
       if(pProject==null) throw new ProjectNotFoundException();

       daoFactory.getProjectDao().deleteProject(pProject);
       return new Project();
   }

   @Transactional
   public Project getProjectById(UUID projectId){
       com.servinglynk.hmis.warehouse.model.v2014.Project pProject = daoFactory.getProjectDao().getProjectById(projectId);
       if(pProject==null) throw new ProjectNotFoundException();

       return ProjectConverter.entityToModel( pProject );
   }

   @Transactional
   public Projects getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems){
       Projects projects = new Projects();
        List<com.servinglynk.hmis.warehouse.model.v2014.Project> entities = daoFactory.getProjectDao().getAllProjects(projectGroupCode,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2014.Project entity : entities){
           projects.addProject(ProjectConverter.entityToModel(entity));
        }
        long count = daoFactory.getProjectDao().getProjectCount(projectGroupCode);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(projects.getProjects().size());
        pagination.setTotal((int)count);
        projects.setPagination(pagination);
        return projects; 
   }


}
