/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.app.util.BianccoConstants;
import com.biancco.admin.app.util.FileUtils;
import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.model.company.CompanySimpleRecord;
import com.biancco.admin.model.folder.FileMeta;
import com.biancco.admin.model.view.CompanyModuleView;
import com.biancco.admin.persistence.dao.CompanyDAO;
import com.biancco.admin.persistence.dao.ParameterDAO;
import com.biancco.admin.persistence.model.Company;
import com.biancco.admin.persistence.model.Parameter;
import com.biancco.admin.persistence.model.PermissionType;
import com.biancco.admin.persistence.model.Power;
import com.biancco.admin.persistence.model.WorkCompany;
import com.biancco.admin.service.CommonService;
import com.biancco.admin.service.CompanyService;

/**
 * @author SOSExcellence.
 *
 */
public class CompanyServiceImpl implements CompanyService {
	/**
	 * The logger.
	 */
	private Logger logger = Logger.getRootLogger();
	/**
	 * Common service.
	 */
	@Autowired
	private CommonService commonService;
	/**
	 * Data access to Company
	 */
	@Autowired
	CompanyDAO companyDao;
	/**
	 * Data access to Parameters
	 */
	@Autowired
	ParameterDAO parameterDao;
	// /**
	// * {@inheritDoc}
	// */
	// public void createNewCompany(final HttpServletRequest request,
	// @RequestParam(value = "image", required = false) MultipartFile logo)
	// throws DBException {
	// Company company = validateCompanyInput(request, logo);
	// this.companyDao.save( company );
	// }
	//
	// /**
	// * @param request
	// * @param logo
	// * @return
	// */
	// private Company validateCompanyInput(HttpServletRequest request,
	// MultipartFile logo) {
	// Company company = new Company();
	// String name = request.getParameter("name");
	// if( name == null ) {
	// throw new ApplicationException("El nombre de la empresa no puede estar
	// vacío.");
	// }
	// String repInput = request.getParameter("representatives");
	// if( repInput == null ) {
	// throw new ApplicationException("Debe ingresar al menos un representante
	// legal.");
	// }
	// if (!logo.isEmpty()) {
	// try {
	// if (!logo.getContentType().equals("image/jpeg")) {
	// throw new ApplicationException("Solo imágenes JPG son aceptadas");
	// }
	// String[] paths = StringUtils.split(logo.getOriginalFilename(), "\\");
	// paths = StringUtils.split(paths[paths.length-1], "/");
	// String fileName = paths[paths.length-1];
	// File f = saveLogo(fileName + ".jpg", logo);
	// company.setLogo(f.getCanonicalPath());
	// } catch (IOException e) {
	// throw new ApplicationException("Error al cargar archivo. "+
	// e.getMessage());
	// }
	// }
	// return company;
	// }
	//
	// private File saveLogo(String filename, MultipartFile image)
	// throws RuntimeException, IOException {
	// File file = null;
	// try {
	// file = new File("/tmp/" + filename);
	// FileUtils.writeByteArrayToFile(file, image.getBytes());
	// } catch (IOException e) {
	// throw new ApplicationException("Error al cargar archivo. "+
	// e.getMessage());
	// }
	// return file;
	// }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompanyModuleView getCompany(HttpSession session, long idCompany) throws DBException {
		CompanyModuleView view = new CompanyModuleView();
		// List<RoleSimpleRecord> roles = this.commonService.getRoles(true);
		Company comp = this.companyDao.getById(idCompany);
		// view.setRoles(roles);
		view.setpType((PermissionType) session.getAttribute("company"));
		view.setCompany(comp);
		return view;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws DBException
	 *             If there is a DB error
	 */
	@Override
	public void addNewWork(HttpServletRequest request, long idCompany) throws DBException {
		Company comp = validateCompany(request, idCompany);
		if (comp.getWorks() == null) {
			comp.setWorks(new ArrayList<WorkCompany>());
		}
		WorkCompany work = new WorkCompany();
		work.setName(request.getParameter("workName"));
		comp.getWorks().add(work);
		this.companyDao.save(comp);
	}

	/**
	 * Validate the inputs values
	 * 
	 * @param request
	 * @param idCompany
	 * @return
	 * @throws DBException
	 *             If there is a DB error
	 */
	private Company validateCompany(HttpServletRequest request, long idCompany) throws DBException {
		String workName = request.getParameter("workName");
		if (workName == null || StringUtils.isEmpty(workName)) {
			throw new ApplicationException("El nombre de la obra no puede estar vacío");
		}
		Company comp = this.companyDao.getById(idCompany);
		if (comp == null) {
			throw new ApplicationException("Compañia " + idCompany + " no existe");
		}
		return comp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CompanySimpleRecord> getCompanyBySuperintendente(long superintendenteId) throws DBException {
		List<CompanySimpleRecord> result = this.companyDao.getCompanyBySuperintendente(superintendenteId);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CompanySimpleRecord> getCompanyByResidente(long residenteId) throws DBException {
		List<CompanySimpleRecord> result = this.companyDao.getCompanyByResidente(residenteId);
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CompanyModuleView getInfoToAdd(HttpSession session) throws DBException {
		CompanyModuleView view = new CompanyModuleView();

		view.setpType((PermissionType) session.getAttribute("company"));
		return view;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelAndView getMainView(HttpSession session) throws DBException {
		return this.commonService.getViewByModule("company", session);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Company saveCompany(String companyEncoded) throws DBException {
		// company basic info
		Company d = (Company) HTTPUtils.getObjectFromFormString(companyEncoded, Company.class);
		// save
		return this.companyDao.save(d);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Company updateCompany(Company company) throws DBException {
		// get company to update
		Company companyInDB = this.companyDao.getById(company.getIdCompany());
		// set changes
		companyInDB.setName(company.getName());
		companyInDB.setRepresentante(company.getRepresentante());
		if (companyInDB.getPower() == null) {
			companyInDB.setPower(new Power());
			companyInDB.getPower().setCompany(companyInDB);
		}
		companyInDB.getPower().setPower(company.getPower().getPower());
		companyInDB.getPower().setNotary(company.getPower().getNotary());
		companyInDB.getPower().setDistrict(company.getPower().getDistrict());
		companyInDB.getPower().setNotaryNum(company.getPower().getNotaryNum());
		// update
		return this.companyDao.update(companyInDB);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public LinkedList<FileMeta> saveAndUploadLogo(MultipartHttpServletRequest request, HttpSession session) {
		// get folder info
		Long companyId = Long.parseLong(request.getParameter("companyId"));
		// FolderType fType =
		// FolderType.fromString(request.getParameter("folderType"));
		// Long ownerModuleId =
		// Long.parseLong(request.getParameter("ownerModuleId"));
		LinkedList<FileMeta> files = null;
		String path = null;
		// save files
		try {
			// build path
			Company com = this.companyDao.getById(companyId);
			Parameter param = this.parameterDao.getParameterValue("GENERAL", "LOGOS_PATH");
			if (null == param || null == param.getValue()) {
				throw new ApplicationException("Directorio de carga no definido");
			}
			path = StringUtils.replace(param.getValue(), BianccoConstants.FOLDER_VARIAIBLE_PATH,
					request.getParameter("companyId"));
			this.logger.info("Uploading logo " + companyId + ", ");
			// store files
			files = FileUtils.storeFiles(request, path, companyId);
			for (FileMeta fm : files) {
				com.setLogo(path + File.separator + fm.getName());
				// save
				this.companyDao.update(com);
			}
		} catch (DBException dbe) {
			// remove previous files
			FileUtils.deleteFiles(files, path);
			throw new ApplicationException("Error al cargar archivo", dbe);
		}
		return files;
	}
}
