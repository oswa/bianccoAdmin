/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.exception;

/**
 * DBException Exception.
 * 
 * @author SOSExcellence.
 */
public class DBException extends Exception {

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            A message.
	 */
	public DBException(final String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * 
	 * @param exception
	 *            The exception.
	 */
	public DBException(final Exception exception) {
		super(exception);
	}

}
