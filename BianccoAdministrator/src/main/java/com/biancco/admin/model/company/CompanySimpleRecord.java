/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.model.company;

/**
 * @author SOSExcellence.
 *
 */
public class CompanySimpleRecord {
	/**
	 * Identifier.
	 */
	private long id;
	/**
	 * Name.
	 */
	private String name;
	/**
	 * Work counter.
	 */
	private long workCount;
	/**
	 * Enable flag.
	 */
	private Boolean enable = false;

	/**
	 * The constructor
	 * 
	 * @param id
	 * @param name
	 * @param workCount
	 */
	public CompanySimpleRecord(long id, String name, long workCount, Boolean enable) {
		this.id = id;
		this.name = name;
		this.workCount = workCount;
		this.enable = enable;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the workCount
	 */
	public long getWorkCount() {
		return workCount;
	}

	/**
	 * @param workCount
	 *            the workCount to set
	 */
	public void setWorkCount(long workCount) {
		this.workCount = workCount;
	}

	/**
	 * @return the enable.
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set.
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
