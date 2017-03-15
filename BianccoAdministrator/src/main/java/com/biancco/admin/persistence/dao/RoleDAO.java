/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.Role;

/**
 * Manage the persistence for Role objects.
 * 
 * @author SOSExcellence.
 */
public interface RoleDAO {
	/**
	 * Saves a role.
	 * 
	 * @param role
	 *            A role.
	 * @return The role saved.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Role save(Role role) throws DBException;

	/**
	 * Updates a role.
	 * 
	 * @param role
	 *            A role.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void update(Role role) throws DBException;

	/**
	 * Deletes a role.
	 * 
	 * @param role
	 *            A role.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(Role role) throws DBException;

	/**
	 * Gets all roles.
	 * 
	 * @param enabledOnly
	 *            Enabled filter.
	 * 
	 * @return A role list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<Role> getAll(boolean enabledOnly) throws DBException;
}
