/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.persistence.model.Role;
import com.biancco.admin.service.CommonService;
import com.biancco.admin.service.EmployeeService;

/**
 * Employee service implementation.
 * 
 * @author SOSExcellence.
 */
public class EmployeeServiceImpl implements EmployeeService {
	/**
	 * Common service.
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeeModuleView getInfoToAdd(HttpSession session) throws DBException {
		EmployeeModuleView view = new EmployeeModuleView();
		List<Role> roles = this.commonService.getRoles(true);
		view.setRoles(roles);
		view.setpType((PermissionType) session.getAttribute("employee"));
		return view;
	}

}
