/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */

package in.co.student.enrollment.sys.bean;

import java.sql.Timestamp;

import lombok.Data;

/**
 * BaseBean JavaBean encapsulates Generic attributes
 */

@Data
public abstract class BaseBean implements DropdownListBean, Comparable<BaseBean> {
	
	
	protected long id;
	protected String createdBy;
	protected String modifiedBy;
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}


	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}


	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}


	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}


	protected Timestamp createdDatetime;
	protected Timestamp modifiedDatetime;


	public int compareTo(BaseBean b) {
		// TODO Auto-generated method stub
		return getValue().compareTo(b.getValue());
	}
	
	

	
	
	
}
