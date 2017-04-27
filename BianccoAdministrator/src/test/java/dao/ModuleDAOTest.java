/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.biancco.admin.persistence.dao.ModuleDAO;
import com.biancco.admin.persistence.model.Module;

/**
 * Module DAO test.
 * 
 * @author SOSExcellence.
 */
public class ModuleDAOTest extends DAOTest {
	// @Test
	public void insert() {
		final ModuleDAO dao = (ModuleDAO) applicationContext.getBean(ModuleDAO.class);

		try {
			Module m = new Module();
			m.setName("EMPRESAS");
			m.setDescription("Modulo de empresas");
			m.setEnable(true);
			System.out.println("saved --> " + dao.save(m));
			m = new Module();
			m.setName("EMPLEADOS");
			m.setDescription("Modulo de empleados");
			m.setEnable(true);
			System.out.println("saved --> " + dao.save(m));
			m = new Module();
			m.setName("CONFIGURACION");
			m.setDescription("Modulo de configuracion");
			m.setEnable(true);
			System.out.println("saved --> " + dao.save(m));

			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}

	}

	@Test
	public void getAll() {
		final ModuleDAO dao = (ModuleDAO) applicationContext.getBean(ModuleDAO.class);

		try {
			int index = 1;
			for (Module m : dao.getAll()) {
				System.out.println(index + " --> " + m.getName() + " " + m.getEnable());
				index++;
			}

			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}

	}

	// @Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void delete() {
		final ModuleDAO dao = (ModuleDAO) applicationContext.getBean(ModuleDAO.class);

		try {
			for (Module m : dao.getAll()) {
				System.out.println("deleting --> " + m.getName());
				dao.delete(m);
			}
			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}

	}

}
