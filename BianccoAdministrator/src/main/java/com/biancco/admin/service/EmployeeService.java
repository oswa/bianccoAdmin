/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import javax.servlet.http.HttpSession;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.view.EmployeeModuleView;

/**
 * Employee service.
 * 
 * @author SOSExcellence.
 */
public interface EmployeeService {

	/**
	 * Gets info needed of view to add employee.
	 * 
	 * @param session
	 *            HTTP session.
	 * @return Info.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	EmployeeModuleView getInfoToAdd(HttpSession session) throws DBException;

}
