/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Document.
 * 
 * @author SOSExcellence.
 */
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
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folder_base")
	private FolderBase folder;
	/**
	 * Template.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_template_doc")
	private TemplateDocument template;
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
	private Employee lockeEmployee;

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
	public Employee getLockeEmployee() {
		return lockeEmployee;
	}

	/**
	 * @param lockeEmployee
	 *            the lockeEmployee to set.
	 */
	public void setLockeEmployee(Employee lockeEmployee) {
		this.lockeEmployee = lockeEmployee;
	}
}
