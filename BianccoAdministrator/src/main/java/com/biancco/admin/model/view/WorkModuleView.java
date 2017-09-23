/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import java.util.List;

import com.biancco.admin.model.employee.EmployeeSimpleRecord;
import com.biancco.admin.persistence.model.Company;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.persistence.model.WorkCompany;

/**
 * Initial information for module views.
 * 
 * @author SOSExcellence.
 */
public class WorkModuleView {
	// /**
	// * Work list.
	// */
	// private List<WorkSimpleRecord> works;
	/**
	 * Permission type.
	 */
	private PermissionType pType;
	/**
	 * Permission type.
	 */
	private Company company;
	/**
	 * Work.
	 */
	private WorkCompany work;
	/**
	 * Residente list.
	 */
	private List<EmployeeSimpleRecord> residentes;
	/**
	 * Superintendente list.
	 */
	private List<EmployeeSimpleRecord> supers;

	/**
	 * @return the pType.
	 */
	public PermissionType getpType() {
		return pType;
	}

	/**
	 * @param pType
	 *            the pType to set.
	 */
	public void setpType(PermissionType pType) {
		this.pType = pType;
	}

	/**
	 * @return the work
	 */
	public WorkCompany getWork() {
		return work;
	}

	/**
	 * @param work
	 *            the work to set
	 */
	public void setWork(WorkCompany work) {
		this.work = work;
	}

	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}

	/**
	 * @param company
	 *            the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}

	/**
	 * @return the residentes.
	 */
	public List<EmployeeSimpleRecord> getResidentes() {
		return residentes;
	}

	/**
	 * @param residentes
	 *            the residentes to set.
	 */
	public void setResidentes(List<EmployeeSimpleRecord> residentes) {
		this.residentes = residentes;
	}

	/**
	 * @return the supers.
	 */
	public List<EmployeeSimpleRecord> getSupers() {
		return supers;
	}

	/**
	 * @param supers
	 *            the supers to set.
	 */
	public void setSupers(List<EmployeeSimpleRecord> supers) {
		this.supers = supers;
	}

}
