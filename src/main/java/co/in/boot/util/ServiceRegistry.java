package co.in.boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.in.boot.service.AuthorityService;
import co.in.boot.service.RoleService;
import co.in.boot.service.UserService;

@Component("serviceRegistry")
public class ServiceRegistry {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private AuthorityService authorityService;

	/**
	 * @return the authorityService
	 */
	public AuthorityService getAuthorityService() {

		return authorityService;
	}

	/**
	 * @return the userService
	 */
	public UserService getUserService() {

		return userService;
	}

	/**
	 * @return the roleService
	 */
	public RoleService getRoleService() {

		return roleService;
	}

}
