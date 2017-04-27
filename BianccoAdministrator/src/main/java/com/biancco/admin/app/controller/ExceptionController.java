/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.AuthenticationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.model.view.SimpleResponse;

/**
 * Exception Controller.
 * 
 * @author SOSExcellence.
 */
@Controller
public class ExceptionController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();

	/**
	 * Handles Authentication exception.
	 * 
	 * @param exception
	 *            The exception.
	 * @param response
	 *            HTTP response.
	 * @return View.
	 */
	@ExceptionHandler(AuthenticationException.class)
	@ResponseBody
	public ModelAndView handleAuthenticationException(final AuthenticationException exception,
			final HttpServletResponse response) {
		this.logger.error("AuthenticationException", exception);
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		SimpleResponse rsp = new SimpleResponse();
		rsp.setMessage(exception.getMessage());
		ModelAndView view = new ModelAndView("/login");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, rsp);

		return view;
	}

	/**
	 * Handles Applications exception.
	 *
	 * @param exception
	 *            The exception.
	 * @param response
	 *            HTTP response.
	 * @return Error view.
	 */
	@ExceptionHandler(ApplicationException.class)
	@ResponseBody
	public SimpleResponse handleApplicationException(final ApplicationException exception,
			final HttpServletResponse response) {
		this.logger.error("ApplicationException", exception);
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		SimpleResponse rsp = new SimpleResponse();
		rsp.setMessage(exception.getMessage());
		return rsp;
	}

	/**
	 * Handles DB exception.
	 *
	 * @param exception
	 *            The exception.
	 * @param response
	 *            HTTP response.
	 * @return Error view.
	 */
	@ExceptionHandler(DBException.class)
	@ResponseBody
	public SimpleResponse handleDBException(final DBException exception, final HttpServletResponse response) {
		this.logger.error("DBException", exception);
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		SimpleResponse rsp = new SimpleResponse();
		rsp.setMessage(exception.getMessage());
		return rsp;
	}

	/**
	 * Handles an RuntimeException.
	 * 
	 * @param runtimeException
	 *            The exception to log.
	 * @param response
	 *            The HTTP response to change the status.
	 * @return Error view.
	 */
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public SimpleResponse handleRuntimeException(final RuntimeException runtimeException,
			final HttpServletResponse response) {
		this.logger.error("RuntimeException", runtimeException);
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return HTTPUtils.readException(runtimeException);
	}
}
