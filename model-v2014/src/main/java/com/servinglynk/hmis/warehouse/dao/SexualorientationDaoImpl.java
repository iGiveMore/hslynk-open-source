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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SexualOrientation;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class SexualorientationDaoImpl extends ParentDaoImpl implements
		SexualorientationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(SexualorientationDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<SexualOrientation> sexualOrientations = domain.getExport().getSexualOrientation();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Sexualorientation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(sexualOrientations !=null && !sexualOrientations.isEmpty())
		{
			for(SexualOrientation sexualOrientation : sexualOrientations)
			{
				Sexualorientation model = null;
				try {
					model = getModelObject(domain, sexualOrientation,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(sexualOrientation.getDateUpdated()));
					model.setSexualorientation(SexualorientationSexualorientationEnum.lookupEnum(BasicDataGenerator.getStringValue(sexualOrientation.getSexualOrientation())));
					Enrollment enrollmentModel = (Enrollment) getModel(Sexualorientation.class.getSimpleName(),Enrollment.class,sexualOrientation.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
					model.setInformationDate(BasicDataGenerator.getLocalDateTime(sexualOrientation.getInformationDate()));
					model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(sexualOrientation.getDataCollectionStage())));
					
					performSaveOrUpdate(model);
				} catch(Exception e) {
					String errorMessage = "Failure in Sexualorientation:::"+sexualOrientation.toString()+ " with exception"+e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation getModelObject(ExportDomain domain,SexualOrientation sexualorientation ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation) getModel(Sexualorientation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class, sexualorientation.getSexualOrientationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation model = new com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(sexualorientation.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,sexualorientation.getSexualOrientationID(),data);
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation createSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       sexualorientation.setId(UUID.randomUUID()); 
	       insert(sexualorientation);
	       return sexualorientation;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation updateSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       update(sexualorientation);
	       return sexualorientation;
	   }
	   public void deleteSexualorientation(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation sexualorientation){
	       delete(sexualorientation);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation getSexualorientationById(UUID sexualorientationId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class);
		      criteria.add(Restrictions.eq("id", sexualorientationId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation> getAllEnrollmentSexualorientations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentSexualorientationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
