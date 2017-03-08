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
import com.biancco.admin.persistence.dao.PermissionDAO;
import com.biancco.admin.persistence.model.Permission;

/**
 *
 * @author SOSExcellence.
 */
public class PermissionDAOImpl implements PermissionDAO {
	/**
	 * Entity Manger.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Permission save(Permission permission) throws DBException {
		try {
			this.entityManager.persist(permission);
			this.entityManager.flush();
			return permission;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void update(Permission permission) throws DBException {
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
	public void delete(Permission permission) throws DBException {
		try {
			this.entityManager.remove(permission);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Permission> getAll() throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Permission> q = builder.createQuery(Permission.class);
			Root<Permission> root = q.from(Permission.class);
			q.select(root);
			q.orderBy(builder.asc(root.get("role")));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}
}
