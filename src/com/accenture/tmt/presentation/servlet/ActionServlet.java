package com.accenture.tmt.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.ActionController;
import com.accenture.tmt.manager.WorkplanAdminController;
import com.accenture.tmt.presentation.dto.ActionDTO;
import com.accenture.tmt.presentation.dto.WorkplanAdminDTO;

/**
 * Servlet implementation class ActionServlet
 */
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
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
		ActionController controller = new ActionController();
		WorkplanAdminController workplanAdminController = new WorkplanAdminController();
		WorkplanAdminDTO workplanAdminDTO = new WorkplanAdminDTO();
		
		ActionDTO actiondto = new ActionDTO();
		int flag = 0;
		String reqId = request.getParameter("select");
		String action = request.getParameter("action");
		String reason = request.getParameter("reason");
		
		actiondto.setReqId(reqId);
		actiondto.setReason(reason);

		if ("Calculate".equals(action)) {
			
			workplanAdminDTO = workplanAdminController.fetchCalculationDetails(actiondto);
			request.setAttribute("workplanAdminDTO", workplanAdminDTO);
			request.getRequestDispatcher("action.jsp").forward(request, response);
			
		} else if ("Accept".equals(action)) {
			flag = controller.acceptRequest(actiondto);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("searchrequest.jsp").forward(request, response);
		} else if ("Reject".equals(action)) {
			flag = controller.rejectRequest(actiondto);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("searchrequest.jsp").forward(request, response);
		} else if ("OnHold".equals(action)) {
			flag = controller.onholdRequest(actiondto);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("searchrequest.jsp").forward(request, response);
		}
	}

}
