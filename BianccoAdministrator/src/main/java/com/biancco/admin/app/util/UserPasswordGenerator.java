/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.util;

import org.apache.commons.lang.StringUtils;

/**
 * User / Password generator.
 * 
 * @author SOSExcellence.
 */
public class UserPasswordGenerator {
	/**
	 * Number key.
	 */
	private static final String NUMBER = "0123456789";
	/**
	 * Uppercase key.
	 */
	private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	 * Lowercase key.
	 */
	private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	/**
	 * Special key.
	 */
	private static final String SPECIAL = "Ò—";

	/**
	 * Gets a PIN number of 4 digits.
	 * 
	 * @return PIN number.
	 */
	public static String getPinNumber() {
		return getPassword(NUMBER, 4);
	}

	/**
	 * Gets a password fixed to 8 digits.
	 * 
	 * @return Password.
	 */
	public static String getPassword() {
		return getPassword(NUMBER + UPPERCASE + LOWERCASE, 8);
	}

	/**
	 * Gets a password from key and fixed length.
	 * 
	 * @param key
	 *            Password Key.
	 * @param length
	 *            Password length.
	 * @return Password.
	 */
	public static String getPassword(String key, int length) {
		String pass = "";
		for (int i = 0; i < length; i++) {
			pass += (key.charAt((int) (Math.random() * key.length())));
		}
		return pass;
	}

	/**
	 * Gets a username by mail.
	 * 
	 * @param mail
	 *            Mail.
	 * @return Username.
	 */
	public static String getUserByMail(String mail) {
		return StringUtils.lowerCase(mail.substring(0, mail.indexOf("@")));
	}
}
