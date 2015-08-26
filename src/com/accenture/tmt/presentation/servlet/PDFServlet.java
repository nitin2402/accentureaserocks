package com.accenture.tmt.presentation.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.commons.io.FileUtils;

import com.accenture.tmt.common.RolloffPdf;
import com.accenture.tmt.dao.dto.EmployeeDetailsFlatDTO;
import com.accenture.tmt.manager.PDFcontroller;
import com.itextpdf.text.DocumentException;

/**
 * Servlet implementation class PDFServlet
 */
public class PDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PDFServlet() {
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
		
		
		File file = new File("C://Users/gunveen.kaur.gulati/workspace/TMT/WebContent/pdfdoc/");
        FileUtils.cleanDirectory(file);
       
	
		PDFcontroller controller =new PDFcontroller();
		String userName = request.getParameter("userName");
		
		
		controller.rollOffEmployee(userName);
		

		EmployeeDetailsFlatDTO emp = controller.FetchEmployeeList(userName);
		RolloffPdf rolloffPdf = new RolloffPdf(emp.getEmpName(), emp.getDesignation(), emp.getLevel(), emp.getEmail(), emp.getLastWD(), emp.getEmpId(), emp.getClientId());
		try {
			rolloffPdf.enter();
		}
		
		catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("message", "");
    	response.sendRedirect("rollOff.jsp");
	}

}
