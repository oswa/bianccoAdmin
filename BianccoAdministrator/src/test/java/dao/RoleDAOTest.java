/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Test;

import com.biancco.admin.model.catalog.RoleSimpleRecord;
import com.biancco.admin.persistence.dao.RoleDAO;
import com.biancco.admin.persistence.model.Role;

/**
 * Role DAO test.
 * 
 * @author SOSExcellence.
 */
public class RoleDAOTest extends DAOTest {
	// @Test
	public void insert() {
		final RoleDAO dao = (RoleDAO) applicationContext.getBean(RoleDAO.class);
		try {
			Role r = new Role();
			r.setDescription("Director General");
			r.setEnable(true);
			r.setName("DIRECTOR GENERAL");
			System.out.println("saved --> " + dao.save(r));
			r = new Role();
			r.setDescription("Encargado administrativo de oficina");
			r.setEnable(true);
			r.setName("ENCARGADO ADMINISTRATIVO DE OFICINA");
			System.out.println("saved --> " + dao.save(r));
			r = new Role();
			r.setDescription("Super Intendente Regional");
			r.setEnable(true);
			r.setName("SUPER INTENDENTE REGIONAL");
			System.out.println("saved --> " + dao.save(r));
			r = new Role();
			r.setDescription("Residente de Obra");
			r.setEnable(true);
			r.setName("RESIDENTE DE OBRA");
			System.out.println("saved --> " + dao.save(r));
			r = new Role();
			r.setDescription("Recursos Humanos");
			r.setEnable(true);
			r.setName("RECURSOS HUMANOS");
			System.out.println("saved --> " + dao.save(r));

			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}

	}

	@Test
	public void getAll() {
		final RoleDAO dao = (RoleDAO) applicationContext.getBean(RoleDAO.class);
		try {
			int index = 1;
			for (RoleSimpleRecord r : dao.getAll(true)) {
				System.out.println(ReflectionToStringBuilder.toString(r));
				index++;
			}

			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}

	}
}
