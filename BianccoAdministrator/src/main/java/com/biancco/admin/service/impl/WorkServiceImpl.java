/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.model.employee.EmployeeSimpleRecord;
import com.biancco.admin.model.view.WorkModuleView;
import com.biancco.admin.persistence.dao.CompanyDAO;
import com.biancco.admin.persistence.dao.EmployeeDAO;
import com.biancco.admin.persistence.dao.WorkDAO;
import com.biancco.admin.persistence.model.Company;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.persistence.model.WorkAmount;
import com.biancco.admin.persistence.model.WorkCompany;
import com.biancco.admin.service.CommonService;
import com.biancco.admin.service.WorkService;

/**
 * Work service implementation.
 * 
 * @author SOSExcellence.
 */
public class WorkServiceImpl implements WorkService {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getRootLogger();
	/**
	 * Common service.
	 */
	@Autowired
	private CommonService commonService;
	/**
	 * WorkCompany DAO.
	 */
	@Autowired
	private WorkDAO workDAO;
	/**
	 * Company DAO.
	 */
	@Autowired
	private CompanyDAO companyDAO;
	/**
	 * Employee DAO.
	 */
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkModuleView getInfoToAdd(HttpSession session) throws DBException {
		WorkModuleView view = new WorkModuleView();
		view.setpType((PermissionType) session.getAttribute("work"));
		view.setCompany(this.companyDAO.getById((Long) session.getAttribute("idCompany")));
		// get employees (residente and superintendente)
		List<EmployeeSimpleRecord> employees = this.employeeDAO.getResidentesAndSuperintendentes();
		this.setResidentesAndSuperintendentes(view, employees);
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkModuleView getWork(HttpSession session, long idWork) throws DBException {
		WorkModuleView view = new WorkModuleView();
		WorkCompany work = this.workDAO.getWorkById(idWork);
		view.setCompany(this.companyDAO.getById((Long) session.getAttribute("idCompany")));
		view.setpType((PermissionType) session.getAttribute("work"));
		view.setWork(work);
		// get employees (residente and superintendente)
		List<EmployeeSimpleRecord> employees = this.employeeDAO.getResidentesAndSuperintendentes();
		this.setResidentesAndSuperintendentes(view, employees);
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView getMainView(HttpSession session) throws DBException {
		return this.commonService.getViewByModule("work", session);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkCompany saveWork(String workEncoded, long idCompany) throws DBException {
		// work info
		WorkCompany w = (WorkCompany) HTTPUtils.getObjectFromFormString(workEncoded, WorkCompany.class);
		Company com = new Company();
		com.setIdCompany(idCompany);
		w.setCompany(com);
		return this.workDAO.save(w);
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public WorkCompany updateWork(WorkCompany work) throws DBException {
		// get employee to update
		WorkCompany workInDb = this.workDAO.getWorkById(work.getIdWork());
		// set changes
		workInDb.setName(work.getName());
		try {
			Calendar c = Calendar.getInstance();
			c.setTime((new SimpleDateFormat("yyyy-MM-dd")).parse(work.getWorkDateWithFormat()));
			workInDb.setWorkDate(c);
		} catch (Exception e) {
			LOGGER.error("Error on set properties to object", e);
		}
		workInDb.setContractNum(work.getContractNum());
		workInDb.setLocation(work.getLocation());
		workInDb.setLocationMap(work.getLocationMap());
		if (workInDb.getWorkAmount() == null) {
			workInDb.setWorkAmount(new WorkAmount());
			workInDb.getWorkAmount().setWorkCompany(workInDb);
		}
		workInDb.getWorkAmount().setBudget(work.getWorkAmount().getBudget());
		workInDb.getWorkAmount().setDirectCost(work.getWorkAmount().getDirectCost());
		workInDb.getWorkAmount().setWorkforce(work.getWorkAmount().getWorkforce());
		workInDb.getWorkAmount().setMaterial(work.getWorkAmount().getMaterial());
		workInDb.getWorkAmount().setEquipmentTools(work.getWorkAmount().getEquipmentTools());
		// company relation
		Company com = new Company();
		com.setIdCompany(work.getCompany().getIdCompany());
		workInDb.setCompany(com);
		// update
		return this.workDAO.update(workInDb);
	}

	/**
	 * Set employees to view.
	 * 
	 * @param view
	 *            View.
	 * @param list
	 *            Employee list.
	 */
	private void setResidentesAndSuperintendentes(WorkModuleView view, List<EmployeeSimpleRecord> list) {
		List<EmployeeSimpleRecord> residentes = this.selectEmployeesByRole(list, "RESIDENTE DE OBRA");
		List<EmployeeSimpleRecord> supers = this.selectEmployeesByRole(list, "SUPER INTENDENTE REGIONAL");
		view.setResidentes(residentes);
		view.setSupers(supers);
	}

	/**
	 * Selects the items from employee list by role.
	 * 
	 * @param employees
	 *            Employee list.
	 * @param role
	 *            Role name.
	 * @return Selected items.
	 */
	@SuppressWarnings("unchecked")
	private List<EmployeeSimpleRecord> selectEmployeesByRole(List<EmployeeSimpleRecord> employees, final String role) {
		Predicate p = new Predicate() {

			@Override
			public boolean evaluate(final Object o) {
				EmployeeSimpleRecord e = (EmployeeSimpleRecord) o;
				return e.getRoleName().equals(role);
			}
		};
		return (List<EmployeeSimpleRecord>) CollectionUtils.select(employees, p);
	}
}
