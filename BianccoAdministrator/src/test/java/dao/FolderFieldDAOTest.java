/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package dao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.model.folder.FieldValue;
import com.biancco.admin.persistence.dao.FolderFieldDAO;
import com.biancco.admin.persistence.model.FolderBase;
import com.biancco.admin.persistence.model.FolderField;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Folder field DAO test.
 * 
 * @author SOSExcellence.
 */
public class FolderFieldDAOTest extends DAOTest {
	// @Test
	public void insert() {
		final FolderFieldDAO dao = (FolderFieldDAO) applicationContext.getBean(FolderFieldDAO.class);
		try {
			// employee folder fields
			this.insertEmployeeFolderFields(dao);

			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	@Test
	public void get() {
		final FolderFieldDAO dao = (FolderFieldDAO) applicationContext.getBean(FolderFieldDAO.class);
		try {
			/*
			 * for (FolderField ff : dao.getFieldsByFolder(13L)) {
			 * System.out.println(ff.getField()); }
			 */
			for (FieldValue fv : dao.getFieldValueByFolder(4L, 1L, FolderType.EMPLOYEE)) {
				System.out.println(fv.getField());
			}

			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	/**
	 * Inserts the folder fields for Employee module.
	 * 
	 * @param dao
	 *            DAO.
	 * @throws DBException
	 */
	private void insertEmployeeFolderFields(FolderFieldDAO dao) throws DBException {
		// RFC folder
		FolderBase rfc = new FolderBase();
		rfc.setIdFolder(2L);
		// CURP folder
		FolderBase curp = new FolderBase();
		curp.setIdFolder(3L);
		// CV folder
		FolderBase cv = new FolderBase();
		cv.setIdFolder(4L);
		// cedula folder
		FolderBase cedula = new FolderBase();
		cedula.setIdFolder(5L);
		// titulo folder
		FolderBase titulo = new FolderBase();
		titulo.setIdFolder(6L);
		// ife folder
		FolderBase ife = new FolderBase();
		ife.setIdFolder(7L);
		// certificado superintendente folder
		FolderBase c_super = new FolderBase();
		c_super.setIdFolder(8L);
		// certificado precios folder
		FolderBase c_precios = new FolderBase();
		c_precios.setIdFolder(9L);
		// domicilio folder
		FolderBase dom = new FolderBase();
		dom.setIdFolder(10L);
		// varios folder
		FolderBase varios = new FolderBase();
		varios.setIdFolder(13L);
		// firma folder
		FolderBase firma = new FolderBase();
		firma.setIdFolder(14L);

		// RFC
		FolderField f = new FolderField();
		f.setField("RFC");
		f.setFolderBase(rfc);
		f.setMaxLength(13);
		f.setRequired(true);
		f.setType(String.class.getName());
		dao.save(f);
		// CURP
		f = new FolderField();
		f.setField("CURP");
		f.setFolderBase(curp);
		f.setMaxLength(18);
		f.setRequired(true);
		f.setType(String.class.getName());
		dao.save(f);
		// curriculum
		f = new FolderField();
		f.setField("Curriculum para empresa");
		f.setFolderBase(cv);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setCatalog("CURRICULUM PARA EMPRESA");
		dao.save(f);
		// cedula
		f = new FolderField();
		f.setField("Cedula");
		f.setFolderBase(cedula);
		f.setMaxLength(20);
		f.setRequired(true);
		f.setType(String.class.getName());
		dao.save(f);
		// titulo
		f = new FolderField();
		f.setField("Titulo");
		f.setFolderBase(titulo);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setCatalog("GRADO DE TITULO");
		dao.save(f);
		// ife
		f = new FolderField();
		f.setField("Numero de IFE/INE");
		f.setFolderBase(ife);
		f.setMaxLength(30);
		f.setRequired(true);
		f.setType(String.class.getName());
		dao.save(f);
		// cert superintendente
		f = new FolderField();
		f.setField("Fecha de &uacute;ltima actualizaci&oacute;n");
		f.setFolderBase(c_super);
		f.setMaxLength(30);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setDate(true);
		dao.save(f);
		// cert precios unitarios
		f = new FolderField();
		f.setField("Fecha de &uacute;ltima actualizaci&oacute;n");
		f.setFolderBase(c_precios);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setDate(true);
		dao.save(f);
		// comprobante domicilio
		f = new FolderField();
		f.setField("Tipo de comprobante");
		f.setFolderBase(dom);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setCatalog("TIPO_DE_COMPROBANTE");
		dao.save(f);
		// tipo certificado
		f = new FolderField();
		f.setField("Tipo de certificado");
		f.setFolderBase(varios);
		f.setMaxLength(100);
		f.setRequired(true);
		f.setType(String.class.getName());
		dao.save(f);
		// fecha registro
		f = new FolderField();
		f.setField("Fecha de registro");
		f.setFolderBase(varios);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setDate(true);
		dao.save(f);
		// vigencia de certificado
		f = new FolderField();
		f.setField("Fecha de vigencia");
		f.setFolderBase(varios);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setDate(true);
		dao.save(f);
		// fecha firma
		f = new FolderField();
		f.setField("Fecha de registro de firma");
		f.setFolderBase(firma);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setDate(true);
		dao.save(f);
		// vigencia firma
		f = new FolderField();
		f.setField("Fecha de vigencia");
		f.setFolderBase(firma);
		f.setRequired(true);
		f.setType(String.class.getName());
		f.setDate(true);
		dao.save(f);
	}
}
