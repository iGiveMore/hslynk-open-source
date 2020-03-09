package com.servinglynk.hmis.warehouse.base.service;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Accounts;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.Roles;

public interface AccountService {
	
	Account findAccountByUsername(String username);

	Account createAccount(Account account, String userService,
			String purpose);

	Account updateAccount(Account account, String userService);

	Account updatePassword(Account account, PasswordChange passwordChange,
			String userService);
	
	void deleteAccount(Account account,Account auditAccount);
	
	Account activateAccount(Account account,String auditUser);
	
	void addRoleToUser(UUID userid, Roles roles) ;
	void removeRoleFromUser(UUID userid, UUID roleid);
	
	
	boolean checkApiAuthorizationForUser(Account account,String apiMethodId);

	void extendUserSession(String accessToken);

	Accounts getUsersByProjectGroup(String projectGroupCode);

	Account getAccount(Account account,boolean onlyBasicInfo);
	
	boolean checkClientConsentAuthorizationForUser(Account account, UUID clientid);

	void passwordUpdateByAdmin(Account account, PasswordChange passwordChange, String username);

}
