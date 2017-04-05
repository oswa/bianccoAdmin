/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

/**
 *
 * @author SOSExcellence.
 */
public enum PermissionType {
	/**
	 * QUERY.
	 */
	QUERY("CONSULTA", "Q"),
	/**
	 * MODIFY.
	 */
	MODIFY("MODIFICACION", "M");
	/**
	 * Name.
	 */
	private String name;
	/**
	 * Type.
	 */
	private String type;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            the name.
	 * @param type
	 *            the type.
	 */
	private PermissionType(String name, String type) {
		this.name = name;
		this.type = type;
	}

	/**
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the type.
	 */
	public String getType() {
		return type;
	}
}
