/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.activemq.command.ActiveMQQueue;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.HmisHousehold;
import com.servinglynk.hmis.warehouse.model.v2015.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentDaoImpl extends ParentDaoImpl implements EnrollmentDao {
	private static final Logger logger = LoggerFactory
			.getLogger(EnrollmentDaoImpl.class);
	@Autowired
	ParentDaoFactory parentDaoFactory;
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		Export export =  domain.getExport();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment> enrollments = export
				.getEnrollment();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, getProjectGroupCode(domain));
		Map<String,HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Project.class, getProjectGroupCode(domain));
		if (enrollments != null && enrollments.size() > 0) {
			for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment  :  enrollments)
			{
				com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = null;
				try {
					enrollmentModel = getModelObject(domain, enrollment,data,modelMap);
//				enrollmentModel
//						.setContinuouslyhomelessoneyear(EnrollmentContinuouslyhomelessoneyearEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
//								.getContinuouslyHomelessOneYear())));
					enrollmentModel
					.setHousingstatus(EnrollmentHousingstatusEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(enrollment
											.getHousingStatus())));
					enrollmentModel
					.setDisablingcondition(EnrollmentDisablingconditionEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getDisablingCondition())));
//				enrollmentModel.setYearshomeless(new Integer(
//						BasicDataGenerator.getStringValue(enrollment
//								.getYearsHomeless())));
					enrollmentModel
					.setResidenceprior(EnrollmentResidencepriorEnum
							.lookupEnum(BasicDataGenerator
									.getStringValue(enrollment
											.getResidencePrior())));
//				enrollmentModel
//						.setStatusdocumented(EnrollmentStatusdocumentedEnum.lookupEnum(BasicDataGenerator
//								.getStringValue(enrollment
//										.getStatusDocumented())));
					enrollmentModel
					.setResidencepriorlengthofstay(EnrollmentResidencepriorlengthofstayEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
							.getResidencePriorLengthOfStay())));
					enrollmentModel
					.setRelationshiptohoh(EnrollmentRelationshiptohohEnum.lookupEnum(BasicDataGenerator
							.getStringValue(enrollment
									.getRelationshipToHoH())));
					enrollmentModel.setDateCreatedFromSource(BasicDataGenerator
							.getLocalDateTime(enrollment.getDateCreated()));
					enrollmentModel.setDateUpdatedFromSource(BasicDataGenerator
							.getLocalDateTime(enrollment.getDateUpdated()));
					enrollmentModel.setEntrydate(BasicDataGenerator
							.getLocalDateTime(enrollment.getEntryDate()));
					enrollmentModel
					.setMonthshomelesspastthreeyears(EnrollmentMonthshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment
							.getMonthsHomelessPastThreeYears())));
					enrollmentModel.setHouseholdid(enrollment.getHouseholdID());
					enrollmentModel.setHousingstatus(EnrollmentHousingstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment.getHousingStatus())));
//				enrollmentModel
//						.setMonthshomelessthistime(EnrollmentMonthshomelessthistimeEnum.lookupEnum(BasicDataGenerator
//								.getStringValue(enrollment
//										.getMonthsHomelessThisTime())));
					enrollmentModel.setOtherresidenceprior(enrollment
							.getOtherResidencePrior());
					com.servinglynk.hmis.warehouse.model.v2015.Project project = (Project) getModel(com.servinglynk.hmis.warehouse.model.v2015.Project.class,enrollment.getProjectID(),getProjectGroupCode(domain),true,projectModelMap, domain.getUpload().getId());
					enrollmentModel.setProject(project);
					enrollmentModel.setTimeshomelesspastthreeyears(EnrollmentTimeshomelesspastthreeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(enrollment.getTimesHomelessPastThreeYears())));
					//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
					// Very important logic needs to come here via a Microservice call.
					if (enrollment.getPersonalID() != null) {
						com.servinglynk.hmis.warehouse.model.v2015.Client client = (com.servinglynk.hmis.warehouse.model.v2015.Client) getModel(com.servinglynk.hmis.warehouse.model.v2015.Client.class, enrollment.getPersonalID(), getProjectGroupCode(domain), true, relatedModelMap, domain.getUpload().getId());
						//TODO: Need to add Unduping logic here and get a unique Client for enrollments.
						// Very important logic needs to come here via a Microservice call.
						LocalDateTime entryDate = enrollmentModel.getEntrydate();
						if (client != null) {
							LocalDateTime dob = client.getDob();
							if (entryDate != null && dob != null) {
								LocalDateTime tempDateTime = LocalDateTime.from(dob);
								long years = tempDateTime.until(entryDate, ChronoUnit.YEARS);
								enrollmentModel.setAgeAtEntry(new Integer(String.valueOf(years)));
							}
							enrollmentModel.setClient(client);
						}
					}
					HmisHousehold hmisHouseHold = parentDaoFactory.getHmisHouseholdDao().fetchBulkUploadHouseHold(enrollmentModel);
					enrollmentModel.setHmisHousehold(hmisHouseHold);
					enrollmentModel.setExport(exportEntity);
					performSaveOrUpdate(enrollmentModel);
					if(!enrollmentModel.isIgnored()) createClientMedataInfo(enrollmentModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the enrollment::"+enrollment.getProjectEntryID() +" Exception ::"+e.getMessage();
					if(enrollmentModel != null){
						Error2015 error = new Error2015();
						error.model_id = enrollmentModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = enrollmentModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = enrollmentModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class.getSimpleName(), domain,exportEntity);
	}

	
	@Override
	@Transactional
	public void populateAgeAtEntry(String projectGroupCode) {
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, projectGroupCode);
		 Iterator<HmisBaseModel> iterator = modelMap.values().iterator();
		while(iterator.hasNext()){
		Enrollment enrollmentModel = (Enrollment) iterator.next();
			if(enrollmentModel != null && enrollmentModel.getClient() !=null && enrollmentModel.getEntrydate()!=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Client client = enrollmentModel.getClient();
				LocalDateTime entryDate = enrollmentModel.getEntrydate();
				if (client != null) {
					LocalDateTime dob = client.getDob();
					if (entryDate != null && dob != null) {
						LocalDateTime tempDateTime = LocalDateTime.from(dob);
						long years = tempDateTime.until(entryDate, ChronoUnit.YEARS);
						enrollmentModel.setAgeAtEntry(new Integer(String.valueOf(years)));
						getCurrentSession().update(enrollmentModel);
					}
			}
		 }
		}
	}
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Enrollment enrollment ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Enrollment modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) getModel(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, enrollment.getProjectEntryID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2015.Enrollment();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2015.Enrollment model = new com.servinglynk.hmis.warehouse.model.v2015.Enrollment();
		//org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollment.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(modelFromDB, domain,enrollment.getProjectEntryID(),data);
		return model;
	}
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment getEnrollmentById(UUID enrollmentId) {
	      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
	      criteria.add(Restrictions.eq("id", enrollmentId));
	      List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment> entities = (List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment>) findByCriteria(criteria);
	      if(!entities.isEmpty()) return entities.get(0);
	      return null;
	}




	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment createEnrollment(
			com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
			enrollment.setId(UUID.randomUUID());
			insert(enrollment);
			createClientMedataInfo(enrollment);
		return enrollment;
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment updateEnrollment(
			com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
			update(enrollment);
		return enrollment;
	}

	@Override
	public void deleteEnrollment(
			com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
		delete(enrollment);
		deleteClientMedataInfo(enrollment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Enrollment getEnrollmentByClientIdAndEnrollmentId(
			UUID enrollmentId,UUID clientId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		criteria.add(Restrictions.eq("id",enrollmentId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment> enrollments = (List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment>) findByCriteria(criteria);
		if(enrollments.size()>0) return enrollments.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment> getEnrollmentsByClientId(UUID clientId,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));		
		return (List<com.servinglynk.hmis.warehouse.model.v2015.Enrollment>) findByCriteria(criteria,startIndex,maxItems);
	}

	public long getEnrollmentCount(UUID clientId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class);
		criteria.createAlias("client","client");
		criteria.add(Restrictions.eq("client.id",clientId));
		return countRows(criteria);
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
	@Autowired JmsTemplate jmsMessagingTemplate;
	
	public void createClientMedataInfo(com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
		ClientMetaDataEntity metaDataEntity = new ClientMetaDataEntity();
		metaDataEntity.setId(UUID.randomUUID());
		metaDataEntity.setClientId(enrollment.getClient().getId());
		metaDataEntity.setClientDedupId(enrollment.getClient().getDedupClientId());
		metaDataEntity.setDate(LocalDateTime.now());
		metaDataEntity.setDateCreated(LocalDateTime.now());
		metaDataEntity.setDateUpdated(LocalDateTime.now());
		metaDataEntity.setDeleted(false);
		metaDataEntity.setMetaDataIdentifier(enrollment.getId());
		metaDataEntity.setType("enrollments");
		metaDataEntity.setProjectGroupCode(enrollment.getProjectGroupCode());
		metaDataEntity.setUserId(enrollment.getUserId());
		metaDataEntity.setAdditionalInfo("{\"enrollmentId\":\""+enrollment.getId()+"\",\"schemaYear\":\"2015\",\"clientId\":\""+enrollment.getClient().getId()+"\"}");
		parentDaoFactory.getClientMetaDataDao().createClientMetaData(metaDataEntity);
		
		
		ActiveMQQueue queue = new ActiveMQQueue("cache.cleint.metadtata");
		try {
			jmsMessagingTemplate.convertAndSend(queue,JsonUtil.coneveterObejctToString(metaDataEntity));
		} catch (JmsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteClientMedataInfo(com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollment) {
		ClientMetaDataEntity metaDataEntity = parentDaoFactory.getClientMetaDataDao().findByIdentifier(enrollment.getId());
		metaDataEntity.setDateUpdated(LocalDateTime.now());
		metaDataEntity.setDeleted(true);
		parentDaoFactory.getClientMetaDataDao().updateClientMetaData(metaDataEntity);
	}
}

