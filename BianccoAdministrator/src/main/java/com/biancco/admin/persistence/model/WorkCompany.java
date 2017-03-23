/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private long idWork;
	/**
	 * Identifier of company.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company", nullable = false)
	private Company company;
	/**
	 * The work name.
	 */
	@Column(name = "name")
	private String name;
	/**
	 * Work date.
	 */
	@Column(name = "work_date")
	private Timestamp workDate;
	/**
	 * Contract num.
	 */
	@Column(name = "contract_num")
	private long contractNum;
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
	 * The supervisor.
	 */
	@Column(name = "supervisor")
	private String supervisor;
	/**
	 * The Resident.
	 */
	@Column(name = "residente")
	private String residente;

	/**
	 * Paths related to the work.
	 */
	// @OneToMany(mappedBy = "work_company", fetch = FetchType.LAZY)
	// private Set<Folder> folders;
	/**
	 * @return the idWork
	 */
	public long getIdWork() {
		return idWork;
	}

	/**
	 * @param idWork
	 *            the idWork to set
	 */
	public void setIdWork(long idWork) {
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
	public Timestamp getWorkDate() {
		return workDate;
	}

	/**
	 * @param workDate
	 *            the workDate to set
	 */
	public void setWorkDate(Timestamp workDate) {
		this.workDate = workDate;
	}

	/**
	 * @return the contractNum
	 */
	public long getContractNum() {
		return contractNum;
	}

	/**
	 * @param contractNum
	 *            the contractNum to set
	 */
	public void setContractNum(long contractNum) {
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

	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * @param supervisor
	 *            the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * @return the residente
	 */
	public String getResidente() {
		return residente;
	}

	/**
	 * @param residente
	 *            the residente to set
	 */
	public void setResidente(String residente) {
		this.residente = residente;
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
}