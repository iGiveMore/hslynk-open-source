package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity;
import com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyStatus;

public interface DeveloperCompanyDao {

	public DeveloperCompanyEntity createDeveloperCompany(DeveloperCompanyEntity developerCompany);
	public DeveloperCompanyStatus createDeveloperCompanyStatus(DeveloperCompanyStatus developerCompanyStatus);
	
	
	
	public DeveloperCompanyEntity updateDeveloperCompany(DeveloperCompanyEntity developerCompany);
	public DeveloperCompanyStatus updateCompanyStatus(DeveloperCompanyStatus developerCompanyStatus);
	
	
	public DeveloperCompanyEntity findByExternalId(String externalId);
	
	
	public void deleteDeveloperCompany(
			DeveloperCompanyEntity developerCompany);
	public List<DeveloperCompanyEntity> findAllDeveloperCompanies(
			String serviceStatus, String trustedAppStatus, Integer iStartIndex,
			Integer iMaxItems);
	public int findAllDeveloperCompaniesCount(String serviceStatus,
			String trustedAppStatus);
	
	public List<DeveloperCompanyEntity> findByOwnerId(UUID ownerId);
}
