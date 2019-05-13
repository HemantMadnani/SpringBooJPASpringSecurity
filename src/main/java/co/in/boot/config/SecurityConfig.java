package co.in.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import co.in.boot.service.LoginUserDetailsService;

/**
 * @author hemant.madnani
 *
 */
@EnableWebSecurity
@ComponentScan("co.in.boot")
@DependsOn("serviceRegistry")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.
	 * authentication.builders.AuthenticationManagerBuilder)
	 */
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

		super.configure(auth);
		auth.authenticationProvider(authenticationProvider());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#authenticationManagerBean()
	 */
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	/**
	 * @return
	 */
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return authenticationProvider;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#userDetailsService()
	 */
	@Override
	@Bean
	public UserDetailsService userDetailsService() {

		return new LoginUserDetailsService();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.
	 * web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/login", "/register").permitAll().antMatchers("/admin").hasAuthority("ROLE_ADMIN").antMatchers("/user")
				.hasAuthority("ROLE_USER").and().formLogin().usernameParameter("email").passwordParameter("password").loginPage("/login")
				.loginProcessingUrl("/authLog").defaultSuccessUrl("/home").failureUrl("/login?error").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logout");
	}

	/**
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

}
