/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import java.util.List;

import com.biancco.admin.model.company.CompanySimpleRecord;
import com.biancco.admin.persistence.model.Company;
import com.biancco.admin.persistence.model.PermissionType;

/**
 * Initial information for company views.
 * 
 * @author SOSExcellence.
 */
public class CompanyModuleView {
	/**
	 * Employee list.
	 */
	private List<CompanySimpleRecord> companies;
	/**
	 * Permission type.
	 */
	private PermissionType pType;
	/**
	 * Company.
	 */
	private Company company;
	/**
	 * @return the companies
	 */
	public List<CompanySimpleRecord> getCompanies() {
		return companies;
	}
	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(List<CompanySimpleRecord> companies) {
		this.companies = companies;
	}
	/**
	 * @return the pType
	 */
	public PermissionType getpType() {
		return pType;
	}
	/**
	 * @param pType the pType to set
	 */
	public void setpType(PermissionType pType) {
		this.pType = pType;
	}
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

}
