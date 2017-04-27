/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a folder-field value.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "folder_value")
public class FolderFieldValue {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_folder_value")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFolderValue;
	/**
	 * Folder field.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folder_field")
	private FolderField field;
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
	 * Value.
	 */
	@Column(name = "value")
	private String value;
	/**
	 * Folder identifier.
	 */
	@Transient
	private Long idFolder;

	/**
	 * Dummy constructor.
	 */
	public FolderFieldValue() {
	}

	/**
	 * @return the idFolderValue.
	 */
	public Long getIdFolderValue() {
		return idFolderValue;
	}

	/**
	 * @param idFolderValue
	 *            the idFolderValue to set.
	 */
	public void setIdFolderValue(Long idFolderValue) {
		this.idFolderValue = idFolderValue;
	}

	/**
	 * @return the field.
	 */
	public FolderField getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set.
	 */
	public void setField(FolderField field) {
		this.field = field;
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

	/**
	 * @return the value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set.
	 */
	public void setValue(String value) {
		this.value = value;
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

}
