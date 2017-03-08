/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.Employee;

/**
 * Manage the persistent info for an employee.
 * 
 * @author SOSExcellence.
 *
 */
public interface EmployeeDAO {
	/**
	 * Return an Employee based on its id.
	 * 
	 * @param idEmployee
	 *            the identifier.
	 * @return the Employee object corresponding to the id.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Employee getById(long idEmployee) throws DBException;

	/**
	 * Return an Employee based on its id.
	 * 
	 * @param nick
	 *            the identifier for the user.
	 * @return the Employee object corresponding to the id.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Employee getByNick(String nick) throws DBException;

	/**
	 * Insert a new Employee.
	 * 
	 * @param employee
	 *            The employee.
	 * @return Employee.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Employee save(Employee employee) throws DBException;

	/**
	 * Delete an Employee from persistent data.
	 * 
	 * @param employee
	 *            the element to delete.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(Employee employee) throws DBException;

	/**
	 * Update an Employee in persistent data.
	 * 
	 * @param employee
	 *            the element to update.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void update(Employee employee) throws DBException;

	/**
	 * Validates the user credentials.
	 * 
	 * @param nick
	 *            The user nick.
	 * @param pass
	 *            The password.
	 * @return A valid employee.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Employee validateCredentials(String nick, String pass) throws DBException;
}
