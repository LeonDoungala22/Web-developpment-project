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
import in.co.student.enrollment.sys.bean.EnrollBean;
import in.co.student.enrollment.sys.bean.UserBean;
import in.co.student.enrollment.sys.exception.ApplicationException;
import in.co.student.enrollment.sys.exception.DuplicateRecordException;
import in.co.student.enrollment.sys.model.EnrollModel;
import in.co.student.enrollment.sys.util.DataUtility;
import in.co.student.enrollment.sys.util.ServletUtility;

/**
 * Servlet implementation class EnrollCtl
 */

@WebServlet(name = "EnrollCtl", urlPatterns = { "/ctl/enroll" })
public class EnrollCtl extends BaseCtl {
	private static final long serialVersionUID = 1L;

	private static Logger log = Logger.getLogger(EnrollCtl.class);

	protected boolean validate(HttpServletRequest request) {

		log.debug("EnrollCtl Method validate Started");

		boolean pass = true;

		log.debug("EnrollCtl Method validate Ended");

		return pass;
	}

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {

		log.debug("EnrollCtl Method populatebean Started");

		EnrollBean bean = new EnrollBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		populateDTO(bean, request);

		log.debug("EnrollCtl Method populatebean Ended");

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

		EnrollModel model = new EnrollModel();
		EnrollBean  bean=new EnrollBean();
 
		UserBean uBean = (UserBean) request.getSession().getAttribute("user");

		long cId = DataUtility.getLong(request.getParameter("cId"));
		try {
			if (cId > 0) {
					EnrollBean findByCourseIdAndUserId = model.findByCourseIdAndUserId(cId, uBean.getId());
					if(findByCourseIdAndUserId==null) {
					bean.setCourseId(cId);
					bean.setUserId(uBean.getId());
					model.add((EnrollBean)populateDTO(bean, request));
					}
					ServletUtility.redirect(SESView.ENROLL_LIST_CTL, request, response);
					return;
			}else {
				ServletUtility.redirect(SESView.COURSE_LIST_CTL, request, response);
				return;
			}
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ServletUtility.forward(getView(), request, response);
		log.debug("StudentCtl Method doGet Ended");

	}


	@Override
	protected String getView() {
		return SESView.ENROLL_VIEW;
	}

}
