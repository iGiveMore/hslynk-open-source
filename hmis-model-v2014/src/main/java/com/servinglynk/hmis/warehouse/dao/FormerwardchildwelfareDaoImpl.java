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

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FamilyReunification;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FormerwardchildwelfareDaoImpl extends ParentDaoImpl implements
		FormerwardchildwelfareDao {
	private static final Logger logger = LoggerFactory
			.getLogger(FormerwardchildwelfareDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<FormerWardChildWelfare> formerWardChildWelfares = domain.getExport().getFormerWardChildWelfare();
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Formerwardchildwelfare.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(CollectionUtils.isNotEmpty(formerWardChildWelfares))
		{
			for(FormerWardChildWelfare e :formerWardChildWelfares) {
				processData(e, domain, data, modelMap, relatedModelMap, exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class.getSimpleName(), domain, exportEntity);
	}
	
	
	public void processData(FormerWardChildWelfare formerWardChildWelfare,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
		Formerwardchildwelfare model = null;
		try {
			model = getModelObject(domain, formerWardChildWelfare,data,modelMap);
			model.setChildwelfaremonths(BasicDataGenerator.getIntegerValue(formerWardChildWelfare.getChildWelfareMonths()));
			model.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getChildWelfareYears())));
			model.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getFormerWardChildWelfare())));
			model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateUpdated()));
			Enrollment enrollmentModel = (Enrollment) getModel(Formerwardchildwelfare.class.getSimpleName(),Enrollment.class, formerWardChildWelfare.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
			model.setExport(exportEntity);
			model.setEnrollmentid(enrollmentModel);
			model.setInformationDate(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getInformationDate()));
			model.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getDataCollectionStage())));
			performSaveOrUpdate(model);
		}catch(Exception e) {
			String errorMessage = "Exception in:"+formerWardChildWelfare.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
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
	public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare getModelObject(ExportDomain domain, FormerWardChildWelfare formerWardChildWelfare ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare) getModel(Formerwardchildwelfare.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class, formerWardChildWelfare.getFormerWardChildWelfareID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare model = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,formerWardChildWelfare.getFormerWardChildWelfareID(),data);
		
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare createFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       formerWardChildWelfare.setId(UUID.randomUUID()); 
	       insert(formerWardChildWelfare);
	       return formerWardChildWelfare;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare updateFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       update(formerWardChildWelfare);
	       return formerWardChildWelfare;
	   }
	   public void deleteFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       delete(formerWardChildWelfare);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare getFormerWardChildWelfareById(UUID formerWardChildWelfareId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class);
		      criteria.add(Restrictions.eq("id", formerWardChildWelfareId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare> getAllEnrollmentFormerWardChildWelfares(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentFormerWardChildWelfaresCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
