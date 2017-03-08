/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.EmployeeDetail;

/**
 * Manage the persistence for EmployeeDetail objects.
 * 
 * @author SOSExcellence.
 */
public interface EmployeeDetailDAO {
	/**
	 * Saves a employee detail.
	 * 
	 * @param detail
	 *            The employee detail.
	 * @return The identifier saved.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	EmployeeDetail save(EmployeeDetail detail) throws DBException;

	/**
	 * Updates a employee detail.
	 * 
	 * @param detail
	 *            The employee detail.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void update(EmployeeDetail detail) throws DBException;

	/**
	 * Deletes a module.
	 * 
	 * @param detail
	 *            The employee detail.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(EmployeeDetail detail) throws DBException;

	/**
	 * Gets detail by identifier.
	 * 
	 * @return The employee detail.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	EmployeeDetail getById(long identifier) throws DBException;
}
