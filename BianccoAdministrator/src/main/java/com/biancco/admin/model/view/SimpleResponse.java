/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.model.view;

/**
 * Simple message.
 * 
 * @author SOSExcellence.
 */
public class SimpleResponse {
	/**
	 * The message.
	 */
	private String message;

	/**
	 * Constructor.
	 */
	public SimpleResponse() {
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            Message.
	 */
	public SimpleResponse(String message) {
		this.message = message;
	}

	/**
	 * @return the message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
