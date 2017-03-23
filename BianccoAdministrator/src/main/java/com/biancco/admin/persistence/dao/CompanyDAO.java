/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import java.io.Serializable;
import java.util.List;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.Company;

/**
 * Data Access manager for Company
 * @author SOSExcellence.
 *
 */
public interface CompanyDAO {
	/**
	 * Return a list of all companies registered
	 * @return
	 * @throws DBException 
	 * 				When there is a problem in the database
	 */
	public List<Company> getAllCompanies() throws DBException;
	/**
	 * Return an company based on its id
	 * @param idCompany the identitifier
	 * @return the company object corresponding to the id
	 * @throws DBException 
	 * 				When there is a problem in the database
	 */
	public Company getCompanyById( long idCompany ) throws DBException;
	/**
	 * Insert a new company
	 * @param company
	 * @return the id generated
	 * @throws DBException 
	 * 				When there is a problem in the database
	 */
	public Serializable insertCompany( Company company ) throws DBException;
	/**
	 * Delete an company from persistent data
	 * @param company the element to delete
	 * @return true id successful
	 */
	public boolean deleteCompany( Company company );
	/**
	 * Update an company in persisten data
	 * @param company the element to update
	 * @return true id successful
	 */
	public boolean updateCompany( Company company );
}
