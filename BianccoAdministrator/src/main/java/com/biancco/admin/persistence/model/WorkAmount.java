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
@Table(name = "work_amount")
public class WorkAmount {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_work_amount")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idWorkAmount;
	/**
	 * The work.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_work_company")
	private WorkCompany workCompany;
	/**
	 * The budget amount of the work.
	 */
	@Column(name = "budget")
	private double budget;
	/**
	 * The direct cost amount.
	 */
	@Column(name = "direct_cost")
	private double directCost;
	/**
	 * The workforce amount.
	 */
	@Column(name = "workforce")
	private double workforce;
	/**
	 * The material amount.
	 */
	@Column(name = "material")
	private double material;
	/**
	 * The equipment tools amount.
	 */
	@Column(name = "equipment_tools")
	private double equipmentTools;
	/**
	 * @return the idWorkAmount
	 */
	public Long getIdWorkAmount() {
		return idWorkAmount;
	}
	/**
	 * @param idWorkAmount the idWorkAmount to set
	 */
	public void setIdWorkAmount(Long idWorkAmount) {
		this.idWorkAmount = idWorkAmount;
	}
	/**
	 * @return the workCompany
	 */
	public WorkCompany getWorkCompany() {
		return workCompany;
	}
	/**
	 * @param workCompany the workCompany to set
	 */
	public void setWorkCompany(WorkCompany workCompany) {
		this.workCompany = workCompany;
	}
	/**
	 * @return the budget
	 */
	public double getBudget() {
		return budget;
	}
	/**
	 * @param budget the budget to set
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}
	/**
	 * @return the directCost
	 */
	public double getDirectCost() {
		return directCost;
	}
	/**
	 * @param directCost the directCost to set
	 */
	public void setDirectCost(double directCost) {
		this.directCost = directCost;
	}
	/**
	 * @return the workforce
	 */
	public double getWorkforce() {
		return workforce;
	}
	/**
	 * @param workforce the workforce to set
	 */
	public void setWorkforce(double workforce) {
		this.workforce = workforce;
	}
	/**
	 * @return the material
	 */
	public double getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(double material) {
		this.material = material;
	}
	/**
	 * @return the equipmentTools
	 */
	public double getEquipmentTools() {
		return equipmentTools;
	}
	/**
	 * @param equipmentTools the equipmentTools to set
	 */
	public void setEquipmentTools(double equipmentTools) {
		this.equipmentTools = equipmentTools;
	}
}
