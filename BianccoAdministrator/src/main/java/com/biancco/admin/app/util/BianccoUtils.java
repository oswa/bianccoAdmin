/**
 * SOSExcellence S.A. de C.V. All rights reserved 2016.
 */
package com.biancco.admin.app.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * @author SOSExcellence.
 *
 */
public class BianccoUtils {


	/**
	 * Method for build a path directory
	 * @param path the path to build
	 * @return true if is successful
	 * @throws IOException if an IO error occurs
	 */
	public static boolean buildPath(String path) throws IOException {
		if( path == null ) {
			return false;
		}
		FileUtils.forceMkdir(new File(path));
		return true;
	}
}
