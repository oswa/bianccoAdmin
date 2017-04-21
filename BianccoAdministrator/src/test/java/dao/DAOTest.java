/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author SOSExcellence.
 */
public class DAOTest {
	protected ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
			new String[] { "/src/main/resources/spring/applicationContext.xml" });
}
