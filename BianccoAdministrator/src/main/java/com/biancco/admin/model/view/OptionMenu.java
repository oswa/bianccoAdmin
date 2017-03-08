/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import com.biancco.admin.persistence.model.PermissionType;

/**
 *
 * @author SOSExcellence.
 */
public class OptionMenu {
	/**
	 * The option.
	 */
	private String option;
	/**
	 * The link.
	 */
	private String module;
	/**
	 * The icon.
	 */
	private String icon;
	/**
	 * The type.
	 */
	private PermissionType type;

	/**
	 * @return the option.
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option
	 *            the option to set.
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * @return the link.
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param link
	 *            the link to set.
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @return the icon.
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set.
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the type.
	 */
	public PermissionType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set.
	 */
	public void setType(PermissionType type) {
		this.type = type;
	}
}
