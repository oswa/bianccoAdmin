/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.persistence.dao;

import com.biancco.admin.persistence.model.WorkCompany;

/**
 * Access to Work in persistence memory.
 * @author SOSExcellence.
 *
 */
public interface WorkDAO {
	/**
	 * Return an Work based on its id.
	 * @param idWork the identitifier
	 * @return the Work object corresponding to the id
	 */
	public WorkCompany getWorkById( long idWork );
	/**
	 * Insert a new Work.
	 * @param Work
	 * @return true if successful
	 */
	public boolean insertWork( WorkCompany Work );
	/**
	 * Delete an Work from persistent data.
	 * @param Work the element to delete
	 * @return true id successful
	 */
	public boolean deleteWork( WorkCompany Work );
	/**
	 * Update an Work in persisten data.
	 * @param Work the element to update
	 * @return true id successful
	 */
	public boolean updateWork( WorkCompany Work );
}
