/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.model.Company;

/**
 * Define the services of the Company.
 * @author SOSExcellence.
 */
public interface CompanyService {
	/**
	 * Get all companies registered
	 * @throws DBException 
	 * 				When there is a problem in the database. 
	 */
	public List<Company> getAllCompanies() throws DBException;
	/**
	 * Delete an Company
	 */
	public Company getCompanyById(long idCompany);
	/**
	 * Register a new Company
	 * @param request the input
	 * @param logo the logo image
	 * @throws DBException
	 * 				When there is a problem in the database. 
	 */
	public void createNewCompany(final HttpServletRequest request, MultipartFile logo) throws DBException;
	/**
	 * Add a work to a company
	 * @param request the input
	 * @param idCompany the company Id
	 * @throws DBException 
	 * 				When there is a problem in the database. 
	 */
	public void addNewWork(final HttpServletRequest request, long idCompany) throws DBException;
	/**
	 * Delete an Company
	 */
	public void deleteCompany();
}
