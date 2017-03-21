/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package com.biancco.admin.app.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;

/**
 * Date utilities.
 * 
 * @author SOSExcellence.
 */
public class DateUtils {
	/**
	 * America Mexico City.
	 */
	private static final String AMERICA = "America/Mexico_City";
	/**
	 * es.
	 */
	private static final String ESPANOL_MIN = "es";
	/**
	 * ES.
	 */
	private static final String ESPANOL_MAY = "MX";

	/**
	 * DateUtils.
	 */
	private DateUtils() {
	}

	/**
	 * Gets the past month.
	 * 
	 * @param month
	 *            the month
	 * @return the past month.
	 */
	public static int getPastMonth(final int month) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		cal.add(Calendar.MONTH, -month);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * Gets the current month.
	 * 
	 * @return the current month.
	 */
	public static int getCurrentMonth() {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		return cal.get(Calendar.MONTH);
	}

	/**
	 * Gets the current date.
	 * 
	 * @return the current date.
	 */
	public static Date getCurrentDate() {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		return cal.getTime();
	}

	/**
	 * Gets the first day of month.
	 * 
	 * @param month
	 *            the month to obtains the date.
	 * @return the first day of month.
	 */
	public static Date getFirstDayOfMonth(final int month) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		cal.set(cal.get(Calendar.YEAR), month, 1);
		return cal.getTime();
	}

	/**
	 * Gets the last day of month.
	 * 
	 * @param month
	 *            the month to obtains the date.
	 * @return the first day of month.
	 */
	public static Date getLastDayOfMonth(final int month) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		cal.set(cal.get(Calendar.YEAR), month, 1);
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

	/**
	 * Gets the date with a format.
	 * 
	 * @param format
	 *            The format of date.
	 * @param dateToFormat
	 *            Date to format
	 * @return Date formatted.
	 */
	public static String getDateWithFormat(final String format, final Date dateToFormat) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(format,
				new Locale(DateUtils.ESPANOL_MIN, DateUtils.ESPANOL_MAY));
		return dateFormat.format(dateToFormat);
	}

	/**
	 * Gets the month as string like Lunes, Martes..
	 * 
	 * @param month
	 *            number of past month to subtract to the current.
	 * @return Month as string.
	 */
	public static String getMonth(final int month) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));

		cal.add(Calendar.MONTH, -month);
		return parseMonth(cal.get(Calendar.MONTH));
	}

	/**
	 * Gets the first day of week.
	 * 
	 * @return date as Date.
	 */
	public static Date getFirstDayOfFourWeekAgo() {
		final int weeksAgo = -4;
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		cal.add(Calendar.WEEK_OF_YEAR, weeksAgo);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		return cal.getTime();
	}

	/**
	 * Gets the first day of week..
	 * 
	 * @return date as Date.
	 */
	public static Date getFirstDayOfWeek() {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		return cal.getTime();
	}

	/**
	 * Gets the first day of week..
	 * 
	 * @return date as Date.
	 */
	public static Date getFirstDayWeekAgo(final int weeksAgo) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		cal.add(Calendar.WEEK_OF_YEAR, weeksAgo);
		cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
		return cal.getTime();
	}

	/**
	 * Parse month number to string.
	 * 
	 * @param month
	 *            Month number.
	 * @return Month as string.
	 */
	private static String parseMonth(final int month) {
		String monthString = "";
		switch (month) {
		case 0:
			monthString = "Enero";
			break;
		case 1:
			monthString = "Febrero";
			break;
		case 2:
			monthString = "Marzo";
			break;
		case 3:
			monthString = "Abril";
			break;
		case 4:
			monthString = "Mayo";
			break;
		case 5:
			monthString = "Junio";
			break;
		case 6:
			monthString = "Julio";
			break;
		case 7:
			monthString = "Agosto";
			break;
		case 8:
			monthString = "Septiembre";
			break;
		case 9:
			monthString = "Octubre";
			break;
		case 10:
			monthString = "Noviembre";
			break;
		case 11:
			monthString = "Diciembre";
			break;
		default:
			break;
		}
		return monthString;
	}

	/**
	 * Convert to Date a String in format dd/mm/yyyy.
	 * 
	 * @param sDate
	 *            String
	 * @return the date
	 */
	public static Date getDate(final String sDate) {
		StringTokenizer st = new StringTokenizer(sDate, "/");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone(DateUtils.AMERICA));
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(st.nextToken()));
		calendar.set(Calendar.MONTH, Integer.parseInt(st.nextToken()) - 1);
		calendar.set(Calendar.YEAR, Integer.parseInt(st.nextToken()));
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * get the next day.
	 * 
	 * @param startDate
	 *            initial date
	 * @return next day
	 */
	public static Date getNextDay(final Date startDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endDate = calendar.getTime();

		return endDate;
	}
}
