/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.model.view.SimpleResponse;

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
	 */
	SimpleResponse validateUser(final HttpServletRequest request, HttpSession session) throws ApplicationException;
}
