package com.servinglynk.hmis.warehouse.service.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.base.service.SearchService;
import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactoryImpl;
import com.servinglynk.hmis.warehouse.service.AffiliationService;
import com.servinglynk.hmis.warehouse.service.AssessmentQuestionService;
import com.servinglynk.hmis.warehouse.service.AssessmentResultService;
import com.servinglynk.hmis.warehouse.service.AssessmentService;
import com.servinglynk.hmis.warehouse.service.BulkUploadErrorActivityService;
import com.servinglynk.hmis.warehouse.service.ClientService;
import com.servinglynk.hmis.warehouse.service.ConnectionwithsoarService;
import com.servinglynk.hmis.warehouse.service.ContactService;
import com.servinglynk.hmis.warehouse.service.CurrentLivingSituationService;
import com.servinglynk.hmis.warehouse.service.DateofengagementService;
import com.servinglynk.hmis.warehouse.service.DisabilitiesService;
import com.servinglynk.hmis.warehouse.service.DomesticviolenceService;
import com.servinglynk.hmis.warehouse.service.EducationService;
import com.servinglynk.hmis.warehouse.service.EmploymentService;
import com.servinglynk.hmis.warehouse.service.EnrollmentCocService;
import com.servinglynk.hmis.warehouse.service.EnrollmentService;
import com.servinglynk.hmis.warehouse.service.EnrollmentServiceV2;
import com.servinglynk.hmis.warehouse.service.EntryrhspService;
import com.servinglynk.hmis.warehouse.service.EntryrhyService;
import com.servinglynk.hmis.warehouse.service.EntryssvfService;
import com.servinglynk.hmis.warehouse.service.EventService;
import com.servinglynk.hmis.warehouse.service.ExitService;
import com.servinglynk.hmis.warehouse.service.ExithousingassessmentService;
import com.servinglynk.hmis.warehouse.service.ExitrhyService;
import com.servinglynk.hmis.warehouse.service.FunderService;
import com.servinglynk.hmis.warehouse.service.HMISTypeService;
import com.servinglynk.hmis.warehouse.service.HealthinsuranceService;
import com.servinglynk.hmis.warehouse.service.HealthstatusService;
import com.servinglynk.hmis.warehouse.service.HistoryService;
import com.servinglynk.hmis.warehouse.service.HmisHouseHoldService;
import com.servinglynk.hmis.warehouse.service.IncomeAndSourceService;
import com.servinglynk.hmis.warehouse.service.InventoryService;
import com.servinglynk.hmis.warehouse.service.MedicalassistanceService;
import com.servinglynk.hmis.warehouse.service.NoncashbenefitsService;
import com.servinglynk.hmis.warehouse.service.OrganizationService;
import com.servinglynk.hmis.warehouse.service.PathstatusService;
import com.servinglynk.hmis.warehouse.service.ProjectService;
import com.servinglynk.hmis.warehouse.service.ProjectServiceV2;
import com.servinglynk.hmis.warehouse.service.ProjectcocService;
import com.servinglynk.hmis.warehouse.service.QuestionService;
import com.servinglynk.hmis.warehouse.service.RHYAfterCareService;
import com.servinglynk.hmis.warehouse.service.ResidentialmoveindateService;
import com.servinglynk.hmis.warehouse.service.RhybcpstatusService;
import com.servinglynk.hmis.warehouse.service.ServicefareferralService;
import com.servinglynk.hmis.warehouse.service.VashExitReasonService;
import com.servinglynk.hmis.warehouse.service.VeteranInfoService;

@Component
public class ParentServiceFactoryImpl extends BaseServiceFactoryImpl  implements ParentServiceFactory {

	@Autowired public OrganizationService organizationService;
	@Autowired public EmploymentService employmentService;
	@Autowired public EnrollmentService enrollmentService;
	@Autowired public DateofengagementService dateofengagementService;
	@Autowired public DisabilitiesService disabilitiesService;
	@Autowired public DomesticviolenceService domesticviolenceService;
	@Autowired public EnrollmentCocService enrollmentCocService;
	@Autowired public HealthinsuranceService healthinsuranceService;
	@Autowired public MedicalassistanceService medicalassistanceService;
	@Autowired public NoncashbenefitsService noncashbenefitsService;
	@Autowired public PathstatusService pathstatusService;
	@Autowired public ResidentialmoveindateService residentialmoveindateService;
	@Autowired public HealthstatusService healthstatusService;
	@Autowired public RhybcpstatusService rhybcpstatusService;
	@Autowired public ProjectService projectService;
	@Autowired public ExitService exitService;
	@Autowired public VeteranInfoService veteranInfoService;
	
	@Autowired public AssessmentService assessmentService;
	@Autowired public AssessmentQuestionService assessmentQuestionService;
	@Autowired public AssessmentResultService assessmentResultService;
	@Autowired public EventService eventService;
	@Autowired public CurrentLivingSituationService currentLivingSituationService;
	
	@Autowired public IncomeAndSourceService incomeAndSourceService;
	@Autowired public ExitrhyService exitrhyService;
	@Autowired public EntryrhspService entryrhspService;
	@Autowired public EntryrhyService entryrhyService;
	@Autowired public EntryssvfService entryssvfService;
	@Autowired public ServicefareferralService servicefareferralService;
	@Autowired public ClientService clientService;
	@Autowired public ContactService contactService;
	@Autowired public EducationService educationService;
	@Autowired public ExithousingassessmentService exithousingassessmentService;
	@Autowired public SearchService searchService;
	@Autowired public ConnectionwithsoarService connectionwithsoarService;
	@Autowired public VashExitReasonService vashExitReasonService;
	@Autowired public RHYAfterCareService rHYAfterCareService;
	@Autowired public BulkUploadErrorActivityService bulkUploadErrorActivityService;
	@Autowired public QuestionService questionService;
	@Autowired private EnrollmentServiceV2 enrollmentServiceV2;
	@Autowired private HMISTypeService hmisTypeService;
	
	public RhybcpstatusService getRhybcpstatusService() {
		return rhybcpstatusService;
	}

	public void setRhybcpstatusService(RhybcpstatusService rhybcpstatusService) {
		this.rhybcpstatusService = rhybcpstatusService;
	}

	public HealthstatusService getHealthstatusService() {
		return healthstatusService;
	}

	public void setHealthstatusService(HealthstatusService healthstatusService) {
		this.healthstatusService = healthstatusService;
	}

	public ResidentialmoveindateService getResidentialmoveindateService() {
		return residentialmoveindateService;
	}

	public void setResidentialmoveindateService(ResidentialmoveindateService residentialmoveindateService) {
		this.residentialmoveindateService = residentialmoveindateService;
	}

	public PathstatusService getPathstatusService() {
		return pathstatusService;
	}

	public void setPathstatusService(PathstatusService pathstatusService) {
		this.pathstatusService = pathstatusService;
	}

	public NoncashbenefitsService getNoncashbenefitsService() {
		return noncashbenefitsService;
	}

	public void setNoncashbenefitsService(NoncashbenefitsService noncashbenefitsService) {
		this.noncashbenefitsService = noncashbenefitsService;
	}

	public MedicalassistanceService getMedicalassistanceService() {
		return medicalassistanceService;
	}

	public void setMedicalassistanceService(MedicalassistanceService medicalassistanceService) {
		this.medicalassistanceService = medicalassistanceService;
	}

	public HealthinsuranceService getHealthinsuranceService() {
		return healthinsuranceService;
	}

	public void setHealthinsuranceService(HealthinsuranceService healthinsuranceService) {
		this.healthinsuranceService = healthinsuranceService;
	}

	public EnrollmentCocService getEnrollmentCocService() {
		return enrollmentCocService;
	}

	public void setEnrollmentCocService(EnrollmentCocService enrollmentCocService) {
		this.enrollmentCocService = enrollmentCocService;
	}

	public DomesticviolenceService getDomesticviolenceService() {
		return domesticviolenceService;
	}

	public void setDomesticviolenceService(DomesticviolenceService domesticviolenceService) {
		this.domesticviolenceService = domesticviolenceService;
	}

	public DisabilitiesService getDisabilitiesService() {
		return disabilitiesService;
	}

	public void setDisabilitiesService(DisabilitiesService disabilitiesService) {
		this.disabilitiesService = disabilitiesService;
	}

	public DateofengagementService getDateofengagementService() {
		return dateofengagementService;
	}

	public void setDateofengagementService(DateofengagementService dateofengagementService) {
		this.dateofengagementService = dateofengagementService;
	}

	public EmploymentService getEmploymentService() {
		return employmentService;
	}

	public void setEmploymentService(EmploymentService employmentService) {
		this.employmentService = employmentService;
	}

	public EnrollmentService getEnrollmentService() {
		return enrollmentService;
	}

	public void setEnrollmentService(EnrollmentService enrollmentService) {
		this.enrollmentService = enrollmentService;
	}

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	@Autowired private ProjectcocService projectcocService;


	public ProjectcocService getProjectcocService() {
		return projectcocService;
	}

	public void setProjectcocService(ProjectcocService projectcocService) {
		this.projectcocService = projectcocService;
	}
	
	@Autowired private FunderService funderService;
	@Autowired private AffiliationService affiliationService;


	public FunderService getFunderService() {
		return funderService;
	}

	public void setFunderService(FunderService funderService) {
		this.funderService = funderService;
	}

	public AffiliationService getAffiliationService() {
		return affiliationService;
	}

	public void setAffiliationService(AffiliationService affiliationService) {
		this.affiliationService = affiliationService;
	}
	
	@Autowired InventoryService inventoryService;


	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public ExitService getExitService() {
		return exitService;
	}

	public void setExitService(ExitService exitService) {
		this.exitService = exitService;
	}

	public VeteranInfoService getVeteranInfoService() {
		return veteranInfoService;
	}

	public void setVeteranInfoService(VeteranInfoService veteranInfoService) {
		this.veteranInfoService = veteranInfoService;
	}

	public IncomeAndSourceService getIncomeAndSourceService() {
		return incomeAndSourceService;
	}

	public void setIncomeAndSourceService(IncomeAndSourceService incomeAndSourceService) {
		this.incomeAndSourceService = incomeAndSourceService;
	}

	public ExitrhyService getExitrhyService() {
		return exitrhyService;
	}

	public void setExitrhyService(ExitrhyService exitrhyService) {
		this.exitrhyService = exitrhyService;
	}

	public EntryrhspService getEntryrhspService() {
		return entryrhspService;
	}

	public void setEntryrhspService(EntryrhspService entryrhspService) {
		this.entryrhspService = entryrhspService;
	}

	public EntryrhyService getEntryrhyService() {
		return entryrhyService;
	}

	public void setEntryrhyService(EntryrhyService entryrhyService) {
		this.entryrhyService = entryrhyService;
	}

	public EntryssvfService getEntryssvfService() {
		return entryssvfService;
	}

	public void setEntryssvfService(EntryssvfService entryssvfService) {
		this.entryssvfService = entryssvfService;
	}

	public ServicefareferralService getServicefareferralService() {
		return servicefareferralService;
	}

	public void setServicefareferralService(ServicefareferralService servicefareferralService) {
		this.servicefareferralService = servicefareferralService;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}

	public EducationService getEducationService() {
		return educationService;
	}

	public void setEducationService(EducationService educationService) {
		this.educationService = educationService;
	}

	public ExithousingassessmentService getExithousingassessmentService() {
		return exithousingassessmentService;
	}

	public void setExithousingassessmentService(ExithousingassessmentService exithousingassessmentService) {
		this.exithousingassessmentService = exithousingassessmentService;
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public BulkUploadErrorActivityService getBulkUploadErrorActivityService() {
		return bulkUploadErrorActivityService;
	}

	public void setBulkUploadErrorActivityService(
			BulkUploadErrorActivityService bulkUploadErrorActivityService) {
		this.bulkUploadErrorActivityService = bulkUploadErrorActivityService;
	}

	/**
	 * @return the connectionwithsoarService
	 */
	public ConnectionwithsoarService getConnectionwithsoarService() {
		return connectionwithsoarService;
	}

	/**
	 * @param connectionwithsoarService the connectionwithsoarService to set
	 */
	public void setConnectionwithsoarService(ConnectionwithsoarService connectionwithsoarService) {
		this.connectionwithsoarService = connectionwithsoarService;
	}

	/**
	 * @return the vashExitReasonService
	 */
	public VashExitReasonService getVashExitReasonService() {
		return vashExitReasonService;
	}

	/**
	 * @param vashExitReasonService the vashExitReasonService to set
	 */
	public void setVashExitReasonService(VashExitReasonService vashExitReasonService) {
		this.vashExitReasonService = vashExitReasonService;
	}

	/**
	 * @return the rHYAfterCareService
	 */
	public RHYAfterCareService getRHYAfterCareService() {
		return rHYAfterCareService;
	}

	/**
	 * @param rHYAfterCareService the rHYAfterCareService to set
	 */
	public void setRHYAfterCareService(RHYAfterCareService rHYAfterCareService) {
		this.rHYAfterCareService = rHYAfterCareService;
	}
	
	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	public EnrollmentServiceV2 getEnrollmentServiceV2() {
		return enrollmentServiceV2;
	}

	public void setEnrollmentServiceV2(EnrollmentServiceV2 enrollmentServiceV2) {
		this.enrollmentServiceV2 = enrollmentServiceV2;
	}
	
	@Autowired ProjectServiceV2 projectServiceV2;

	public ProjectServiceV2 getProjectServiceV2() {
		return projectServiceV2;
	}

	public void setProjectServiceV2(ProjectServiceV2 projectServiceV2) {
		this.projectServiceV2 = projectServiceV2;
	}

	public HMISTypeService getHmisTypeService() {
		return hmisTypeService;
	}

	public void setHmisTypeService(HMISTypeService hmisTypeService) {
		this.hmisTypeService = hmisTypeService;
	}

	/**
	 * @return the assessmentService
	 */
	public AssessmentService getAssessmentService() {
		return assessmentService;
	}

	/**
	 * @param assessmentService the assessmentService to set
	 */
	public void setAssessmentService(AssessmentService assessmentService) {
		this.assessmentService = assessmentService;
	}

	/**
	 * @return the assessmentQuestionService
	 */
	public AssessmentQuestionService getAssessmentQuestionService() {
		return assessmentQuestionService;
	}

	/**
	 * @param assessmentQuestionService the assessmentQuestionService to set
	 */
	public void setAssessmentQuestionService(AssessmentQuestionService assessmentQuestionService) {
		this.assessmentQuestionService = assessmentQuestionService;
	}

	/**
	 * @return the assessmentResultService
	 */
	public AssessmentResultService getAssessmentResultService() {
		return assessmentResultService;
	}

	/**
	 * @param assessmentResultService the assessmentResultService to set
	 */
	public void setAssessmentResultService(AssessmentResultService assessmentResultService) {
		this.assessmentResultService = assessmentResultService;
	}

	/**
	 * @return the eventService
	 */
	public EventService getEventService() {
		return eventService;
	}

	/**
	 * @param eventService the eventService to set
	 */
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	/**
	 * @return the currentLivingSituationService
	 */
	public CurrentLivingSituationService getCurrentLivingSituationService() {
		return currentLivingSituationService;
	}

	/**
	 * @param currentLivingSituationService the currentLivingSituationService to set
	 */
	public void setCurrentLivingSituationService(CurrentLivingSituationService currentLivingSituationService) {
		this.currentLivingSituationService = currentLivingSituationService;
	}

	/**
	 * @return the rHYAfterCareService
	 */
	public RHYAfterCareService getrHYAfterCareService() {
		return rHYAfterCareService;
	}

	/**
	 * @param rHYAfterCareService the rHYAfterCareService to set
	 */
	public void setrHYAfterCareService(RHYAfterCareService rHYAfterCareService) {
		this.rHYAfterCareService = rHYAfterCareService;
	}
	
	@Autowired HistoryService historyService;


	public HistoryService getHistoryService() {
		return historyService;
	}

	public void setHistoryService(HistoryService historyService) {
		this.historyService = historyService;
	}
	
	@Autowired private HmisHouseHoldService hmisHouseHoldService;


	public HmisHouseHoldService getHmisHouseHoldService() {
		return hmisHouseHoldService;
	}

	public void setHmisHouseHoldService(HmisHouseHoldService hmisHouseHoldService) {
		this.hmisHouseHoldService = hmisHouseHoldService;
	}
	
}