/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BeanUtils;
import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.app.util.UserPasswordGenerator;
import com.biancco.admin.model.catalog.RoleSimpleRecord;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.dao.EmployeeDetailDAO;
import com.biancco.admin.persistence.model.Employee;
import com.biancco.admin.persistence.model.EmployeeDetail;
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
	 * Employee DAO.
	 */
	@Autowired
	private EmployeeDAO employeeDAO;
	/**
	 * Employee detail DAO.
	 */
	@Autowired
	private EmployeeDetailDAO employeeDetailDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeeModuleView getInfoToAdd(HttpSession session) throws DBException {
		EmployeeModuleView view = new EmployeeModuleView();
		List<RoleSimpleRecord> roles = this.commonService.getRoles(true);
		view.setRoles(roles);
		view.setpType((PermissionType) session.getAttribute("employee"));
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeeModuleView getEmployee(HttpSession session, long idEmployee) throws DBException {
		EmployeeModuleView view = new EmployeeModuleView();
		List<RoleSimpleRecord> roles = this.commonService.getRoles(true);
		Employee emp = this.employeeDAO.getById(idEmployee);
		view.setRoles(roles);
		view.setpType((PermissionType) session.getAttribute("employee"));
		view.setEmployee(emp);
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView getMainView(HttpSession session) throws DBException {
		return this.commonService.getViewByModule("employee", session);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee saveEmployee(String detailEncoded, long idRole) throws DBException {
		// employee detail
		EmployeeDetail d = (EmployeeDetail) HTTPUtils.getObjectFromFormString(detailEncoded, EmployeeDetail.class);
		// role
		Role r = new Role();
		r.setIdRole(idRole);
		// generate user & password
		Employee e = new Employee();
		e.setEnable(true);
		e.setNick(UserPasswordGenerator.getUserByMail(d.getMail()));
		e.setPassword(UserPasswordGenerator.getPassword());
		e.setRole(r);
		// set employee to detail
		d.setEmployee(e);
		// set detail to employee
		e.setEmployeeDetail(d);
		// save
		return this.employeeDAO.save(e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee updateEmployee(String detailEncoded, long idRole, long idEmployee) throws DBException {
		// employee detail
		Map<String, String> detailProps = HTTPUtils.getPropertiesFromEncodedString(detailEncoded);
		// get employee to update
		Employee e = this.employeeDAO.getById(idEmployee);
		// role
		Role r = new Role();
		r.setIdRole(idRole);
		// set changes
		e.setRole(r);
		BeanUtils.setPropertiesToObject(e.getEmployeeDetail(), detailProps);
		// set nick if mail was change
		e.setNick(UserPasswordGenerator.getUserByMail(e.getEmployeeDetail().getMail()));
		// update
		return this.employeeDAO.update(e);
	}
}
