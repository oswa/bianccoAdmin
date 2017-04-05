/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.model.catalog.RoleSimpleRecord;
import com.biancco.admin.model.employee.EmployeeSimpleRecord;
import com.biancco.admin.model.view.EmployeeModuleView;
import com.biancco.admin.model.view.FolderView;
import com.biancco.admin.model.view.Node;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.dao.RoleDAO;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.service.CommonService;

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
	public FolderView getFolderByModuleAndId(String module, long identifier, HttpSession session) throws DBException {
		// set permission type
		PermissionType pType = (PermissionType) session.getAttribute(module);
		// build view
		FolderView fv = new FolderView();
		fv.setpType(pType);
		fv.setTypeId(identifier);
		fv.setFolder(getFolder());

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
			this.setPermission(info, pType);
		}
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

	private Node getFolder() {
		Node node = new Node();
		node.setText("Parent");
		node.setHref("2");
		node.setIcon("glyphicon glyphicon-folder-close");
		node.setSelectedIcon("glyphicon glyphicon-folder-open");
		node.setTags("");
		List<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < 5; i++) {
			Node n1 = new Node();
			n1.setText("Folder " + (i + 1));
			n1.setHref("2");
			n1.setIcon("glyphicon glyphicon-folder-close");
			n1.setSelectedIcon("glyphicon glyphicon-folder-open");
			n1.setTags("");
			nodes.add(n1);
		}
		node.setNodes(nodes);
		return node;
	}

}