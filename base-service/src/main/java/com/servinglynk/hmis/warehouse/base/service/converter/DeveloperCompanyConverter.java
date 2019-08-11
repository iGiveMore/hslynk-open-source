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
		developerCompany.setLogoUrl(pDeveloperCompany.getLogoUrl());
		Account owner = new Account();
		owner.setFirstName(pDeveloperCompany.getAccount().getFirstName());
		owner.setLastName(pDeveloperCompany.getAccount().getLastName());
		owner.setUsername(pDeveloperCompany.getAccount().getUsername());
		developerCompany.setOwner(owner);
		
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
		}
	}
	
	public static com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity convertSimpleToPersistentDeveloperCompany(DeveloperCompany developerCompany, com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyEntity pDeveloperCompany) {

		if (ValidationUtil.isNotNull(developerCompany.getDomain())) {
			pDeveloperCompany.setDomain(developerCompany.getDomain());
		}
		return pDeveloperCompany;
	}
}