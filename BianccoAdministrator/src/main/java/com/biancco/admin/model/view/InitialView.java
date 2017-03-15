/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Initial View.
 * 
 * @author SOSExcellence.
 */
public class InitialView {
	/**
	 * The menu.
	 */
	private List<OptionMenu> menu;
	/**
	 * The name.
	 */
	private String name;
	/**
	 * The config option flag.
	 */
	private boolean configOption = false;

	/**
	 * @return the menu.
	 */
	public List<OptionMenu> getMenu() {
		return menu;
	}

	/**
	 * @param menu
	 *            the menu to set.
	 */
	public void setMenu(List<OptionMenu> menu) {
		this.menu = menu;
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
	 * @param option
	 *            The option to add.
	 */
	public void addOption(OptionMenu option) {
		if (this.menu == null) {
			this.menu = new ArrayList<OptionMenu>();
		}
		this.menu.add(option);
	}

	/**
	 * @return the configOption.
	 */
	public boolean isConfigOption() {
		return configOption;
	}

	/**
	 * @param configOption the configOption to set.
	 */
	public void setConfigOption(boolean configOption) {
		this.configOption = configOption;
	}
}
