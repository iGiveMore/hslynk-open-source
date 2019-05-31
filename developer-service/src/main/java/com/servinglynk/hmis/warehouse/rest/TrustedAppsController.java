package com.servinglynk.hmis.warehouse.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.core.model.RedirectUri;
import com.servinglynk.hmis.warehouse.core.model.RedirectUris;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.TrustedApp;
import com.servinglynk.hmis.warehouse.core.model.TrustedAppStatus;



@RestController
@RequestMapping("/trustedapps")
public class TrustedAppsController extends ControllerBase {

	@RequestMapping(value = "/{trustedappid}", method = RequestMethod.PUT)
	@APIMapping(value="DCS_UPDATE_TRUSTEDAPP",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApp updateTrustedApp(@PathVariable("trustedappid") String trustedAppId, @RequestBody TrustedApp trustedApp, HttpServletRequest request) throws Exception {

		Session session=sessionHelper.getSession(request);
		trustedApp.setTrustedAppId(trustedAppId);

	return serviceFactory.getTrustedAppService().updateTrustedAppInfoForDevelopers(trustedApp, session.getAccount().getUsername(),
			Constants.DEVELOPER_CONSOLE_SERVICE);
	}


	@RequestMapping(value = "/{trustedappid}", method = RequestMethod.DELETE)
	@APIMapping(value="DCS_DELETE_TRUSTEDAPP",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApp deleteTrustedApp(@PathVariable("trustedappid") String trustedAppId, HttpServletRequest request) throws Exception {
		Session session=sessionHelper.getSession(request);
	
		serviceFactory.getTrustedAppService().deleteTrustedAppForDevelopers(trustedAppId, session.getAccount().getUsername(),
				Constants.DEVELOPER_CONSOLE_SERVICE);

		
		return new TrustedApp();
	}


	@RequestMapping(value = "/{trustedappid}/trustedappsecret", method = RequestMethod.PUT)
	@APIMapping(value="DCS_REGENERATE_TRUSTEDAPP_SECRETE",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApp regenerateTrustedAppSecret(@PathVariable("trustedappid") String trustedAppId, HttpServletRequest request) throws Exception {
		Session session=sessionHelper.getSession(request);
	
		String newTrustedAppSecret = serviceFactory.getTrustedAppService().regenerateTrustedAppSecret(trustedAppId, session.getAccount().getUsername(),
				Constants.DEVELOPER_CONSOLE_SERVICE);

		TrustedApp trustedApp = makeIdOnlyTrustedApp(trustedAppId);
		trustedApp.setTrustedAppSecret(newTrustedAppSecret);
		return trustedApp;
	}



	@RequestMapping(value = "/{trustedappid}/approvalsubmission", method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_APPROVAL_SUBMISSION_FOR_TRUSTEDAPP",checkSessionToken=true, checkTrustedApp=true)
	public TrustedAppStatus createApprovalSubmission(@PathVariable("trustedappid") String trustedAppId, @RequestBody TrustedAppStatus trustedAppStatus,
			HttpServletRequest request) throws Exception {

		Session session=sessionHelper.getSession(request);
		 serviceFactory.getTrustedAppService().processApprovalSubmission(trustedAppId, trustedAppStatus, session.getAccount(),
				Constants.DEVELOPER_CONSOLE_SERVICE);
		 return new TrustedAppStatus();

	}

	
	@RequestMapping(value = "/{trustedappid}/approvaldecision", method = RequestMethod.POST)
	@APIMapping(value="DCS_CREATE_APPROVAL_DECISION_FOR_TRUSTEDAPP",checkSessionToken=true, checkTrustedApp=true)
	public TrustedAppStatus createApprovalDecision(@PathVariable("trustedappid") String trustedAppId, @RequestBody TrustedAppStatus trustedAppStatus,
			HttpServletRequest request) throws Exception {
	
		Session session=sessionHelper.getSession(request);
		
		serviceFactory.getTrustedAppService().processApprovalDecision(trustedAppId, trustedAppStatus, session.getAccount(), Constants.DEVELOPER_CONSOLE_SERVICE);
		return new TrustedAppStatus();
	}

	@RequestMapping(value = "/{trustedappid}", method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_TRUSTEDAPP",checkSessionToken=true, checkTrustedApp=true)
	public TrustedApp getTrustedApp(@PathVariable("trustedappid") String trustedAppId, HttpServletRequest request) throws Exception {

		Session session=sessionHelper.getSession(request);
		return serviceFactory.getTrustedAppService().getTrustedAppInfoForDevelopers(trustedAppId, session.getAccount().getUsername(),Constants.DEVELOPER_CONSOLE_SERVICE);

	}

	@RequestMapping(value = "/{trustedappid}/redirecturis", method = RequestMethod.POST)
	@APIMapping(value="DCS_REGISTER_REDIRECT_URI",checkSessionToken=true, checkTrustedApp=true)
	public RedirectUris registerRedirectUris(@PathVariable("trustedappid") String trustedAppId, @RequestBody RedirectUris redirectUris, HttpServletRequest request)
			throws Exception {

		Session session=sessionHelper.getSession(request);

		serviceFactory.getTrustedAppService().registerRedirectUris(trustedAppId, redirectUris.getRedirectUris(), session.getAccount().getUsername(),Constants.DEVELOPER_CONSOLE_SERVICE);

	
		return redirectUris;
	}
	
	
	@RequestMapping(value = "/{trustedappid}/redirecturis", method = RequestMethod.GET)
	@APIMapping(value="DCS_GET_REDIRECT_URIS",checkSessionToken=true, checkTrustedApp=true)
	public RedirectUris getRedirectUris(@PathVariable("trustedappid") String trustedAppId, HttpServletRequest request) throws Exception {

		Session session=sessionHelper.getSession(request);

		List<RedirectUri> redirectUris = serviceFactory.getTrustedAppService().getRedirectUris(trustedAppId, session.getAccount().getUsername(),Constants.DEVELOPER_CONSOLE_SERVICE);

		RedirectUris redirectUrisObj = new RedirectUris();
		
		redirectUrisObj.setRedirectUris(redirectUris);
		return redirectUrisObj;
	}
	
	
	private TrustedApp makeIdOnlyTrustedApp(String trustedAppId) {
		TrustedApp trustedApp = new TrustedApp();
		trustedApp.setTrustedAppId(trustedAppId);
		return trustedApp;
	}
	
	
}