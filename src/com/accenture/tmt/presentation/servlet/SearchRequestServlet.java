package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.manager.SearchRequestController;
import com.accenture.tmt.presentation.dto.SearchRequestDTO;

/**
 * Servlet implementation class SearchRequestServlet
 */
public class SearchRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRequestServlet() {
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
		
		SearchRequestController controller = new SearchRequestController();
		List<SearchRequestDTO> approved_requests = new ArrayList<SearchRequestDTO>();
		List<SearchRequestDTO> unapproved_requests = new ArrayList<SearchRequestDTO>();
		
		approved_requests = controller.searchApprovedRequests();
		unapproved_requests = controller.searchUnpprovedRequests();
		
		request.setAttribute("approved_requests", approved_requests);
		request.setAttribute("unapproved_requests", unapproved_requests);
	}

}
