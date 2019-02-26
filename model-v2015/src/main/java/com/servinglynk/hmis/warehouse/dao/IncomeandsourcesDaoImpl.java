/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.IncomeAndSources;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesAlimonyEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesChildsupportEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesEarnedEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesGaEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesIncomefromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPensionEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesPrivatedisabilityEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSocsecretirementEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsdiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesSsiEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesTanfEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesUnemploymentEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilitynonserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesVadisabilityserviceEnum;
import com.servinglynk.hmis.warehouse.enums.IncomeandsourcesWorkerscompEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class IncomeandsourcesDaoImpl extends ParentDaoImpl implements
		IncomeandsourcesDao {
	private static final Logger logger = LoggerFactory
			.getLogger(IncomeandsourcesDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<IncomeAndSources> incomeAndSourceses = domain.getExport().getIncomeAndSources();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class, getProjectGroupCode(domain));
		if(incomeAndSourceses !=null && !incomeAndSourceses.isEmpty())
		{
			for(IncomeAndSources incomeAndSources : incomeAndSourceses)
			{
				Incomeandsources incomeAndSourcesModel = null;
				try {
					incomeAndSourcesModel = getModelObject(domain, incomeAndSources,data,modelMap);
					incomeAndSourcesModel.setAlimony(IncomeandsourcesAlimonyEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getAlimony())));
					if(StringUtils.isNotBlank(incomeAndSources.getAlimonyAmount()))
						incomeAndSourcesModel.setAlimonyamount(new BigDecimal(incomeAndSources.getAlimonyAmount()));
					if(StringUtils.isNotBlank(incomeAndSources.getChildSupportAmount()))
						incomeAndSourcesModel.setChildsupportamount(new BigDecimal(incomeAndSources.getChildSupportAmount()));
					incomeAndSourcesModel.setEarnedamount(new BigDecimal(0));
					if(StringUtils.isNotBlank(incomeAndSources.getEarnedAmount()))
						incomeAndSourcesModel.setEarnedamount(new BigDecimal(incomeAndSources.getEarnedAmount()));
					incomeAndSourcesModel.setEarned(IncomeandsourcesEarnedEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getEarned())));
					incomeAndSourcesModel.setChildsupport(IncomeandsourcesChildsupportEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getChildSupport())));
					incomeAndSourcesModel.setGa(IncomeandsourcesGaEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getGA())));
					if(StringUtils.isNotBlank(incomeAndSources.getGAAmount()))
						incomeAndSourcesModel.setGaamount(new BigDecimal(incomeAndSources.getGAAmount()));
					incomeAndSourcesModel.setIncomefromanysource(IncomeandsourcesIncomefromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getIncomeFromAnySource())));
					incomeAndSourcesModel.setOthersource(IncomeandsourcesOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getOtherSource())));
					if(StringUtils.isNotBlank(incomeAndSources.getOtherAmount()))
						incomeAndSourcesModel.setOthersourceamount(new BigDecimal(incomeAndSources.getOtherAmount()));
					incomeAndSourcesModel.setOthersourceidentify(incomeAndSources.getOtherSourceIdentify());
					incomeAndSourcesModel.setPension(IncomeandsourcesPensionEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getPension())));
					if(StringUtils.isNotBlank(incomeAndSources.getPensionAmount()))
						incomeAndSourcesModel.setPensionamount(new BigDecimal(incomeAndSources.getPensionAmount()));
					incomeAndSourcesModel.setPrivatedisability(IncomeandsourcesPrivatedisabilityEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getPrivateDisability())));
					if(StringUtils.isNotBlank(incomeAndSources.getPrivateDisabilityAmount()))
						incomeAndSourcesModel.setPrivatedisabilityamount(new BigDecimal(incomeAndSources.getPrivateDisabilityAmount()));
					incomeAndSourcesModel.setSocsecretirement(IncomeandsourcesSocsecretirementEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSocSecRetirement())));
					if(StringUtils.isNotBlank(incomeAndSources.getSocSecRetirementAmount()))
						incomeAndSourcesModel.setSocsecretirementamount( new BigDecimal(incomeAndSources.getSocSecRetirementAmount()));
					incomeAndSourcesModel.setSsdi(IncomeandsourcesSsdiEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSSDI())));
					if(StringUtils.isNotBlank(incomeAndSources.getSSIAmount()))
						incomeAndSourcesModel.setSsdiamount(new BigDecimal(incomeAndSources.getSSIAmount()));
					incomeAndSourcesModel.setSsi(IncomeandsourcesSsiEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getSSI())));
					incomeAndSourcesModel.setTanf(IncomeandsourcesTanfEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getTANF())));
					if(StringUtils.isNotBlank(incomeAndSources.getTANFAmount()))
						incomeAndSourcesModel.setTanfamount(new BigDecimal(incomeAndSources.getTANFAmount()));
					if(StringUtils.isNotBlank(incomeAndSources.getTotalMonthlyIncome()))
						incomeAndSourcesModel.setTotalmonthlyincome(new BigDecimal(incomeAndSources.getTotalMonthlyIncome()));
					incomeAndSourcesModel.setUnemployment(IncomeandsourcesUnemploymentEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getUnemployment())));
					if(StringUtils.isNotBlank(incomeAndSources.getUnemploymentAmount()))
						incomeAndSourcesModel.setUnemploymentamount(new BigDecimal(incomeAndSources.getUnemploymentAmount()));
					incomeAndSourcesModel.setVadisabilitynonservice(IncomeandsourcesVadisabilitynonserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getVADisabilityNonService())));
					if(StringUtils.isNotBlank(incomeAndSources.getVADisabilityNonServiceAmount()))
						incomeAndSourcesModel.setVadisabilitynonserviceamount(new BigDecimal(incomeAndSources.getVADisabilityNonServiceAmount()));
					incomeAndSourcesModel.setVadisabilityservice(IncomeandsourcesVadisabilityserviceEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getVADisabilityService())));
					if(StringUtils.isNotBlank(incomeAndSources.getVADisabilityServiceAmount()))
						incomeAndSourcesModel.setVadisabilityserviceamount(new BigDecimal(incomeAndSources.getVADisabilityServiceAmount()));
					incomeAndSourcesModel.setWorkerscomp(IncomeandsourcesWorkerscompEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getWorkersComp())));
					if(StringUtils.isNotBlank(incomeAndSources.getWorkersCompAmount()))
						incomeAndSourcesModel.setWorkerscompamount(new BigDecimal(incomeAndSources.getWorkersCompAmount()));
					incomeAndSourcesModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(incomeAndSources.getDateCreated()));
					incomeAndSourcesModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(incomeAndSources.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, incomeAndSources.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					incomeAndSourcesModel.setEnrollmentid(enrollmentModel);
					incomeAndSourcesModel.setExport(exportEntity);
					incomeAndSourcesModel.setInformationDate(BasicDataGenerator.getLocalDateTime(incomeAndSources.getInformationDate()));
					incomeAndSourcesModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(incomeAndSources.getDataCollectionStage())));
					performSaveOrUpdate(incomeAndSourcesModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the incomeAndSources::"+incomeAndSources.getIncomeAndSourcesID() +" Exception ::"+e.getMessage();
					if(incomeAndSourcesModel != null){
						Error2015 error = new Error2015();
						error.model_id = incomeAndSourcesModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = incomeAndSourcesModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = incomeAndSourcesModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources getModelObject(ExportDomain domain, IncomeAndSources incomeandsources ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources) getModel(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class, incomeandsources.getIncomeAndSourcesID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources model = new com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources();
		//org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(incomeandsources.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(modelFromDB, domain,incomeandsources.getIncomeAndSourcesID(),data);
		return model;
	}
	

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources createIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource){
	       incomeAndSource.setId(UUID.randomUUID());
	       insert(incomeAndSource);
	       return incomeAndSource;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources updateIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource){
	       update(incomeAndSource);
	       return incomeAndSource;
	   }
	   public void deleteIncomeAndSource(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources incomeAndSource){
	       delete(incomeAndSource);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources getIncomeAndSourceById(UUID incomeAndSourceId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class);
		      criteria.add(Restrictions.eq("id", incomeAndSourceId));
		      List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources> entities = (List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources> getAllEnrollmentIncomeAndSources(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentIncomeAndSourcesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
