/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.app.exception.DBException;
import com.biancco.admin.persistence.dao.CompanyDAO;
import com.biancco.admin.persistence.model.Company;
import com.biancco.admin.persistence.model.Representative;
import com.biancco.admin.persistence.model.WorkCompany;
import com.biancco.admin.service.CompanyService;

/**
 * @author SOSExcellence.
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

	/**
	 * Data access to Company
	 */
	@Autowired
	CompanyDAO companyDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createNewCompany(final HttpServletRequest request,
			@RequestParam(value = "image", required = false) MultipartFile logo) throws DBException {
		Company company = validateCompanyInput(request, logo);
		this.companyDao.insertCompany(company);
	}

	/**
	 * @param request
	 * @param logo
	 * @return
	 */
	private Company validateCompanyInput(HttpServletRequest request, MultipartFile logo) {
		Company company = new Company();
		String name = request.getParameter("name");
		if (name == null) {
			throw new ApplicationException("El nombre de la empresa no puede estar vacío.");
		}
		String repInput = request.getParameter("representatives");
		if (repInput == null) {
			throw new ApplicationException("Debe ingresar al menos un representante legal.");
		}
		List<Representative> repList = new ArrayList<Representative>();
		for (String repName : StringUtils.split(repInput, ":")) {
			Representative rep = new Representative();
			rep.setName(repName);
			repList.add(rep);
		}
		company.setRepresentatives(repList);
		if (!logo.isEmpty()) {
			try {
				if (!logo.getContentType().equals("image/jpeg")) {
					throw new ApplicationException("Solo imágenes JPG son aceptadas");
				}
				String[] paths = StringUtils.split(logo.getOriginalFilename(), "\\");
				paths = StringUtils.split(paths[paths.length - 1], "/");
				String fileName = paths[paths.length - 1];
				File f = saveLogo(fileName + ".jpg", logo);
				company.setLogo(f.getCanonicalPath());
			} catch (IOException e) {
				throw new ApplicationException("Error al cargar archivo. " + e.getMessage());
			}
		}
		return company;
	}

	private File saveLogo(String filename, MultipartFile image) throws RuntimeException, IOException {
		File file = null;
		try {
			file = new File("/tmp/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException e) {
			throw new ApplicationException("Error al cargar archivo. " + e.getMessage());
		}
		return file;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteCompany() {
		// TODO ED: Implements.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Company getCompanyById(long idCompany) {
		// TODO ED: Implements.
		return new Company();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Company> getAllCompanies() throws DBException {
		return this.companyDao.getAllCompanies();
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
		this.companyDao.updateCompany(comp);
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
		Company comp = this.companyDao.getCompanyById(idCompany);
		if (comp == null) {
			throw new ApplicationException("Compañia " + idCompany + " no existe");
		}
		return comp;
	}

}
