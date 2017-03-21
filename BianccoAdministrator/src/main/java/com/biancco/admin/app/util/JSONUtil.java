/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON utilities.
 * 
 * @author SOSExcellence.
 */
public class JSONUtil {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getRootLogger();

	/**
	 * Constructor privado.
	 */
	private JSONUtil() {
		// Empty constructor
	}

	/**
	 * Metodo para convertir objecto a JSON.
	 * 
	 * @param object
	 *            object to convert.
	 * @return string
	 */
	public static String getJSONString(final Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			JSONUtil.LOGGER.error("getJSONString", e);
			return null;
		}
	}

	/**
	 * Metodo para convertir objecto a JSON.
	 * 
	 * @param json
	 *            JSON string to read.
	 * @param clazz
	 *            object to convert.
	 * @return Object created.
	 */
	public static Object getObjectFromJSON(final String json, final Class<?> clazz) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
			JSONUtil.LOGGER.error("getObjectFromJSON", e);
			return null;
		}
	}
}
