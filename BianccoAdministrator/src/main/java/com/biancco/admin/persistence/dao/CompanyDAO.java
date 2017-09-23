/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.company.CompanySimpleRecord;
import com.biancco.admin.persistence.model.Company;

/**
 * Data Access manager for Company
 * @author SOSExcellence.
 *
 */
public interface CompanyDAO {
	/**
	 * Return a Company based on its id.
	 * 
	 * @param idCompany
	 *            the identifier.
	 * @return the Company object corresponding to the id.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Company getById(long idCompany) throws DBException;
	/**
	 * Insert a new company.
	 * @param company.
	 * @return the company registered.
	 * @throws DBException.
	 * 				When there is a problem in the database.
	 */
	public Company save( Company company ) throws DBException;
	/**
	 * Return all companies.
	 * @return list of companies.
	 * @throws DBException 
	 * 				When there is a problem in the database.
	 */
	public List<CompanySimpleRecord> getAll() throws DBException;
	/**
	 * Return a list of companies related to the superintendente.
	 * @param employeeId employee id.
	 * @return list of companies.
	 * @throws DBException 
	 * 				When there is a problem in the database.
	 */
	public List<CompanySimpleRecord> getCompanyBySuperintendente( long employeeId ) throws DBException;
	/**
	 * Return a list of companies related to the residente.
	 * @param employeeId employee id.
	 * @return list of companies.
	 * @throws DBException 
	 * 				When there is a problem in the database.
	 */
	public List<CompanySimpleRecord> getCompanyByResidente( long employeeId ) throws DBException;
	/**
	 * Update a Company in persistent data.
	 * 
	 * @param company
	 *            the element to update.
	 * @return Company updated.
	 * @throws DBException
	 *             If a problem occurs.
	 */
	Company update(Company company) throws DBException;
}
