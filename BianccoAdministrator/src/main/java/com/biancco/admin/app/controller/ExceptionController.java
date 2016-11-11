/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.view.model.SimpleResponse;

/**
 * Exception Controller.
 * 
 * @author SOSExcellence.
 */
@Controller
public class ExceptionController {
    /**
     * Handles Applications exception.
     *
     * @param exception
     *            The exception.
     * @return Error view.
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ApplicationException.class)
    public @ResponseBody SimpleResponse handleApplicationException(final ApplicationException exception) {
        SimpleResponse response = new SimpleResponse();
        response.setMessage(exception.getMessage());
        return response;
    }
}
