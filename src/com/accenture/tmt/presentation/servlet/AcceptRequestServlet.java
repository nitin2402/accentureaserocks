package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ActionController;
import com.accenture.tmt.presentation.dto.ActionDTO;

/**
 * Servlet implementation class AcceptRequestServlet
 */
public class AcceptRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptRequestServlet() {
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
		
		int flag = 0;
		
		ActionController controller = new ActionController();
		ActionDTO actiondto = new ActionDTO();
		
		String specificReq = request.getParameter("specificReq");
		String [] empASE = request.getParameterValues("empASE[]");
		String [] empSE = request.getParameterValues("empSE[]");
		String [] empSSE = request.getParameterValues("empSSE[]");
		String reqId = request.getParameter("reqId");
		String reason = request.getParameter("reason");
		
		actiondto.setReqId(reqId);
		actiondto.setReason(reason);

		flag = controller.acceptRequest(empASE, empSE, empSSE,specificReq, actiondto);
		
		if(flag == 1){
			request.setAttribute("reqId", reqId);
			request.setAttribute("result", "Accepted");
			request.getRequestDispatcher("searchrequest.jsp").forward(request, response);
			} else {
				request.setAttribute("reqId", reqId);
				request.setAttribute("result", "Not Accepted");
				request.getRequestDispatcher("searchrequest.jsp").forward(request, response);
			}
		
	}

}
