/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.util;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpServerErrorException;

import com.biancco.admin.app.exception.ApplicationException;
import com.biancco.admin.model.view.SimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author SOSExcellence.
 */
public final class HTTPUtils {
	/**
	 * UTF-8 literal or ISO-8859-1.
	 */
	public static final String CHARSET_UTF8 = "UTF-8";
	/**
	 * Key in header with the client IP address defined in balancer.
	 */
	public static final String HEADER_IP_KEY = "CLIENT_IP_ADDRESS";
	/**
	 * Key in header with the client IP address defined in balancer.
	 */
	public static final String TAXES_IP_CLIENT = "TAXES_IP_CLIENT";
	/**
	 * Key in header with the authorization token.
	 */
	public static final String HEADER_AUTH_KEY = "Authorization";
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getRootLogger();

	/**
	 * Default constructor, utility class.
	 */
	private HTTPUtils() {
	}

	/**
	 * Obtains the Authorization header from client.
	 *
	 * @param request
	 *            Request from client.
	 * @return Authorization header from client.
	 */
	public static String getAuthHeader(final HttpServletRequest request) {
		String auth = request.getHeader(HTTPUtils.HEADER_AUTH_KEY);
		auth = auth.trim();
		if (LOGGER.isDebugEnabled()) {
			LOGGER.info("Authorization-Token: [" + auth + "]");
		}
		return auth;
	}

	/**
	 * Decode a string in charset defined.
	 *
	 * @param string
	 *            string to decode.
	 * @param charset
	 *            Charset.
	 * @return decoded string.
	 */
	public static String decodeString(final String string, final String charset) {
		try {
			return URLDecoder.decode(string, charset);
		} catch (IOException e) {
			throw new ApplicationException("Error al decodificar: " + string + " en charset: " + charset, e);
		}
	}

	/**
	 * Encode a string in charset defined.
	 *
	 * @param string
	 *            string to encode.
	 * @param charset
	 *            Charset.
	 * @return Encoded string.
	 */
	public static String encodeString(final String string, final String charset) {
		try {
			return URLEncoder.encode(string, charset);
		} catch (IOException e) {
			throw new ApplicationException("Error al codificar: " + string + " con charset: " + charset, e);
		}
	}

	/**
	 * Read parameters from request and creates a Map with param names and
	 * values.
	 *
	 * @param request
	 *            HttpServletRequest object.
	 * @return Map created.
	 */
	@SuppressWarnings({ "rawtypes" })
	public static MultiValueMap<String, String> readRequestParameters(final HttpServletRequest request) {
		// read parameters.
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String[] paramValues = request.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++) {
				String paramValue = paramValues[i];
				map.add(paramName, paramValue);
			}
		}
		if (LOGGER.isDebugEnabled()) {
			Iterator<?> it = map.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				LOGGER.info(e.getKey() + " " + e.getValue());
			}
		}
		return map;
	}

	/**
	 * Gets an object from Form serialized.
	 * 
	 * @param form
	 *            Form serialized.
	 * @param clazz
	 *            Class to convert.
	 * @return Object.
	 */
	public static Object getObjectFromFormString(String form, Class<?> clazz) {
		try {
			form = HTTPUtils.decodeString(form, HTTPUtils.CHARSET_UTF8);
			String[] attributes = form.split("&");
			// gets a new instance from Object to convert
			Object o = clazz.newInstance();
			// register methods
			Method[] methods = o.getClass().getDeclaredMethods();
			Map<String, Class<?>[]> mapMethods = new HashMap<String, Class<?>[]>();
			for (Method m : methods) {
				if (m.getName().startsWith("set")) {
					mapMethods.put(m.getName(), m.getParameterTypes());
				}
			}
			// parse form attributes to Object
			for (String attr : attributes) {
				String[] field = attr.split("=");
				String key = field[0];
				String value = field[1];
				// get method
				String methodName = "set" + String.valueOf(key.charAt(0)).toUpperCase() + key.substring(1);
				Class<?>[] params = mapMethods.get(methodName);
				// set value to Object
				Method m = o.getClass().getDeclaredMethod(methodName, params);
				Class<?> parameterClazz = params[0];
				Object param = castStringToObject(parameterClazz, value);
				m.invoke(o, param);
			}
			return o;
		} catch (Exception e) {
			LOGGER.error("Exception converting form to object", e);
			return null;
		}
	}

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
			}
			Constructor<?> constructor = (Constructor<?>) clazz.getConstructor(new Class<?>[] { String.class });
			return (Object) constructor.newInstance(new Object[] { value });
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Exception casting value to object", e);
			return null;
		}
	}

	/**
	 * Read object from exception.
	 *
	 * @param exception
	 *            Exception to read.
	 * @return ResponseMessageVO object.
	 */
	public static SimpleResponse readException(final HttpServerErrorException exception) {
		String r = exception.getResponseBodyAsString();
		ObjectMapper mapper = new ObjectMapper();
		SimpleResponse vo = null;
		try {
			vo = mapper.readValue(r, SimpleResponse.class);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
			vo = new SimpleResponse();
			vo.setMessage("Error desconocido, intente más tarde.");
		}
		return vo;
	}

	/**
	 * Obtains the IpAddress from client.
	 *
	 * @param request
	 *            Request from client.
	 * @return ip address from client.
	 */
	public static String getClientIpAddress(final HttpServletRequest request) {
		String ip = request.getHeader(HEADER_IP_KEY);
		if (!StringUtils.hasText(ip)) {
			ip = request.getRemoteAddr();
		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.info("HTTPUtils-IP: " + ip);
		}
		return ip;
	}

	/**
	 * @param request
	 *            the HttpServletRequest.
	 * @return String
	 */
	public static String getSessionId(HttpServletRequest request) {
		if (request == null || request.getRequestedSessionId() == null || !request.isRequestedSessionIdValid()) {
			return null;
		}
		return request.getRequestedSessionId();
	}

	/**
	 * Read object from AdminModule exception.
	 *
	 * @param exception
	 *            Exception to read.
	 * @return ResponseMessageVO object.
	 */
	public static SimpleResponse readException(final ApplicationException exception) {
		String msg = evaluateError(exception.getMessageError());
		SimpleResponse vo = new SimpleResponse(msg);
		LOGGER.error("Error: " + msg, exception);
		return vo;
	}

	/**
	 * Read object from exception.
	 *
	 * @param exception
	 *            Exception to read.
	 * @return ResponseMessageVO object.
	 */
	public static SimpleResponse readException(final Exception exception) {
		String msg = evaluateError(exception.getMessage());
		SimpleResponse vo = new SimpleResponse("Ha ocurrido un problema en la aplicación, intente más tarde.");
		LOGGER.error("Error: " + msg, exception);
		return vo;
	}

	/**
	 * Evaluates an error message.
	 * 
	 * @param message
	 *            The message to evaluate.
	 * @return The error message.
	 */
	private static String evaluateError(final String message) {
		String localmessage = message;
		if (localmessage == null || "".equals(localmessage)) {
			localmessage = "Error desconocido";
		}
		return localmessage;
	}
}
