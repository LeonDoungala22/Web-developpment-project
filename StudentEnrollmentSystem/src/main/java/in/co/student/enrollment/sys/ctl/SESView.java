/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064
   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */

package in.co.student.enrollment.sys.ctl;

public interface SESView {

	public String APP_CONTEXT = "/StudentEnrollmentSystem";

	public String PAGE_FOLDER = "/jsp";

	public String ERROR_VIEW = PAGE_FOLDER + "/Error.jsp";

	public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	public String USER_REGISTRATION_VIEW = PAGE_FOLDER + "/userRegistration.jsp";

	public String LOGIN_VIEW = PAGE_FOLDER + "/login.jsp";
	
	public String COURSE_CATEGORY_VIEW = PAGE_FOLDER + "/courseCategory.jsp";
	public String COURSE_CATEGORY_LIST_VIEW = PAGE_FOLDER + "/courseCategoryList.jsp";
	
	public String COURSE_VIEW = PAGE_FOLDER + "/course.jsp";
	public String COURSE_LIST_VIEW = PAGE_FOLDER + "/courseList.jsp";
	
	public String ENROLL_VIEW = PAGE_FOLDER + "/enroll.jsp";
	public String ENROLL_LIST_VIEW = PAGE_FOLDER + "/enrollList.jsp";
	
	
	public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/studentList.jsp";

	public String WELCOME_VIEW = PAGE_FOLDER + "/welcome.jsp";

	public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER + "/changePassword.jsp";

	public String MY_PROFILE_VIEW = PAGE_FOLDER + "/myProfile.jsp";

	public String FORGET_PASSWORD_VIEW = PAGE_FOLDER + "/forgetPassword.jsp";

	public String ERROR_CTL = "/ctl/ErrorCtl";

	public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	
	public String COURSE_CATEGORY_CTL = APP_CONTEXT + "/ctl/courseCategory";
	public String COURSE_CATEGORY_LIST_CTL = APP_CONTEXT + "/ctl/courseCategoryList";
	
	public String COURSE_CTL = APP_CONTEXT + "/ctl/course";
	public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/courseList";
	
	public String ENROLL_CTL = APP_CONTEXT + "/ctl/enroll";
	public String ENROLL_LIST_CTL = APP_CONTEXT + "/ctl/enrollList";
	
	public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/studentList";

	public String USER_REGISTRATION_CTL = APP_CONTEXT + "/registration";
	public String LOGIN_CTL = APP_CONTEXT + "/login";
	public String WELCOME_CTL = APP_CONTEXT + "/welcome";
	public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";

	public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/changePassword";

	public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/myProfile";

	public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/forgetPassword";

}
