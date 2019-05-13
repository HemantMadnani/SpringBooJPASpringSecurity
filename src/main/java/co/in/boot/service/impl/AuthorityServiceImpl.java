package co.in.boot.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import co.in.boot.model.Authority;
import co.in.boot.service.AuthorityService;

@Service
public class AuthorityServiceImpl extends BaseServiceImpl<Authority, Long> implements AuthorityService {

	@PostConstruct
	private void setBaseDao() {

		super.baseDao = getDaoFactory().getAuthorityDao();
	}

	@Override
	public Authority saveAuthority(final Authority entity) {

		return getDaoFactory().getAuthorityDao().save(entity);
	}

}
