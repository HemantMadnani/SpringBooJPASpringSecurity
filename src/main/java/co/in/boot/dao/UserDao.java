package co.in.boot.dao;

import org.springframework.stereotype.Repository;

import co.in.boot.model.User;

@Repository
public interface UserDao extends BaseDao<User, Long> {

	public User findByEmail(String username);

}
