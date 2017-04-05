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
import org.springframework.web.bind.annotation.ResponseStatus;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
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
	 * Handles Applications exception.
	 *
	 * @param exception
	 *            The exception.
	 * @return Error view.
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ApplicationException.class)
	@ResponseBody
	public SimpleResponse handleApplicationException(final ApplicationException exception) {
		this.logger.error("ApplicationException", exception);
		SimpleResponse response = new SimpleResponse();
		response.setMessage(exception.getMessage());
		return response;
	}

	/**
	 * Handles DB exception.
	 *
	 * @param exception
	 *            The exception.
	 * @return Error view.
	 */
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(DBException.class)
	@ResponseBody
	public SimpleResponse handleDBException(final DBException exception) {
		this.logger.error("DBException", exception);
		SimpleResponse response = new SimpleResponse();
		response.setMessage(exception.getMessage());
		return response;
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
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ RuntimeException.class })
	@ResponseBody
	public SimpleResponse handleRuntimeException(final RuntimeException runtimeException,
			final HttpServletResponse response) {
		this.logger.error("RuntimeException", runtimeException);
		return HTTPUtils.readException(runtimeException);
	}
}
