package co.in.boot.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.in.boot.model.Authority;
import co.in.boot.model.Role;
import co.in.boot.model.User;
import co.in.boot.util.ServiceRegistry;

@RestController
public class HomeController {

	@Autowired
	private ServiceRegistry serviceRegistry;

	@GetMapping("/")
	public ModelAndView loadHome() {

		return new ModelAndView("home");
	}

	@GetMapping("/testData")
	public String enterDaata() {

		final Authority authority = new Authority();
		authority.setDescription("Add authority");
		authority.setName("ADD");

		serviceRegistry.getAuthorityService().saveAuthority(authority);
		final Set<Authority> authorities = new HashSet<>();
		authorities.add(authority);

		final Role role = new Role();
		role.setDescription("ROle for user");
		role.setName("ROLE_USER");
		role.setAuthorities(authorities);
		serviceRegistry.getRoleService().saveRole(role);

		final Set<Role> roles = new HashSet<>();
		roles.add(role);

		final User user = new User();
		user.setEmail("admin@gmail.com");
		user.setPassword(bCryptPasswordEncoder().encode("Rob@1234"));
		user.setActive(1);
		user.setRoles(roles);

		serviceRegistry.getUserService().addUser(user);
		return "Data Entered";
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
