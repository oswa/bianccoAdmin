/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.exception;

import javax.persistence.PersistenceException;

/**
 * DBException Exception.
 * 
 * @author SOSExcellence.
 */
public class DBException extends Exception {
	/**
	 * Persistence exception.
	 */
	private Throwable persistenceExceptionCause;

	/**
	 * JPA detail message.
	 */
	private String jpaDetailMessage;

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
		if (exception instanceof PersistenceException) {
			this.setPersistenceExceptionCause(exception.getCause());
			if (exception.getCause() != null && exception.getCause().getCause() != null
					&& exception.getCause().getCause().getMessage() != null) {
				this.setJpaDetailMessage(exception.getCause().getCause().getMessage());
			}
		}
	}

	/**
	 * @return the persistenceExceptionCause.
	 */
	public Throwable getPersistenceExceptionCause() {
		return persistenceExceptionCause;
	}

	/**
	 * @param persistenceExceptionCause
	 *            the persistenceExceptionCause to set.
	 */
	public void setPersistenceExceptionCause(Throwable persistenceExceptionCause) {
		this.persistenceExceptionCause = persistenceExceptionCause;
	}

	/**
	 * @return the jpaDetailMessage.
	 */
	public String getJpaDetailMessage() {
		return jpaDetailMessage;
	}

	/**
	 * @param jpaDetailMessage
	 *            the jpaDetailMessage to set.
	 */
	public void setJpaDetailMessage(String jpaDetailMessage) {
		this.jpaDetailMessage = jpaDetailMessage;
	}

}
