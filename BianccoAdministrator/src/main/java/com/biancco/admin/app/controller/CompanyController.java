/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.controller;

import java.util.LinkedList;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.app.util.JSONUtil;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.model.view.CompanyModuleView;
import com.biancco.admin.persistence.model.Company;
import com.biancco.admin.service.CommonService;
import com.biancco.admin.service.CompanyService;

/**
 * Company controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Company service.
	 */
	@Autowired
	private CompanyService companyService;
	/**
	 * Common service.
	 */
	@Autowired
	private CommonService commonService;

	/**
	 * Shows view to add company.
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
	public ModelAndView addCompany(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session) throws ApplicationException, DBException {
		this.logger.info("Controller | addCompany");
		// get info needed of view
		CompanyModuleView info = this.companyService.getInfoToAdd(session);
		// build view
		ModelAndView view = new ModelAndView("/page/company/new_edit");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		// add view to history
		this.commonService.addViewToHistory(view, false, session);
		return view;
	}

	/**
	 * Shows view to edit company.
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
	public ModelAndView editCompany(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_comp", required = true) long idCompany)
			throws ApplicationException, DBException {
		this.logger.info("Controller | editCompany " + idCompany);
		// get info needed of view
		CompanyModuleView info = this.companyService.getCompany(session, idCompany);
		// build view
		ModelAndView view = new ModelAndView("/page/company/new_edit");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		session.removeAttribute(BianccoConstants.ID_COMPANY);
		session.setAttribute(BianccoConstants.ID_COMPANY, info.getCompany().getIdCompany());
		// add view to history
		this.commonService.addViewToHistory(view, false, session);
		return view;
	}

	/**
	 * Saves an company.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @param companyEncoded
	 *            Company detail.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/save")
	public ModelAndView saveCompany(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_company", required = true) String companyEncoded) throws ApplicationException, DBException {
		this.logger.info("Controller | saveCompany " + companyEncoded );
		this.companyService.saveCompany(companyEncoded);
		// build view
		ModelAndView view = this.companyService.getMainView(session);
		// add view to history
		this.commonService.addViewToHistory(view, true, session);
		return view;
	}

	/**
	 * Updates an company.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @param companyEncoded
	 *            Company detail.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/update")
	public ModelAndView updateCompany(HttpSession session, @RequestBody Company company)
			throws ApplicationException, DBException {
		this.logger.info("Controller | updateCompany " + company.getIdCompany() + "-" + company.getName());
		this.companyService.updateCompany(company);
		// build view
		ModelAndView view = this.companyService.getMainView(session);
		// add view to history
		this.commonService.addViewToHistory(view, true, session);
		return view;
	}
	/**
	 * Upload logo file.
	 * 
	 * @param session
	 *            The HTTP session.
	 * @param request
	 *            Multipart HTTP request.
	 * @return Message response.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/upload")
	@ResponseBody
	public LinkedList<FileMeta> uploadFiles(HttpSession session, MultipartHttpServletRequest request)
			throws ApplicationException {
		this.logger.info("Controller | uploadLogoFile ");
		// save & upload files
		return this.companyService.saveAndUploadLogo(request, session);
	}

	/**
	 * Refresh logo content.
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
	@RequestMapping(method = RequestMethod.POST, value = "/refresh")
	@ResponseBody
	public String refreshLogo(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session)
			throws ApplicationException, DBException {
		this.logger.info("Controller | refreshLogo ");
		Long companyId = Long.parseLong(request.getParameter("companyId"));
		CompanyModuleView comView = this.companyService.getCompany(session, companyId);
		return HTTPUtils.encodeString(JSONUtil.getJSONString(comView.getCompany().getLogo()), HTTPUtils.CHARSET_UTF8);
	}
}
