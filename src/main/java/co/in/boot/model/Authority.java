package co.in.boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {

	@Id
	@GeneratedValue(generator = "increment", strategy = GenerationType.AUTO)
	@Column(name = "authority_id")
	private Long id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "description")
	private String description;

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
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(final String name) {

		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {

		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(final String description) {

		this.description = description;
	}

}
