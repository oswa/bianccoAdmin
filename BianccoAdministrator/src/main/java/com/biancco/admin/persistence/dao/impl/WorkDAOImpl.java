/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao.impl;

import com.biancco.admin.persistence.dao.WorkDAO;
import com.biancco.admin.persistence.model.WorkCompany;

/**
 * @author SOSExcellence.
 *
 */
public class WorkDAOImpl implements WorkDAO {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkCompany getWorkById(long idWork) {
		// TODO Ed: Add the query to the database in order to get the Work
		return new WorkCompany();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean insertWork(WorkCompany Work) {
		// TODO Ed: Insert into the database
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteWork(WorkCompany Work) {
		// TODO Ed: Delete into the database
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean updateWork(WorkCompany Work) {
		// TODO Ed: Update into the database
		return true;
	}

}
