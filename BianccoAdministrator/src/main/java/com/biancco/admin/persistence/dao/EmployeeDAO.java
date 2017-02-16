/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import com.biancco.admin.persistence.model.EmployeeDetail;

/**
 * Manage the persisten info for an employee.
 * 
 * @author SOSExcellence.
 *
 */
public interface EmployeeDAO {
	/**
	 * Return an Employee based on its id
	 * 
	 * @param idEmployee
	 *            the identitifier
	 * @return the Employee object corresponding to the id
	 */
	EmployeeDetail getEmployeeById(long idEmployee);

	/**
	 * Return an Employee based on its id
	 * 
	 * @param nick
	 *            the identitifier for the user
	 * @param pass
	 *            the password.
	 * @return the Employee object corresponding to the id
	 */
	EmployeeDetail getEmployeeByNick(String nick, String pass);

	/**
	 * Insert a new Employee
	 * 
	 * @param Employee
	 * @return true if successful
	 */
	boolean insertEmployee(EmployeeDetail Employee);

	/**
	 * Delete an Employee from persistent data
	 * 
	 * @param Employee
	 *            the element to delete
	 * @return true id successful
	 */
	boolean deleteEmployee(EmployeeDetail Employee);

	/**
	 * Update an Employee in persisten data
	 * 
	 * @param Employee
	 *            the element to update
	 * @return true id successful
	 */
	boolean updateEmployee(EmployeeDetail Employee);
}
