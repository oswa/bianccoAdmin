/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

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
 * @author SOSExcellence.
 * Represents a company representative.
 *
 */
@Entity
@Table(name = "representative")
public class Representative {
	/**
	 * the representative id.
	 */
	@Id
	@Column(name = "id_representative")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRepresentative;
	/**
	 * Identifier of company.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company", nullable = false)
	private Company company;
	/**
	 * The representative name.
	 */
	@Column(name = "name")
	private String name;
	/**
	 * The empty constructor. 
	 */
	public Representative() {
	}
	/**
	 * @return the idRepresentative
	 */
	public long getIdRepresentative() {
		return idRepresentative;
	}
	/**
	 * @param idRepresentative the idRepresentative to set
	 */
	public void setIdRepresentative(long idRepresentative) {
		this.idRepresentative = idRepresentative;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
