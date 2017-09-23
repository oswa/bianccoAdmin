/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.biancco.admin.app.util.DateUtils;

/**
 * Entity that represents a Work
 * 
 * @author SOSExcellence.
 *
 */
@Entity
@Table(name = "work_company")
public class WorkCompany {
	/**
	 * The work identifier.
	 */
	@Id
	@Column(name = "id_work_company")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idWork;
	/**
	 * Identifier of company.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company", nullable = false)
	private Company company;
	/**
	 * The power.
	 */
	@OneToOne(mappedBy = "workCompany", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private WorkAmount workAmount;
	/**
	 * The work name.
	 */
	@Column(name = "name")
	private String name;
	/**
	 * Work date.
	 */
	@Column(name = "work_date")
	@Temporal(TemporalType.DATE)
	private Calendar workDate;
	/**
	 * Work date with format (yyyy-mm-dd).
	 */
	@Transient
	private String workDateWithFormat;
	/**
	 * Contract num.
	 */
	@Column(name = "contract_num")
	private Long contractNum;
	/**
	 * The location.
	 */
	@Column(name = "location")
	private String location;
	/**
	 * The location map.
	 */
	@Column(name = "location_map")
	private String locationMap;
	/**
	 * Residente.
	 */
	@Column(name = "residente")
	private Long residente;
	/**
	 * Super-intendente.
	 */
	@Column(name = "superintendente")
	private Long superintendente;
	/**
	 * Supervisor.
	 */
	@Column(name = "supervisor")
	private String supervisor;

	/**
	 * @return the idWork
	 */
	public Long getIdWork() {
		return idWork;
	}

	/**
	 * @param idWork
	 *            the idWork to set
	 */
	public void setIdWork(Long idWork) {
		this.idWork = idWork;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the workDate
	 */
	public Calendar getWorkDate() {
		return workDate;
	}

	/**
	 * @param workDate
	 *            the workDate to set
	 */
	public void setWorkDate(Calendar workDate) {
		this.workDate = workDate;
	}

	/**
	 * @return the contractNum
	 */
	public Long getContractNum() {
		return contractNum;
	}

	/**
	 * @param contractNum
	 *            the contractNum to set
	 */
	public void setContractNum(Long contractNum) {
		this.contractNum = contractNum;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the locationMap
	 */
	public String getLocationMap() {
		return locationMap;
	}

	/**
	 * @param locationMap
	 *            the locationMap to set
	 */
	public void setLocationMap(String locationMap) {
		this.locationMap = locationMap;
	}

	// /**
	// * @return the supervisor
	// */
	// public String getSupervisor() {
	// return supervisor;
	// }
	//
	// /**
	// * @param supervisor
	// * the supervisor to set
	// */
	// public void setSupervisor(String supervisor) {
	// this.supervisor = supervisor;
	// }
	//
	// /**
	// * @return the residente
	// */
	// public String getResidente() {
	// return residente;
	// }
	//
	// /**
	// * @param residente
	// * the residente to set
	// */
	// public void setResidente(String residente) {
	// this.residente = residente;
	// }
	//
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
	 * @return the workAmount
	 */
	public WorkAmount getWorkAmount() {
		return workAmount;
	}

	/**
	 * @param workAmount
	 *            the workAmount to set
	 */
	public void setWorkAmount(WorkAmount workAmount) {
		this.workAmount = workAmount;
	}

	/**
	 * @return the workDateWithFormat
	 */
	public String getWorkDateWithFormat() {
		this.workDateWithFormat = DateUtils.getDateWithFormat("yyyy-MM-dd", workDate.getTime());
		return workDateWithFormat;
	}

	/**
	 * @param workDateWithFormat
	 *            the workDateWithFormat to set
	 */
	public void setWorkDateWithFormat(String workDateWithFormat) {
		this.workDateWithFormat = workDateWithFormat;
	}

	/**
	 * @return the residente.
	 */
	public Long getResidente() {
		return residente;
	}

	/**
	 * @param residente
	 *            the residente to set.
	 */
	public void setResidente(Long residente) {
		this.residente = residente;
	}

	/**
	 * @return the superintendente.
	 */
	public Long getSuperintendente() {
		return superintendente;
	}

	/**
	 * @param superintendente
	 *            the superintendente to set.
	 */
	public void setSuperintendente(Long superintendente) {
		this.superintendente = superintendente;
	}

	/**
	 * @return the supervisor.
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * @param supervisor
	 *            the supervisor to set.
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
}