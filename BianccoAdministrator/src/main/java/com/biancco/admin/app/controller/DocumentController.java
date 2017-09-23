/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.app.util.JSONUtil;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.model.view.Node;
import com.biancco.admin.persistence.model.FolderType;
import com.biancco.admin.service.DocumentService;
import com.biancco.admin.service.FolderService;

/**
 * Document Controller.
 * 
 * @author SOSExcellence.
 */
@Controller
@RequestMapping(value = "/document")
public class DocumentController {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Document service.
	 */
	@Autowired
	private DocumentService documentService;
	/**
	 * Folder service.
	 */
	@Autowired
	private FolderService folderService;

	/**
	 * Gets a file from document.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @return file.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/get/{idDoc}")
	public void download(final HttpServletRequest request, final HttpServletResponse response, HttpSession session,
			@PathVariable long idDoc) throws ApplicationException, DBException {
		this.logger.info("Controller | document download " + idDoc);
		// get file
		FileMeta file = this.documentService.getFileFromDocument(idDoc);
		// write file
		response.setContentType(file.getContentType());
		response.setHeader("Content-disposition", "attachment; filename=\"" + file.getName());
		try {
			FileCopyUtils.copy(file.getBytes(), response.getOutputStream());
		} catch (IOException e) {
			this.logger.error("Error al descargar(copy) archivo " + file.getName(), e);
		}
	}

	/**
	 * Deletes a document.
	 * 
	 * @param request
	 *            The HTTP request.
	 * @param response
	 *            The HTTP response.
	 * @param session
	 *            The HTTP session.
	 * @return file.
	 * @throws DBException
	 *             If a db exception thrown.
	 * @throws ApplicationException
	 *             If an application exception thrown.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/delete")
	@ResponseBody
	public String delete(final HttpServletRequest request, final HttpServletResponse response, HttpSession session,
			@RequestParam(value = "_type", required = true) final FolderType type,
			@RequestParam(value = "_id", required = true) final long ownerModuleId,
			@RequestParam(value = "_idDoc", required = true) final long idDoc)
			throws ApplicationException, DBException {
		this.logger.info("Controller | document delete " + idDoc);
		// delete file
		this.documentService.deleteDocument(idDoc);
		// refresh documents
		Node tree = this.folderService.getTreeFolderByType(type, ownerModuleId);
		return HTTPUtils.encodeString(JSONUtil.getJSONString(tree), HTTPUtils.CHARSET_UTF8);
	}
}
