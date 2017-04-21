/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.folder;

import java.util.Calendar;

import com.biancco.admin.app.util.DateUtils;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Represents a folder - document.
 * 
 * @author SOSExcellence.
 */
public class FolderDocument {
	/**
	 * The identifier.
	 */
	private Long idFolder;
	/**
	 * Parent folder.
	 */
	private Long parent;
	/**
	 * Type.
	 */
	private FolderType type;
	/**
	 * Path root.
	 */
	private String pathRoot;
	/**
	 * Path child.
	 */
	private String pathChild;
	/**
	 * Allow modify flag.
	 */
	private Boolean allowModify;
	/**
	 * Patterns.
	 */
	private String patterns;
	/**
	 * The identifier.
	 */
	private Long idDocument;
	/**
	 * Module owner.
	 */
	private Long ownerModuleId;
	/**
	 * Name.
	 */
	private String name;
	/**
	 * Version.
	 */
	private String version;
	/**
	 * Creation date.
	 */
	private String creationDate;
	/**
	 * Modify date.
	 */
	private String modifyDate;
	/**
	 * Last modify date.
	 */
	private String lastModifyDate;
	/**
	 * Locked flag.
	 */
	private Boolean locked;

	/**
	 * Constructor.
	 * 
	 * @param idFolder
	 *            Folder identifier.
	 * @param parent
	 *            Folder parent.
	 * @param type
	 *            Folder type.
	 * @param pathRoot
	 *            Folder path root.
	 * @param pathChild
	 *            Folder path child.
	 * @param allowModify
	 *            Folder Allow modify flag.
	 * @param patterns
	 *            Folder patterns.
	 * @param idDocument
	 *            Document identifier.
	 * @param ownerModuleId
	 *            Document owner module identifier.
	 * @param name
	 *            Document name.
	 * @param version
	 *            Document version.
	 * @param creationDate
	 *            Document creation date.
	 * @param modifyDate
	 *            Document modify date.
	 * @param lastModifyDate
	 *            Document last modify date.
	 * @param lockeD
	 *            Document locked flag.
	 */
	public FolderDocument(Long idFolder, Long parent, FolderType type, String pathRoot, String pathChild,
			Boolean allowModify, String patterns, Long idDocument, Long ownerModuleId, String name, String version,
			Calendar creationDate, Calendar modifyDate, Calendar lastModifyDate, Boolean locked) {
		this.idFolder = idFolder;
		this.parent = parent;
		this.type = type;
		this.pathRoot = pathRoot;
		this.pathChild = pathChild;
		this.allowModify = allowModify;
		this.patterns = patterns;
		this.idDocument = idDocument;
		this.ownerModuleId = ownerModuleId;
		this.name = name;
		this.version = version;
		// validate the dates
		if (creationDate != null) {
			this.creationDate = DateUtils.getDateWithFormat(DateUtils.APP_PATTERN, creationDate.getTime());
		}
		if (modifyDate != null) {
			this.modifyDate = DateUtils.getDateWithFormat(DateUtils.APP_PATTERN, modifyDate.getTime());
		}
		if (lastModifyDate != null) {
			this.lastModifyDate = DateUtils.getDateWithFormat(DateUtils.APP_PATTERN, lastModifyDate.getTime());
		}
		this.locked = locked;
	}

	/**
	 * @return the idFolder.
	 */
	public Long getIdFolder() {
		return idFolder;
	}

	/**
	 * @param idFolder
	 *            the idFolder to set.
	 */
	public void setIdFolder(Long idFolder) {
		this.idFolder = idFolder;
	}

	/**
	 * @return the parent.
	 */
	public Long getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set.
	 */
	public void setParent(Long parent) {
		this.parent = parent;
	}

	/**
	 * @return the type.
	 */
	public FolderType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set.
	 */
	public void setType(FolderType type) {
		this.type = type;
	}

	/**
	 * @return the pathRoot.
	 */
	public String getPathRoot() {
		return pathRoot;
	}

	/**
	 * @param pathRoot
	 *            the pathRoot to set.
	 */
	public void setPathRoot(String pathRoot) {
		this.pathRoot = pathRoot;
	}

	/**
	 * @return the pathChild.
	 */
	public String getPathChild() {
		return pathChild;
	}

	/**
	 * @param pathChild
	 *            the pathChild to set.
	 */
	public void setPathChild(String pathChild) {
		this.pathChild = pathChild;
	}

	/**
	 * @return the allowModify.
	 */
	public Boolean getAllowModify() {
		return allowModify;
	}

	/**
	 * @param allowModify
	 *            the allowModify to set.
	 */
	public void setAllowModify(Boolean allowModify) {
		this.allowModify = allowModify;
	}

	/**
	 * @return the patterns.
	 */
	public String getPatterns() {
		return patterns;
	}

	/**
	 * @param patterns
	 *            the patterns to set.
	 */
	public void setPatterns(String patterns) {
		this.patterns = patterns;
	}

	/**
	 * @return the idDocument.
	 */
	public Long getIdDocument() {
		return idDocument;
	}

	/**
	 * @param idDocument
	 *            the idDocument to set.
	 */
	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	/**
	 * @return the ownerModuleId.
	 */
	public Long getOwnerModuleId() {
		return ownerModuleId;
	}

	/**
	 * @param ownerModuleId
	 *            the ownerModuleId to set.
	 */
	public void setOwnerModuleId(Long ownerModuleId) {
		this.ownerModuleId = ownerModuleId;
	}

	/**
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the version.
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set.
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the creationDate.
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set.
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the modifyDate.
	 */
	public String getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate
	 *            the modifyDate to set.
	 */
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return the lastModifyDate.
	 */
	public String getLastModifyDate() {
		return lastModifyDate;
	}

	/**
	 * @param lastModifyDate
	 *            the lastModifyDate to set.
	 */
	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	/**
	 * @return the locked.
	 */
	public Boolean getLocked() {
		return locked;
	}

	/**
	 * @param locked
	 *            the locked to set.
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
}
