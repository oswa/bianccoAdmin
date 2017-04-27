/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.ModuleDAO;
import com.biancco.admin.persistence.model.Module;

/**
 * Module DAO implementation.
 * 
 * @author SOSExcellence.
 */
public class ModuleDAOImpl implements ModuleDAO {
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
	public Module save(Module module) throws DBException {
		try {
			this.entityManager.persist(module);
			this.entityManager.flush();
			return module;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Module module) throws DBException {
		try {
			this.entityManager.merge(module);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(Module module) throws DBException {
		try {
			this.entityManager.remove(module);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Module> getAll() throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Module> q = builder.createQuery(Module.class);
			Root<Module> root = q.from(Module.class);
			q.select(root);
			q.orderBy(builder.asc(root.get("name")));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Module getById(Long identifier) throws DBException {
		try {
			return this.entityManager.find(Module.class, identifier);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

}
