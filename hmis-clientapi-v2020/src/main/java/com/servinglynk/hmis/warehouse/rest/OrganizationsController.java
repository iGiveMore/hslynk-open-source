package com.servinglynk.hmis.warehouse.rest; 

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.model.Organization;
import com.servinglynk.hmis.warehouse.core.model.Organizations;

@RestController
@RequestMapping("/organizations")
public class OrganizationsController extends ControllerBase { 

   @RequestMapping(method=RequestMethod.POST)
   @APIMapping(value="CLIENT_API_CREATE_CLIENT",checkTrustedApp=true,checkSessionToken=true)
   public Organization createOrganization(@RequestBody Organization organization,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        return serviceFactory.getOrganizationService().createOrganization(organization,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{organizationid}",method=RequestMethod.PUT)
   @APIMapping(value="CLIENT_API_UPDATE_ORGANIZATION",checkTrustedApp=true,checkSessionToken=true)
   public Organization updateOrganization(@PathVariable( "organizationId" ) UUID organizationId,@RequestBody Organization organization,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        organization.setOrganizationId(organizationId);
        return serviceFactory.getOrganizationService().updateOrganization(organization,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{organizationId}",method=RequestMethod.DELETE)
   @APIMapping(value="CLIENT_API_DELETE_ORGANIZATION",checkTrustedApp=true,checkSessionToken=true)
   public Organization deleteOrganization(@PathVariable( "organizationId" ) UUID organizationId,HttpServletRequest request) throws Exception{
        Session session = sessionHelper.getSession(request); 
        return serviceFactory.getOrganizationService().deleteOrganization(organizationId,session.getAccount().getUsername()); 
   }

   @RequestMapping(value="/{organizationId}",method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ORGANIZATION_BY_ID",checkTrustedApp=true,checkSessionToken=true)
   public Organization getOrganizationById(@PathVariable( "organizationId" ) UUID organizationId,HttpServletRequest request) throws Exception{
        return serviceFactory.getOrganizationService().getOrganizationById(organizationId); 
   }

   @RequestMapping(method=RequestMethod.GET)
   @APIMapping(value="CLIENT_API_GET_ALL_ORGANIZATIONS",checkTrustedApp=true,checkSessionToken=true)
   public Organizations getAllOrganizations( @RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null) maxItems =30;
           Session session = sessionHelper.getSession(request);
        return serviceFactory.getOrganizationService().getAllOrganizations(session.getAccount().getProjectGroup().getProjectGroupCode(),startIndex,maxItems); 
   }

}

