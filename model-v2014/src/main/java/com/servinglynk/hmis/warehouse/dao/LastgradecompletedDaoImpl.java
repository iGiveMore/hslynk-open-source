/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Inventory;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastGradeCompleted;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class LastgradecompletedDaoImpl extends ParentDaoImpl implements
		LastgradecompletedDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LastgradecompletedDaoImpl.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.
	 * hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<LastGradeCompleted> lastGradeCompletedList = domain.getExport()
				.getLastGradeCompleted();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Lastgradecompleted.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if (CollectionUtils.isNotEmpty(lastGradeCompletedList)) {
			for(LastGradeCompleted e  : lastGradeCompletedList) {
				processData(e, domain, data, modelMap, relatedModelMap, exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class.getSimpleName(), domain,exportEntity);
	}
	
	
	public void processData(LastGradeCompleted lastGradeCompleted,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
		Lastgradecompleted model = null;
		try {
			model =  getModelObject(domain, lastGradeCompleted,data,modelMap);
			model
			.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum
					.lookupEnum(BasicDataGenerator
							.getStringValue(lastGradeCompleted
									.getLastGradeCompleted())));
			
			model.setDateCreatedFromSource(BasicDataGenerator
					.getLocalDateTime(lastGradeCompleted.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator
					.getLocalDateTime(lastGradeCompleted.getDateUpdated()));
			Enrollment enrollmentModel = (Enrollment) getModel(Lastgradecompleted.class.getSimpleName(),Enrollment.class, lastGradeCompleted.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
			model.setEnrollmentid(enrollmentModel);
			model.setExport(exportEntity);
			
			performSaveOrUpdate(model);
		}catch(Exception e) {
			String errorMessage = "Failure in LastGradeCompleted:::"+lastGradeCompleted.toString()+ " with exception"+e.getLocalizedMessage();
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
	
	public com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted getModelObject(ExportDomain domain,LastGradeCompleted lastGradeCompleted ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted) getModel(Lastgradecompleted.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class, lastGradeCompleted.getLastGradeCompletedID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted model = new com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(lastGradeCompleted.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,lastGradeCompleted.getLastGradeCompletedID(),data);
		
		return model;
	}
}
