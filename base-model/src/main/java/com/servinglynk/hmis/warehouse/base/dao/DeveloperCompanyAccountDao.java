package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.model.base.DeveloperCompanyAccountEntity;

public interface DeveloperCompanyAccountDao {
	
	public List<DeveloperCompanyAccountEntity> findByDeveloperCompanyId(UUID developerCompanyId);
	
	public DeveloperCompanyAccountEntity create(DeveloperCompanyAccountEntity developerCompanyAccount);
	public DeveloperCompanyAccountEntity update(
			DeveloperCompanyAccountEntity developerCompanyAccount);
	public DeveloperCompanyAccountEntity findByDeveloperCompanyIdAndAccountUsername(UUID companyId,String userName);
	public void deleteCompanyAccount(DeveloperCompanyAccountEntity developerCompanyAccount);
	public DeveloperCompanyAccountEntity findByDeveloperCompanyIdAndAccountId(UUID  developerCompanyId,UUID accountId);
}
