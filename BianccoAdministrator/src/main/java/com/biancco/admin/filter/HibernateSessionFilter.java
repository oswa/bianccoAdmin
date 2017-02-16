/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.filter;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;

/**
 * Hibernate session filter.
 * 
 * @author SOSExcellence.
 */
@SuppressWarnings("deprecation")
public class HibernateSessionFilter extends OpenSessionInViewFilter {
	/**
	 * The default mode is FlushMode.NEVER This can be modified depending on the
	 * number of transactions.
	 * 
	 * @param sessionFactory
	 *            Injected by Spring.
	 * @throws DataAccessResourceFailureException
	 *             thrown in case the session cannot be created.
	 * @see org.springframework.orm.hibernate.support.OpenSessionInViewFilter#getSession(net.sf.hibernate.SessionFactory)
	 * @return Hibernate session.
	 */
	protected final Session getSession(final SessionFactory sessionFactory) throws DataAccessResourceFailureException {
		Session session = super.openSession(sessionFactory);
		session.setFlushMode(FlushMode.COMMIT);
		return session;
	}

	/**
	 * We do an explicit flush here just in case we do not have an automated
	 * flush.
	 * 
	 * @param session
	 *            session to close.
	 * @param factory
	 *            factory needed to create session.
	 */
	protected final void closeSession(final Session session, final SessionFactory factory) {
		session.flush();
		session.close();
		super.destroy();
	}
}