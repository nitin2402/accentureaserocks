package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PDFcontroller controller =new PDFcontroller();
		String userName = request.getParameter("userName");
		EmployeeDetailsFlatDTO emp = controller.FetchEmployeeList(userName);
		System.out.println(emp.getEmpName());
		RolloffPdf rolloffPdf = new RolloffPdf(emp.getEmpName(), emp.getDesignation(), emp.getLevel(), emp.getEmail(), emp.getLastWD(), emp.getEmpId(), emp.getClientId());
		try {
			rolloffPdf.enter();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 PrintWriter out = response.getWriter(  );
		    response.setContentType("text/html");
		   out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Download</title>");
		    out.println("<script type=\"text/javascript\"> function openTab(th) ");
		    out.println("{");
		    out.println("window.open(th.name,'_blank');");
		    out.println("}");
		    out.println("</script>");
		    out.println("</head>");
		    out.println("<body bgcolor=\"white\">");
		    out.println("<a onclick=\"openTab(this)\" href='#' name=\"template/ExitCheckList.pdf\">Download Check List Form</a>");
		    out.println("</body>");
		    out.println("</html>");
	}

}
