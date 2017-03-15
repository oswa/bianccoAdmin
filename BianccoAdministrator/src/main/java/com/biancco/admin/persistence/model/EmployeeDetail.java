/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.sql.Timestamp;
import java.util.Date;

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
 * Employee.
 * 
 * @author SOSExcellence.
 *
 */
@Entity
@Table(name = "employee_detail")
public class EmployeeDetail {
	/**
	 * Identifier of employee.
	 */
	@Id
	@Column(name = "id_employee_detail")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmployeeDetail;
	/**
	 * Identifier of employee.
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_employee")
	private Employee employee;
	/**
	 * First Name.
	 */
	@Column(name = "name")
	private String name;
	/**
	 * Last Name.
	 */
	@Column(name = "last_name")
	private String lastName;
	/**
	 * Address of the eployee.
	 */
	@Column(name = "address")
	private String address;
	/**
	 * The phone number.
	 */
	@Column(name = "phone")
	private String phone;
	/**
	 * The email.
	 */
	@Column(name = "mail")
	private String mail;
	/**
	 * The RFC.
	 */
	@Column(name = "rfc")
	private String rfc;
	/**
	 * The curp of the employee.
	 */
	@Column(name = "curp")
	private String curp;
	/**
	 * The cedula.
	 */
	@Column(name = "cedula")
	private String cedula;
	/**
	 * The UFE number.
	 */
	@Column(name = "ife")
	private String ife;
	/**
	 * The birthdate.
	 */
	@Column(name = "date_born")
	private Timestamp date_born;
	/**
	 * The date of the superintendente.
	 */
	@Column(name = "date_superintendente")
	private Timestamp date_superintendente;
	/**
	 * The date of unit price.
	 */
	@Column(name = "date_precio_unitario")
	private Timestamp date_precio_unitario;
	/**
	 * The date of register sign.
	 */
	@Column(name = "date_firma_registro")
	private Timestamp date_firma_registro;
	/**
	 * The date of vigency sign
	 */
	@Column(name = "date_firma_vigencia")
	private Timestamp date_firma_vigencia;

	/**
	 * @return the idEmployeeDetail.
	 */
	public Long getIdEmployeeDetail() {
		return idEmployeeDetail;
	}

	/**
	 * @param idEmployeeDetail
	 *            the idEmployeeDetail to set.
	 */
	public void setIdEmployeeDetail(Long idEmployeeDetail) {
		this.idEmployeeDetail = idEmployeeDetail;
	}

	/**
	 * @return the idEmployee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param idEmployee
	 *            the idEmployee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc
	 *            the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp
	 *            the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * @param cedula
	 *            the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * @return the ife
	 */
	public String getIfe() {
		return ife;
	}

	/**
	 * @param ife
	 *            the ife to set
	 */
	public void setIfe(String ife) {
		this.ife = ife;
	}

	/**
	 * @return the date_superintendente
	 */
	public Date getDate_superintendente() {
		return date_superintendente;
	}

	/**
	 * @param date_superintendente
	 *            the date_superintendente to set
	 */
	public void setDate_superintendente(Timestamp date_superintendente) {
		this.date_superintendente = date_superintendente;
	}

	/**
	 * @return the date_precio_unitario
	 */
	public Date getDate_precio_unitario() {
		return date_precio_unitario;
	}

	/**
	 * @param date_precio_unitario
	 *            the date_precio_unitario to set
	 */
	public void setDate_precio_unitario(Timestamp date_precio_unitario) {
		this.date_precio_unitario = date_precio_unitario;
	}

	/**
	 * @return the date_firma_registro
	 */
	public Date getDate_firma_registro() {
		return date_firma_registro;
	}

	/**
	 * @param date_firma_registro
	 *            the date_firma_registro to set
	 */
	public void setDate_firma_registro(Timestamp date_firma_registro) {
		this.date_firma_registro = date_firma_registro;
	}

	/**
	 * @return the date_firma_vigencia
	 */
	public Date getDate_firma_vigencia() {
		return date_firma_vigencia;
	}

	/**
	 * @param date_firma_vigencia
	 *            the date_firma_vigencia to set
	 */
	public void setDate_firma_vigencia(Timestamp date_firma_vigencia) {
		this.date_firma_vigencia = date_firma_vigencia;
	}

	/**
	 * @return the date_born.
	 */
	public Date getDate_born() {
		return date_born;
	}

	/**
	 * @param date_born
	 *            the date_born to set.
	 */
	public void setDate_born(Timestamp date_born) {
		this.date_born = date_born;
	}
}
