package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.accenture.tmt.manager.AuthorizeEmployeeController;
import com.accenture.tmt.presentation.dto.LoginDTO;

/**
 * Servlet implementation class TypeOfUserServlet
 */
public class TypeOfUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypeOfUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AuthorizeEmployeeController authorizecontroller = new AuthorizeEmployeeController();
		
		
		LoginDTO dto = new LoginDTO();
		String select = request.getParameter("select");
		String action = request.getParameter("action");
		dto.setLoginid(select);
		if("Viewer".equals(action)){
			int a = 0;
				 a =  authorizecontroller.vieweremployee(dto);
				if(a == 1){
					request.setAttribute("message", "Authorised as viewer");
					request.getRequestDispatcher("authorizeemployee.jsp").forward(request, response);
				}
		}
		
		else if("User".equals(action)){
			int a =0;
			 a =  authorizecontroller.useremployee(dto);
			 if(a == 1){
				 request.setAttribute("message", "Authorised as user");
					request.getRequestDispatcher("authorizeemployee.jsp").forward(request, response);
			 }
		}
			 else if("Admin".equals(action)){
				 int a = 0;
				 a =  authorizecontroller.adminemployee(dto);
				 if(a == 1){
					 request.setAttribute("message", "Authorised as admin");
					 request.getRequestDispatcher("authorizeemployee.jsp").forward(request, response);
			 }
		}
	}
	
}
