/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
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
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.company.CompanySimpleRecord;
import com.biancco.admin.persistence.dao.CompanyDAO;
import com.biancco.admin.persistence.model.Company;
import com.biancco.admin.persistence.model.WorkCompany;

/**
 * @author SOSExcellence.
 *
 */
public class CompanyDAOImpl implements CompanyDAO {
	/**
	 * Logger.
	 */
	private Logger logger = Logger.getRootLogger();
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
	public Company getById(long identifier) throws DBException {
		try {
			return this.entityManager.find(Company.class, identifier);
		} catch (Exception e) {
			this.logger.error("Error on get company by id", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @return
	 */
	@Override
	@Transactional
	public Company save(Company company) throws DBException {
		try {
			this.entityManager.persist(company);
			this.entityManager.flush();
			return company;
		} catch (Exception e) {
			this.logger.error("Error on save company", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<CompanySimpleRecord> getAll() throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanySimpleRecord> criteriaQuery = builder.createQuery(CompanySimpleRecord.class);

			// build query
			Root<Company> companyRoot = criteriaQuery.from(Company.class);
			// join table(s)
			Join<Company, WorkCompany> joinWorkCompany = companyRoot.join("works", JoinType.LEFT);
			// selection
			Path<Long> pathId = companyRoot.get("idCompany");
			Path<String> pathName = companyRoot.get("name");
			Path<Boolean> pathEnable = companyRoot.get("enable");
			criteriaQuery.select(builder.construct(CompanySimpleRecord.class, pathId, pathName,
					builder.count(joinWorkCompany), pathEnable));
			// group
			criteriaQuery.groupBy(companyRoot.get("idCompany"), companyRoot.get("name"));
			// order
			criteriaQuery.orderBy(builder.asc(companyRoot.get("name")));

			return this.entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			this.logger.error("Error on get all companies", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<CompanySimpleRecord> getCompanyByResidente(long employeeId) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanySimpleRecord> criteriaQuery = builder.createQuery(CompanySimpleRecord.class);

			// build query
			Root<Company> companyRoot = criteriaQuery.from(Company.class);
			// join table(s)
			Join<Company, WorkCompany> joinWorkCompany = companyRoot.join("works", JoinType.LEFT);
			// selection
			Path<Long> pathId = companyRoot.get("idCompany");
			Path<String> pathName = companyRoot.get("name");
			Path<Boolean> pathEnable = companyRoot.get("enable");
			criteriaQuery.select(builder.construct(CompanySimpleRecord.class, pathId, pathName,
					builder.count(joinWorkCompany), pathEnable));
			// where
			criteriaQuery.where(builder.equal(joinWorkCompany.get("residente"), employeeId),
					builder.equal(companyRoot.get("enable"), true));
			// group
			criteriaQuery.groupBy(companyRoot.get("idCompany"), companyRoot.get("name"));
			// order
			criteriaQuery.orderBy(builder.asc(companyRoot.get("name")));

			return this.entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			this.logger.error("Error on get company by residente", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<CompanySimpleRecord> getCompanyBySuperintendente(long employeeId) throws DBException {
		try {
			CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
			CriteriaQuery<CompanySimpleRecord> criteriaQuery = builder.createQuery(CompanySimpleRecord.class);

			// build query
			Root<Company> companyRoot = criteriaQuery.from(Company.class);
			// join table(s)
			Join<Company, WorkCompany> joinWorkCompany = companyRoot.join("works", JoinType.LEFT);
			// selection
			Path<Long> pathId = companyRoot.get("idCompany");
			Path<String> pathName = companyRoot.get("name");
			Path<Boolean> pathEnable = companyRoot.get("enable");
			criteriaQuery.select(builder.construct(CompanySimpleRecord.class, pathId, pathName,
					builder.count(joinWorkCompany), pathEnable));
			// where
			criteriaQuery.where(builder.equal(joinWorkCompany.get("superintendente"), employeeId),
					builder.equal(companyRoot.get("enable"), true));
			// group
			criteriaQuery.groupBy(companyRoot.get("idCompany"), companyRoot.get("name"));
			// order
			criteriaQuery.orderBy(builder.asc(companyRoot.get("name")));

			return this.entityManager.createQuery(criteriaQuery).getResultList();
		} catch (Exception e) {
			this.logger.error("Error on get company by superintendente", e);
			throw new DBException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Company update(Company company) throws DBException {
		try {
			return entityManager.merge(company);
		} catch (Exception e) {
			this.logger.error("Error on update company", e);
			throw new DBException(e);
		}
	}

}
