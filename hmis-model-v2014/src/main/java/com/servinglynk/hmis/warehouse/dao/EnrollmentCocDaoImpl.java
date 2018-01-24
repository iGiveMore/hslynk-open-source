/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentCocDaoImpl extends ParentDaoImpl implements
		EnrollmentCocDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(EnrollmentCocDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
		List<EnrollmentCoC> enrollmentCoCs = domain.getExport().getEnrollmentCoC();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(EnrollmentCoc.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class, getProjectGroupCode(domain));
		Map<String,HmisBaseModel> projectCocModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class, getProjectGroupCode(domain));
		if(CollectionUtils.isNotEmpty(enrollmentCoCs))
		{
			for(EnrollmentCoC enrollmentCoC: enrollmentCoCs) {
				processData(enrollmentCoC, domain, data, modelMap, relatedModelMap, projectCocModelMap, exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, EnrollmentCoc.class.getSimpleName(), domain, exportEntity);
	}
	
	public void processData(EnrollmentCoC enrollmentCoc,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,Map<String,HmisBaseModel> projectCocModelMap, com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
		EnrollmentCoc model = null;
		try {
		model = getModelObject(domain, enrollmentCoc,data,modelMap);
		model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateCreated()));
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateUpdated()));
		Enrollment enrollmentModel = (Enrollment) getModel(EnrollmentCoc.class.getSimpleName(),Enrollment.class,enrollmentCoc.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
		model.setEnrollmentid(enrollmentModel);
			Projectcoc projectCoc = (Projectcoc) getModel(EnrollmentCoc.class.getSimpleName(),Projectcoc.class,enrollmentCoc.getProjectCoCID(),getProjectGroupCode(domain),false,projectCocModelMap, domain.getUpload().getId());
		model.setProjectCoc(projectCoc);	
		model.setCocCode(enrollmentCoc.getCocCode());
		model.setExport(exportEntity);
		model.setInformationDate(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getInformationDate()));
		model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollmentCoc.getDataCollectionStage())));
		performSaveOrUpdate(model);
	} catch (Exception e) {
		String errorMessage = "Error occured with "+enrollmentCoc.toString() + " Execption :::"+e.getLocalizedMessage();
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
	public com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc getModelObject(ExportDomain domain, EnrollmentCoC enrollmentCoc ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc) getModel(EnrollmentCoc.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class, enrollmentCoc.getEnrollmentCoCID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc model = new com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,enrollmentCoc.getEnrollmentCoCID(),data);
		return model;
	}
	

	   public com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc createEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCoc){
	       enrollmentCoc.setId(UUID.randomUUID()); 
	       insert(enrollmentCoc);
	       return enrollmentCoc;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc updateEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCoc){
	       update(enrollmentCoc);
	       return enrollmentCoc;
	   }
	   public void deleteEnrollmentCoc(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCoc){
	       delete(enrollmentCoc);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc getEnrollmentCocById(UUID enrollmentCocId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class);
		      criteria.add(Restrictions.eq("id", enrollmentCocId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc> getAllEnrollmentEnrollmentCocs(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentEnrollmentCocsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }


	public com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc getEnrollmentCocByDedupEnrollmentCocId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc> enrollmentCoc = (List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc>) findByCriteria(criteria);
		if(enrollmentCoc !=null && enrollmentCoc.size()>0) return enrollmentCoc.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc> getAllEnrollmentCoc(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class);	
		List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc> enrollmentCoc = (List<com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc>) findByCriteria(criteria,startIndex,maxItems);
		return enrollmentCoc;
	}
	
	
	public long getEnrollmentCocCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class);	
		return countRows(criteria);
	}

}
