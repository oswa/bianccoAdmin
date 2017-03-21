/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.persistence.model.Employee;

/**
 * Employee service.
 * 
 * @author SOSExcellence.
 */
public interface EmployeeService {

	/**
	 * Gets the info needed of view to add employee.
	 * 
	 * @param session
	 *            HTTP session.
	 * @return Info.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	EmployeeModuleView getInfoToAdd(HttpSession session) throws DBException;

	/**
	 * Gets an employee.
	 * 
	 * @param session
	 *            HTTP sesiion.
	 * @param idEmployee
	 *            Employee identifier.
	 * @return View.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	EmployeeModuleView getEmployee(HttpSession session, long idEmployee) throws DBException;

	/**
	 * Gets the employee main view.
	 * 
	 * @param session
	 *            HTTP session.
	 * @return View.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	ModelAndView getMainView(HttpSession session) throws DBException;

	/**
	 * Saves an employee.
	 * 
	 * @param detailEncoded
	 *            Employee detail.
	 * @param idRole
	 *            Role identifier.
	 * @return Employee.
	 * @exception DBException
	 *                If a db exception thrown
	 */
	Employee saveEmployee(String detailEncoded, long idRole) throws DBException;

}
