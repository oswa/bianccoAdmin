/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Module.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "module")
public class Module {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_module")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idModule;
	/**
	 * The name.
	 */
	@Column(name = "module")
	private String name;
	/**
	 * The description.
	 */
	@Column(name = "description")
	private String description;
	/**
	 * Enable flag.
	 */
	@Column(name = "enable")
	@Convert(converter = BooleanYNConverter.class)
	private Boolean enable = false;

	/**
	 * @return the idModule.
	 */
	public Long getIdModule() {
		return idModule;
	}

	/**
	 * @param idModule
	 *            the idModule to set.
	 */
	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}

	/**
	 * @return the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
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