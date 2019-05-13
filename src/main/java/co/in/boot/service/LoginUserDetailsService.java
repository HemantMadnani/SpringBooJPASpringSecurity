package co.in.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.in.boot.model.LoginUserDetail;
import co.in.boot.model.User;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		final User user = userService.findByEmail(username);
		if (user != null) {
			return new LoginUserDetail(user);
		}
		throw new UsernameNotFoundException("Invalid Credentials");
	}

}
