/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.folder;

import java.util.List;

import com.biancco.admin.persistence.model.FolderType;
import com.biancco.admin.persistence.model.Parameter;

/**
 * Represents a field-value;
 * 
 * @author SOSExcellence.
 */
public class FieldValue {
	/**
	 * Field identifier.
	 */
	private Long idFolderField;
	/**
	 * Value identifier.
	 */
	private Long idFolderValue;
	/**
	 * Field.
	 */
	private String field;
	/**
	 * Module owner.
	 */
	private Long ownerModuleId;
	/**
	 * Folder type owner.
	 */
	private FolderType ownerFolderType;
	/**
	 * Value.
	 */
	private String value;
	/**
	 * Type (Class name).
	 */
	private String fieldType;
	/**
	 * Required flag.
	 */
	private Boolean required;
	/**
	 * Max lenngth if apply.
	 */
	private Integer maxLength;
	/**
	 * Catalog (group param) if apply.
	 */
	private String catalog;
	/**
	 * Date flag.
	 */
	private Boolean date;
	/**
	 * Catalog if apply.
	 */
	private List<Parameter> catalogValues;

	/**
	 * Constructor.
	 * 
	 * @param idFolderField
	 *            Field identifier.
	 * @param idFolderValue
	 *            Value identifier.
	 * @param field
	 *            Field.
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @param ownerFolderType
	 *            Owner folder type.
	 * @param value
	 *            Value.
	 * @param fieldType
	 *            Field type.
	 * @param required
	 *            Required flag.
	 * @param maxLength
	 *            Field max length.
	 * @param catalog
	 *            Catalog.
	 * @param date
	 *            Date flag.
	 */
	public FieldValue(Long idFolderField, Long idFolderValue, String field, Long ownerModuleId,
			FolderType ownerFolderType, String value, String fieldType, Boolean required, int maxLength, String catalog,
			Boolean date/*
						 * , List<Parameter> catalogValues
						 */) {
		this.idFolderField = idFolderField;
		this.idFolderValue = 0l;
		if (idFolderValue != null) {
			this.idFolderValue = idFolderValue;
		}
		this.field = field;
		this.ownerModuleId = ownerModuleId;
		this.ownerFolderType = ownerFolderType;
		this.value = value;
		this.fieldType = fieldType;
		this.required = required;
		this.maxLength = maxLength;
		this.catalog = catalog;
		this.date = date;
		// this.catalogValues = catalogValues;
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
	 * @return the fieldType.
	 */
	public String getFieldType() {
		return fieldType;
	}

	/**
	 * @param fieldType
	 *            the fieldType to set.
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
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
	public Integer getMaxLength() {
		return maxLength;
	}

	/**
	 * @param maxLength
	 *            the maxLength to set.
	 */
	public void setMaxLength(Integer maxLength) {
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
