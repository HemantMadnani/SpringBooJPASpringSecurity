package co.in.boot.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import co.in.boot.model.User;
import co.in.boot.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	@PostConstruct
	private void setBaseDao() {

		super.baseDao = getDaoFactory().getUserDao();
	}

	@Override
	public User findByEmail(final String username) {

		return getDaoFactory().getUserDao().findByEmail(username);
	}

	@Override
	public User addUser(final User user) {

		return getDaoFactory().getUserDao().save(user);
	}

}
