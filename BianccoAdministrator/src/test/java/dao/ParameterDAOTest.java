/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.biancco.admin.persistence.dao.ParameterDAO;

/**
 * ParameterDAOTest.
 * 
 * @author SOSExcellence.
 */
public class ParameterDAOTest {

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes", "resource" })
	public void getParameters() {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				new String[] { "/src/main/resources/spring/applicationContext.xml" });

		TransactionTemplate transactionTemplate = (TransactionTemplate) applicationContext
				.getBean("transactionTemplate");
		final ParameterDAO dao = (ParameterDAO) applicationContext.getBean(ParameterDAO.class);
		transactionTemplate.execute(new TransactionCallback() {
			public Object doInTransaction(final TransactionStatus ts) {
				try {
					dao.getParameters();
					assertTrue(true);
				} catch (Exception e) {
					ts.setRollbackOnly();
					e.printStackTrace();
					assertTrue(false);
				}
				return null;
			}
		});
		assertTrue(true);
	}

}
