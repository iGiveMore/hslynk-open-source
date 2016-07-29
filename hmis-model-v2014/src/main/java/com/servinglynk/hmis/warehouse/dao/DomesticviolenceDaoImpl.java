package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DomesticViolence;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class DomesticviolenceDaoImpl extends ParentDaoImpl implements
		DomesticviolenceDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DomesticviolenceDaoImpl.class);
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
		java.util.List<DomesticViolence> domesticViolenceList = domain.getExport().getDomesticViolence();
		Long i=new Long(0L);
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Domesticviolence.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(domesticViolenceList!=null && !domesticViolenceList.isEmpty())
		{
			for(DomesticViolence domesticViolence : domesticViolenceList)
			{
				Domesticviolence domesticviolenceModel = null;
				try {
					domesticviolenceModel = getModelObject(domain, domesticViolence,data,modelMap);
					domesticviolenceModel.setDomesticviolencevictim(DomesticviolenceDomesticviolencevictimEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getDomesticViolenceVictim())));
					domesticviolenceModel.setWhenoccurred(DomesticviolenceWhenoccurredEnum.lookupEnum(BasicDataGenerator.getStringValue(domesticViolence.getWhenOccurred())));
					domesticviolenceModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateCreated()));
					domesticviolenceModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(domesticViolence.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Domesticviolence.class.getSimpleName(),Enrollment.class,domesticViolence.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());;
					domesticviolenceModel.setEnrollmentid(enrollmentModel);
					domesticviolenceModel.setExport(exportEntity);
					performSaveOrUpdate(domesticviolenceModel);
				}catch (Exception e) {
					String errorMessage = "Exception in:"+domesticViolence.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
					if (domesticviolenceModel != null) {
						Error2014 error = new Error2014();
						error.model_id = domesticviolenceModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = domesticviolenceModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = domesticviolenceModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
				
			}
		}

	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence getModelObject(ExportDomain domain, DomesticViolence domesticViolence ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolenceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			domesticViolenceModel = (com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence) getModel(Domesticviolence.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class, domesticViolence.getDomesticViolenceID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domesticViolenceModel == null) {
			domesticViolenceModel = new com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence();
			domesticViolenceModel.setId(UUID.randomUUID());
			domesticViolenceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(domesticViolenceModel, domain,domesticViolence.getDomesticViolenceID(),data.i+data.j);
		return domesticViolenceModel;
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence createDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence){
	       domesticViolence.setId(UUID.randomUUID()); 
	       insert(domesticViolence);
	       return domesticViolence;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence updateDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence){
	       update(domesticViolence);
	       return domesticViolence;
	   }
	   public void deleteDomesticViolence(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence domesticViolence){
	       delete(domesticViolence);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence getDomesticViolenceById(UUID domesticViolenceId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence) get(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class, domesticViolenceId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence> getAllEnrollmentDomesticViolences(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDomesticViolencesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
	
}
