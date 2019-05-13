package co.in.boot.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class LoginUserDetail implements UserDetails {

	private static final long serialVersionUID = 817709038367553607L;

	private final User user;

	public LoginUserDetail(final User user) {

		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		final List<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			role.getAuthorities().forEach(auth -> authorities.add(new SimpleGrantedAuthority(auth.getName())));
		});
		return authorities;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {

		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
