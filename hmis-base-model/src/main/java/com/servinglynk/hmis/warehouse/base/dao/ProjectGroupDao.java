package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;

public interface ProjectGroupDao extends BaseDao {

	com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity createProjectGroup(com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGroupEntity);
	com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity updateProjectGroup(com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGroupEntity);	
	void deleteProjectGroup(com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity projectGroupEntity);
	ProjectGroupEntity getProjectGroupById(UUID projectGroupId);
	ProjectGroupEntity getProjectGroupByGroupCode(String projectGroupCode);
	List<com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity> getAllProjectGroups(Integer startIndex, Integer maxItems);
	long getProjectGroupCount();
	List<ProjectGroupEntity> getAllActiveProjectGroups();
	List<String> getAllActiveProjectGroupCodes();	
}