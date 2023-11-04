/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */
package in.co.student.enrollment.sys.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import in.co.student.enrollment.sys.bean.DropdownListBean;





/**
 * HTML Utility class to produce HTML contents like Dropdown List.
 */
public class HTMLUtility {

	public static String getList(String name, String selectedVal,HashMap<String, String> map) {
		
	
		StringBuffer sb = new StringBuffer(	"<select class='form-control bd' name='" + name + "'>");

		Set<String> keys = map.keySet();
		String val = null;
		String select = "-----Select-----";
		sb.append("<option selected value='" + select + "'>" + select+ "</option>");
		for (String key : keys) {
			val = map.get(key);
			if (key.trim().equals(selectedVal)) {

				sb.append("<option selected value='" + key + "'>" + val
						+ "</option>");
			} else {
				sb.append("<option value='" + key + "'>" + val + "</option>");
			}
		}
		sb.append("</select>");
		return sb.toString();
	}

	public static String getList(String name, String selectedVal, List list) {
		
		Collections.sort(list);

		List<DropdownListBean> dd = (List<DropdownListBean>) list;

		StringBuffer sb = new StringBuffer("<select class='form-control bd' name='" + name + "' id='" + name+ "'>");
		
		String key = null;
		
		String val = null;
		
		String select = "-----Select-----";
		
		sb.append("<option selected value='" + select + "'>" + select+ "</option>");
		
		for (DropdownListBean obj : dd) {
			key = obj.getKey();
			val = obj.getValue();

			if (key.trim().equals(selectedVal)) {
				sb.append("<option selected value='" + key + "'>" + val+ "</option>");
			} else {
				sb.append("<option value='" + key + "'>" + val + "</option>");
			}
		}

		sb.append("</select>");
		return sb.toString();
	}
}
