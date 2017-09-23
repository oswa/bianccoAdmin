/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.service;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.company.CompanySimpleRecord;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.model.view.CompanyModuleView;
import com.biancco.admin.persistence.model.Company;

/**
 * Define the services of the Company.
 * @author SOSExcellence.
 */
public interface CompanyService {
	/**
	 * Gets a company.
	 * 
	 * @param session
	 *            HTTP sesiion.
	 * @param idCompany
	 *            Company identifier.
	 * @return View.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	CompanyModuleView getCompany(HttpSession session, long idCompany) throws DBException;

	/**
	 * Get companies related to the superintendente
	 * @param superintendenteId superintendente identifier 
	 * @throws DBException 
	 * 				When there is a problem in the database. 
	 */
	public List<CompanySimpleRecord> getCompanyBySuperintendente(long superintendenteId) throws DBException;
	/**
	 * Get companies related to the residente
	 * @param residenteId residente identifier
	 * @throws DBException 
	 * 				When there is a problem in the database. 
	 */
	public List<CompanySimpleRecord> getCompanyByResidente(long residenteId) throws DBException;
	/**
	 * Add a work to a company
	 * @param request the input
	 * @param idCompany the company Id
	 * @throws DBException 
	 * 				When there is a problem in the database. 
	 */
	public void addNewWork(final HttpServletRequest request, long idCompany) throws DBException;
	/**
	 * Gets the info needed of view to add company.
	 * 
	 * @param session
	 *            HTTP session.
	 * @return Info.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	CompanyModuleView getInfoToAdd(HttpSession session) throws DBException;
	/**
	 * Gets the company main view.
	 * 
	 * @param session
	 *            HTTP session.
	 * @return View.
	 * @exception DBException
	 *                If a db exception thrown.
	 */
	ModelAndView getMainView(HttpSession session) throws DBException;
	/**
	 * Saves a company.
	 * 
	 * @param companyEncoded
	 *            Company basic info.
	 * @return Company.
	 * @exception DBException
	 *                If a db exception thrown
	 */
	Company saveCompany(String companyEncoded) throws DBException;

	/**
	 * Updates a company.
	 * 
	 * @param company Info of company.
	 * @return Company.
	 * @exception DBException
	 *                If a db exception thrown
	 */
	Company updateCompany(Company company) throws DBException;

	/**
	 * Upload logo.
	 * 
	 * @param request
	 *            Multipart HTTP request.
	 * @param session
	 *            HTTP session.
	 * @return File meta list.
	 */
	LinkedList<FileMeta> saveAndUploadLogo(MultipartHttpServletRequest request, HttpSession session);
}
