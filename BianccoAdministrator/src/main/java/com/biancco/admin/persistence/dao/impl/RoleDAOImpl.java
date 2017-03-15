/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.RoleDAO;
import com.biancco.admin.persistence.model.Role;

/**
 * Role DAO implementation.
 * 
 * @author SOSExcellence.
 */
public class RoleDAOImpl implements RoleDAO {
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
	public Role save(Role role) throws DBException {
		try {
			this.entityManager.persist(role);
			this.entityManager.flush();
			return role;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void update(Role role) throws DBException {
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
	public void delete(Role role) throws DBException {
		try {
			this.entityManager.remove(role);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Role> getAll(boolean enabledOnly) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Role> q = builder.createQuery(Role.class);
			Root<Role> root = q.from(Role.class);
			q.select(root);
			if (enabledOnly) {
				Predicate pEnabled = builder.equal(root.get("enable"), enabledOnly);
				q.where(pEnabled);
			}
			q.orderBy(builder.asc(root.get("name")));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}
}
