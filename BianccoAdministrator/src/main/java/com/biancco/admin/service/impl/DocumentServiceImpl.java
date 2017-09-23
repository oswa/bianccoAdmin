/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.app.util.DateUtils;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.persistence.dao.DocumentDAO;
import com.biancco.admin.persistence.model.Document;
import com.biancco.admin.persistence.model.Employee;
import com.biancco.admin.persistence.model.FolderBase;
import com.biancco.admin.persistence.model.FolderType;
import com.biancco.admin.service.DocumentService;

/**
 * Document service implementation.
 * 
 * @author SOSExcellence.
 */
public class DocumentServiceImpl implements DocumentService {
	/**
	 * The logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Document DAO.
	 */
	@Autowired
	private DocumentDAO documentDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void saveDocuments(long folderId, long ownerModuleId, FolderType fType, LinkedList<FileMeta> files,
			HttpSession session) throws DBException {
		// get employee
		Employee emp = (Employee) session.getAttribute(BianccoConstants.ATTR_USER);
		// get folder
		FolderBase f = new FolderBase();
		f.setIdFolder(folderId);
		for (FileMeta fm : files) {
			if (fm.isAlreadyExists()) {
				List<Document> docs = this.documentDAO.getByName(ownerModuleId, fType, fm);
				Document d = this.filterDocumentByPath(fm.getPath(), docs);
				Calendar c = Calendar.getInstance();
				if (d.getLastModifyDate() != null) {
					d.setModifyDate(d.getLastModifyDate());
					d.setModifyEmployee(d.getLastModifyEmployee());
				} else {
					d.setModifyDate(c);
					d.setModifyEmployee(emp);
				}
				d.setLastModifyDate(c);
				d.setLastModifyEmployee(emp);
				// update
				this.documentDAO.updateWithoutATransaction(d);
			} else {
				// create document
				Document d = new Document();
				d.setCreationDate(Calendar.getInstance());
				d.setCreationEmployee(emp);
				d.setFolder(f);
				d.setName(fm.getName());
				d.setOwnerFolderType(fType);
				d.setOwnerModuleId(ownerModuleId);
				d.setVersion(this.getVersion());
				d.setPath(fm.getPath());
				d.setContentType(fm.getContentType());
				// save
				this.documentDAO.saveWithoutATransaction(d);
			}
		}
		this.documentDAO.commit();
	}

	/**
	 * Get version from current date (yyyyMMddhhmmss).
	 * 
	 * @return
	 */
	private String getVersion() {
		Calendar c = Calendar.getInstance();
		return DateUtils.getDateWithFormat("yyyyMMddhhmmss", c.getTime());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileMeta getFileFromDocument(long idDoc) throws DBException {
		// get file info
		FileMeta fm = this.documentDAO.getFileFromDocument(idDoc);
		File f = new File(fm.getPath(), fm.getName());
		// set bytes
		if (f.exists()) {
			try {
				fm.setBytes(FileUtils.readFileToByteArray(f));
			} catch (IOException e) {
				this.logger.error("Error al leer el archivo " + fm.getName(), e);
			}
		}
		return fm;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteDocument(long idDoc) throws DBException {
		// get doc to delete
		Document doc = this.documentDAO.getById(idDoc);
		// delete file
		try {
			org.apache.commons.io.FileUtils.forceDelete(new File(doc.getPath(), doc.getName()));
		} catch (IOException e) {
			this.logger.error("Error borrando el archivo " + doc.getName(), e);
			throw new ApplicationException("No se puede borrar el documento, por favor contacte a un administrador");
		}
		// delete doc
		this.documentDAO.delete(idDoc);
	}

	private Document filterDocumentByPath(String path, List<Document> docs) {
		for (Document d : docs) {
			if (d.getPath().equals(path)) {
				return d;
			}
		}
		return null;
	}

}
