/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */

package in.co.student.enrollment.sys.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import in.co.student.enrollment.sys.bean.BaseBean;
import in.co.student.enrollment.sys.bean.CourseBean;
import in.co.student.enrollment.sys.exception.ApplicationException;
import in.co.student.enrollment.sys.exception.DuplicateRecordException;
import in.co.student.enrollment.sys.model.CourseCategoryModel;
import in.co.student.enrollment.sys.model.CourseModel;
import in.co.student.enrollment.sys.util.DataUtility;
import in.co.student.enrollment.sys.util.DataValidator;
import in.co.student.enrollment.sys.util.PropertyReader;
import in.co.student.enrollment.sys.util.ServletUtility;



/**
 * Servlet implementation class CourseCtl
 */

@WebServlet(name = "CourseCtl", urlPatterns = { "/ctl/course" })
public class CourseCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(CourseCtl.class);
	
	

	@Override
	protected void preload(HttpServletRequest request) {
		try {
			request.setAttribute("categoryList", new CourseCategoryModel().list());
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}

	protected boolean validate(HttpServletRequest request) {

		log.debug("CourseCtl Method validate Started");

		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("courseCode"))) {
			request.setAttribute("CourseCode", PropertyReader.getValue("error.require", "CourseCode"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", "Name"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("startDate"))) {
			request.setAttribute("startDate", PropertyReader.getValue("error.require", "Start Date"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("totalClass"))) {
			request.setAttribute("totalClass", PropertyReader.getValue("error.require", "Total Class"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("timing"))) {
			request.setAttribute("timing", PropertyReader.getValue("error.require", "Timing"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("cost"))) {
			request.setAttribute("cost", PropertyReader.getValue("error.require", "Cost"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("status"))) {
			request.setAttribute("status", PropertyReader.getValue("error.require", "Status"));
			pass = false;
		}
		
		
		if ("-----Select-----".equalsIgnoreCase(request.getParameter("categoryId"))) {
			request.setAttribute("categoryId", PropertyReader.getValue("error.require", "Category Name"));
			pass = false;
		}
		
		if (DataValidator.isNull(request.getParameter("description"))) {
			request.setAttribute("description", PropertyReader.getValue("error.require", "Description"));
			pass = false;
		}

		log.debug("CourseCtl Method validate Ended");

		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("CourseCtl Method populatebean Started");

		CourseBean bean = new CourseBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setCategoryId(DataUtility.getLong(request.getParameter("categoryId")));
		bean.setCourseCode(DataUtility.getString(request.getParameter("courseCode")));
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setStartDate(DataUtility.getDate(request.getParameter("startDate")));
		bean.setTotalClass(DataUtility.getString(request.getParameter("totalClass")));
		bean.setTiming(DataUtility.getString(request.getParameter("timing")));
		bean.setCost(DataUtility.getString(request.getParameter("cost")));
		bean.setStatus(DataUtility.getString(request.getParameter("status")));
		bean.setDescription(DataUtility.getString(request.getParameter("description")));

		populateDTO(bean, request);

		log.debug("CourseCtl Method populatebean Ended");

		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("StudentCtl Method doGet Started");

		String op = DataUtility.getString(request.getParameter("operation"));

		CourseModel model = new CourseModel();

		long id = DataUtility.getLong(request.getParameter("id"));

		if (id > 0 || op != null) {

			CourseBean bean;
			try {
				bean = model.findByPK(id);

				ServletUtility.setBean(bean, request);

			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("StudentCtl Method doGet Ended");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.debug("CourseCtl Method doPost Started");
		String op = DataUtility.getString(request.getParameter("operation")); 
		CourseModel model = new CourseModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op)) {
			CourseBean bean = (CourseBean) populateBean(request);
			try {
				if (id > 0) {
					model.update(bean);
					ServletUtility.setSuccessMessage("Data is successfully Updated", request);
				} else {
					long pk = model.add(bean);
					ServletUtility.setSuccessMessage("Data is successfully saved", request);
				}
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage(e.getMessage(), request);
			}
			ServletUtility.forward(getView(), request, response);
		} else if (OP_DELETE.equalsIgnoreCase(op)) {
			CourseBean bean = (CourseBean) populateBean(request);
			try {
				model.delete(bean);
				ServletUtility.redirect(SESView.COURSE_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				log.error(e);
				ServletUtility.handleException(e, request, response);
				return;
			}
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(SESView.COURSE_LIST_CTL, request, response);
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(SESView.COURSE_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);
		log.debug("CourseCtl Method doPostEnded");
	}

	@Override
	protected String getView() {
		return SESView.COURSE_VIEW;
	}

}
