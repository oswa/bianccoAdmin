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
@JsonIgnoreProperties({ "bytes", "path", "contentType" })
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
	 * Content type.
	 */
	private String contentType;
	/**
	 * Exists flag.
	 */
	private boolean alreadyExists;

	/**
	 * Dummy constructor.
	 */
	public FileMeta() {
	}

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            Name.
	 * @param path
	 *            Parent path.
	 * @param contentType
	 *            Content type.
	 */
	public FileMeta(String name, String path, String contentType) {
		this.name = name;
		this.path = path;
		this.contentType = contentType;
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

	/**
	 * @return the contentType.
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType
	 *            the contentType to set.
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the alreadyExists.
	 */
	public boolean isAlreadyExists() {
		return alreadyExists;
	}

	/**
	 * @param alreadyExists
	 *            the alreadyExists to set.
	 */
	public void setAlreadyExists(boolean alreadyExists) {
		this.alreadyExists = alreadyExists;
	}

}
