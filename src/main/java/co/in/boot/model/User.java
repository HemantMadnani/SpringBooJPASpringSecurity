package co.in.boot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	private int active;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), name = "user_role")
	private Set<Role> roles = new HashSet<>();

	public User(final String email, final String password) {

		super();
		this.email = email;
		this.password = password;
	}

	public User() {

	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {

		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(final Set<Role> roles) {

		this.roles = roles;
	}

	/**
	 * @return the active
	 */
	public int getActive() {

		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(final int active) {

		this.active = active;
	}

	/**
	 * @return the id
	 */
	public Long getId() {

		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(final Long id) {

		this.id = id;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(final String email) {

		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {

		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(final String password) {

		this.password = password;
	}

}
