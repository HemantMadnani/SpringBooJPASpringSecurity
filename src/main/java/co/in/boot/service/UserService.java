package co.in.boot.service;

import co.in.boot.model.User;

public interface UserService {

	public User findByEmail(String username);

	public User addUser(User user);

}
