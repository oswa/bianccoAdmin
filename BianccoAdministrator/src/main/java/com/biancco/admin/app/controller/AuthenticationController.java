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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.view.InitialView;
import com.biancco.admin.model.view.SimpleResponse;
import com.biancco.admin.persistence.model.Employee;
import com.biancco.admin.service.AuthenticationService;

/**
 * Authentication controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/login")
public class AuthenticationController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * The authentication service.
	 */
	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * Sign in.
	 * 
	 * @param response
	 *            The HTTP response.
	 * @return view.
	 * @throws DBException
	 * @throws ApplicationException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public ModelAndView signin(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, RedirectAttributes attributes) throws ApplicationException, DBException {
		this.logger.info("Controller | signin");
		// validate user
		SimpleResponse rsp = this.authenticationService.validateUser(request, session);
		// build view
		ModelAndView view = new ModelAndView("/page/main");
		// validate session
		if (session.getAttribute(BianccoConstants.ATTR_USER) != null) {
			Employee emp = (Employee) session.getAttribute(BianccoConstants.ATTR_USER);
			InitialView iView = this.authenticationService.getInitialView(emp, session);
			view.addObject(BianccoConstants.MODEL_ATTRIBUTE, iView);
		} else {
			view.setViewName("/login");
			view.addObject(BianccoConstants.MODEL_ATTRIBUTE, rsp);
		}
		return view;
	}

	/**
	 * Sign off.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param session
	 *            The HTTP session.
	 * @return login view.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/signoff")
	public RedirectView signoff(final HttpServletRequest request, final HttpSession session) {
		this.logger.info("Controller | signoff");
		session.removeAttribute("token");
		session.invalidate();
		RedirectView view = new RedirectView("/login.jsp");
		view.setContextRelative(true);
		return view;
	}
}
