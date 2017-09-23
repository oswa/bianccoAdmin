/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.persistence.dao.DocumentDAO;
import com.biancco.admin.persistence.model.Document;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Document DAO implementation.
 * 
 * @author SOSExcellence.
 */
public class DocumentDAOImpl implements DocumentDAO {
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
	public Document getById(Long idDoc) throws DBException {
		try {
			return this.entityManager.find(Document.class, idDoc);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Document save(Document doc) throws DBException {
		try {
			this.entityManager.persist(doc);
			this.entityManager.flush();
			return doc;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveWithoutATransaction(Document doc) throws DBException {
		try {
			this.entityManager.persist(doc);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(long idDoc) throws DBException {
		try {
			Document d = this.entityManager.getReference(Document.class, idDoc);
			this.entityManager.remove(d);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Document update(Document doc) throws DBException {
		try {
			return entityManager.merge(doc);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Document> getByModule(long idModule, FolderType type) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Document> q = builder.createQuery(Document.class);
			Root<Document> root = q.from(Document.class);
			q.select(root);
			q.where(builder.equal(root.get("ownerModuleId"), idModule),
					builder.equal(root.get("ownerFolderType"), type));

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
	public FileMeta getFileFromDocument(long idDocument) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<FileMeta> criteria = builder.createQuery(FileMeta.class);
			Root<Document> root = criteria.from(Document.class);
			// selection
			Path<String> pathName = root.get("name");
			Path<String> pathDoc = root.get("path");
			Path<String> pathContent = root.get("contentType");
			criteria.select(builder.construct(FileMeta.class, pathName, pathDoc, pathContent));
			// conditions
			criteria.where(builder.equal(root.get("idDocument"), idDocument));

			return this.entityManager.createQuery(criteria).getSingleResult();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional()
	public List<Document> getByName(long ownerModuleId, FolderType fType, FileMeta fm) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<Document> criteria = builder.createQuery(Document.class);
			Root<Document> root = criteria.from(Document.class);
			// conditions
			criteria.where(builder.equal(root.get("ownerModuleId"), ownerModuleId),
					builder.equal(root.get("ownerFolderType"), fType), builder.equal(root.get("name"), fm.getName()),
					builder.equal(root.get("path"), fm.getPath()));

			return this.entityManager.createQuery(criteria).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void commit() throws DBException {
		try {
			this.entityManager.flush();
		} catch (Exception e) {
			throw new DBException(e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Document updateWithoutATransaction(Document doc) throws DBException {
		try {
			return entityManager.merge(doc);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

}
