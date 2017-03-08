/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.Permission;

/**
 * Manage the persistence for Permission objects.
 * 
 * @author SOSExcellence.
 */
public interface PermissionDAO {
	/**
	 * Saves a permission.
	 * 
	 * @param permission
	 *            A permission.
	 * @return The permission saved.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Permission save(Permission permission) throws DBException;

	/**
	 * Updates a permission.
	 * 
	 * @param permission
	 *            A permission.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void update(Permission permission) throws DBException;

	/**
	 * Deletes a permission.
	 * 
	 * @param permission
	 *            A permission.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(Permission permission) throws DBException;

	/**
	 * Gets all permissions.
	 * 
	 * @return A permission list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<Permission> getAll() throws DBException;
}
