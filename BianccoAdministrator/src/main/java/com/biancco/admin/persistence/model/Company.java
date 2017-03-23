/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents an Company
 * @author SOSExcellence.
 *
 */
@Entity
@Table(name = "company")
public class Company {
	/**
	 * Identifier.
	 */
	@Id
	@Column(name = "id_company")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCompany;
	/**
	 * Enterpice name.
	 */
	@Column(name = "name")
	private String name;
	/**
	 * Enterpice logo.
	 */
	@Column(name = "logo")
	private String logo;
	/**
	 * Works related to the enteprice.
	 */
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private List<WorkCompany> works;
	/**
	 * The representantes list.
	 */
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private List<Representative> representatives;
	/**
	 * Empty constructor. 
	 */
	public Company() {
	}
	/**
	 * @return the idCompany
	 */
	public long getIdCompany() {
		return idCompany;
	}

	/**
	 * @param idCompany the idCompany to set
	 */
	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
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
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the representatives
	 */
	public List<Representative> getRepresentatives() {
		return representatives;
	}

	/**
	 * @param representatives the representatives to set
	 */
	public void setRepresentatives(List<Representative> representatives) {
		this.representatives = representatives;
	}
	/**
	 * @return the works
	 */
	public List<WorkCompany> getWorks() {
		return works;
	}
	/**
	 * @param works the works to set
	 */
	public void setWorks(List<WorkCompany> works) {
		this.works = works;
	}
}
