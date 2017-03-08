/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.view.InitialView;
import com.biancco.admin.model.view.SimpleResponse;
import com.biancco.admin.persistence.model.Employee;

/**
 * Authentication service.
 * 
 * @author SOSExcellence.
 */
public interface AuthenticationService {
	/**
	 * Validates user.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param session
	 *            The HTTP session.
	 * @return Simple response object.
	 * @throws ApplicationException
	 *             If a problem occurs.
	 * @throws DBException
	 *             If a db problem occurs.
	 */
	SimpleResponse validateUser(final HttpServletRequest request, HttpSession session)
			throws ApplicationException, DBException;

	/**
	 * Gets the initial view.
	 * 
	 * @param employee
	 *            The employee signed.
	 * @return Initial view.
	 */
	InitialView getInitialView(Employee employee);
}
