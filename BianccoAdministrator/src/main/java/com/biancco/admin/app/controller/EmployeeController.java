/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.service.EmployeeService;

/**
 * Employee controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Employee service.
	 */
	@Autowired
	private EmployeeService employeeService;

	/**
	 * Shows view to add employee.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ModelAndView addEmployee(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session) throws ApplicationException, DBException {
		this.logger.info("Controller | addEmployee");
		// get info needed of view
		EmployeeModuleView info = this.employeeService.getInfoToAdd(session);
		// build view
		ModelAndView view = new ModelAndView("/page/employee/new_edit");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		return view;
	}
}
