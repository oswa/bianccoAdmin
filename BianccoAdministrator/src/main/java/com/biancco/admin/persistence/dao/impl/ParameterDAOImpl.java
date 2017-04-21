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
import com.biancco.admin.persistence.dao.ParameterDAO;
import com.biancco.admin.persistence.model.Parameter;

/**
 *
 * @author SOSExcellence.
 */
public class ParameterDAOImpl implements ParameterDAO {
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
	public Parameter save(Parameter param) throws DBException {
		try {
			this.entityManager.persist(param);
			this.entityManager.flush();
			return param;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Parameter update(Parameter param) throws DBException {
		try {
			return entityManager.merge(param);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(long idParam) throws DBException {
		try {
			Parameter p = this.entityManager.getReference(Parameter.class, idParam);
			this.entityManager.remove(p);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Parameter> getByGroup(String group) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Parameter> q = builder.createQuery(Parameter.class);
			Root<Parameter> root = q.from(Parameter.class);
			q.select(root);
			q.where(builder.equal(root.get("group"), group));
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
	public Parameter getById(Long identifier) throws DBException {
		try {
			return this.entityManager.find(Parameter.class, identifier);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<String> getGroupNames() throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<String> q = builder.createQuery(String.class);
			Root<Parameter> root = q.from(Parameter.class);
			q.multiselect(root.get("group"));
			q.groupBy(root.get("group"));
			q.orderBy(builder.asc(root.get("group")));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getParameterValue(String groupName, String paramName) throws DBException {
		// TODO Auto-generated method stub
		return null;
	}

}
