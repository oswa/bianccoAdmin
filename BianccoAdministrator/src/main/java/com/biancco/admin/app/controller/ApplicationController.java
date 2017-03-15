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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.service.CommonService;

/**
 * View Controller.
 * 
 * @author SOSExcellence.
 */
@Controller
public class ApplicationController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Common service.
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * Gets view by module.
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
	@RequestMapping(method = RequestMethod.POST, value = "/{module}")
	public ModelAndView getModuleView(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @PathVariable final String module) throws ApplicationException, DBException {
		this.logger.info("Controller | " + module);
		// build view
		ModelAndView view = this.commonService.getViewByModule(module, session);
		return view;
	}

}
