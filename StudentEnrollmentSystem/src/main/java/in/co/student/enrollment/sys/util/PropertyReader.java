/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */

package in.co.student.enrollment.sys.util;

import java.util.ResourceBundle;

/**
 * Read the property values from application properties file using Resource
 * Bundle
 */

public class PropertyReader {

	private static ResourceBundle rb = ResourceBundle.getBundle("system");

	public static String getValue(String key) {

		String val = null;
		try {
			val = rb.getString(key);
		} catch (Exception e) {
			val = key;
		}

		return val;

	}

	public static String getValue(String key, String param) {
		String msg = getValue(key);
		msg = msg.replace("{0}", param);
		return msg;
	}

	public static String getValue(String key, String[] params) {
		String msg = getValue(key);
		for (int i = 0; i < params.length; i++) {
			msg = msg.replace("{" + i + "}", params[i]);
		}
		return msg;
	}

	public static void main(String[] args) {
		String params = "email";
		System.out.println(PropertyReader.getValue("requires", params));
	}

}
