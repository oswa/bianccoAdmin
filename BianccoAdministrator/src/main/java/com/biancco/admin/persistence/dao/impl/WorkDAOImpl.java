/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.WorkDAO;
import com.biancco.admin.persistence.model.WorkCompany;

/**
 * @author SOSExcellence.
 *
 */
public class WorkDAOImpl implements WorkDAO {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Entity Manager.
	 */
	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkCompany getWorkById(long idWork) throws DBException {
		try {
			return this.entityManager.find(WorkCompany.class, idWork);
		} catch (Exception e) {
			this.logger.error("Error on get company by id", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkCompany updateWork(WorkCompany Work) throws DBException {
		try {
			return entityManager.merge(Work);
		} catch (Exception e) {
			this.logger.error("Error on update company", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * @return 
	 */
	@Override
	@Transactional
	public WorkCompany save(WorkCompany company) throws DBException {
		try {
			this.entityManager.persist(company);
			this.entityManager.flush();
			return company;
		} catch (Exception e) {
			this.logger.error("Error on save work", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public WorkCompany update(WorkCompany work) throws DBException {
		try {
			return entityManager.merge(work);
		} catch (Exception e) {
			this.logger.error("Error on update work", e);
			throw new DBException(e);
		}
	}
}
