/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2020.Project;

/**
 * @author Sandeep
 *
 */
public interface ProjectDao extends ParentDao {
	   com.servinglynk.hmis.warehouse.model.v2020.Project createProject(com.servinglynk.hmis.warehouse.model.v2020.Project project);
	   com.servinglynk.hmis.warehouse.model.v2020.Project updateProject(com.servinglynk.hmis.warehouse.model.v2020.Project project);
	   void deleteProject(com.servinglynk.hmis.warehouse.model.v2020.Project project);
	   com.servinglynk.hmis.warehouse.model.v2020.Project getProjectById(UUID projectId);
	   List<com.servinglynk.hmis.warehouse.model.v2020.Project> getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems);
	   long getProjectCount(String getAllProjects);
	   void populateUserProjectGroupCode(HmisBaseModel model,String caller);
	   com.servinglynk.hmis.warehouse.model.v2020.Project checkProjectExists(String projectName, String sourceSystemId);
	List<Project> getProjectsForExport(String projectGroupCode, List<String> projectIds, LocalDateTime startDate,
			LocalDateTime endDate);
}
