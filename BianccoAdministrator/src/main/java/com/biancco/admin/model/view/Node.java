/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.model.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Node (Folder).
 * 
 * @author SOSExcellence.
 */
public class Node {
	/**
	 * Parent folder name.
	 */
	private String text;
	/**
	 * Icon.
	 */
	private String icon;
	/**
	 * Selected icon.
	 */
	private String selectedIcon;
	/**
	 * Href.
	 */
	private String href;
	/**
	 * Tags.
	 */
	private Integer[] tags;
	/**
	 * Node list.
	 */
	private List<Node> nodes;

	/**
	 * @return the text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set.
	 */
	public void setText(String text) {
		this.text = text;
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
	 * @return the selectedIcon.
	 */
	public String getSelectedIcon() {
		return selectedIcon;
	}

	/**
	 * @param selectedIcon
	 *            the selectedIcon to set.
	 */
	public void setSelectedIcon(String selectedIcon) {
		this.selectedIcon = selectedIcon;
	}

	/**
	 * @return the href.
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href
	 *            the href to set.
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the tags.
	 */
	public Integer[] getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set.
	 */
	public void setTags(Integer[] tags) {
		this.tags = tags;
	}

	/**
	 * @return the nodes.
	 */
	public List<Node> getNodes() {
		return nodes;
	}

	/**
	 * @param nodes
	 *            the nodes to set.
	 */
	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	/**
	 * Add node to nodes.
	 * 
	 * @param node
	 *            Node to add.
	 */
	public void addNode(Node node) {
		if (this.nodes == null) {
			this.nodes = new ArrayList<Node>();
		}
		this.nodes.add(node);
	}
}
