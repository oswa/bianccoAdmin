/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
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
	 * @return A doucument list.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	List<Document> getByModule(long idModule, FolderType type) throws DBException;
}
