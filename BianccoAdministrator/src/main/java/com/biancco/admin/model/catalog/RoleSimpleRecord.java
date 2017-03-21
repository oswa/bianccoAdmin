/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.catalog;

/**
 * Role simple record.
 * 
 * @author SOSExcellence.
 */
public class RoleSimpleRecord {
	/**
	 * Identifier.
	 */
	private long id;
	/**
	 * Name.
	 */
	private String name;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            Identifier.
	 * @param name
	 *            Name.
	 */
	public RoleSimpleRecord(long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set.
	 */
	public void setId(long id) {
		this.id = id;
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
}
