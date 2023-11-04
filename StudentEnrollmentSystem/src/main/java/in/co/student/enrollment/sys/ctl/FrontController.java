/*
 * DOUNGALA NZOYEM LEON MARTIAL - Matricola: 001447064

   INGEGNERIA - INGEGNERIA INFORMATICA E DELL'AUTOMAZIONE CURR. ARTIFICIAL INTELLIGENCE
   
   Project : Student Enrollement 
 * 
 * 
 */

package in.co.student.enrollment.sys.ctl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import in.co.student.enrollment.sys.util.ServletUtility;




/**
 * Servlet Filter implementation class FrontController
 */
/**
 * Main Controller performs session checking and logging operations before
 * calling any application controller.It prevents any user to access
 * application without login.
 * 
 */
@WebFilter(filterName="FrontCtl",urlPatterns={"/ctl/*","/doc/*"})
public class FrontController implements Filter {

	private static Logger log=Logger.getLogger(FrontController.class);
	
	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException {
		log.debug("FrontController doFilter method start");
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(true);
	
		
		
		if (session.getAttribute("user") == null) {
			
			ServletUtility.setErrorMessage("Your session has been expired. Please re-Login.", request);
			
			String hitUri=request.getRequestURI();
		
			req.setAttribute("uri", hitUri);			
			
			ServletUtility.forward("/login", request, response);
			
		} else {
			chain.doFilter(req, resp);
			System.out.println("respronse front coltoller");
		}
		log.debug("FrontController doFilter method end");
	}
	

	public void init(FilterConfig conf) throws ServletException {
		// TODO Auto-generated method stub

	}

}
