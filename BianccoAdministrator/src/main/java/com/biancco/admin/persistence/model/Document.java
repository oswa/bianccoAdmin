/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Document.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "document")
public class Document {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_document")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	/**
	 * Folder.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folder_base")
	private FolderBase folder;
	/**
	 * Template.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_template_doc")
	private TemplateDocument template;
	/**
	 * Module owner.
	 */
	@Column(name = "owner_module_id")
	private Long ownerModuleId;
	/**
	 * Folder type owner.
	 */
	@Column(name = "owner_folder_type")
	@Enumerated(EnumType.STRING)
	private FolderType ownerFolderType;
	/**
	 * Name.
	 */
	@Column(name = "name")
	private String name;
	/**
	 * Version.
	 */
	@Column(name = "version")
	private String version;
	/**
	 * Creation date.
	 */
	@Column(name = "creation_date")
	private Calendar creationDate;
	/**
	 * Creation employee.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creation_employee")
	private Employee creationEmployee;
	/**
	 * Modify date.
	 */
	@Column(name = "modify_date")
	private Calendar modifyDate;
	/**
	 * Modify employee.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modify_employee")
	private Employee modifyEmployee;
	/**
	 * Last modify date.
	 */
	@Column(name = "last_modif_date")
	private Calendar lastModifyDate;
	/**
	 * Last modify employee.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "last_modif_employee")
	private Employee lastModifyEmployee;
	/**
	 * Locked flag.
	 */
	@Column(name = "locked")
	private Boolean locked;
	/**
	 * Locked employee.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locked_employee")
	private Employee lockedEmployee;

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
	 * @return the folder.
	 */
	public FolderBase getFolder() {
		return folder;
	}

	/**
	 * @param folder
	 *            the folder to set.
	 */
	public void setFolder(FolderBase folder) {
		this.folder = folder;
	}

	/**
	 * @return the template.
	 */
	public TemplateDocument getTemplate() {
		return template;
	}

	/**
	 * @param template
	 *            the template to set.
	 */
	public void setTemplate(TemplateDocument template) {
		this.template = template;
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
	public Calendar getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set.
	 */
	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the creationEmployee.
	 */
	public Employee getCreationEmployee() {
		return creationEmployee;
	}

	/**
	 * @param creationEmployee
	 *            the creationEmployee to set.
	 */
	public void setCreationEmployee(Employee creationEmployee) {
		this.creationEmployee = creationEmployee;
	}

	/**
	 * @return the modifyDate.
	 */
	public Calendar getModifyDate() {
		return modifyDate;
	}

	/**
	 * @param modifyDate
	 *            the modifyDate to set.
	 */
	public void setModifyDate(Calendar modifyDate) {
		this.modifyDate = modifyDate;
	}

	/**
	 * @return the modifyEmployee.
	 */
	public Employee getModifyEmployee() {
		return modifyEmployee;
	}

	/**
	 * @param modifyEmployee
	 *            the modifyEmployee to set.
	 */
	public void setModifyEmployee(Employee modifyEmployee) {
		this.modifyEmployee = modifyEmployee;
	}

	/**
	 * @return the lastModifyDate.
	 */
	public Calendar getLastModifyDate() {
		return lastModifyDate;
	}

	/**
	 * @param lastModifyDate
	 *            the lastModifyDate to set.
	 */
	public void setLastModifyDate(Calendar lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	/**
	 * @return the lastModifyEmployee.
	 */
	public Employee getLastModifyEmployee() {
		return lastModifyEmployee;
	}

	/**
	 * @param lastModifyEmployee
	 *            the lastModifyEmployee to set.
	 */
	public void setLastModifyEmployee(Employee lastModifyEmployee) {
		this.lastModifyEmployee = lastModifyEmployee;
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

	/**
	 * @return the lockeEmployee.
	 */
	public Employee getLockedEmployee() {
		return lockedEmployee;
	}

	/**
	 * @param lockeEmployee
	 *            the lockeEmployee to set.
	 */
	public void setLockedEmployee(Employee lockedEmployee) {
		this.lockedEmployee = lockedEmployee;
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
	 * @return the ownerFolderType.
	 */
	public FolderType getOwnerFolderType() {
		return ownerFolderType;
	}

	/**
	 * @param ownerFolderType
	 *            the ownerFolderType to set.
	 */
	public void setOwnerFolderType(FolderType ownerFolderType) {
		this.ownerFolderType = ownerFolderType;
	}
}
