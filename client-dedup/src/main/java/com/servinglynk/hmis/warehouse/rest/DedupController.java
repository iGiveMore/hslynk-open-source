package com.servinglynk.hmis.warehouse.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.domain.Person;
import com.servinglynk.hmis.warehouse.rest.service.DedupService;
import com.servinglynk.hmis.warehouse.util.AuthenticationException;
import com.servinglynk.hmis.warehouse.util.AuthenticationRequest;


@RestController
@RequestMapping("/api/v1")
public class DedupController  extends ControllerBase{
	
	
	 @Autowired
		protected DedupService deDupService;
	 
	 @RequestMapping(value = "/authenticate", 
			 method = RequestMethod.POST)
	 @APIMapping(value="CLIENT_DEDUP_AUTHENTICATE",checkSessionToken=false, checkTrustedApp=false)
		public String authenticate(@RequestBody AuthenticationRequest authRequest) {
			String sessionKey = null;
			try {
				sessionKey = deDupService.authenticate(authRequest);
			} catch (AuthenticationException e) {
				throw new AuthenticationException("Unauthorized");
			}
			return sessionKey;
		}
	 
	 @RequestMapping(value = "/dedup" , method = RequestMethod.POST)
	 @APIMapping(value="CLIENT_DEDUP_SERVICE",checkSessionToken=false, checkTrustedApp=false)
		public Person createReport(@RequestBody Person person,@RequestHeader HttpHeaders headers) throws Exception {
		 	List<String> sessionKeys = (List<String>) headers.get("OPENEMPI_SESSION_KEY");
		 	Person finalPerson = deDupService.dedupingLogic(person, sessionKeys.get(0));
		 	finalPerson.setPersonIdentifiers(null);
		 	return finalPerson;
		}
}
