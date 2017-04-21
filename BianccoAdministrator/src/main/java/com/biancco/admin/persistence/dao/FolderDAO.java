/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FolderDocument;
import com.biancco.admin.persistence.model.FolderBase;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Data access to Folder
 * 
 * @author SOSExcellence.
 *
 */
public interface FolderDAO {
	/**
	 * Gets a folder by id.
	 * 
	 * @param idFolder
	 *            the identifier.
	 * @return Folder.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderBase getById(Long idFolder) throws DBException;

	/**
	 * Saves a Folder.
	 * 
	 * @param folder
	 *            The parameter.
	 * @return Folder stored.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderBase save(FolderBase folder) throws DBException;

	/**
	 * Deletes a folder by identifier.
	 * 
	 * @param idFolder
	 *            Folder identifier.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(long idFolder) throws DBException;

	/**
	 * Updates a Folder.
	 * 
	 * @param folder
	 *            Folder to update.
	 * @return Folder updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FolderBase update(FolderBase folder) throws DBException;

	/**
	 * Gets the folder structure by type.
	 * 
	 * @param folderType
	 *            Folder type.
	 * @return Folder list.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	List<FolderBase> getFoldersByType(FolderType folderType) throws DBException;

	/**
	 * Gets the folder structure by type.
	 * 
	 * @param folderType
	 *            Folder type.
	 * @return Folder structure.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	List<FolderBase> getFolderBaseByType(FolderType folderType) throws DBException;

	/**
	 * Gets the folder documents by module.
	 * 
	 * @param folderType
	 *            Folder type.
	 * @param ownerId
	 *            Module identifier.
	 * @return Folder documents.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	List<FolderDocument> getFolderDocumentsByType(FolderType folderType, long ownerId) throws DBException;

}
