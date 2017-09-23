/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Parse utilities.
 * 
 * @author SOSExcellence.
 */
public class BeanUtils {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getRootLogger();

	/**
	 * Cast a string value to Object.
	 * 
	 * @param clazz
	 *            Class to cast.
	 * @param value
	 *            Value to convert.
	 * @return Object.
	 */
	public static Object castStringToObject(Class<?> clazz, String value) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if (clazz.getName().equals("java.util.Date")) {
				return format.parse(value);
			} else if (clazz.getName().equals("java.util.Calendar")) {
				Method m = clazz.getDeclaredMethod("setTime", Date.class);
				Object o = Calendar.getInstance();
				m.invoke(o, format.parse(value));
				return o;
			} else if (clazz.getName().equals("java.sql.Timestamp")) {
				Calendar c = Calendar.getInstance();
				c.setTime(format.parse(value));
				return new java.sql.Timestamp(c.getTimeInMillis());
			}
			Constructor<?> constructor = (Constructor<?>) clazz.getConstructor(new Class<?>[] { String.class });
			return (Object) constructor.newInstance(new Object[] { value });
		} catch (Exception e) {
			LOGGER.error("Error on cast value to object", e);
			return null;
		}
	}

	/**
	 * Set properties to object.
	 * 
	 * @param obj
	 *            Object.
	 * @param properties
	 *            Properties to set.
	 */
	public static void setPropertiesToObject(Object obj, Map<String, String> properties) {
		try {
			// register parameter types to invoke methods
			Method[] methods = obj.getClass().getDeclaredMethods();
			Map<String, Class<?>[]> parameterTypes = new HashMap<String, Class<?>[]>();
			for (Method m : methods) {
				if (m.getName().startsWith("set")) {
					parameterTypes.put(m.getName(), m.getParameterTypes());
				}
			}
			// set properties
			for (Map.Entry<String, String> entry : properties.entrySet()) {
				String prop = entry.getKey();
				String value = entry.getValue();
				// get method
				String methodName = "set" + String.valueOf(prop.charAt(0)).toUpperCase() + prop.substring(1);
				Class<?>[] params = parameterTypes.get(methodName);
				// set value to Object
				Method m = obj.getClass().getDeclaredMethod(methodName, params);
				Class<?> parameterClazz = params[0];
				Object param = BeanUtils.castStringToObject(parameterClazz, value);
				m.invoke(obj, param);
			}
		} catch (Exception e) {
			LOGGER.error("Error on set properties to object", e);
		}
	}
}
