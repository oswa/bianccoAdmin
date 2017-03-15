/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Boolean Y/N converter.
 * 
 * @author SOSExcellence.
 */
@Converter(autoApply = true)
public class BooleanYNConverter implements AttributeConverter<Boolean, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String convertToDatabaseColumn(Boolean value) {
		if (Boolean.TRUE.equals(value)) {
			return "Y";
		} else {
			return "N";
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean convertToEntityAttribute(String value) {
		return "Y".equals(value);
	}
}
