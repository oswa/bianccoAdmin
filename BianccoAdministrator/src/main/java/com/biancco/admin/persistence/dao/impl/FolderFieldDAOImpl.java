/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

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
import com.biancco.admin.model.folder.FieldValue;
import com.biancco.admin.persistence.dao.FolderFieldDAO;
import com.biancco.admin.persistence.model.FolderBase;
import com.biancco.admin.persistence.model.FolderField;
import com.biancco.admin.persistence.model.FolderFieldValue;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Folder fiel DAO implementation.
 * 
 * @author SOSExcellence.
 */
public class FolderFieldDAOImpl implements FolderFieldDAO {
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
	public FolderField getById(Long idFolderField) throws DBException {
		try {
			return this.entityManager.find(FolderField.class, idFolderField);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public FolderField save(FolderField field) throws DBException {
		try {
			this.entityManager.persist(field);
			this.entityManager.flush();
			return field;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(long idFolderField) throws DBException {
		try {
			FolderBase f = this.entityManager.getReference(FolderBase.class, idFolderField);
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
	public FolderField update(FolderField field) throws DBException {
		try {
			return entityManager.merge(field);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional(readOnly = true)
	public List<FolderField> getFieldsByFolder(long idFolder) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();

			CriteriaQuery<FolderField> q = builder.createQuery(FolderField.class);
			Root<FolderField> root = q.from(FolderField.class);
			q.select(root);
			q.where(builder.equal(root.get("folderBase").get("idFolder"), idFolder));
			q.orderBy(builder.asc(root.get("idFolderField")));

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
	public List<FieldValue> getFieldValueByFolder(long idFolder, long ownerModuleId, FolderType folderType)
			throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<FieldValue> q = builder.createQuery(FieldValue.class);
			// root
			Root<FolderField> root = q.from(FolderField.class);
			// join
			Join<FolderField, FolderFieldValue> joinVal = root.join("value", JoinType.LEFT);
			// selection
			Path<Long> pFolderFieldId = root.get("idFolderField");
			Path<String> pFieldType = root.get("type");
			Path<Boolean> pRequired = root.get("required");
			Path<Integer> pMaxLength = root.get("maxLength");
			Path<String> pField = root.get("field");
			Path<Long> pCatalog = root.get("catalog");
			Path<Boolean> pDate = root.get("date");
			Path<Long> pFolderValueId = joinVal.get("idFolderValue");
			Path<Long> pOwnerModuleId = joinVal.get("ownerModuleId");
			Path<FolderType> pOwnerFolderType = joinVal.get("ownerFolderType");
			Path<String> pValue = joinVal.get("value");

			// join condition
			Predicate pOwner = builder.equal(pOwnerModuleId, ownerModuleId);
			Predicate pType = builder.equal(pOwnerFolderType, folderType);
			joinVal.on(builder.and(pOwner, pType));

			q.select(builder.construct(FieldValue.class, pFolderFieldId, pFolderValueId, pField, pOwnerModuleId,
					pOwnerFolderType, pValue, pFieldType, pRequired, pMaxLength, pCatalog, pDate));

			// condition
			Predicate pFolder = builder.equal(root.get("folderBase").get("idFolder"), idFolder);
			q.where(builder.and(pFolder));
			// order
			q.orderBy(builder.asc(pFolderFieldId));

			return this.entityManager.createQuery(q).getResultList();
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

}
