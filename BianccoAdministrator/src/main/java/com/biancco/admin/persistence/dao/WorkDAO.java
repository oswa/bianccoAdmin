/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.WorkCompany;

/**
 * Access to Work in persistence memory.
 * @author SOSExcellence.
 *
 */
public interface WorkDAO {
	/**
	 * Return an Work based on its id.
	 * @param idWork the identitifier
	 * @return the Work object corresponding to the id
	 * @throws DBException When there is an error in the database
	 */
	public WorkCompany getWorkById( long idWork ) throws DBException;
	/**
	 * Update an Work in persisten data.
	 * @param Work the element to update
	 * @return true id successful
	 * @throws DBException When an error occurs
	 */
	public WorkCompany updateWork( WorkCompany Work ) throws DBException;
	/**
	 * Save a work to persistent memory.
	 * @param work the info to save.
	 * @return the object saved.
	 */
	public WorkCompany save(WorkCompany work) throws DBException;
	/**
	 * Update a Work in persistent data.
	 * 
	 * @param work
	 *            the element to update.
	 * @return Work updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	WorkCompany update(WorkCompany company) throws DBException;
}
