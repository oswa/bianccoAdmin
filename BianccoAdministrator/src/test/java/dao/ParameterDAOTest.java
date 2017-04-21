/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.ParameterDAO;
import com.biancco.admin.persistence.model.Parameter;

/**
 * ParameterDAOTest.
 *
 * @author SOSExcellence.
 */
public class ParameterDAOTest extends DAOTest {
	// @Test
	public void insert() {
		final ParameterDAO dao = (ParameterDAO) applicationContext.getBean(ParameterDAO.class);

		try {
			this.insertVoucherType(dao);
			assertTrue(true);
		} catch (Exception e) {

			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void getGroupNames() {
		final ParameterDAO dao = (ParameterDAO) applicationContext.getBean(ParameterDAO.class);
		try {
			List<String> groups = dao.getGroupNames();
			for (String g : groups) {
				System.out.println(g);
			}
			assertTrue(true);
		} catch (DBException e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	private void insertCVCompany(ParameterDAO dao) throws DBException {
		// Curriculum para empresas
		Parameter p = new Parameter();
		p.setEnable(true);
		p.setGroup("CURRICULUM PARA EMPRESA");
		p.setName("1");
		p.setValue("CIPI CONSTRUCCIONES S.A. DE C.V.");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("CURRICULUM PARA EMPRESA");
		p.setName("2");
		p.setValue("LAMANSO");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("CURRICULUM PARA EMPRESA");
		p.setName("3");
		p.setValue("CESNA");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("CURRICULUM PARA EMPRESA");
		p.setName("4");
		p.setValue("GRUPO OMM");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("CURRICULUM PARA EMPRESA");
		p.setName("5");
		p.setValue("DYCOM");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("CURRICULUM PARA EMPRESA");
		p.setName("6");
		p.setValue("VENCOM");
		dao.save(p);
	}

	private void insertVoucherType(ParameterDAO dao) throws DBException {
		// Comprobante domiciliario
		Parameter p = new Parameter();
		p.setEnable(true);
		p.setGroup("TIPO_DE_COMPROBANTE");
		p.setName("1");
		p.setValue("LUZ");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("TIPO_DE_COMPROBANTE");
		p.setName("2");
		p.setValue("TELEFONO");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("TIPO_DE_COMPROBANTE");
		p.setName("3");
		p.setValue("PREDIAL");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("TIPO_DE_COMPROBANTE");
		p.setName("4");
		p.setValue("AGUA");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("TIPO_DE_COMPROBANTE");
		p.setName("5");
		p.setValue("CONTRATO");
		dao.save(p);
	}

	private void insertTitleName(ParameterDAO dao) throws DBException {
		// Grado de titulo
		Parameter p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("1");
		p.setValue("LICENCIADO");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("2");
		p.setValue("MAESTRO");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("3");
		p.setValue("PASANTE");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("4");
		p.setValue("DR");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("5");
		p.setValue("BACHILLERATO");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("6");
		p.setValue("SECUNDARIA");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("7");
		p.setValue("PRIMARIA");
		dao.save(p);
		p = new Parameter();
		p.setEnable(true);
		p.setGroup("GRADO DE TITULO");
		p.setName("8");
		p.setValue("SIN ESTUDIOS");
		dao.save(p);
	}
}
