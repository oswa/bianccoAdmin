/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.biancco.admin.persistence.dao.PermissionDAO;
import com.biancco.admin.persistence.model.Module;
import com.biancco.admin.persistence.model.Permission;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.persistence.model.Role;

/**
 * Permission DAO test.
 * 
 * @author SOSExcellence.
 */
public class PermissionDAOTest extends DAOTest {
	// @Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert() {
		final PermissionDAO dao = (PermissionDAO) applicationContext.getBean(PermissionDAO.class);

		try {
			/**
			 * ROLES { 1-DIRECTOR GENERAL, 2-ENCARGADO ADMINISTRATIVO DE
			 * OFICINA, 3-SUPER INTENDENTE REGIONAL, 4-RESIDENTE DE OBRA,
			 * 5-RECURSOS HUMANOS }
			 * 
			 * MODULOS { 1-EMPRESAS, 2-EMPLEADOS, 3-CONFIGURACION }
			 */
			Module mEmpresas = new Module();
			mEmpresas.setIdModule(1L);
			Module mEmpleados = new Module();
			mEmpleados.setIdModule(2L);
			Module mConfiguracion = new Module();
			mConfiguracion.setIdModule(3L);

			Role rDG = new Role();
			rDG.setIdRole(1L);
			Role rEO = new Role();
			rEO.setIdRole(2L);
			Role rSI = new Role();
			rSI.setIdRole(3L);
			Role rRO = new Role();
			rRO.setIdRole(4L);
			Role rRH = new Role();
			rRH.setIdRole(5L);

			// EMPRESAS
			Permission p = new Permission();
			p.setModule(mEmpresas);
			p.setRole(rDG);
			p.setType(PermissionType.MODIFY);

			p = new Permission();
			p.setModule(mEmpresas);
			p.setRole(rEO);
			p.setType(PermissionType.QUERY);
			System.out.println("saved --> " + dao.save(p));

			p = new Permission();
			p.setModule(mEmpresas);
			p.setRole(rSI);
			p.setType(PermissionType.MODIFY);
			System.out.println("saved --> " + dao.save(p));

			p = new Permission();
			p.setModule(mEmpresas);
			p.setRole(rRO);
			p.setType(PermissionType.MODIFY);
			System.out.println("saved --> " + dao.save(p));

			// EMPLEADOS
			p = new Permission();
			p.setModule(mEmpleados);
			p.setRole(rDG);
			p.setType(PermissionType.MODIFY);
			System.out.println("saved --> " + dao.save(p));

			p = new Permission();
			p.setModule(mEmpleados);
			p.setRole(rEO);
			p.setType(PermissionType.QUERY);
			System.out.println("saved --> " + dao.save(p));

			p = new Permission();
			p.setModule(mEmpleados);
			p.setRole(rRH);
			p.setType(PermissionType.MODIFY);
			System.out.println("saved --> " + dao.save(p));

			p = new Permission();
			p.setModule(mEmpleados);
			p.setRole(rSI);
			p.setType(PermissionType.QUERY);
			System.out.println("saved --> " + dao.save(p));

			// CONFIGURACION
			p = new Permission();
			p.setModule(mConfiguracion);
			p.setRole(rDG);
			p.setType(PermissionType.MODIFY);
			System.out.println("saved --> " + dao.save(p));

			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}

	}

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getAll() {
		final PermissionDAO dao = (PermissionDAO) applicationContext.getBean(PermissionDAO.class);

		try {
			int index = 1;
			for (Permission p : dao.getAll()) {
				System.out.println(index + " --> " + p.getRole().getName() + " - " + p.getModule().getName() + " - "
						+ p.getType());
				index++;
			}

			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}
	}
}