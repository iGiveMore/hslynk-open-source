package com.servinglynk.hmis.warehouse.base.service.converter;

import com.servinglynk.hmis.warehouse.common.ValidationUtil;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.DeveloperCompany;


public class DeveloperCompanyConverter {

	public static DeveloperCompany convertToDeveloperCompany(com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity pDeveloperCompany) {
		DeveloperCompany developerCompany = new DeveloperCompany();
		
		developerCompany.setDeveloperCompanyId(pDeveloperCompany.getExternalId());
		developerCompany.setName(pDeveloperCompany.getName());
		developerCompany.setDomain(pDeveloperCompany.getDomain());
		developerCompany.setLogoUrl(pDeveloperCompany.getLogoUrl());				developerCompany.setExpectedAppFinishDate(pDeveloperCompany.getExpectedAppFinishDate());		developerCompany.setAppExperience(pDeveloperCompany.getAppExperience());		developerCompany.setAppPlatforms(pDeveloperCompany.getAppPlatforms());		developerCompany.setCompanySize(pDeveloperCompany.getCompanySize());		developerCompany.setCompanySkillSet(pDeveloperCompany.getCompanySkillSet());		developerCompany.setContactEmail(pDeveloperCompany.getContactEmail());		developerCompany.setStatus(pDeveloperCompany.getStatus());				
		Account owner = new Account();
		owner.setFirstName(pDeveloperCompany.getAccount().getFirstName());
		owner.setLastName(pDeveloperCompany.getAccount().getLastName());
		owner.setUsername(pDeveloperCompany.getAccount().getUsername());
		developerCompany.setOwner(owner);
				return developerCompany;
	}
	

	public static com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity convertToPersistentDeveloperCompany(DeveloperCompany developerCompany, com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity pDeveloperCompany) {		
		if (pDeveloperCompany == null) {
			pDeveloperCompany = new com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity();
		}
		if (ValidationUtil.isNotNull(developerCompany.getName())) {
			pDeveloperCompany.setName(developerCompany.getName());
		}
		if (ValidationUtil.isNotNull(developerCompany.getDomain())) {
			pDeveloperCompany.setDomain(developerCompany.getDomain());
		}
		if (ValidationUtil.isNotNull(developerCompany.getLogoUrl())) {
			pDeveloperCompany.setLogoUrl(developerCompany.getLogoUrl());
		}				if (ValidationUtil.isNotNull(developerCompany.getAppPlatforms())) {			pDeveloperCompany.setAppPlatforms(developerCompany.getAppPlatforms());		}		if (ValidationUtil.isNotNull(developerCompany.getAppExperience())) {			pDeveloperCompany.setAppExperience(developerCompany.getAppExperience());		}				if (ValidationUtil.isNotNull(developerCompany.getCompanySize())) {			pDeveloperCompany.setCompanySize(developerCompany.getCompanySize());		}				if (ValidationUtil.isNotNull(developerCompany.getCompanySkillSet())) {			pDeveloperCompany.setCompanySkillSet(developerCompany.getCompanySkillSet());		}		if (ValidationUtil.isNotNull(developerCompany.getContactEmail())) {			pDeveloperCompany.setContactEmail(developerCompany.getContactEmail());		}		if (ValidationUtil.isNotNull(developerCompany.getExpectedAppFinishDate())) {			pDeveloperCompany.setExpectedAppFinishDate(developerCompany.getExpectedAppFinishDate());		}				return pDeveloperCompany;
	}
	
	public static com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity convertSimpleToPersistentDeveloperCompany(DeveloperCompany developerCompany, com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity pDeveloperCompany) {

		if (ValidationUtil.isNotNull(developerCompany.getDomain())) {
			pDeveloperCompany.setDomain(developerCompany.getDomain());
		}				if (ValidationUtil.isNotNull(developerCompany.getLogoUrl())) {			pDeveloperCompany.setLogoUrl(developerCompany.getLogoUrl());		}				if (ValidationUtil.isNotNull(developerCompany.getName())) {			pDeveloperCompany.setName(developerCompany.getName());		}				if (ValidationUtil.isNotNull(developerCompany.getAppPlatforms())) {			pDeveloperCompany.setAppPlatforms(developerCompany.getAppPlatforms());		}		if (ValidationUtil.isNotNull(developerCompany.getAppExperience())) {			pDeveloperCompany.setAppExperience(developerCompany.getAppExperience());		}				if (ValidationUtil.isNotNull(developerCompany.getCompanySize())) {			pDeveloperCompany.setCompanySize(developerCompany.getCompanySize());		}				if (ValidationUtil.isNotNull(developerCompany.getCompanySkillSet())) {			pDeveloperCompany.setCompanySkillSet(developerCompany.getCompanySkillSet());		}		if (ValidationUtil.isNotNull(developerCompany.getContactEmail())) {			pDeveloperCompany.setContactEmail(developerCompany.getContactEmail());		}		if (ValidationUtil.isNotNull(developerCompany.getExpectedAppFinishDate())) {			pDeveloperCompany.setExpectedAppFinishDate(developerCompany.getExpectedAppFinishDate());		}		
		return pDeveloperCompany;
	}
}