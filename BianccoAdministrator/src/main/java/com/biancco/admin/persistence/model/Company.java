/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents an Company
 * 
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
	private Long idCompany;
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
	 * The representante legal.
	 */
	@Column(name = "representante")
	private String representante;
	/**
	 * Enable flag.
	 */
	@Column(name = "enable")
	@Convert(converter = BooleanYNConverter.class)
	private Boolean enable = false;
	/**
	 * The power.
	 */
	@OneToOne(mappedBy = "company", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Power power;
	/**
	 * Works related to the enteprice.
	 */
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private List<WorkCompany> works;

	/**
	 * Empty constructor.
	 */
	public Company() {
	}

	/**
	 * @return the idCompany
	 */
	public Long getIdCompany() {
		return idCompany;
	}

	/**
	 * @param idCompany
	 *            the idCompany to set
	 */
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
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
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo
	 *            the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the works
	 */
	public List<WorkCompany> getWorks() {
		return works;
	}

	/**
	 * @param works
	 *            the works to set
	 */
	public void setWorks(List<WorkCompany> works) {
		this.works = works;
	}

	/**
	 * @return the representante
	 */
	public String getRepresentante() {
		return representante;
	}

	/**
	 * @param representante
	 *            the representante to set
	 */
	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	/**
	 * @return the power
	 */
	public Power getPower() {
		return power;
	}

	/**
	 * @param power
	 *            the power to set
	 */
	public void setPower(Power power) {
		this.power = power;
	}

	/**
	 * @return the enable.
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *            the enable to set.
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
