/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a Parameter.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "PARAMETERS")
public class Parameter {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "ID_PARAM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long identifier;
	/**
	 * The group.
	 */
	@Column(name = "GROUP_PARAM")
	private String group;
	/**
	 * The name.
	 */
	@Column(name = "NAME")
	private String name;
	/**
	 * The value.
	 */
	@Column(name = "VALUE_PARAM")
	private String value;
	/**
	 * The description.
	 */
	@Column(name = "DESCRIPTION")
	private String description;

	/**
	 * @return the identifier.
	 */
	public Long getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier
	 *            the identifier to set.
	 */
	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the group.
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set.
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
