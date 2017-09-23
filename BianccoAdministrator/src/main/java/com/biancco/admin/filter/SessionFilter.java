/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.persistence.model.Employee;

/**
 * Session filter.
 * 
 * @author SOSExcellence.
 */
public class SessionFilter implements Filter {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * URLs that does not need to validate token.
	 */
	private String[] exceptionURL;
	/**
	 * String text/html.
	 */
	private static final String TEXT_HTML = "text/html";
	/**
	 * String access denied.
	 */
	private static final String ACCESS_DENIED = ":o Acceso denegado";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void destroy() {
		this.logger.info("Destroying session filter...");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		final String url = req.getRequestURL().toString();
		/*
		 * this.logger.info("URL request: " + url);
		 * this.logger.info("URL context path: " + req.getContextPath());
		 * this.logger.info("URL request: " + url);
		 */
		// validating URL exceptions
		final boolean found = this.checkURL(url);
		if (found || url.endsWith(req.getContextPath()) || url.endsWith(req.getContextPath() + "/")) {
			filterChain.doFilter(request, response);
		} else {
			Employee e = (Employee) req.getSession().getAttribute(BianccoConstants.ATTR_USER);
			if (e == null) {
				this.responseError(req, response);
			} else {
				filterChain.doFilter(request, response);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.logger.info("Starting SessionFilter...");
		final String urlExceptions = filterConfig.getInitParameter("URL-Exceptions");
		this.exceptionURL = urlExceptions.split(",");
	}

	/**
	 * Check if the URL is in the exceptions.
	 * 
	 * @param url
	 *            the URL to check.
	 * @return true if the URL is an exception.
	 */
	private boolean checkURL(final String url) {
		boolean foundURL = false;
		for (String aURL : this.exceptionURL) {
			if (url.endsWith(aURL)) {
				foundURL = true;
			}
		}
		return foundURL;
	}

	/**
	 * Response an error.
	 * 
	 * @param res
	 *            ServletResponse
	 * @param req
	 *            HTTP request.
	 * @throws IOException
	 *             if the writer is not available.
	 */
	private void responseError(final HttpServletRequest req, final ServletResponse res) throws IOException {
		HttpServletResponse response = (HttpServletResponse) res;
		this.logger.error(SessionFilter.ACCESS_DENIED);
		response.sendRedirect(req.getContextPath());
		/*
		 * response.setContentType(SessionFilter.TEXT_HTML);
		 * response.setStatus(HttpStatus.UNAUTHORIZED.value()); final
		 * PrintWriter out = response.getWriter();
		 * out.println(SessionFilter.ACCESS_DENIED); out.close();
		 */
	}

}
