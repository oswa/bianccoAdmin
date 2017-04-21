/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Folder base.
 * 
 * @author SOSExcellence.
 */
@Entity
@Table(name = "folder_base")
public class FolderBase {
	/**
	 * The identifier.
	 */
	@Id
	@Column(name = "id_folder_base")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFolder;
	/**
	 * Parent folder.
	 */
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "id_folder_parent")
	@Column(name = "id_folder_parent")
	private Long parent;
	/**
	 * Type.
	 */
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private FolderType type;
	/**
	 * Path root.
	 */
	@Column(name = "path_root")
	private String pathRoot;
	/**
	 * Path child.
	 */
	@Column(name = "path_child")
	private String pathChild;
	/**
	 * Allow modify flag.
	 */
	@Column(name = "allow_modify")
	@Convert(converter = BooleanYNConverter.class)
	private Boolean allowModify = false;
	/**
	 * Patterns.
	 */
	@Column(name = "patterns")
	private String patterns;
	/**
	 * Folder childs.
	 */
	// @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	// private List<FolderBase> childs;
	/**
	 * Documents.
	 */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "folder")
	private List<Document> documents;

	/**
	 * @return the idFolder.
	 */
	public Long getIdFolder() {
		return idFolder;
	}

	/**
	 * @param idFolder
	 *            the idFolder to set.
	 */
	public void setIdFolder(Long idFolder) {
		this.idFolder = idFolder;
	}

	/**
	 * @return the type.
	 */
	public FolderType getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set.
	 */
	public void setType(FolderType type) {
		this.type = type;
	}

	/**
	 * @return the pathRoot.
	 */
	public String getPathRoot() {
		return pathRoot;
	}

	/**
	 * @param pathRoot
	 *            the pathRoot to set.
	 */
	public void setPathRoot(String pathRoot) {
		this.pathRoot = pathRoot;
	}

	/**
	 * @return the pathChild.
	 */
	public String getPathChild() {
		return pathChild;
	}

	/**
	 * @param pathChild
	 *            the pathChild to set.
	 */
	public void setPathChild(String pathChild) {
		this.pathChild = pathChild;
	}

	/**
	 * @return the allowModify.
	 */
	public Boolean getAllowModify() {
		return allowModify;
	}

	/**
	 * @param allowModify
	 *            the allowModify to set.
	 */
	public void setAllowModify(Boolean allowModify) {
		this.allowModify = allowModify;
	}

	/**
	 * @return the patterns.
	 */
	public String getPatterns() {
		return patterns;
	}

	/**
	 * @param patterns
	 *            the patterns to set.
	 */
	public void setPatterns(String patterns) {
		this.patterns = patterns;
	}

	/**
	 * @return the parent.
	 */
	public Long getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set.
	 */
	public void setParent(Long parent) {
		this.parent = parent;
	}

	/**
	 * @return the documents.
	 */
	public List<Document> getDocuments() {
		return documents;
	}

	/**
	 * @param documents
	 *            the documents to set.
	 */
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	/**
	 * @return the parent.
	 * 
	 *         public FolderBase getParent() { return parent; }
	 */

	/**
	 * @param parent
	 *            the parent to set.
	 * 
	 *            public void setParent(FolderBase parent) { this.parent =
	 *            parent; }
	 */

	/**
	 * @return the childs.
	 * 
	 *         public List<FolderBase> getChilds() { return childs; }
	 */

	/**
	 * @param childs
	 *            the childs to set.
	 * 
	 *            public void setChilds(List<FolderBase> childs) { this.childs =
	 *            childs; }
	 */
}
