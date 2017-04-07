/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.catalog.RoleSimpleRecord;
import com.biancco.admin.model.view.FolderView;

/**
 * Common service.
 * 
 * @author SOSExcellence.
 */
public interface CommonService {
	/**
	 * Gets the model and view by module.
	 * 
	 * @param module
	 *            The module.
	 * @param session
	 *            The HTTP session.
	 * @return model and view.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	ModelAndView getViewByModule(String module, HttpSession session) throws DBException;

	/**
	 * Gets role list.
	 * 
	 * @param enabledOnly
	 *            Enabled only filter.
	 * @return role list.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	List<RoleSimpleRecord> getRoles(boolean enabledOnly) throws DBException;

	/**
	 * Gets a folder by module and identifier.
	 * 
	 * @param module
	 *            Module.
	 * @param identifier
	 *            Identifier.
	 * @param session
	 *            HTTP session.
	 * @return Folder view.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	FolderView getFolderByModuleAndId(String module, long identifier, HttpSession session) throws DBException;

	/**
	 * Back to view in session.
	 * 
	 * @param session
	 *            HTTP session.
	 * @param indexView
	 *            Index view to go.
	 * @return View.
	 */
	ModelAndView backToView(HttpSession session, Integer indexView);

	/**
	 * Add view to history.
	 * 
	 * @param view
	 *            View to add.
	 * @param updatePreviousView
	 *            Update previous view flag.
	 * @param session
	 *            HTTP session.
	 */
	void addViewToHistory(ModelAndView view, boolean updatePreviousView, HttpSession session);

}
