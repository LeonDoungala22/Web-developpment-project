/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */

package in.co.student.enrollment.sys.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import in.co.student.enrollment.sys.bean.CourseBean;
import in.co.student.enrollment.sys.bean.CourseCategoryBean;
import in.co.student.enrollment.sys.exception.ApplicationException;
import in.co.student.enrollment.sys.exception.DatabaseException;
import in.co.student.enrollment.sys.exception.DuplicateRecordException;
import in.co.student.enrollment.sys.util.JDBCDataSource;




/**
 * JDBC Implementation of CourseModel
 */

public class CourseModel {
	private static Logger log = Logger.getLogger(CourseModel.class.getName());
	

	public Integer nextPK() throws DatabaseException {
		log.info("Model nextPK Started");
		Connection conn = null;
		int pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(ID) FROM Course");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			throw new DatabaseException("Exception : Exception in getting PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.info("Model nextPK End");
		return pk + 1;
	}

	
	public long add(CourseBean bean) throws ApplicationException, DuplicateRecordException {
		
		Connection conn = null;
		int pk = 0;

		CourseBean existbean = findByCourseName(bean.getName());

		if (existbean != null) {
			throw new DuplicateRecordException("CourseName is already exists");
		}
		CourseCategoryBean wBean=new CourseCategoryModel().findByPK(bean.getCategoryId());

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPK();
			conn.setAutoCommit(false); 
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Course VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setLong(2, bean.getCategoryId());
			pstmt.setString(3, wBean.getName());
			pstmt.setString(4, bean.getCourseCode());
			pstmt.setString(5, bean.getName());
			pstmt.setDate(6,new java.sql.Date(bean.getStartDate().getTime()));
			pstmt.setString(7, bean.getTotalClass());
			pstmt.setString(8, bean.getTiming());
			pstmt.setString(9, bean.getCost());
			pstmt.setString(10, bean.getStatus());
			pstmt.setString(11, bean.getDescription());
			pstmt.setString(12, bean.getCreatedBy());
			pstmt.setString(13, bean.getModifiedBy());
			pstmt.setTimestamp(14, bean.getCreatedDatetime());
			pstmt.setTimestamp(15, bean.getModifiedDatetime());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in add Course");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
		return pk;
	}

	
	public void delete(CourseBean bean) throws ApplicationException {
		
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); 			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Course WHERE ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); 
			pstmt.close();

		} catch (Exception e) {
		
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception : Exception in delete Course");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		
	}



	public CourseBean findByCourseName(String name) throws ApplicationException {
		log.info("Model findByLogin Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM Course WHERE Name=?");
		CourseBean bean = null;
		Connection conn = null;
		System.out.println("sql" + sql);

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setCategoryId(rs.getLong(2));
				bean.setCategoryName(rs.getString(3));
				bean.setCourseCode(rs.getString(4));
				bean.setName(rs.getString(5));
				bean.setStartDate(rs.getDate(6));
				bean.setTotalClass(rs.getString(7));
				bean.setTiming(rs.getString(8));
				bean.setCost(rs.getString(9));
				bean.setStatus(rs.getString(10));
				bean.setDescription(rs.getString(11));
				bean.setCreatedBy(rs.getString(12));
				bean.setModifiedBy(rs.getString(13));
				bean.setCreatedDatetime(rs.getTimestamp(14));
				bean.setModifiedDatetime(rs.getTimestamp(15));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception : Exception in getting Course by login");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.info("Model findByLogin End");
		return bean;
	}


	public CourseBean findByPK(long pk) throws ApplicationException {
		log.info("Model findByPK Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM Course WHERE ID=?");
		CourseBean bean = null;
		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setCategoryId(rs.getLong(2));
				bean.setCategoryName(rs.getString(3));
				bean.setCourseCode(rs.getString(4));
				bean.setName(rs.getString(5));
				bean.setStartDate(rs.getDate(6));
				bean.setTotalClass(rs.getString(7));
				bean.setTiming(rs.getString(8));
				bean.setCost(rs.getString(9));
				bean.setStatus(rs.getString(10));
				bean.setDescription(rs.getString(11));
				bean.setCreatedBy(rs.getString(12));
				bean.setModifiedBy(rs.getString(13));
				bean.setCreatedDatetime(rs.getTimestamp(14));
				bean.setModifiedDatetime(rs.getTimestamp(15));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException("Exception : Exception in getting Course by pk");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.info("Model findByPK End");
		return bean;
	}

	

	public void update(CourseBean bean) throws ApplicationException, DuplicateRecordException {
		log.info("Model update Started");
		Connection conn = null;

		CourseBean beanExist = findByCourseName(bean.getName());
		if (beanExist != null && !(beanExist.getId() == bean.getId())) {
			throw new DuplicateRecordException("CourseNo is already exist");
		}
		
		CourseCategoryBean wBean=new CourseCategoryModel().findByPK(bean.getCategoryId());

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false); 
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE Course SET categoryId=?,categoryName=?,CourseCode=?,name=?,startDate=?,totalClass=?,timing=?,cost=?,status=?,Description=?,"
					+ "CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=? WHERE ID=?");
			pstmt.setLong(1, bean.getCategoryId());
			pstmt.setString(2, wBean.getName());
			pstmt.setString(3, bean.getCourseCode());
			pstmt.setString(4, bean.getName());
			pstmt.setDate(5,new java.sql.Date(bean.getStartDate().getTime()));
			pstmt.setString(6, bean.getTotalClass());
			pstmt.setString(7, bean.getTiming());
			pstmt.setString(8, bean.getCost());
			pstmt.setString(9, bean.getStatus());
			pstmt.setString(10, bean.getDescription());
			pstmt.setString(11, bean.getCreatedBy());
			pstmt.setString(12, bean.getModifiedBy());
			pstmt.setTimestamp(13, bean.getCreatedDatetime());
			pstmt.setTimestamp(14, bean.getModifiedDatetime());
			pstmt.setLong(15, bean.getId());
			pstmt.executeUpdate();
			conn.commit(); // End transaction
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception : Delete rollback exception " + ex.getMessage());
			}
			throw new ApplicationException("Exception in updating Course ");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.info("Model update End");
	}

	

	public List<CourseBean> search(CourseBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}


	public List<CourseBean> search(CourseBean bean, int pageNo, int pageSize) throws ApplicationException {
		log.info("Model search Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM Course WHERE 1=1");

		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			
			if (bean.getCategoryId() > 0) {
				sql.append(" AND CategoryId = " + bean.getCategoryId());
			}
			
			if (bean.getCourseCode() != null && bean.getCourseCode().length() > 0) {
				sql.append(" AND CourseCode like '" + bean.getCourseCode() + "%'");
			}
			
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" AND Name like '" + bean.getName() + "%'");
			}
			
			if (bean.getCategoryName() != null && bean.getCategoryName().length() > 0) {
				sql.append(" AND CategoryName like '" + bean.getCategoryName() + "%'");
			}
			
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" Limit " + pageNo + ", " + pageSize);
		}

		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setCategoryId(rs.getLong(2));
				bean.setCategoryName(rs.getString(3));
				bean.setCourseCode(rs.getString(4));
				bean.setName(rs.getString(5));
				bean.setStartDate(rs.getDate(6));
				bean.setTotalClass(rs.getString(7));
				bean.setTiming(rs.getString(8));
				bean.setCost(rs.getString(9));
				bean.setStatus(rs.getString(10));
				bean.setDescription(rs.getString(11));
				bean.setCreatedBy(rs.getString(12));
				bean.setModifiedBy(rs.getString(13));
				bean.setCreatedDatetime(rs.getTimestamp(14));
				bean.setModifiedDatetime(rs.getTimestamp(15));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in search Course");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		log.info("Model search End");
		return list;
	}

	

	public List<CourseBean> list() throws ApplicationException {
		return list(0, 0);
	}



	public List<CourseBean> list(int pageNo, int pageSize) throws ApplicationException {
		log.info("Model list Started");
		ArrayList<CourseBean> list = new ArrayList<CourseBean>();
		StringBuffer sql = new StringBuffer("select * from Course");
	
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
		}

		Connection conn = null;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CourseBean bean = new CourseBean();
				bean.setId(rs.getLong(1));
				bean.setCategoryId(rs.getLong(2));
				bean.setCategoryName(rs.getString(3));
				bean.setCourseCode(rs.getString(4));
				bean.setName(rs.getString(5));
				bean.setStartDate(rs.getDate(6));
				bean.setTotalClass(rs.getString(7));
				bean.setTiming(rs.getString(8));
				bean.setCost(rs.getString(9));
				bean.setStatus(rs.getString(10));
				bean.setDescription(rs.getString(11));
				bean.setCreatedBy(rs.getString(12));
				bean.setModifiedBy(rs.getString(13));
				bean.setCreatedDatetime(rs.getTimestamp(14));
				bean.setModifiedDatetime(rs.getTimestamp(15));
				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			throw new ApplicationException("Exception : Exception in getting list of Course");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

		log.info("Model list End");
		return list;

	}



}
