package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.WorkPlanController;
import com.accenture.tmt.presentation.dto.WorkplanDTO;

/**
 * Servlet implementation class workplanServlet
 */
public class workplanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public workplanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		WorkplanDTO workplandto = new WorkplanDTO(); 
		
		String userName = request.getParameter("userName");
		int nASE = Integer.parseInt(request.getParameter("NASE"));
		int nSE = Integer.parseInt(request.getParameter("NSE"));
		int nSSE = Integer.parseInt(request.getParameter("NSSE"));
		String comment = request.getParameter("comment");
	
		workplandto.setUserName(userName);
		workplandto.setnASE(nASE);
		workplandto.setnSE(nSE);
		workplandto.setnSSE(nSSE);
		workplandto.setComment(comment);
		
		WorkPlanController workplanController = new WorkPlanController();
		
		String reqId = workplanController.raiseRequest(workplandto);
		
		if(reqId.equalsIgnoreCase("NotInserted")){
			request.setAttribute("message", "Sorry your request can't be submitted.");
			request.getRequestDispatcher("userhome.jsp").forward(request, response);
		} else{
			request.setAttribute("message", "Congrats !!! your request has been submitted.Your Request ID is");
			request.setAttribute("reqId", reqId);
			request.getRequestDispatcher("userhome.jsp").forward(request, response);
		}
		
		
	}

}
