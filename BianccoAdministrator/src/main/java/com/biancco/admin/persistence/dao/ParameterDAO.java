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
	 * Gets all parameters.
	 * 
	 * @return parameter list.
	 * @throws DBException
	 *             when there is a problem on DB.
	 */
	List<Parameter> getParameters() throws DBException;

}
