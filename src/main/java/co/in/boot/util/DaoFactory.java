package co.in.boot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.in.boot.dao.AuthorityDao;
import co.in.boot.dao.RoleDao;
import co.in.boot.dao.UserDao;

@Component
public class DaoFactory {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private AuthorityDao authorityDao;

	/**
	 * @return the authorityDao
	 */
	public AuthorityDao getAuthorityDao() {

		return authorityDao;
	}

	/**
	 * @return the userDao
	 */
	public UserDao getUserDao() {

		return userDao;
	}

	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {

		return roleDao;
	}

}
