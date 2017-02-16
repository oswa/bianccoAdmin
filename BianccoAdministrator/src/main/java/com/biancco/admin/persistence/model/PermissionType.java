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
	QUERY("CONSULTA"),
	/**
	 * MODIFY.
	 */
	MODIFY("MOFICACION");
	/**
	 * The name.
	 */
	private String name;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            the name.
	 */
	private PermissionType(String name) {
		this.name = name;
	}

	/**
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
}
