/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.biancco.admin.model.view.SimpleResponse;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.model.EmployeeDetail;
import com.biancco.admin.service.AuthenticationService;

/**
 * Authentication service implementation.
 * 
 * @author SOSExcellence.
 */
public class AuthenticationServiceImpl implements AuthenticationService {
	/**
	 * The employee DAO.
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleResponse validateUser(final HttpServletRequest request, HttpSession session) {
		SimpleResponse response = new SimpleResponse();
		if (request.getAttribute("user") != null && request.getAttribute("pwd") != null) {
			String user = StringUtils.trimToEmpty((String) request.getAttribute("user"));
			String pass = (String) request.getAttribute("pwd");
			// get user & pass from db
			EmployeeDetail employee = this.employeeDAO.getEmployeeByNick(user, pass);
			// TODO validate all scenarios
			if (employee == null) {
				response.setMessage("Usuario no encontrado");
			}
			// create session
			session.setAttribute("employee", employee);
		} else {
			response.setMessage("Verifica usuario y contraseña y vuelve a intentar");
		}
		return response;
	}

}
