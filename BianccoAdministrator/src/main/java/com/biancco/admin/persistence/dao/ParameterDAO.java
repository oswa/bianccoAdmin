/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.Parameter;

/**
 * Manage the persistence for Parameter objects.
 * 
 * @author SOSExcellence.
 */
public interface ParameterDAO {
	/**
	 * Gets a parameter by id.
	 * 
	 * @param idParam
	 *            the identifier.
	 * @return the Parameter object corresponding to the id.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Parameter getById(Long idParam) throws DBException;

	/**
	 * Insert a new Parameter.
	 * 
	 * @param param
	 *            The parameter.
	 * @return Parameter.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Parameter save(Parameter param) throws DBException;

	/**
	 * Deletes a Parameter from persistent data.
	 * 
	 * @param idParam
	 *            the element to delete.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(long idParam) throws DBException;

	/**
	 * Updates a Parameter in persistent data.
	 * 
	 * @param param
	 *            the element to update.
	 * @return Parameter updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Parameter update(Parameter param) throws DBException;

	/**
	 * Gets all parameters by group.
	 * 
	 * @return A param list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<Parameter> getByGroup(String group) throws DBException;

	/**
	 * Gets the group name list.
	 * 
	 * @return Group name list (catalog names).
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<String> getGroupNames() throws DBException;

	/**
	 * Gets the value by parameter & group.
	 * 
	 * @param groupName
	 *            Group name.
	 * @param paramName
	 *            Parameter name.
	 * @return
	 * @throws DBException
	 *             when there is a problem on DB.
	 */
	Parameter getParameterValue(String groupName, String paramName) throws DBException;

}
