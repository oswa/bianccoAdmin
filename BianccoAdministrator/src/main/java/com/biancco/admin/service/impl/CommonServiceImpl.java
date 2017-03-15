/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.employee.EmployeeBasicRecord;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.dao.RoleDAO;
import com.biancco.admin.persistence.model.Employee;
import com.biancco.admin.persistence.model.Permission;
import com.biancco.admin.persistence.model.Role;
import com.biancco.admin.service.CommonService;

/**
 * Common service implementation.
 * 
 * @author SOSExcellence.
 */
public class CommonServiceImpl implements CommonService {
	/**
	 * Employee DAO.
	 */
	@Autowired
	private EmployeeDAO employeeDAO;
	/**
	 * Role DAO.
	 */
	@Autowired
	private RoleDAO roleDAO;
	/**
	 * The main pages for modules.
	 */
	private static final Map<String, String> pages;
	/**
	 * initialize pages.
	 */
	static {
		pages = new HashMap<String, String>();
		pages.put("company", "list");
		pages.put("employee", "list");
		// modules.put("CONFIGURACION", "configuration");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView getViewByModule(String module, HttpSession session) throws DBException {
		// build view
		ModelAndView view = new ModelAndView("/page/" + module + "/" + pages.get(module));
		// get initial information
		EmployeeModuleView info = this.getInitialInformationByModule(module, session);
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		return view;
	}

	/**
	 * Gets initial information by module view.
	 * 
	 * @param module
	 *            The module.
	 * @param session
	 *            HTTP session.
	 * @return Initial information.
	 * @throws DBException
	 */
	private EmployeeModuleView getInitialInformationByModule(String module, HttpSession session) throws DBException {
		// extract permissions
		Employee e = (Employee) session.getAttribute(BianccoConstants.ATTR_USER);
		List<Permission> permissions = e.getRole().getPermissions();
		// set info by module
		EmployeeModuleView info = new EmployeeModuleView();
		if ("employee".equals(module)) {
			this.setEmployees(info);
			this.setPermission(info, permissions);
		}
		return info;
	}

	/**
	 * Sets employees to info model.
	 * 
	 * @param info
	 *            The info.
	 * @throws DBException
	 */
	private void setEmployees(EmployeeModuleView info) throws DBException {
		List<EmployeeBasicRecord> result = this.employeeDAO.getAll();
		info.setEmployees(result);
	}

	/**
	 * Sets permission type to info model.
	 * 
	 * @param info
	 *            Info model.
	 * @param permissions
	 *            Permission list.
	 */
	private void setPermission(EmployeeModuleView info, List<Permission> permissions) {
		for (Permission p : permissions) {
			if (p.getModule().equals("EMPLEADOS")) {
				info.setpType(p.getType());
				break;
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> getRoles(boolean enabledOnly) throws DBException {
		return this.roleDAO.getAll(enabledOnly);
	}

}
