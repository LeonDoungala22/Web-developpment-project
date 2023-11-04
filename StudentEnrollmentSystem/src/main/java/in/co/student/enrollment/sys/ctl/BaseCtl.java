/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */

package in.co.student.enrollment.sys.ctl;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.student.enrollment.sys.bean.BaseBean;
import in.co.student.enrollment.sys.bean.UserBean;
import in.co.student.enrollment.sys.util.DataUtility;
import in.co.student.enrollment.sys.util.DataValidator;
import in.co.student.enrollment.sys.util.ServletUtility;



/**
 * Servlet implementation class BaseCtl
 */
/**
 * Base controller class of project. It contain (1) Generic operations (2)
 * Generic constants (3) Generic work flow
 * 
 */
@WebServlet("/BaseCtl")
public abstract class BaseCtl extends HttpServlet {
	private static final Logger log = Logger.getLogger(BaseCtl.class.getName());

	public static final String OP_SAVE = "Save";
	public static final String OP_CANCEL = "Cancel";
	public static final String OP_DELETE = "Delete";
	public static final String OP_LIST = "List";
	public static final String OP_SEARCH = "Search";
	public static final String OP_VIEW = "View";
	public static final String OP_NEXT = "Next";
	public static final String OP_PREVIOUS = "Previous";
	public static final String OP_NEW = "New";
	public static final String OP_GO = "Go";
	public static final String OP_BACK = "Back";
	public static final String OP_LOG_OUT = "Logout";
	public static final String OP_RESET = "Reset";
	public static final String OP_CONFIRM_PAY = "Confirm And Payment";
	public static final String OP_BOOK_PAY = "Book And Payment";

	public static final String MSG_SUCCESS = "success";

	public static final String MSG_ERROR = "error";

	public BaseCtl() {
	}

	protected boolean validate(HttpServletRequest request) {
		return true;

	}

	protected void preload(HttpServletRequest request) {
	}

	protected BaseBean populateBean(HttpServletRequest request) {
		return null;
	}

	protected BaseBean populateDTO(BaseBean dto, HttpServletRequest request) {
		log.info("BaseCtl populate DTO method start");
		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		if (user == null) {
			createdBy = "root";
			modifiedBy = "root";
		} else {

			modifiedBy = user.getUserName();

			if ("null".equalsIgnoreCase(createdBy) || DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}

		}
	
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDatetime(DataUtility.getTimestamp(cdt));
		} else {
			dto.setCreatedDatetime(DataUtility.getCurrentTimestamp());
		}

		dto.setModifiedDatetime(DataUtility.getCurrentTimestamp());

		log.info("BaseCtl populate DTO method end");
		return dto;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("BaseCtl service method start");

		preload(request);

		String op = DataUtility.getString(request.getParameter("operation"));

		if (DataValidator.isNotNull(op) && !OP_CANCEL.equalsIgnoreCase(op) && !OP_VIEW.equalsIgnoreCase(op)
				&& !OP_DELETE.equalsIgnoreCase(op) && !OP_RESET.equalsIgnoreCase(op)) {
			if (!validate(request)) {
				BaseBean bean = (BaseBean) populateBean(request);
				ServletUtility.setBean(bean, request);
				ServletUtility.forward(getView(), request, response);
				return;
			}
		}

		log.info("BaseCtl service method end");
		super.service(request, response);
	}

	protected abstract String getView();

}
