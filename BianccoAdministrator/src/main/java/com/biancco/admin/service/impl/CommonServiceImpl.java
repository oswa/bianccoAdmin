/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.catalog.RoleSimpleRecord;
import com.biancco.admin.model.employee.EmployeeSimpleRecord;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.model.view.FolderView;
import com.biancco.admin.model.view.InitialView;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.dao.RoleDAO;
import com.biancco.admin.persistence.model.FolderType;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.service.CommonService;
import com.biancco.admin.service.FolderService;

/**
 * Common service implementation.
 * 
 * @author SOSExcellence.
 */
public class CommonServiceImpl implements CommonService {
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
	 * Employee DAO.
	 */
	@Autowired
	private EmployeeDAO employeeDAO;
	/**
	 * Role DAO.
	 */
	@Autowired
	private RoleDAO roleDAO;
	/**
	 * The main pages for modules.
	 */
	private static final Map<String, String> pages;
	/**
	 * initialize pages.
	 */
	static {
		pages = new HashMap<String, String>();
		pages.put("company", "list");
		pages.put("employee", "list");
		// modules.put("CONFIGURACION", "configuration");
	}
	/**
	 * Roles.
	 */
	private static List<RoleSimpleRecord> roles = new ArrayList<RoleSimpleRecord>();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView getViewByModule(String module, HttpSession session) throws DBException {
		// build view
		ModelAndView view = new ModelAndView("/page/" + module + "/" + pages.get(module));
		// get initial information
		Object info = this.getInitialInformationByModule(module, session);
		view.addObject(BianccoConstants.MODEL_ATTRIBUTE, info);
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolderView getTreeFolder(String type, long ownerModuleId, HttpSession session) throws DBException {
		// get folder type
		FolderType fType = FolderType.fromName(type);
		logger.info(ReflectionToStringBuilder.toString(fType));
		logger.info(ReflectionToStringBuilder.toString(session.getAttributeNames()));
		// set permission type
		PermissionType pType = (PermissionType) session.getAttribute(fType.getOwnerModule());
		// build view
		FolderView fv = new FolderView();
		fv.setpType(pType);
		fv.setOwnerModuleId(ownerModuleId);
		// get tree folder
		fv.setFolder(this.folderService.getTreeFolderByType(fType, ownerModuleId));

		return fv;
	}

	/**
	 * Gets initial information by module view.
	 * 
	 * @param module
	 *            The module.
	 * @param session
	 *            HTTP session.
	 * @return Initial information.
	 * @throws DBException
	 */
	private Object getInitialInformationByModule(String module, HttpSession session) throws DBException {
		// get permission type from session
		PermissionType pType = (PermissionType) session.getAttribute(module);
		// set info by module
		Object info = null;
		if ("employee".equals(module)) {
			// set info by module
			info = new EmployeeModuleView();
			this.setEmployees((EmployeeModuleView) info);
		}
		// set permission
		this.setPermission(info, pType);
		return info;
	}

	/**
	 * Sets employees to info model.
	 * 
	 * @param info
	 *            The info.
	 * @throws DBException
	 */
	private void setEmployees(EmployeeModuleView info) throws DBException {
		List<EmployeeSimpleRecord> result = this.employeeDAO.getAll();
		info.setEmployees(result);
	}

	/**
	 * Sets permission type to info model.
	 * 
	 * @param info
	 *            Info model.
	 * @param pType
	 *            Permission type.
	 */
	private void setPermission(Object info, PermissionType pType) {
		try {
			Method m = info.getClass().getDeclaredMethod("setpType", PermissionType.class);
			m.invoke(info, pType);
		} catch (Exception e) {
			this.logger.error("Error on set permission", e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<RoleSimpleRecord> getRoles(boolean enabledOnly) throws DBException {
		if (roles.isEmpty()) {
			roles = this.roleDAO.getAll(enabledOnly);
		}
		return roles;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ModelAndView backToView(HttpSession session, Integer indexView) {
		// get history
		LinkedList<ModelAndView> history = (LinkedList<ModelAndView>) session
				.getAttribute(BianccoConstants.VIEW_HISTORY);
		// get number of views to remove
		int size = history.size();
		int diff = size - (size - indexView);
		// get main view if apply
		if (indexView == 0 || (diff == size - 1)) {
			// indexView = size - 1;
			ModelAndView mainView = history.get(0);
			// initialize history
			history = new LinkedList<ModelAndView>();
			history.add(this.getMainView(mainView));
		} else {
			// remove unused views
			for (int index = 0; index < diff; index++) {
				history.removeLast();
			}
		}
		// update history
		session.removeAttribute(BianccoConstants.VIEW_HISTORY);
		session.setAttribute(BianccoConstants.VIEW_HISTORY, history);
		// get last view
		return history.getLast();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void addViewToHistory(ModelAndView view, boolean updatePreviousView, HttpSession session) {
		LinkedList<ModelAndView> history = null;
		// validate view history
		if (session.getAttribute(BianccoConstants.VIEW_HISTORY) == null) {
			history = new LinkedList<ModelAndView>();
		} else {
			history = (LinkedList<ModelAndView>) session.getAttribute(BianccoConstants.VIEW_HISTORY);
		}
		// remove previous view if apply
		if (updatePreviousView) {
			history.removeLast();
			history.removeLast();
		}
		// add view
		history.add(view);
		// update history
		session.removeAttribute(BianccoConstants.VIEW_HISTORY);
		session.setAttribute(BianccoConstants.VIEW_HISTORY, history);
	}

	/**
	 * Gets the main view content.
	 * 
	 * @param mainView
	 *            Main page.
	 * @return Main view content.
	 */
	private ModelAndView getMainView(ModelAndView mainView) {
		// get initial info
		InitialView iView = (InitialView) mainView.getModel().get(BianccoConstants.MODEL_ATTRIBUTE);
		mainView = new ModelAndView("/page/modules");
		mainView.addObject(BianccoConstants.MODEL_ATTRIBUTE, iView);
		return mainView;
	}
}