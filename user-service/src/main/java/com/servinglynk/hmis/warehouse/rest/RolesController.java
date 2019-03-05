package com.servinglynk.hmis.warehouse.rest;

import static com.servinglynk.hmis.warehouse.common.Constants.USER_SERVICE;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Role;
import com.servinglynk.hmis.warehouse.core.model.Roles;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.core.web.interceptor.SessionHelper;

@RestController
@RequestMapping("/roles")
public class RolesController extends ControllerBase {
	
	
	@RequestMapping(method=RequestMethod.POST)
	@APIMapping(value="ACL_CREATE_ROLE",checkTrustedApp=true,checkSessionToken=true)
	public Role createRole(@RequestBody Role role,HttpServletRequest request) throws Exception {
	  return serviceFactory.getRoleService().createRole(role,USER_SERVICE);
	}
	
	@RequestMapping(value="/{roleId}",method=RequestMethod.PUT)
	@APIMapping(value="ACL_UPDATE_ROLE",checkTrustedApp=true,checkSessionToken=true)
	public Role updateRole(@PathVariable("roleId") String roleId ,@RequestBody Role role,HttpServletRequest request) throws Exception  {
		return serviceFactory.getRoleService().updateRole(role,USER_SERVICE);
	}

	@RequestMapping(value="/{roleId}",method=RequestMethod.DELETE)
	@APIMapping(value="ACL_DELETE_ROLE",checkTrustedApp=true,checkSessionToken=true)
	public Role deleteRole(@PathVariable("roleId") UUID roleId, HttpServletRequest request) throws Exception {
		return serviceFactory.getRoleService().deleteRole(roleId);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="ACL_GET_ALL_ROLES",checkTrustedApp=true,checkSessionToken=true)
	public Roles getAllRoles( @RequestParam(value="startIndex", required=false,defaultValue="0") Integer startIndex,
				@RequestParam(value="maxItems", required=false,defaultValue="30") Integer maxItems,
				HttpServletRequest request) throws Exception {
			
			if (maxItems > 50)  maxItems = 50;
			
			Session session = sessionHelper.getSession(request);
			
			return serviceFactory.getRoleService().getAllRoles(session.getAccount(),startIndex,maxItems);
	}
}