/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.model.EmployeeDetail;

/**
 * Employee DAO implementation.
 * 
 * @author SOSExcellence.
 *
 */
public class EmployeeDAOImpl extends HibernateDaoSupport implements EmployeeDAO {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeeDetail getEmployeeById(long idEmployee) {
		// TODO ED: Implments
		return new EmployeeDetail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmployeeDetail getEmployeeByNick(String nick, String pass) {
		// TODO ED: Implments
		return new EmployeeDetail();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insertEmployee(EmployeeDetail Employee) {
		// TODO ED: Implments
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteEmployee(EmployeeDetail Employee) {
		// TODO ED: Implments
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateEmployee(EmployeeDetail Employee) {
		// TODO ED: Implments
		return false;
	}

}
