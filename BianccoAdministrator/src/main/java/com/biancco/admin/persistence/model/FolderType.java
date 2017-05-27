/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import com.biancco.admin.app.util.BianccoConstants;

/**
 * Folder types. Next modules must be add at the end of list.
 * 
 * @author SOSExcellence.
 */
public enum FolderType {
	/**
	 * Company folder.
	 */
	COMPANY("company", BianccoConstants.MODULE_COMPANY),
	/**
	 * Work company project folder.
	 */
	WORK_COMPANY_PROJECT("work_project", BianccoConstants.MODULE_COMPANY),
	/**
	 * Work company administration folder.
	 */
	WORK_COMPANY_ADMINISTRATION("work_admin", BianccoConstants.MODULE_COMPANY),
	/**
	 * Work company budget folder.
	 */
	WORK_COMPANY_BUDGET("work_budget", BianccoConstants.MODULE_COMPANY),
	/**
	 * Employee folder.
	 */
	EMPLOYEE("employee", BianccoConstants.MODULE_EMPLOYEE);

	/**
	 * Folder name.
	 */
	private String folder;
	/**
	 * Owner module.
	 */
	private String ownerModule;

	/**
	 * Constructor.
	 * 
	 * @param folder
	 *            Type name.
	 */
	private FolderType(String folder, String module) {
		this.folder = folder;
		this.ownerModule = module;
	}

	/**
	 * @return Folder name.
	 */
	public String getFolder() {
		return this.folder;
	}

	/**
	 * Gets the folder type from folder name.
	 * 
	 * @param folder
	 *            Folder name.
	 * @return Folder type.
	 */
	public static FolderType fromName(final String folder) {
		for (FolderType f : FolderType.values()) {
			if (f.folder.equals(folder)) {
				return f;
			}
		}
		return null;
	}

	/**
	 * Gets the folder type from a string.
	 * 
	 * @param string
	 *            Value Enum name.
	 * @return Folder type.
	 */
	public static FolderType fromString(final String string) {
		for (FolderType f : FolderType.values()) {
			if (f.name().equals(string)) {
				return f;
			}
		}
		return null;
	}

	/**
	 * @return Owner module.
	 */
	public String getOwnerModule() {
		return this.ownerModule;
	}
}
