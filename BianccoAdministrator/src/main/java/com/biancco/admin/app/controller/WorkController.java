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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.view.WorkModuleView;
import com.biancco.admin.persistence.model.WorkCompany;
import com.biancco.admin.service.CommonService;
import com.biancco.admin.service.WorkService;

/**
 * Work controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/work")
public class WorkController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Employee service.
	 */
	@Autowired
	private WorkService workService;
	/**
	 * Common service.
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * Shows view to add work.
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
	public ModelAndView addWork(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session) throws ApplicationException, DBException {
		this.logger.info("Controller | addWork");
		// get info needed of view
		WorkModuleView info = this.workService.getInfoToAdd(session);
		// build view
		ModelAndView view = new ModelAndView("/page/work/new_edit");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		// add view to history
		this.commonService.addViewToHistory(view, false, session);
		return view;
	}

	/**
	 * Shows view to edit work.
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
	public ModelAndView editWork(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_work", required = true) long idWork)
			throws ApplicationException, DBException {
		this.logger.info("Controller | editWork " + idWork);
		// get info needed of view
		WorkModuleView info = this.workService.getWork(session, idWork);
		// build view
		ModelAndView view = new ModelAndView("/page/work/new_edit");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		// add view to history
		this.commonService.addViewToHistory(view, false, session);
		return view;
	}

	/**
	 * Saves a work.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @param workEncoded
	 *            Work detail.
	 * @param idRole
	 *            Role identifier.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ModelAndView saveWork(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_work", required = true) String workEncoded,
			@RequestParam(value = "_idCompany", required = true) long idCompany) throws ApplicationException, DBException {
		this.logger.info("Controller | saveWork " + workEncoded );
		this.workService.saveWork(workEncoded, idCompany);
		// build view
		ModelAndView view = this.workService.getMainView(session);
		// add view to history
		this.commonService.addViewToHistory(view, true, session);
		return view;
	}

	/**
	 * Updates a work.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @param detailEncoded
	 *            Work detail.
	 * @param idRole
	 *            Role identifier.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public ModelAndView updateWork(HttpSession session, @RequestBody WorkCompany work)
			throws ApplicationException, DBException {
		this.logger.info("Controller | updateWork " + work.getIdWork() + "-" + work.getName());
		this.workService.updateWork(work);
		// build view
		ModelAndView view = this.workService.getMainView(session);
		// add view to history
		this.commonService.addViewToHistory(view, true, session);
		return view;
	}
}
