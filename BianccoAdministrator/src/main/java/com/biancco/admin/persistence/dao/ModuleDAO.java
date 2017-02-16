/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.Module;

/**
 * Manage the persistence for Module objects.
 * 
 * @author SOSExcellence.
 */
public interface ModuleDAO {
	/**
	 * Saves a module.
	 * 
	 * @param module
	 *            A module.
	 * @return The identifier saved.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Long save(Module module) throws DBException;

	/**
	 * Updates a module.
	 * 
	 * @param module
	 *            A module.
	 * @return The identifier saved.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void update(Module module) throws DBException;

	/**
	 * Deletes a module.
	 * 
	 * @param module
	 *            A module.
	 * @return The identifier saved.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(Module module) throws DBException;

	/**
	 * Gets all modules.
	 * 
	 * @return A module list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<Module> getAll() throws DBException;
}
