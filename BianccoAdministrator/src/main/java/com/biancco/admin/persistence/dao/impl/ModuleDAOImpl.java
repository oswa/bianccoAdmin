/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.ModuleDAO;
import com.biancco.admin.persistence.model.Module;

/**
 * Module DAO implementation.
 * 
 * @author SOSExcellence.
 */
public class ModuleDAOImpl extends HibernateDaoSupport implements ModuleDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long save(Module module) throws DBException {
		try {
			return (Long) this.getHibernateTemplate().getSessionFactory().getCurrentSession().save(module);
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(Module module) throws DBException {
		try {
			this.getHibernateTemplate().getSessionFactory().getCurrentSession().update(module);
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Module module) throws DBException {
		try {
			getHibernateTemplate().getSessionFactory().getCurrentSession().delete(module);
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Module> getAll() throws DBException {
		try {
			EntityManager em = getHibernateTemplate().getSessionFactory().createEntityManager();
			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<Module> q = builder.createQuery(Module.class);
			Root<Module> root = q.from(Module.class);
			q.select(root);
			q.orderBy(builder.asc(root.get("name")));

			return em.createQuery(q).getResultList();
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

}
