/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.util.Calendar;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
			// create document
			Document d = new Document();
			d.setCreationDate(Calendar.getInstance());
			d.setCreationEmployee(emp);
			d.setFolder(f);
			d.setName(fm.getName());
			d.setOwnerFolderType(fType);
			d.setOwnerModuleId(ownerModuleId);
			d.setVersion(this.getVersion());
			// save
			this.documentDAO.saveWithoutATransaction(d);
		}
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

}
