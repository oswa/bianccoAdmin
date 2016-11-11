/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.view.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Authentication controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/login")
public class AuthenticationController {
    /**
     * Sign in.
     * 
     * @param response
     *            The HTTP response.
     * @return view.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/signin")
    public RedirectView signin(final HttpServletResponse response) {
        System.out.println("Controller | signin");
        RedirectView view = new RedirectView("/jsp/index.jsp");
        view.setContextRelative(true);
        return view;
    }

}
