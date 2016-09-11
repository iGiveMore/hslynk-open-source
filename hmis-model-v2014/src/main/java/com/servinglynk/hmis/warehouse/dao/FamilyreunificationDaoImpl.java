/**
 * 
 */
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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FamilyReunification;
import com.servinglynk.hmis.warehouse.enums.FamilyreunificationFamilyreunificationachievedEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Familyreunification;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FamilyreunificationDaoImpl extends ParentDaoImpl implements
		FamilyreunificationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(FamilyreunificationDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<FamilyReunification> familyReunifications = domain.getExport().getFamilyReunification();
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(familyReunifications!=null && familyReunifications.size() >0 ) 
		{
			for(FamilyReunification familyReunification : familyReunifications)
			{
				Familyreunification model = null;
				try {
					model = getModelObject(domain, familyReunification,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(familyReunification.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(familyReunification.getDateUpdated()));
					model.setFamilyreunificationachieved(FamilyreunificationFamilyreunificationachievedEnum.lookupEnum(BasicDataGenerator.getStringValue(familyReunification.getFamilyReunificationAchieved())));
					Exit exit = (Exit) getModel(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class.getSimpleName(),Exit.class, familyReunification.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setExitid(exit);
					model.setExport(exportEntity);
					HmisBaseModel hmisBaseModel = modelMap.get(model.getSourceSystemId());
					if(hmisBaseModel !=null ) {
						modelMatch(hmisBaseModel, model);
					}
					performSaveOrUpdate(model);
				}catch (Exception e) {
					String errorMessage = "Exception in:"+familyReunification.getFamilyReunificationID()+  ":: Exception" +e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Familyreunification getModelObject(ExportDomain domain, FamilyReunification familyReunification ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunificationModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			familyReunificationModel = (com.servinglynk.hmis.warehouse.model.v2014.Familyreunification) getModel(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class, familyReunification.getFamilyReunificationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(familyReunificationModel == null) {
			familyReunificationModel = new com.servinglynk.hmis.warehouse.model.v2014.Familyreunification();
			familyReunificationModel.setId(UUID.randomUUID());
			familyReunificationModel.setRecordToBeInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(familyReunificationModel, domain,familyReunification.getFamilyReunificationID(),data.i+data.j);
		return familyReunificationModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Familyreunification createFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification){
	       familyReunification.setId(UUID.randomUUID()); 
	       insert(familyReunification);
	       return familyReunification;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Familyreunification updateFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification){
	       update(familyReunification);
	       return familyReunification;
	   }
	   public void deleteFamilyReunification(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification familyReunification){
	       delete(familyReunification);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Familyreunification getFamilyReunificationById(UUID familyReunificationId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Familyreunification) get(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class, familyReunificationId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Familyreunification> getAllExitFamilyReunifications(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Familyreunification>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitFamilyReunificationsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Familyreunification.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
