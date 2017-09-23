/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;
import java.util.Map;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.employee.EmployeeSimpleRecord;
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
	 * @param idEmployee
	 *            the element to delete.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(long idEmployee) throws DBException;

	/**
	 * Update an Employee in persistent data.
	 * 
	 * @param employee
	 *            the element to update.
	 * @return Employee updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Employee update(Employee employee) throws DBException;

	/**
	 * Updates a specific fields on Employee.
	 * 
	 * @return Employee updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Employee update(long idEmployee, Map<String, String> properties) throws DBException;

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

	/**
	 * Gets all employees (simple record).
	 * 
	 * @return A employee list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<EmployeeSimpleRecord> getAll() throws DBException;

	/**
	 * Get employees where the role is superintendente or residente.
	 * 
	 * @return Employee list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<EmployeeSimpleRecord> getResidentesAndSuperintendentes() throws DBException;
}
