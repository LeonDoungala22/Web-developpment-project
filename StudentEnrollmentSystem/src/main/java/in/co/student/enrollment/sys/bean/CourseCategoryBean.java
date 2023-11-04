/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */



package in.co.student.enrollment.sys.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseCategoryBean extends BaseBean{
	
	private String name;
	private String description;
	
	public String getKey() {
		return String.valueOf(id);
	}

	public String getValue() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
