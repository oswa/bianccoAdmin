/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.AuthenticationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BeanUtils;
import com.biancco.admin.model.employee.EmployeeSimpleRecord;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.model.Employee;
import com.biancco.admin.persistence.model.EmployeeDetail;
import com.biancco.admin.persistence.model.Role;

/**
 * Employee DAO implementation.
 * 
 * @author SOSExcellence.
 *
 */
public class EmployeeDAOImpl implements EmployeeDAO {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
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
			this.logger.error("Error on poersist employee", e);
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
	public void delete(long idEmployee) throws DBException {
		try {
			Employee e = this.entityManager.getReference(Employee.class, idEmployee);
			this.entityManager.remove(e);
		} catch (Exception e) {
			this.logger.error("Error on delete employee", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Employee update(Employee employee) throws DBException {
		try {
			return entityManager.merge(employee);
		} catch (Exception e) {
			this.logger.error("Error on update employee", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee update(long idEmployee, Map<String, String> properties) throws DBException {
		try {
			Employee e = this.entityManager.find(Employee.class, idEmployee);
			BeanUtils.setPropertiesToObject(e, properties);
			return e;
		} catch (Exception e) {
			this.logger.error("Error on update employee", e);
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
			this.logger.error("Error on get employee by id", e);
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
			this.logger.error("Error on validate employee credentials", e);
			throw new AuthenticationException("Usuario/Contraseña incorrecto.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<EmployeeSimpleRecord> getAll() throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<EmployeeSimpleRecord> criteria = builder.createQuery(EmployeeSimpleRecord.class);

			Root<Employee> e = criteria.from(Employee.class);
			// join table(s)
			Join<Employee, EmployeeDetail> joinDetail = e.join("employeeDetail", JoinType.LEFT);
			Join<Employee, Role> joinRole = e.join("role", JoinType.LEFT);
			// selection
			Path<Long> pathId = e.get("idEmployee");
			Path<String> pathName = joinDetail.get("name");
			Path<String> pathLastName = joinDetail.get("lastName");
			Path<String> pathNick = e.get("nick");
			Path<String> pathRole = joinRole.get("name");
			Path<Boolean> pathEnable = e.get("enable");

			criteria.select(builder.construct(EmployeeSimpleRecord.class, pathId, pathName, pathLastName, pathNick,
					pathRole, pathEnable));
			// conditions
			// Predicate pEnabled = builder.equal(e.get("enable"), true);
			// criteria.where(pEnabled);

			return this.entityManager.createQuery(criteria).getResultList();
		} catch (Exception e) {
			this.logger.error("Error on get all employees", e);
			throw new DBException(e);
		}
	}
}
