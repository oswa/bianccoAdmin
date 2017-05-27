/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.folder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * File meta.
 * 
 * @author SOSExcellence.
 */
@JsonIgnoreProperties({ "bytes", "path" })
public class FileMeta {
	/**
	 * Name.
	 */
	private String name;
	/**
	 * Size.
	 */
	private String size;
	/**
	 * Bytes.
	 */
	private byte[] bytes;
	/**
	 * Path.
	 */
	private String path;

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
	 * @return the size.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the bytes.
	 */
	public byte[] getBytes() {
		return bytes;
	}

	/**
	 * @param bytes
	 *            the bytes to set.
	 */
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	/**
	 * @return the path.
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set.
	 */
	public void setPath(String path) {
		this.path = path;
	}

}
