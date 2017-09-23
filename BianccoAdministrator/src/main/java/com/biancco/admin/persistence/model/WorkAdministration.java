/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author SOSExcellence.
 *
 *	Represents an work adminsitration.
 */
@Entity
@Table(name = "work_administration")
public class WorkAdministration {
	/**
	 * The id.
	 */
	@Id
	@Column(name = "id_work_administration")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idWorkAdministration;
	/**
	 * The contract id.
	 */
	@Column(name = "contract_id")
	private long contractId;
	/**
	 * The contact for the contract.
	 */
	@Column(name = "contract_contact")
	private String contractContact;
	/**
	 * The phone of the contact.
	 */
	@Column(name = "contract_contact_phone")
	private String contractContactPhone;
	/**
	 * The contract amount.
	 */
	@Column(name = "contract_amount")
	private double contractAmount;
	/**
	 * The contract type.
	 */
	@Column(name = "contract_type")
	private String contractType;
	/**
	 * The contract date.
	 */
	@Column(name = "contract_date")
	private Timestamp contractDate;
	/**
	 * The resident name.
	 */
	@Column(name = "residente")
	private String residente;
	/**
	 * The superintendente name.
	 */
	@Column(name = "superintendente")
	private String superintendente;
	/**
	 * The supervisor name.
	 */
	@Column(name = "supervisor")
	private String supervisor;
	/**
	 * The concurso number.
	 */
	@Column(name = "numero_concurso")
	private long numeroConcurso;
	/**
	 * The monto pago.
	 */
	@Column(name = "monto_pago")
	private double montoPago;
	/**
	 * The plazo ejecucion.
	 */
	@Column(name = "plazo_ejecucion")
	private int plazoEjecucion;
	/**
	 * the initieal date.
	 */
	@Column(name = "date_initial")
	private Timestamp dateInitial;
	/**
	 * The end date.
	 */
	@Column(name = "date_end")
	private Timestamp dateEnd;
	/**
	 * The estimation number.
	 */
	@Column(name = "estimacion_numero")
	private long estimacionNumero;
	/**
	 * The estimation amount.
	 */
	@Column(name = "estimacion_monto")
	private double estimacionMonto;
	/**
	 * @return the idWorkAdministration
	 */
	public long getIdWorkAdministration() {
		return idWorkAdministration;
	}
	/**
	 * @param idWorkAdministration the idWorkAdministration to set
	 */
	public void setIdWorkAdministration(long idWorkAdministration) {
		this.idWorkAdministration = idWorkAdministration;
	}
	/**
	 * @return the contractId
	 */
	public long getContractId() {
		return contractId;
	}
	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(long contractId) {
		this.contractId = contractId;
	}
	/**
	 * @return the contractContact
	 */
	public String getContractContact() {
		return contractContact;
	}
	/**
	 * @param contractContact the contractContact to set
	 */
	public void setContractContact(String contractContact) {
		this.contractContact = contractContact;
	}
	/**
	 * @return the contractContactPhone
	 */
	public String getContractContactPhone() {
		return contractContactPhone;
	}
	/**
	 * @param contractContactPhone the contractContactPhone to set
	 */
	public void setContractContactPhone(String contractContactPhone) {
		this.contractContactPhone = contractContactPhone;
	}
	/**
	 * @return the contractAmount
	 */
	public double getContractAmount() {
		return contractAmount;
	}
	/**
	 * @param contractAmount the contractAmount to set
	 */
	public void setContractAmount(double contractAmount) {
		this.contractAmount = contractAmount;
	}
	/**
	 * @return the contractType
	 */
	public String getContractType() {
		return contractType;
	}
	/**
	 * @param contractType the contractType to set
	 */
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	/**
	 * @return the contractDate
	 */
	public Timestamp getContractDate() {
		return contractDate;
	}
	/**
	 * @param contractDate the contractDate to set
	 */
	public void setContractDate(Timestamp contractDate) {
		this.contractDate = contractDate;
	}
	/**
	 * @return the residente
	 */
	public String getResidente() {
		return residente;
	}
	/**
	 * @param residente the residente to set
	 */
	public void setResidente(String residente) {
		this.residente = residente;
	}
	/**
	 * @return the superintendente
	 */
	public String getSuperintendente() {
		return superintendente;
	}
	/**
	 * @param superintendente the superintendente to set
	 */
	public void setSuperintendente(String superintendente) {
		this.superintendente = superintendente;
	}
	/**
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}
	/**
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	/**
	 * @return the numeroConcurso
	 */
	public long getNumeroConcurso() {
		return numeroConcurso;
	}
	/**
	 * @param numeroConcurso the numeroConcurso to set
	 */
	public void setNumeroConcurso(long numeroConcurso) {
		this.numeroConcurso = numeroConcurso;
	}
	/**
	 * @return the montoPago
	 */
	public double getMontoPago() {
		return montoPago;
	}
	/**
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(double montoPago) {
		this.montoPago = montoPago;
	}
	/**
	 * @return the plazoEjecucion
	 */
	public int getPlazoEjecucion() {
		return plazoEjecucion;
	}
	/**
	 * @param plazoEjecucion the plazoEjecucion to set
	 */
	public void setPlazoEjecucion(int plazoEjecucion) {
		this.plazoEjecucion = plazoEjecucion;
	}
	/**
	 * @return the dateInitial
	 */
	public Timestamp getDateInitial() {
		return dateInitial;
	}
	/**
	 * @param dateInitial the dateInitial to set
	 */
	public void setDateInitial(Timestamp dateInitial) {
		this.dateInitial = dateInitial;
	}
	/**
	 * @return the dateEnd
	 */
	public Timestamp getDateEnd() {
		return dateEnd;
	}
	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}
	/**
	 * @return the estimacionNumero
	 */
	public long getEstimacionNumero() {
		return estimacionNumero;
	}
	/**
	 * @param estimacionNumero the estimacionNumero to set
	 */
	public void setEstimacionNumero(long estimacionNumero) {
		this.estimacionNumero = estimacionNumero;
	}
	/**
	 * @return the estimacionMonto
	 */
	public double getEstimacionMonto() {
		return estimacionMonto;
	}
	/**
	 * @param estimacionMonto the estimacionMonto to set
	 */
	public void setEstimacionMonto(double estimacionMonto) {
		this.estimacionMonto = estimacionMonto;
	}
	
}
