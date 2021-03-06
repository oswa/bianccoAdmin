/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.view.InitialView;
import com.biancco.admin.model.view.OptionMenu;
import com.biancco.admin.model.view.SimpleResponse;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.model.Employee;
import com.biancco.admin.persistence.model.Permission;
import com.biancco.admin.persistence.model.PermissionType;
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
	 * The modules.
	 */
	private static final Map<String, String> modules;
	/**
	 * initialize modules.
	 */
	static {
		modules = new HashMap<String, String>();
		modules.put("EMPRESAS", "company");
		modules.put("EMPLEADOS", "employee");
		modules.put("OBRAS", "work");
		// modules.put("CONFIGURACION", "configuration");
	}
	/**
	 * The links.
	 */
	private static final Map<String, String> icons;
	/**
	 * initialize links.
	 */
	static {
		icons = new HashMap<String, String>();
		icons.put("EMPRESAS", "folder-home.png");
		icons.put("EMPLEADOS", "users.png");
		icons.put("OBRAS", "work.png");
	}
	/**
	 * Configuration option.
	 */
	private static final String CONFIG_OPTION = "CONFIGURACION";

	/**
	 * {@inheritDoc}
	 * 
	 * @throws DBException
	 */
	@Override
	public SimpleResponse validateUser(final HttpServletRequest request, HttpSession session) throws DBException {
		SimpleResponse response = new SimpleResponse();
		if (request.getParameter("user") != null && request.getParameter("pwd") != null) {
			String user = StringUtils.trimToEmpty((String) request.getParameter("user"));
			String pass = StringUtils.trimToEmpty((String) request.getParameter("pwd"));
			// get user & pass from db
			Employee employee = this.employeeDAO.validateCredentials(user, pass);
			// TODO validate all scenarios
			if (employee == null) {
				response.setMessage("Usuario no encontrado");
			}
			// create session
			session.setAttribute(BianccoConstants.ATTR_USER, employee);
		} else {
			response.setMessage("Verifica usuario y contraseña y vuelve a intentar");
		}
		return response;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InitialView getInitialView(Employee employee, HttpSession session) {
		InitialView view = new InitialView();
		// assign name
		String name = employee.getNick();
		if (employee.getEmployeeDetail() != null) {
			name = employee.getEmployeeDetail().getName();
		}
		view.setName(name);
		// extract permissions
		for (Permission p : employee.getRole().getPermissions()) {
			String moduleName = p.getModule().getName();

			if (moduleName.equals(CONFIG_OPTION)) {
				// set permission to session
				session.setAttribute("config", true);

				view.setConfigOption(true);
				continue;
			}
			String moduleId = modules.get(moduleName);
			PermissionType pType = p.getType();
			OptionMenu o = new OptionMenu();
			o.setOption(formatOptionMenu(moduleName));
			o.setType(pType);
			o.setModule(moduleId);
			o.setIcon(icons.get(moduleName));
			if (!moduleName.equals("OBRAS")) {
				view.addOption(o);
			}
			// set permission to session
			session.setAttribute(moduleId, pType);
		}
		return view;
	}

	/**
	 * Formats module name to menu option.
	 * 
	 * @param moduleName
	 *            The module name.
	 * @return menu option name.
	 */
	private String formatOptionMenu(String moduleName) {
		return moduleName.substring(0, 1).toUpperCase() + moduleName.substring(1).toLowerCase();
	}

}
