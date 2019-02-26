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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.WorstHousingSituation;
import com.servinglynk.hmis.warehouse.enums.WorsthousingsituationWorsthousingsituationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class WorsthousingsituationDaoImpl extends ParentDaoImpl implements
		WorsthousingsituationDao {
	private static final Logger logger = LoggerFactory
			.getLogger(WorsthousingsituationDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<WorstHousingSituation> worstHousingSituationList = domain.getExport().getWorstHousingSituation();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Worsthousingsituation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(worstHousingSituationList !=null && !worstHousingSituationList.isEmpty())
		{
			for(WorstHousingSituation worstHousingSituation : worstHousingSituationList)
			{
				Worsthousingsituation model = null;
				try {
					model = getModelObject(domain, worstHousingSituation,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(worstHousingSituation.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(worstHousingSituation.getDateUpdated()));
					model.setWorsthousingsituation(WorsthousingsituationWorsthousingsituationEnum.lookupEnum(BasicDataGenerator.getStringValue(worstHousingSituation.getWorstHousingSituation())));
					model.setExport(exportEntity);
					Enrollment enrollmentModel = (Enrollment) getModel(Worsthousingsituation.class.getSimpleName(),Enrollment.class,worstHousingSituation.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					
					performSaveOrUpdate(model);
				}catch(Exception e) {
					String errorMessage = "Exception in worstHousingSituation:"+worstHousingSituation.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, Worsthousingsituation.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation getModelObject(ExportDomain domain, WorstHousingSituation worsthousingsituation ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation) getModel(Worsthousingsituation.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class, worsthousingsituation.getWorstHousingSituationID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation model = new com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(worsthousingsituation.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,worsthousingsituation.getWorstHousingSituationID(),data);
		return model;
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation createWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation){
	       worsthousingsituation.setId(UUID.randomUUID()); 
	       insert(worsthousingsituation);
	       return worsthousingsituation;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation updateWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation){
	       update(worsthousingsituation);
	       return worsthousingsituation;
	   }
	   public void deleteWorsthousingsituation(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation worsthousingsituation){
	       delete(worsthousingsituation);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation getWorsthousingsituationById(UUID worsthousingsituationId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class);
		      criteria.add(Restrictions.eq("id", worsthousingsituationId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation> getAllEnrollmentWorsthousingsituations(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentWorsthousingsituationsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
