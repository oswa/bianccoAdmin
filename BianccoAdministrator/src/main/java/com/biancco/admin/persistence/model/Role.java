/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Role.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "role")
public class Role {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_role")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	/**
	 * The name.
	 */
	@Column(name = "role")
	private String name;
	/**
	 * The description.
	 */
	@Column(name = "description")
	private String description;
	/**
	 * Enable flag.
	 */
	@Column(name = "enable")
	private Boolean enable = false;
	/**
	 * Permission list.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<Permission> permissions;

	/**
	 * @return the idRole.
	 */
	public Long getIdRole() {
		return idRole;
	}

	/**
	 * @param idRole
	 *            the idRole to set.
	 */
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
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

	/**
	 * @return the enable.
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set.
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * @return the modules.
	 */
	public Set<Permission> getPermissions() {
		return permissions;
	}

	/**
	 * @param modules
	 *            the modules to set.
	 */
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
