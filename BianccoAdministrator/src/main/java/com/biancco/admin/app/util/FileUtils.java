/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.model.folder.FileMeta;

/**
 * File utilities.
 * 
 * @author SOSExcellence.
 */
public class FileUtils {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getRootLogger();

	/**
	 * Store file(s) into a file system with a specific path.
	 * 
	 * @param request
	 *            Multipart HTTP request.
	 * @param path
	 *            Path to upload file(s).
	 * @param ownerModuleId
	 *            Owner module identifier.
	 * @return File info list.
	 */
	public static LinkedList<FileMeta> storeFiles(MultipartHttpServletRequest request, String path,
			long ownerModuleId) {
		LinkedList<FileMeta> files = new LinkedList<FileMeta>();
		// get file names
		Iterator<String> it = request.getFileNames();
		// store files
		while (it.hasNext()) {
			MultipartFile mpf = request.getFile(it.next());
			// file meta result
			FileMeta fm = new FileMeta();
			fm.setName(mpf.getOriginalFilename());
			fm.setSize(formatBytes(mpf.getSize()));
			fm.setContentType(mpf.getContentType());
			try {
				// set bytes
				fm.setBytes(mpf.getBytes());
				// create parent path
				path = path.replace(BianccoConstants.FOLDER_VARIAIBLE_PATH, File.separator + ownerModuleId);
				fm.setPath(path);
				LOGGER.info("Guardando archivo -> " + ReflectionToStringBuilder.toString(fm));
				File f = new File(path);
				if (!f.exists()) {
					LOGGER.info("Creando ruta de archivo -> " + f.getCanonicalPath());
					org.apache.commons.io.FileUtils.forceMkdir(f);
				}
				// create final file
				File file = new File(f, fm.getName());
				// validate if exists
				fm.setAlreadyExists(file.exists());
				// copy file to disk
				FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(file));
				// add file to list
				files.add(fm);
			} catch (FileNotFoundException e) {
				// remove previous files
				deleteFiles(files, path);
				throw new ApplicationException("La ruta para guardar el archivo no existe.", e);
			} catch (IOException e) {
				// remove previous files
				deleteFiles(files, path);
				throw new ApplicationException("Error al guardar archivo(s).", e);
			}
		}
		return files;
	}

	/**
	 * Deletes a file physically within the list.
	 * 
	 * @param files
	 * @param path
	 */
	public static void deleteFiles(LinkedList<FileMeta> files, String path) {
		for (FileMeta fm : files) {
			File f = new File(path, fm.getName());
			try {
				org.apache.commons.io.FileUtils.forceDelete(f);
			} catch (IOException e) {
				throw new ApplicationException("Error al borrar archivo(s).", e);
			}
		}
	}

	/**
	 * Format bytes to KB, MB or GB.
	 * 
	 * @param bytes
	 *            Bytes to format.
	 * @return Bytes formatted.
	 */
	public static String formatBytes(long bytes) {
		double size = 0;
		if (bytes < 1024) {
			return bytes + " Bytes";
		} else if (bytes < 1048576) {
			size = bytes / 1024;
			return formatDecimal(size) + " KB";
		} else if (bytes < 1073741824) {
			size = bytes / 1048576;
			return formatDecimal(size) + " MB";
		} else {
			size = bytes / 1073741824;
			return formatDecimal(size) + " GB";
		}
	}

	/**
	 * Format decimal numbers to #.##
	 * 
	 * @param size
	 *            Size to format.
	 * @return Decimal formatted.
	 */
	public static String formatDecimal(double size) {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		return df.format(size);
	}

}
