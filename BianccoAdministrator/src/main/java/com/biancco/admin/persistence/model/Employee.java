/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author SOSExcellence.
 */
@Entity
@Table(name = "employee")
public class Employee {
	/**
	 * Identifier.
	 */
	@Id
	@Column(name = "id_employee")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmployee;
	/**
	 * The employee detail.
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
	private EmployeeDetail employeeDetail;
	/**
	 * The role.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role")
	private Role role;
	/**
	 * The nick;
	 */
	@Column(name = "nick")
	private String nick;
	/**
	 * The password.
	 */
	@Column(name = "password")
	private String password;
	/**
	 * Enable flag.
	 */
	@Column(name = "enable")
	@Convert(converter = BooleanYNConverter.class)
	private Boolean enable = false;

	/**
	 * @return the idEmployee.
	 */
	public Long getIdEmployee() {
		return idEmployee;
	}

	/**
	 * @param idEmployee
	 *            the idEmployee to set.
	 */
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
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
	 * @return the nick.
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick
	 *            the nick to set.
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * @return the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the employeeDetail.
	 */
	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	/**
	 * @param employeeDetail
	 *            the employeeDetail to set.
	 */
	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
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
}
