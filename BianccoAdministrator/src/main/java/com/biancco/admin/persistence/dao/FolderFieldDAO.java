/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FieldValue;
import com.biancco.admin.persistence.model.FolderField;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Folder field DAO.
 * 
 * @author SOSExcellence.
 */
public interface FolderFieldDAO {
	/**
	 * Gets a folder field by id.
	 * 
	 * @param idFolderField
	 *            the identifier.
	 * @return Folder field.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderField getById(Long idFolderField) throws DBException;

	/**
	 * Saves a Folder field.
	 * 
	 * @param field
	 *            Field.
	 * @return Folder field stored.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderField save(FolderField field) throws DBException;

	/**
	 * Deletes a folder field by identifier.
	 * 
	 * @param idFolderField
	 *            Folder field identifier.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(long idFolderField) throws DBException;

	/**
	 * Updates a Folder field.
	 * 
	 * @param field
	 *            Folder field to update.
	 * @return Folder field updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderField update(FolderField field) throws DBException;

	/**
	 * Gets the fields by folder.
	 * 
	 * @param idFolder,
	 *            Folder identifier.
	 * @return Folder field list.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	List<FolderField> getFieldsByFolder(long idFolder) throws DBException;

	/**
	 * Gets the field-value by folder.
	 * 
	 * @param idFolder,
	 *            Folder identifier.
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @param Owner
	 *            folder type.
	 * @return Folder field list.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	List<FieldValue> getFieldValueByFolder(long idFolder, long ownerModuleId, FolderType folderType) throws DBException;

	/**
	 * Returns the max id of the Folder Base.
	 * @return
	 */
	Long getMaxFolderBaseId() throws DBException;
}
