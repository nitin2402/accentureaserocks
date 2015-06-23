package com.accenture.tmt.presentation.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.BudgetController;



/**
 * Servlet implementation class AddBudget
 */
public class AddBudget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBudget() {
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
		String ASE=request.getParameter("Associate Software Engineer");
		String SE=request.getParameter("Software Engineer");
		String SSE=request.getParameter("Senior Software Engineer");
		String TL=request.getParameter("Team Lead");
		String AM=request.getParameter("Associate Manager");
		String M=request.getParameter("Manager");
		String SM=request.getParameter("Senior Manager");
		
String a[]={ASE,SE,SSE,TL,AM,M,SM};
		
		BudgetController newBudget = new BudgetController();
		int check = newBudget.addBudget(a);
		if(check !=0){
			request.setAttribute("message","Budget values Updated");
			request.getRequestDispatcher("budgetplan.jsp").forward(request, response);}
		if(check ==0){
			request.setAttribute("message","Update failed");
			request.getRequestDispatcher("budgetplan.jsp").forward(request, response);}
	}

}
