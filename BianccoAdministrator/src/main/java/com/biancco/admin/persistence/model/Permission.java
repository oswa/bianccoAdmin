/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Permission.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "permission")
public class Permission {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_permission")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPermission;
	/**
	 * The module
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_module")
	private Module module;
	/**
	 * The role.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role")
	private Role role;
	/**
	 * The type.
	 */
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private PermissionType type;

	/**
	 * @return the idPermission.
	 */
	public Long getIdPermission() {
		return idPermission;
	}

	/**
	 * @param idPermission
	 *            the idPermission to set.
	 */
	public void setIdPermission(Long idPermission) {
		this.idPermission = idPermission;
	}

	/**
	 * @return the module.
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set.
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * @return the role.
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set.
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the type.
	 */
	public PermissionType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set.
	 */
	public void setType(PermissionType type) {
		this.type = type;
	}
}
