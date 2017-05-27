/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.DocumentDAO;
import com.biancco.admin.persistence.model.Document;
import com.biancco.admin.persistence.model.FolderType;
import com.biancco.admin.persistence.model.Parameter;

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
			Parameter p = this.entityManager.getReference(Parameter.class, idDoc);
			this.entityManager.remove(p);
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
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

		CriteriaQuery<Document> q = builder.createQuery(Document.class);
		Root<Document> root = q.from(Document.class);
		q.select(root);
		q.where(builder.equal(root.get("ownerModuleId"), idModule), builder.equal(root.get("ownerFolderType"), type));

		return this.entityManager.createQuery(q).getResultList();
	}

}
