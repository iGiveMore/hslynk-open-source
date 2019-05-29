package com.servinglynk.hmis.warehouse.test.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.servinglynk.hmis.warehouse.base.service.core.BaseServiceFactory;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.config.RestConfig;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.Errors;
import com.servinglynk.hmis.warehouse.core.model.Locale;
import com.servinglynk.hmis.warehouse.core.model.PasswordChange;
import com.servinglynk.hmis.warehouse.core.model.PasswordReset;
import com.servinglynk.hmis.warehouse.core.model.Preferences;
import com.servinglynk.hmis.warehouse.core.model.ProjectGroup;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.UsernameChange;
import com.servinglynk.hmis.warehouse.test.core.TestData;;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
@WebAppConfiguration
public class TestAccountsRestEndpoint  {
	
	
	protected final Log LOG = LogFactory.getLog(getClass());
	
	@Autowired WebApplicationContext wac;
	
	@Autowired BaseServiceFactory serviceFactory;
	
	
	public Session createSession(String username,String pwd) throws Exception {
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Session session = new Session();
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(pwd);
		session.setAccount(account);
		
		Session sess = executor.executePost("/sessions",session,Session.class);
		Assert.assertNotNull(sess.getToken());
		return sess;
	}
	
	public void endSession(Session session) throws Exception {
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		executor.executeDelete("/sessions/"+session.getToken());
	}
	
	@Test
	public void testCreateAccount() throws Exception {
	//	Session session = createSession("superadmin@hmis.com","password");
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token=9DB4F46517B849EE8B0B42132E969485E5B80260369B4704AE48CE0576CD2730");
		
		
		Account account = TestData.getAccount();
		
		account.setOrganizationId(UUID.fromString("fdeb1314-92e1-4336-9c4f-97696868e1c0"));
		
		Role role = new Role();
		role.setId(UUID.fromString("33f2a166-4316-4e98-8a0a-7130eabce13e"));
		
		ProjectGroup projectGroup = new ProjectGroup();
		projectGroup.setProjectGroupName("Project Group 1");
		projectGroup.setProjectGroupDesc("Project Group 1 Desc");
	/*	Project project = new Project();
		project.setProjectId(UUID.fromString("5b89157c-1f00-4948-ab9b-f02215ea3320"));
		projectGroup.addProject(project);*/
		projectGroup = serviceFactory.getProjectGroupService().createProjectGroup(projectGroup, "JUNIT Testing");
		
		account.setRole(role);
		account.setProjectGroup(projectGroup);
		System.out.println(account.toJSONString());

		Account newAccount = executor.executePost("/accounts", account, Account.class);
	//	Errors newAccount = executor.executePost("/accounts", account, Errors.class);
		System.out.println(newAccount.toJSONString());
		assertNotNull(newAccount.getAccountId());
	}
	
	
	@Test
	public void testGetAccountEmailAddress() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);
		
		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

		Account account2 = executor.executeGet("/accounts/self/emailaddress", Account.class);

		assertNotNull(account2.getEmailAddress());
		assertNotNull(account2.getAccountId());	
	}
	
	@Test
	public void testGetBasicAccountInfo() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);
		
		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		Account account2 = executor.executeGet("/accounts/self/basicinfo", Account.class);
		
		assertNotNull(account2.getFirstName());
		assertNotNull(account2.getEmailAddress());
	}
	
	@Test
	public void testGetAuthorizedTrustedApps() throws Exception {
		
	}
	
	
	@Test
	public void testUpdateAccount() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		Account account2 = executor.executeGet("/accounts/self",  Account.class);
	
		account2.setLastName("LAST NAME IS UPDATED");
		
		Account upAccount = executor.executePut("/accounts/self", account2, Account.class);
		
		assertEquals(upAccount.getLastName(),"LAST NAME IS UPDATED");
		
		
	}
	
	@Test
	public void testGetAccountStatus() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		Account account2 = executor.executeGet("/accounts/"+newAccount.getUsername()+"/status", Account.class);
		
		assertEquals(newAccount.getStatus(),account2.getStatus());
		
	}
	
	
	@Test
	public void testGetAccountPreferences() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		Preferences preferences = executor.executeGet("/accounts/self/preferences",  Preferences.class);
		
		assertNotNull(preferences);
	}
	
	
	@Test
	public void testUpdateAccountPreferences() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());

		
		Preferences preferences = executor.executeGet("/accounts/self/preferences", Preferences.class);
		
		Locale locale = new Locale();
		locale.setCountry("US");
		locale.setLanguage("ENGLISH");
		locale.setFriendlyName("EN");
		preferences.setLocale(locale);
		
		Preferences newPreferences =executor.executePut("/accounts/self/preferences",preferences, Preferences.class);
		
		//assertNotEquals(newPreferences.getLocale().getLocaleId(),null);
		assertEquals(newPreferences.getLocale().getCountry(),preferences.getLocale().getCountry());
		
	}
	 
	
	// Password not updated just created a new password reset record
	
	@Test
	public void testPasswordReset() throws Exception {

		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		PasswordReset passwordReset = executor.executePost("/accounts/"+newAccount.getUsername()+"/passwordresets", null, PasswordReset.class);
		

	}
	
	
	@Test
	public void testPasswordUpdate() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		PasswordChange pwdChange = new PasswordChange();
	//	pwdChange.setcurrentPassword(newAccount.getPassword());
	//	pwdChange.setnewPasswordd("newPassword");
		
		Account resp = executor.executePost("/accounts/self/passwordchanges", pwdChange , Account.class);
	}
	
	
	@Test
	public void testUsernameChange() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		UsernameChange uname = new UsernameChange();
		uname.setCurrentPassword(newAccount.getPassword());
		uname.setNewUsername("HelloPassword@hmis.com");
		
		UsernameChange passwordReset = executor.executePost("/accounts/self/usernamechanges", uname, UsernameChange.class);
		
	
		
	}

	@Test
	public void testCreateDuplicateAccount() throws Exception {
	
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		Errors errors =  executor.executePost("/accounts", account, Errors.class);
		
		assertEquals("ERR_CODE_ACCOUNT_ALREADY_EXISTS", errors.getError().get(0).getCode());
		assertEquals("An account with the specified username already exists. username: "+account.getUsername(), errors.getError().get(0).getMessage());
		
	}
	
	@Test
	public void testGetAccountEmailAddressWithoutAccount() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		noSessiontExecutor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+GeneralUtil.getUniqueToken(64));
		
	
		Errors errors =   noSessiontExecutor.executeGet("/accounts/self/emailaddress",  Errors.class);
		
		assertEquals(errors.getError().get(0).getCode(),"INVALID_SESSION_TOKEN");
	}
	
	
	@Test
	public void testPasswordUpdateWithWrongCurrentPwd() throws Exception {
		
		WebserviceTestExecutor noSessiontExecutor  = new WebserviceTestExecutor(wac);
		noSessiontExecutor.setAcceptHeaderAsJson();
		noSessiontExecutor.setContentTypeHeaderAsJson();
		noSessiontExecutor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		
		Account account =  TestData.getAccount();
		Account newAccount = noSessiontExecutor.executePost("/accounts", account, Account.class);

		Session session = createSession(newAccount.getUsername(),newAccount.getPassword());
		
		WebserviceTestExecutor executor = new WebserviceTestExecutor(wac);
		executor.setAcceptHeaderAsJson();
		executor.setContentTypeHeaderAsJson();
		executor.setHeaderValue("X-HMIS-TrustedApp-Id", "MASTER_TRUSTED_APP");
		executor.setHeaderValue("Authorization","HMISHNUserAuth session_token="+session.getToken());
		
		PasswordChange pwdChange = new PasswordChange();
	//	pwdChange.setcurrentPassword("TestPassword");
	//	pwdChange.setnewPasswordd("newPassword");
		
		Errors errors = executor.executePost("/accounts/self/passwordchanges", pwdChange , Errors.class);
		
		
		assertEquals(errors.getError().get(0).getMessage(), "The specified currentPassword does not match with the password stored in the database.");
	
		
	}

}
