/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.view.WorkModuleView;
import com.biancco.admin.persistence.model.WorkCompany;

/**
 * Work service.
 * 
 * @author SOSExcellence.
 */
public interface WorkService {

	/**
	 * Gets the info needed of view to add work.
	 * 
	 * @param session
	 *            HTTP session.
	 * @return Info.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	WorkModuleView getInfoToAdd(HttpSession session) throws DBException;

	/**
	 * Gets a work.
	 * 
	 * @param session
	 *            HTTP sesiion.
	 * @param idWork
	 *            Work identifier.
	 * @return View.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	WorkModuleView getWork(HttpSession session, long idWork) throws DBException;

	/**
	 * Gets the work main view.
	 * 
	 * @param session
	 *            HTTP session.
	 * @return View.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	ModelAndView getMainView(HttpSession session) throws DBException;

	/**
	 * Saves an work.
	 * 
	 * @param workEncoded
	 *            Work detail.
	 * @return Work.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	WorkCompany saveWork(String workEncoded, long idCompany) throws DBException;

	/**
	 * Updates a work.
	 * 
	 * @param work
	 *            The changes of the work.
	 * @return Work.
	 * @exception DBException
	 *                If a db exception thrown
	 */
	WorkCompany updateWork(WorkCompany work) throws DBException;

}
