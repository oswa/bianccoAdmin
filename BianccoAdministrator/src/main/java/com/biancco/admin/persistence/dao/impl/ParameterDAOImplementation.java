/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.ParameterDAO;
import com.biancco.admin.persistence.model.Parameter;

/**
 *
 * @author SOSExcellence.
 */
public class ParameterDAOImplementation extends HibernateDaoSupport implements ParameterDAO {

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Parameter> getParameters() throws DBException {
		try {
			Criteria criteria = getHibernateTemplate().getSessionFactory().getCurrentSession()
					.createCriteria(Parameter.class).addOrder(Order.asc("group")).addOrder(Order.asc("name"));
			return (List<Parameter>) criteria.list();
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

}
