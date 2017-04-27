/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.FolderFieldValue;

/**
 * Folder field value DAO.
 * 
 * @author SOSExcellence.
 */
public interface FolderFieldValueDAO {
	/**
	 * Gets a field value by id.
	 * 
	 * @param idFolderFieldValue
	 *            the identifier.
	 * @return Field value.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderFieldValue getById(Long idFolderFieldValue) throws DBException;

	/**
	 * Saves a field value.
	 * 
	 * @param value
	 *            Field value.
	 * @return Field value stored.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderFieldValue save(FolderFieldValue value) throws DBException;

	/**
	 * Saves a field value list.
	 * 
	 * @param values
	 *            Field value list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void save(List<FolderFieldValue> values) throws DBException;

	/**
	 * Deletes a field value by identifier.
	 * 
	 * @param idFolderFieldValue
	 *            Field value identifier.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(long idFolderFieldValue) throws DBException;

	/**
	 * Updates a field value.
	 * 
	 * @param value
	 *            Field value to update.
	 * @return Field value updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderFieldValue update(FolderFieldValue value) throws DBException;
}
