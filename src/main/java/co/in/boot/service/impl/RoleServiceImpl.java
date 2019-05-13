package co.in.boot.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import co.in.boot.model.Role;
import co.in.boot.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Long> implements RoleService {

	@PostConstruct
	private void setBaseDao() {

		super.baseDao = getDaoFactory().getRoleDao();
	}

	@Override
	public Role saveRole(final Role entity) {

		return getDaoFactory().getRoleDao().save(entity);
	}

}
