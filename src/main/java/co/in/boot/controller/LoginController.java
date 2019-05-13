package co.in.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.in.boot.model.User;

@RestController
public class LoginController {

	@GetMapping("/login")
	public ModelAndView loadLogin() {

		return new ModelAndView("login", "user", new User());
	}

}
