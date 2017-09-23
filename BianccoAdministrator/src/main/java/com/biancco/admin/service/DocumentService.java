/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service;

import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Document service.
 * 
 * @author SOSExcellence.
 */
public interface DocumentService {
	/**
	 * @param folderId
	 *            Folder identifier.
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @param fType
	 *            Folder type.
	 * @param files
	 *            File list.
	 * @param session
	 *            HTTP session.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	void saveDocuments(long folderId, long ownerModuleId, FolderType fType, LinkedList<FileMeta> files,
			HttpSession session) throws DBException;

	/**
	 * Gets the file from document.
	 * 
	 * @param idDoc
	 *            Document identifier.
	 * @return File information.
	 * @throws DBException
	 *             If a db exception is thrown.
	 */
	FileMeta getFileFromDocument(long idDoc) throws DBException;

	/**
	 * Deletes a document.
	 * 
	 * @param idDoc
	 *            Document identifier.
	 */
	void deleteDocument(long idDoc) throws DBException;
}
