/**
 * SOSExcellence S.A. de C.V. all rights reserved 2016.
 */
package util;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.junit.Test;

import com.biancco.admin.app.util.HTTPUtils;
import com.biancco.admin.persistence.model.EmployeeDetail;
import com.biancco.admin.persistence.model.FolderType;

/**
 * Jackson mapper test.
 * 
 * @author SOSExcellence.
 */
public class JacksonTest {

	@Test
	public void getObjectFromEncodeString() {
		try {
			String encoded = "name=Copado&lastName=Copas&date_born=1980-07-10&address=Tecnologico&phone=722345678&mail=copado%40mail.com";
			EmployeeDetail d = (EmployeeDetail) HTTPUtils.getObjectFromFormString(encoded, EmployeeDetail.class);
			System.out.println(ReflectionToStringBuilder.toString(d));
			// System.out.println(ReflectionToStringBuilder.toString(d.getDate_born().getTime()));
			String date = "1980-12-23";
			System.out.println(((Calendar) castStringToObject(Calendar.class, date)).getTime());

			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue(false);
		}
	}

	public Object castStringToObject(Class<?> clazz, String value) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if (clazz.getName().equals("java.util.Date")) {
				return format.parse(value);
			} else if (clazz.getName().equals("java.util.Calendar")) {
				Method m = clazz.getDeclaredMethod("setTime", Date.class);
				Object cal = Calendar.getInstance();
				m.invoke(cal, format.parse(value));
				return cal;
			}
			Constructor<?> constructor = (Constructor<?>) clazz.getConstructor(new Class<?>[] { String.class });
			return (Object) constructor.newInstance(new Object[] { value });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void testMethod() {
		final String t = "employee";
		FolderType type = FolderType.fromName(t);
		System.out.println(ReflectionToStringBuilder.toString(type));
	}

}
