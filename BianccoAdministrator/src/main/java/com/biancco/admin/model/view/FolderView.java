/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import java.util.List;

import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.app.util.JSONUtil;
import com.biancco.admin.model.folder.FieldValue;
import com.biancco.admin.persistence.model.PermissionType;

/**
 * Folder view.
 * 
 * @author SOSExcellence.
 */
public class FolderView {
	/**
	 * Owner module identifier.
	 */
	private long ownerModuleId;
	/**
	 * Permission type.
	 */
	private PermissionType pType;
	/**
	 * Folder tree.
	 */
	private Node folder;
	/**
	 * Folder tree as JSON.
	 */
	private String folderAsJSON;
	/**
	 * Folder identifier.
	 */
	private long folderId;
	/**
	 * Folder fields.
	 */
	private List<FieldValue> fields;

	/**
	 * @return the ownerModuleId.
	 */
	public long getOwnerModuleId() {
		return ownerModuleId;
	}

	/**
	 * @param ownerModuleId
	 *            the ownerModuleId to set.
	 */
	public void setOwnerModuleId(long ownerModuleId) {
		this.ownerModuleId = ownerModuleId;
	}

	/**
	 * @param folderAsJSON
	 *            the folderAsJSON to set.
	 */
	public void setFolderAsJSON(String folderAsJSON) {
		this.folderAsJSON = folderAsJSON;
	}

	/**
	 * @return the pType.
	 */
	public PermissionType getpType() {
		return pType;
	}

	/**
	 * @param pType
	 *            the pType to set.
	 */
	public void setpType(PermissionType pType) {
		this.pType = pType;
	}

	/**
	 * @return the folder.
	 */
	public Node getFolder() {
		return folder;
	}

	/**
	 * @param folder
	 *            the folder to set.
	 */
	public void setFolder(Node folder) {
		this.folder = folder;
	}

	/**
	 * @return the folderId.
	 */
	public long getFolderId() {
		return folderId;
	}

	/**
	 * @param folderId
	 *            the folderId to set.
	 */
	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	/**
	 * @return the fields.
	 */
	public List<FieldValue> getFields() {
		return fields;
	}

	/**
	 * @param fields
	 *            the fields to set.
	 */
	public void setFields(List<FieldValue> fields) {
		this.fields = fields;
	}

	/**
	 * @return folder as JSON.
	 */
	public String getFolderAsJSON() {
		this.folderAsJSON = HTTPUtils.encodeString(JSONUtil.getJSONString(this.folder), HTTPUtils.CHARSET_UTF8);
		return folderAsJSON;
	}

}
