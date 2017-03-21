/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import java.util.List;

import com.biancco.admin.model.catalog.RoleSimpleRecord;
import com.biancco.admin.model.employee.EmployeeSimpleRecord;
import com.biancco.admin.persistence.model.Employee;
import com.biancco.admin.persistence.model.PermissionType;

/**
 * Initial information for module views.
 * 
 * @author SOSExcellence.
 */
public class EmployeeModuleView {
	/**
	 * Employee list.
	 */
	private List<EmployeeSimpleRecord> employees;
	/**
	 * Permission type.
	 */
	private PermissionType pType;
	/**
	 * Employee.
	 */
	private Employee employee;
	/**
	 * Roles.
	 */
	private List<RoleSimpleRecord> roles;

	/**
	 * @return the employees.
	 */
	public List<EmployeeSimpleRecord> getEmployees() {
		return employees;
	}

	/**
	 * @param result
	 *            the employees to set.
	 */
	public void setEmployees(List<EmployeeSimpleRecord> employees) {
		this.employees = employees;
	}

	/**
	 * @return the pType.
	 */
	public PermissionType getpType() {
		return pType;
	}

	/**
	 * @param pType
	 *            the pType to set.
	 */
	public void setpType(PermissionType pType) {
		this.pType = pType;
	}

	/**
	 * @return the employee.
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set.
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the roles.
	 */
	public List<RoleSimpleRecord> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set.
	 */
	public void setRoles(List<RoleSimpleRecord> roles) {
		this.roles = roles;
	}

}
