/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.controller;

import java.util.LinkedList;
import java.util.List;

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
import com.biancco.admin.model.folder.FolderDocument;
import com.biancco.admin.model.view.FolderView;
import com.biancco.admin.model.view.Node;
import com.biancco.admin.persistence.model.FolderFieldValue;
import com.biancco.admin.persistence.model.FolderType;
import com.biancco.admin.service.FolderService;

/**
 * Folder controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/folder")
public class FolderController extends ExceptionController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Folder service.
	 */
	@Autowired
	private FolderService folderService;

	/**
	 * Gets the fields by folder.
	 * 
	 * @param session
	 *            The HTTP session.
	 * @return view.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/fields")
	public ModelAndView getFolderFields(HttpSession session, @RequestBody FolderDocument folder)
			throws ApplicationException, DBException {
		this.logger.info("Controller | getFolderFields " + folder.getType().name() + " " + folder.getIdFolder());
		// build view
		ModelAndView view = new ModelAndView("/page/folder_fields");
		// get information
		FolderView info = this.folderService.getFolderFields(folder.getType().getFolder(), folder.getOwnerModuleId(),
				folder.getIdFolder(), session);
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		return view;
	}

	/**
	 * Saves the field values from folder.
	 * 
	 * @param session
	 *            The HTTP session.
	 * @return Message response.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/fields/save")
	public ModelAndView saveFieldValues(HttpSession session, @RequestBody List<FolderFieldValue> values)
			throws ApplicationException, DBException {
		this.logger.info("Controller | saveFieldValues " + values.size());
		// save values
		FolderView info = this.folderService.saveFieldValues(values, session);
		// build view
		ModelAndView view = new ModelAndView("/page/folder_fields");
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		return view;
	}

	/**
	 * Upload files.
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
		this.logger.info("Controller | uploadFiles ");
		// save & upload files
		return this.folderService.saveAndUploadFiles(request, session);
	}

	/**
	 * Refresh folder content.
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
	public String refreshFolder(final HttpServletRequest request, final HttpServletResponse response,
			HttpSession session, @RequestParam(value = "_type", required = true) final FolderType type,
			@RequestParam(value = "_id", required = true) final long ownerModuleId)
			throws ApplicationException, DBException {
		this.logger.info("Controller | refreshFolder " + type.getFolder() + " " + ownerModuleId);
		// get information
		// HTTPUtils.encodeString(JSONUtil.getJSONString(this.folder),
		// HTTPUtils.CHARSET_UTF8);
		// return this.folderService.getTreeFolderByType(type, ownerModuleId);
		Node tree = this.folderService.getTreeFolderByType(type, ownerModuleId);
		return HTTPUtils.encodeString(JSONUtil.getJSONString(tree), HTTPUtils.CHARSET_UTF8);
	}
}
