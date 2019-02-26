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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.HealthStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2016.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2016.Error2016;
import com.servinglynk.hmis.warehouse.model.v2016.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class HealthStatusDaoImpl extends ParentDaoImpl implements
		HealthStatusDao {
	private static final Logger logger = LoggerFactory
			.getLogger(HealthStatusDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		com.servinglynk.hmis.warehouse.model.v2016.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2016.Export) getModel(com.servinglynk.hmis.warehouse.model.v2016.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus.class, getProjectGroupCode(domain));
		List<HealthStatus> healthStatuses = domain.getExport().getHealthStatus();
		if(healthStatuses !=null &&  !healthStatuses.isEmpty())
		{
			for(HealthStatus healthStatus : healthStatuses )
			{
				com.servinglynk.hmis.warehouse.model.v2016.HealthStatus healthStatusModel = null;
				try {
					healthStatusModel = getModelObject(domain, healthStatus,data,modelMap);
					healthStatusModel.setDueDate(BasicDataGenerator.getLocalDateTime(healthStatus.getDueDate()));
					healthStatusModel.setHealthCategory(HealthStatusHealthCategoryEnum.lookupEnum(BasicDataGenerator.getStringValue(healthStatus.getHealthCategory())));
					healthStatusModel.setHealthStatus(HealthStatusHealthStatusEnum.lookupEnum(BasicDataGenerator.getStringValue(healthStatus.getHealthStatus())));
					healthStatusModel.setInformationDate(BasicDataGenerator.getLocalDateTime(healthStatus.getInformationDate()));
					healthStatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(healthStatus.getDateCreated()));
					healthStatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthStatus.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,healthStatus.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap , domain.getUpload().getId());
					healthStatusModel.setEnrollmentid(enrollmentModel);
					healthStatusModel.setExport(exportEntity);
					healthStatusModel.setInformationDate(BasicDataGenerator.getLocalDateTime(healthStatus.getInformationDate()));
					healthStatusModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(healthStatus.getDataCollectionStage())));
					performSaveOrUpdate(healthStatusModel);
				}catch(Exception e){
					String errorMessage = "Exception beause of the healthStatus::"+healthStatus.getHealthStatusID() +" Exception ::"+e.getMessage();
					if(healthStatusModel != null){
						Error2016 error = new Error2016();
						error.model_id = healthStatusModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = healthStatusModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = healthStatusModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
      	  }
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2016.HealthStatus.class.getSimpleName(), domain, exportEntity);
		}


	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
	public com.servinglynk.hmis.warehouse.model.v2016.HealthStatus getModelObject(ExportDomain domain, HealthStatus healthStatus ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2016.HealthStatus modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2016.HealthStatus) getModel(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus.class, healthStatus.getHealthStatusID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2016.HealthStatus();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2016.HealthStatus model = new com.servinglynk.hmis.warehouse.model.v2016.HealthStatus();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(healthStatus.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,healthStatus.getHealthStatusID(),data);
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2016.HealthStatus createHealthStatus(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus HealthStatus){
	       HealthStatus.setId(UUID.randomUUID());
	       insert(HealthStatus);
	       return HealthStatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2016.HealthStatus updateHealthStatus(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus HealthStatus){
	       update(HealthStatus);
	       return HealthStatus;
	   }
	   public void deleteHealthStatus(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus HealthStatus){
	       delete(HealthStatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2016.HealthStatus getHealthStatusById(UUID HealthStatusId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus.class);
		      criteria.add(Restrictions.eq("id", HealthStatusId));
		      List<com.servinglynk.hmis.warehouse.model.v2016.HealthStatus> entities = (List<com.servinglynk.hmis.warehouse.model.v2016.HealthStatus>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2016.HealthStatus> getAllEnrollmentHealthStatuses(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2016.HealthStatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentHealthStatusesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.HealthStatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
