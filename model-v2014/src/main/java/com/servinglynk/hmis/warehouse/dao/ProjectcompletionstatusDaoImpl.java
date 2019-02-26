/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectcompletionstatusDaoImpl extends ParentDaoImpl implements
		ProjectcompletionstatusDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ProjectcompletionstatusDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ProjectCompletionStatus> projectCompletionStatusList = domain.getExport().getProjectCompletionStatus();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Projectcompletionstatus.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(projectCompletionStatusList !=null && !projectCompletionStatusList.isEmpty()) 
		{
			for(ProjectCompletionStatus projectCompletionStatus : projectCompletionStatusList)
			{
				Projectcompletionstatus model = null;
				try {
					model = getModelObject(domain, projectCompletionStatus,data,modelMap);
					model.setEarlyexitreason(ProjectcompletionstatusEarlyexitreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getEarlyExitReason())));
					model.setProjectcompletionstatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getProjectCompletionStatus())));
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(projectCompletionStatus.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(projectCompletionStatus.getDateUpdated()));
					Exit exit = (Exit) getModel(Projectcompletionstatus.class.getSimpleName(),Exit.class, projectCompletionStatus.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setExitid(exit);
					model.setExport(exportEntity);
					
					performSaveOrUpdate(model);
				} catch(Exception e) {
					 String errorMessage = "Failure in Projectcompletionstatus:::"+projectCompletionStatus.toString()+ " with exception"+e.getLocalizedMessage();
					if (model != null) {
						Error2014 error = new Error2014();
						error.model_id = model.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = model.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = model.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus getModelObject(ExportDomain domain,ProjectCompletionStatus projectcompletionstatus ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus) getModel(Projectcompletionstatus.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class, projectcompletionstatus.getProjectCompletionStatusID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus model = new com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(projectcompletionstatus.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,projectcompletionstatus.getProjectCompletionStatusID(),data);
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus createProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus){
	       projectCompletionStatus.setId(UUID.randomUUID()); 
	       insert(projectCompletionStatus);
	       return projectCompletionStatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus updateProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus){
	       update(projectCompletionStatus);
	       return projectCompletionStatus;
	   }
	   public void deleteProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus){
	       delete(projectCompletionStatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus getProjectCompletionStatusById(UUID projectCompletionStatusId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class);
		      criteria.add(Restrictions.eq("id", projectCompletionStatusId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus> getAllExitProjectCompletionStatuses(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitProjectCompletionStatusesCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
