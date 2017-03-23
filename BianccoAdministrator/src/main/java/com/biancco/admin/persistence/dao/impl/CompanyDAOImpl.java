/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.CompanyDAO;
import com.biancco.admin.persistence.model.Company;

/**
 * @author SOSExcellence.
 *
 */
@Repository("companyDao")
public class CompanyDAOImpl implements CompanyDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Company> getAllCompanies() throws DBException {
		try {
			return new ArrayList<Company>();
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Company getCompanyById(long idCompany) throws DBException {
		try {
			return new Company();
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Serializable insertCompany(Company company) throws DBException {
		try {
			return null;
		} catch (HibernateException e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteCompany(Company company) {
		// TODO Ed: Delete into the database
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateCompany(Company company) {
		// TODO Ed: Update into the database
		return true;
	}

}
