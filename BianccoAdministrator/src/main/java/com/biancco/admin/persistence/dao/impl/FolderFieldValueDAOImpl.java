/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.FolderFieldValueDAO;
import com.biancco.admin.persistence.model.FolderFieldValue;

/**
 * Folder field value DAO imlementation.
 * 
 * @author SOSExcellence.
 */
public class FolderFieldValueDAOImpl implements FolderFieldValueDAO {
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
	public FolderFieldValue getById(Long idFolderFieldValue) throws DBException {
		try {
			return this.entityManager.find(FolderFieldValue.class, idFolderFieldValue);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public FolderFieldValue save(FolderFieldValue value) throws DBException {
		try {
			this.entityManager.persist(value);
			this.entityManager.flush();
			return value;
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void save(List<FolderFieldValue> values) throws DBException {
		try {
			for (FolderFieldValue val : values) {
				this.entityManager.merge(val);
			}
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public FolderFieldValue update(FolderFieldValue value) throws DBException {
		try {
			return entityManager.merge(value);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public void delete(long idFolderFieldValue) throws DBException {
		try {
			FolderFieldValue val = this.entityManager.getReference(FolderFieldValue.class, idFolderFieldValue);
			this.entityManager.remove(val);
		} catch (Exception e) {
			throw new DBException(e);
		}
	}
}
