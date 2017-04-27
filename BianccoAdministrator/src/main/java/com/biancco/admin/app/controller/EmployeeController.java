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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.service.CommonService;
import com.biancco.admin.service.EmployeeService;

/**
 * Employee controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController extends ExceptionController {
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
	 * Common service.
	 */
	@Autowired
	private CommonService commonService;

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
		// add view to history
		this.commonService.addViewToHistory(view, false, session);
		return view;
	}

	/**
	 * Shows view to edit employee.
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
	@RequestMapping(method = RequestMethod.POST, value = "/edit")
	public ModelAndView editEmployee(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_emp", required = true) long idEmployee)
			throws ApplicationException, DBException {
		this.logger.info("Controller | editEmployee " + idEmployee);
		// get info needed of view
		EmployeeModuleView info = this.employeeService.getEmployee(session, idEmployee);
		// build view
		ModelAndView view = new ModelAndView("/page/employee/new_edit");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		// add view to history
		this.commonService.addViewToHistory(view, false, session);
		return view;
	}

	/**
	 * Saves an employee.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @param detailEncoded
	 *            Employee detail.
	 * @param idRole
	 *            Role identifier.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ModelAndView saveEmployee(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_detail", required = true) String detailEncoded,
			@RequestParam(value = "_role", required = true) long idRole) throws ApplicationException, DBException {
		this.logger.info("Controller | saveEmployee " + detailEncoded + " - " + idRole);
		this.employeeService.saveEmployee(detailEncoded, idRole);
		// build view
		ModelAndView view = this.employeeService.getMainView(session);
		// add view to history
		this.commonService.addViewToHistory(view, true, session);
		return view;
	}

	/**
	 * Updates an employee.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @param detailEncoded
	 *            Employee detail.
	 * @param idRole
	 *            Role identifier.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public ModelAndView updateEmployee(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_detail", required = true) String detailEncoded,
			@RequestParam(value = "_role", required = true) long idRole,
			@RequestParam(value = "_emp", required = true) long idEmployee) throws ApplicationException, DBException {
		this.logger.info("Controller | updateEmployee " + detailEncoded + " - " + idRole + " - " + idEmployee);
		this.employeeService.updateEmployee(detailEncoded, idRole, idEmployee);
		// build view
		ModelAndView view = this.employeeService.getMainView(session);
		// add view to history
		this.commonService.addViewToHistory(view, true, session);
		return view;
	}
}
