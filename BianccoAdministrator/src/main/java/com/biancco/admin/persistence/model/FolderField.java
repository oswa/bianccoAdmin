/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Folder field.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "folder_field")
public class FolderField {
	/**
	 * Identifier.
	 */
	@Id
	@Column(name = "id_folder_field")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFolderField;
	/**
	 * Folder base.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_folder_base")
	private FolderBase folderBase;
	/**
	 * Folder-field value.
	 */
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "field", cascade = CascadeType.ALL)
	private FolderFieldValue value;
	/**
	 * Field.
	 */
	@Column(name = "field")
	private String field;
	/**
	 * Type (Class name).
	 */
	@Column(name = "type")
	private String type;
	/**
	 * Required flag.
	 */
	@Column(name = "required")
	@Convert(converter = BooleanYNConverter.class)
	private Boolean required;
	/**
	 * Max lenngth if apply.
	 */
	@Column(name = "max_length")
	private int maxLength;
	/**
	 * Date flag.
	 */
	@Column(name = "date")
	@Convert(converter = BooleanYNConverter.class)
	private Boolean date;
	/**
	 * Catalog if apply.
	 */
	@Column(name = "group_param")
	private String catalog;
	/**
	 * Catalog if apply.
	 */
	@ManyToMany
	@JoinTable(name = "parameters", joinColumns = @JoinColumn(name = "group_param", insertable = false, updatable = false), inverseJoinColumns = @JoinColumn(name = "group_param"))
	private List<Parameter> catalogValues;

	/**
	 * Dummy constructor.
	 */
	public FolderField() {
	}

	/**
	 * @return the idFolderField.
	 */
	public Long getIdFolderField() {
		return idFolderField;
	}

	/**
	 * @param idFolderField
	 *            the idFolderField to set.
	 */
	public void setIdFolderField(Long idFolderField) {
		this.idFolderField = idFolderField;
	}

	/**
	 * @return the field.
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set.
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the required.
	 */
	public Boolean getRequired() {
		return required;
	}

	/**
	 * @param required
	 *            the required to set.
	 */
	public void setRequired(Boolean required) {
		this.required = required;
	}

	/**
	 * @return the maxLength.
	 */
	public int getMaxLength() {
		return maxLength;
	}

	/**
	 * @param maxLength
	 *            the maxLength to set.
	 */
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * @return the catalog.
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * @param catalog
	 *            the catalog to set.
	 */
	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	/**
	 * @return the catalogValues.
	 */
	public List<Parameter> getCatalogValues() {
		return catalogValues;
	}

	/**
	 * @param catalogValues
	 *            the catalogValues to set.
	 */
	public void setCatalogValues(List<Parameter> catalogValues) {
		this.catalogValues = catalogValues;
	}

	/**
	 * @return the folderBase.
	 */
	public FolderBase getFolderBase() {
		return folderBase;
	}

	/**
	 * @param folderBase
	 *            the folderBase to set.
	 */
	public void setFolderBase(FolderBase folderBase) {
		this.folderBase = folderBase;
	}

	/**
	 * @return the value.
	 */
	public FolderFieldValue getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set.
	 */
	public void setValue(FolderFieldValue value) {
		this.value = value;
	}

	/**
	 * @return the date.
	 */
	public Boolean getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set.
	 */
	public void setDate(Boolean date) {
		this.date = date;
	}
}
