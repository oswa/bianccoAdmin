/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Company Power.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "power")
public class Power {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_power")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPower;
	/**
	 * The company.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_company")
	private Company company;
	/**
	 * The name of the person with power.
	 */
	@Column(name = "power")
	private String power;
	/**
	 * The notary name.
	 */
	@Column(name = "notary")
	private String notary;
	/**
	 * The disctrict of the notary.
	 */
	@Column(name = "district")
	private String district;
	/**
	 * The notary num.
	 */
	@Column(name = "notarynum")
	private String notaryNum;
	/**
	 * @return the idPower
	 */
	public Long getIdPower() {
		return idPower;
	}
	/**
	 * @param idPower the idPower to set
	 */
	public void setIdPower(Long idPower) {
		this.idPower = idPower;
	}
	/**
	 * @return the power
	 */
	public String getPower() {
		return power;
	}
	/**
	 * @param power the power to set
	 */
	public void setPower(String power) {
		this.power = power;
	}
	/**
	 * @return the notary
	 */
	public String getNotary() {
		return notary;
	}
	/**
	 * @param notary the notary to set
	 */
	public void setNotary(String notary) {
		this.notary = notary;
	}
	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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
	/**
	 * @return the notaryNum
	 */
	public String getNotaryNum() {
		return notaryNum;
	}
	/**
	 * @param notaryNum the notaryNum to set
	 */
	public void setNotaryNum(String notaryNum) {
		this.notaryNum = notaryNum;
	}
}
