/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FieldValue;
import com.biancco.admin.model.folder.FolderDocument;
import com.biancco.admin.model.view.FolderView;
import com.biancco.admin.model.view.Node;
import com.biancco.admin.persistence.dao.FolderDAO;
import com.biancco.admin.persistence.dao.FolderFieldDAO;
import com.biancco.admin.persistence.dao.FolderFieldValueDAO;
import com.biancco.admin.persistence.dao.ParameterDAO;
import com.biancco.admin.persistence.model.FolderFieldValue;
import com.biancco.admin.persistence.model.FolderType;
import com.biancco.admin.persistence.model.Parameter;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.service.FolderService;

/**
 * Folder service implementation.
 * 
 * @author SOSExcellence.
 */
public class FolderServiceImpl implements FolderService {
	/**
	 * The logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Access to work persistent memory.
	 */
	@Autowired
	private FolderDAO folderDao;
	/**
	 * Folder field DAO.
	 */
	@Autowired
	private FolderFieldDAO folderFieldDAO;
	/**
	 * Parameter DAO.
	 */
	@Autowired
	private ParameterDAO paramaterDAO;
	/**
	 * Folder field value DAO.
	 */
	@Autowired
	private FolderFieldValueDAO folderFieldValueDAO;
	/**
	 * Icon folder-close.
	 */
	private String ICON_FOLDER_CLOSE = "glyphicon glyphicon-folder-close";
	/**
	 * Icon birefcase.
	 */
	private String ICON_BRIEFCASE = "glyphicon glyphicon-briefcase";
	/**
	 * Icon file.
	 */
	private String ICON_FILE = "glyphicon glyphicon-file";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Node getTreeFolderByType(FolderType folderType, long ownerModuleId) throws DBException {
		// get folder-documents
		List<FolderDocument> folder = this.folderDao.getFolderDocumentsByType(folderType, ownerModuleId);
		if (folder == null || folder.isEmpty()) {
			throw new ApplicationException(
					"Estructura de folder no configurado, por favor contacte a un administrador.");
		}
		// build tree node
		Node node = buildTreeFolder(folder, ownerModuleId);
		return node;
	}

	/**
	 * Build a tree node with the folder-documents.
	 * 
	 * @param folder
	 *            Folder-documents.
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @return Node root.
	 */
	private Node buildTreeFolder(List<FolderDocument> folder, long ownerModuleId) {
		// get root
		FolderDocument root = folder.get(0);
		// set owner module identifier
		root.setOwnerModuleId(ownerModuleId);
		// create root node
		Node node = new Node();
		node.setText(root.getPathChild());
		node.setIcon(ICON_BRIEFCASE);
		node.setFolder(true);
		node.setDetail(root);
		// clean folder
		folder.remove(0);
		// get parent
		Long parent = root.getIdFolder();
		// set childs to root
		List<Node> childs = this.extractNodesByParent(folder, parent, ownerModuleId);
		node.setNodes(childs);

		return node;
	}

	/**
	 * Extract nodes by parent.
	 * 
	 * @param folder
	 *            Folder-documents.
	 * @param parent
	 *            Parent identifier.
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @return Nodes (folders & documents) by parent.
	 */
	private List<Node> extractNodesByParent(List<FolderDocument> folder, final Long parent, long ownerModuleId) {
		// select items
		List<FolderDocument> selectedItems = this.selectFoldersByParent(folder, parent);
		// initialize nodes
		List<Node> nodes = new ArrayList<Node>();
		// evaluate items
		Node node = null;
		int totalDocs = 0;
		for (FolderDocument fd : selectedItems) {
			// set owner module identifier
			fd.setOwnerModuleId(ownerModuleId);
			// create a folder node
			if (node == null) {
				node = new Node();
				node.setText(fd.getPathChild());
				node.setIcon(ICON_FOLDER_CLOSE);
				node.setFolder(true);
				node.setDetail(fd);
				// add node
				nodes.add(node);
				// set childs if contains
				Long nodeParent = fd.getIdFolder();
				List<Node> childs = this.extractNodesByParent(folder, nodeParent, ownerModuleId);
				if (!childs.isEmpty()) {
					node.setNodes(childs);
				}
			}
			// validate if contains a document
			Long idDoc = fd.getIdDocument();
			if (idDoc != null) {
				// create a document node
				Node child = new Node();
				child.setText(fd.getName());
				child.setIcon(ICON_FILE);
				child.setFolder(false);
				child.setDetail(fd);
				// add child
				node.addNode(child);
				// count docs
				totalDocs++;
				node.setTags(new Integer[] { totalDocs });
			} else {
				// reset node
				node = null;
				// reset counter
				totalDocs = 0;
			}
		}
		return nodes;
	}

	/**
	 * Selects the items from folder by parent.
	 * 
	 * @param folder
	 *            Folder-documents.
	 * @param parent
	 *            Parent identifier.
	 * @return Selected items.
	 */
	@SuppressWarnings("unchecked")
	private List<FolderDocument> selectFoldersByParent(List<FolderDocument> folder, final Long parent) {
		// select items by parent
		Predicate p = new Predicate() {

			@Override
			public boolean evaluate(final Object o) {
				FolderDocument fd = (FolderDocument) o;
				return fd.getParent() == parent;
			}
		};
		return (List<FolderDocument>) CollectionUtils.select(folder, p);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolderView getFolderFields(String type, long ownerModuleId, long folderId, HttpSession session)
			throws DBException {
		// get folder type
		FolderType fType = FolderType.fromName(type);
		// set permission type
		PermissionType pType = (PermissionType) session.getAttribute(fType.getOwnerModule());
		// build view
		FolderView fv = new FolderView();
		fv.setpType(pType);
		fv.setOwnerModuleId(ownerModuleId);
		fv.setFolderId(folderId);
		fv.setFolderType(fType);
		// get fields
		List<FieldValue> fields = this.folderFieldDAO.getFieldValueByFolder(folderId, ownerModuleId, fType);
		// retrieve catalogs if apply
		this.setCatalogToField(fields);
		fv.setFields(fields);
		return fv;
	}

	/**
	 * Set catalogs to field list if apply.
	 * 
	 * @param fields
	 *            Field list.
	 * @throws DBException
	 */
	private void setCatalogToField(List<FieldValue> fields) throws DBException {
		if (fields != null && !fields.isEmpty()) {
			for (FieldValue f : fields) {
				String paramGroup = StringUtils.trimToNull(f.getCatalog());
				if (paramGroup != null) {
					List<Parameter> params = this.paramaterDAO.getByGroup(paramGroup);
					f.setCatalogValues(params);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FolderView saveFieldValues(List<FolderFieldValue> values, HttpSession session) throws DBException {
		// save
		this.folderFieldValueDAO.save(values);
		// refresh view
		FolderFieldValue val = values.get(0);
		return this.getFolderFields(val.getOwnerFolderType().getFolder(), val.getOwnerModuleId(), val.getIdFolder(),
				session);
	}
}