/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.employee;

/**
 * Basic record.
 * 
 * @author SOSExcellence.
 */
public class EmployeeBasicRecord {
	/**
	 * Identifier.
	 */
	private long id;
	/**
	 * Name.
	 */
	private String name;
	/**
	 * Last name.
	 */
	private String lastName;
	/**
	 * Nick.
	 */
	private String nick;
	/**
	 * Role name.
	 */
	private String roleName;
	/**
	 * Enable flag.
	 */
	private Boolean enable = false;

	/**
	 * Constructor.
	 * 
	 * @param id
	 *            Identifier.
	 * @param name
	 *            Name.
	 * @param lastName
	 *            Lastname.
	 * @param nick
	 *            Nick.
	 * @param roleName
	 *            Role name.
	 * @param enable
	 *            Enable flag.
	 */
	public EmployeeBasicRecord(long id, String name, String lastName, String nick, String roleName, Boolean enable) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.nick = nick;
		this.roleName = roleName;
		this.enable = enable;
	}

	/**
	 * @return the id.
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set.
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the nick.
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick
	 *            the nick to set.
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * @return the roleName.
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set.
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
