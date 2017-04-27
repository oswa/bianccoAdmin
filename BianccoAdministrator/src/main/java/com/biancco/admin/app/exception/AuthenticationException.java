/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.exception;

/**
 * Authentication exception.
 * 
 * @author SOSExcellence.
 */
public class AuthenticationException extends RuntimeException {
	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The message.
	 */
	private String messageError;
	/**
	 * The original message error.
	 */
	private String originalMessageError;
	/**
	 * The exception.
	 */
	private Exception exception;

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            The message error.
	 */
	public AuthenticationException(final String message) {
		super(message, new Throwable(message));
		this.messageError = message;
		this.originalMessageError = message;
	}

	/**
	 * Constructor.
	 * 
	 * @param message
	 *            The message error.
	 * @param exception
	 *            The exception.
	 */
	public AuthenticationException(final String message, final Exception exception) {
		super(message, exception);
		this.messageError = message;
		this.originalMessageError = exception.getMessage();
		this.exception = exception;
	}

	/**
	 * Constructor.
	 * 
	 * @param exception
	 *            The exception.
	 */
	public AuthenticationException(final Exception exception) {
		super(exception);
		this.messageError = exception.getMessage();
		this.originalMessageError = exception.getMessage();
		this.exception = exception;
	}

	/**
	 * @return the messageError.
	 */
	public String getMessageError() {
		return messageError;
	}

	/**
	 * @param messageError
	 *            the messageError to set.
	 */
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	/**
	 * @return the originalMessageError.
	 */
	public String getOriginalMessageError() {
		return originalMessageError;
	}

	/**
	 * @param originalMessageError
	 *            the originalMessageError to set.
	 */
	public void setOriginalMessageError(String originalMessageError) {
		this.originalMessageError = originalMessageError;
	}

	/**
	 * @return the exception.
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception
	 *            the exception to set.
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}
}
