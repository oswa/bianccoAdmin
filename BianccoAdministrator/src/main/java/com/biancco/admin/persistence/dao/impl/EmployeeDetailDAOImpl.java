/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.EmployeeDetailDAO;
import com.biancco.admin.persistence.model.EmployeeDetail;

/**
 * Employee detail DAO implementation.
 * 
 * @author SOSExcellence.
 */
public class EmployeeDetailDAOImpl implements EmployeeDetailDAO {
	/**
	 * Entity Manager.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public EmployeeDetail save(EmployeeDetail detail) throws DBException {
		try {
			this.entityManager.persist(detail);
			this.entityManager.flush();
			return detail;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void update(EmployeeDetail detail) throws DBException {
		try {
			//
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(EmployeeDetail detail) throws DBException {
		try {
			this.entityManager.remove(detail);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public EmployeeDetail getById(long identifier) throws DBException {
		try {
			return this.entityManager.find(EmployeeDetail.class, identifier);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}
}
