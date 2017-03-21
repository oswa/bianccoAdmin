/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.catalog.RoleSimpleRecord;

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

}
