/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.app.util.JSONUtil;
import com.biancco.admin.persistence.model.PermissionType;

/**
 * Folder view.
 * 
 * @author SOSExcellence.
 */
public class FolderView {
	/**
	 * Type identifier.
	 */
	private long typeId;
	/**
	 * Permission type.
	 */
	private PermissionType pType;
	/**
	 * Folder.
	 */
	private Node folder;
	/**
	 * Folder as JSON.
	 */
	private String folderAsJSON;

	/**
	 * @return the typeId.
	 */
	public long getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId
	 *            the typeId to set.
	 */
	public void setTypeId(long typeId) {
		this.typeId = typeId;
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
	 * @return folder as JSON.
	 */
	public String getFolderAsJSON() {
		this.folderAsJSON = HTTPUtils.encodeString(JSONUtil.getJSONString(this.folder), HTTPUtils.CHARSET_UTF8);
		return folderAsJSON;
	}

}
