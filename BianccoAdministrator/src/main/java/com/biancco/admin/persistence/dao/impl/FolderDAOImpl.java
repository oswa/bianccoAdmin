/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FolderDocument;
import com.biancco.admin.persistence.dao.FolderDAO;
import com.biancco.admin.persistence.model.Document;
import com.biancco.admin.persistence.model.FolderBase;
import com.biancco.admin.persistence.model.FolderType;

/**
 * @author SOSExcellence.
 *
 */
public class FolderDAOImpl implements FolderDAO {
	/**
	 * Entity Manager.
	 */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public FolderBase getById(Long idFolder) throws DBException {
		try {
			return this.entityManager.find(FolderBase.class, idFolder);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public FolderBase save(FolderBase folder) throws DBException {
		try {
			this.entityManager.persist(folder);
			this.entityManager.flush();
			return folder;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(long idFolder) throws DBException {
		try {
			FolderBase f = this.entityManager.getReference(FolderBase.class, idFolder);
			this.entityManager.remove(f);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public FolderBase update(FolderBase folder) throws DBException {
		try {
			return entityManager.merge(folder);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<FolderBase> getFoldersByType(FolderType folderType) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<FolderBase> q = builder.createQuery(FolderBase.class);
			Root<FolderBase> root = q.from(FolderBase.class);
			q.select(root);
			q.where(builder.equal(root.get("type"), folderType));
			q.orderBy(builder.asc(root.get("pathChild")));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<FolderBase> getFolderBaseByType(FolderType folderType) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<FolderBase> q = builder.createQuery(FolderBase.class);
			Root<FolderBase> root = q.from(FolderBase.class);
			q.select(root);
			q.where(builder.equal(root.get("type"), folderType));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<FolderDocument> getFolderDocumentsByType(FolderType folderType, long idModule) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<FolderDocument> q = builder.createQuery(FolderDocument.class);
			// root
			Root<FolderBase> root = q.from(FolderBase.class);
			// join
			Join<FolderBase, Document> joinDoc = root.join("documents", JoinType.LEFT);
			joinDoc.on(builder.equal(joinDoc.get("ownerModuleId"), idModule));
			// selection
			Path<Long> pFolderId = root.get("idFolder");
			Path<Long> pFolderParent = root.get("parent");
			Path<FolderType> pFoldertype = root.get("type");
			Path<String> pFolderPathRoot = root.get("pathRoot");
			Path<String> pFolderPathChild = root.get("pathChild");
			Path<Boolean> pFolderAllowModify = root.get("allowModify");
			Path<String> pFolderPatterns = root.get("patterns");
			Path<Long> pDocId = joinDoc.get("idDocument");
			Path<Long> pDocOwnerId = joinDoc.get("ownerModuleId");
			Path<String> pDocName = joinDoc.get("name");
			Path<String> pDocVersion = joinDoc.get("version");
			Path<Calendar> pDocCreationDate = joinDoc.get("creationDate");
			Path<Calendar> pDocModifyDate = joinDoc.get("modifyDate");
			Path<Calendar> pDocLastModifyDate = joinDoc.get("lastModifyDate");
			Path<Boolean> pDocLocked = joinDoc.get("locked");

			q.select(builder.construct(FolderDocument.class, pFolderId, pFolderParent, pFoldertype, pFolderPathRoot,
					pFolderPathChild, pFolderAllowModify, pFolderPatterns, pDocId, pDocOwnerId, pDocName, pDocVersion,
					pDocCreationDate, pDocModifyDate, pDocLastModifyDate, pDocLocked));

			// condition
			Predicate pType = builder.equal(root.get("type"), folderType);
			// Predicate pDoc = builder.equal(joinDoc.get("ownerModuleId"),
			// idModule);
			q.where(builder.and(pType));
			// order
			q.orderBy(builder.asc(root.get("idFolder")));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}
}
