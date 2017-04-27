/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.view.FolderView;
import com.biancco.admin.model.view.Node;
import com.biancco.admin.persistence.model.FolderFieldValue;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Service for Folder task.
 * 
 * @author SOSExcellence.
 *
 */
public interface FolderService {
	/**
	 * Gets the tree folder-documents by type.
	 * 
	 * @param folderType
	 *            Folder type.
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @return Tree of folder-documents.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	Node getTreeFolderByType(FolderType folderType, long ownerModuleId) throws DBException;

	/**
	 * Gets the fields by folder.
	 * 
	 * @param type
	 *            Folder type.
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @param folderId
	 *            Folder identifier.
	 * @param session
	 *            HTTP session.
	 * @return Folder view.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	FolderView getFolderFields(String type, long ownerModuleId, long folderId, HttpSession session) throws DBException;

	/**
	 * Saves the field values.
	 * 
	 * @param values
	 *            Field values.
	 * @return Folder view.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	FolderView saveFieldValues(List<FolderFieldValue> values, HttpSession session) throws DBException;
}
