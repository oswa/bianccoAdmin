/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.persistence.model.Document;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Document DAO.
 * 
 * @author SOSExcellence.
 */
public interface DocumentDAO {
	/**
	 * Gets a document by id.
	 * 
	 * @param idDoc
	 *            Document identifier.
	 * @return Document.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Document getById(Long idDoc) throws DBException;

	/**
	 * Insert a new Document.
	 * 
	 * @param doc
	 *            Document to save.
	 * @return Document stored.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Document save(Document doc) throws DBException;

	/**
	 * Insert a new Document.
	 * 
	 * @param doc
	 *            Document to save.
	 * @return Document stored.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void saveWithoutATransaction(Document doc) throws DBException;

	/**
	 * Deletes a Document.
	 * 
	 * @param idDoc
	 *            Document identifier to delete.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	void delete(long idDoc) throws DBException;

	/**
	 * Updates a Document.
	 * 
	 * @param doc
	 *            Document to update.
	 * @return Document updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Document update(Document doc) throws DBException;

	/**
	 * Gets all documents by module.
	 * 
	 * @return A document list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<Document> getByModule(long idModule, FolderType type) throws DBException;

	/**
	 * Gets the file from document.
	 * 
	 * @param idDocument
	 *            Document identifier.
	 * @return File.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	FileMeta getFileFromDocument(long idDocument) throws DBException;

	/**
	 * Gets a document by name.
	 * 
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @param fType
	 *            Folder type.
	 * @param fm
	 *            File info.
	 * @return Document.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<Document> getByName(long ownerModuleId, FolderType fType, FileMeta fm) throws DBException;

	/**
	 * Commit a DB transaction.
	 */
	void commit() throws DBException;

	/**
	 * Update a document.
	 * 
	 * @param doc
	 *            Document.
	 * @return Document updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Document updateWithoutATransaction(Document doc) throws DBException;
}
