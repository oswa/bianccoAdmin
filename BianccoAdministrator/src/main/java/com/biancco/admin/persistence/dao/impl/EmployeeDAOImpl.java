/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.model.Employee;

/**
 * Employee DAO implementation.
 * 
 * @author SOSExcellence.
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	/**
	 * Entity Maneger.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Employee getByNick(String nick) throws DBException {
		// TODO ED: Implments
		return new Employee();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Employee save(Employee employee) throws DBException {
		try {
			this.entityManager.persist(employee);
			this.entityManager.flush();
			return employee;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws DBException
	 */
	@Override
	@Transactional
	public void delete(Employee employee) throws DBException {
		try {
			this.entityManager.remove(employee);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void update(Employee employee) throws DBException {
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
	public Employee getById(long identifier) throws DBException {
		try {
			return this.entityManager.find(Employee.class, identifier);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public Employee validateCredentials(String nick, String pass) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Employee> q = builder.createQuery(Employee.class);
			Root<Employee> root = q.from(Employee.class);
			q.select(root);
			q.where(builder.equal(root.get("nick"), nick), builder.equal(root.get("password"), pass));

			return this.entityManager.createQuery(q).getSingleResult();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}
}
