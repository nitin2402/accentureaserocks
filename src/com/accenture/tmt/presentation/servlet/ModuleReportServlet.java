package com.accenture.tmt.presentation.servlet;

import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.dao.dto.ModuleReportFlatDTO;
import com.accenture.tmt.manager.ModuleReportController;
import com.accenture.tmt.presentation.dto.ModuleReportDTO;

/**
 * Servlet implementation class ModuleReportServlet
 */
public class ModuleReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModuleReportServlet() {
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

		String moduleName = request.getParameter("module");
		String startDate = request.getParameter(CONSTANTS.GET_START_DATE_FOR_MODULE_REPORT);
		String endDate = request.getParameter(CONSTANTS.GET_END_DATE_FOR_MODULE_REPORT);
		String action = request.getParameter("action");
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		// SimpleDateFormat df1 = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate1 = null;

		Date endDate1 = null;
		java.sql.Date sqlStart = null;
		java.sql.Date sqlEnd = null;
		try {
			startDate1 = df.parse(startDate);
			sqlStart = new java.sql.Date(startDate1.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			endDate1 = df.parse(endDate);
			sqlEnd = new java.sql.Date(endDate1.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
		ModuleReportDTO modulereportdto = new ModuleReportDTO();
		modulereportdto.setModuleName(moduleName);
		modulereportdto.setStartDate(sqlStart);
		modulereportdto.setEndDate(sqlEnd);
		modulereportdto.setAction(action);
		if ((moduleName == null || moduleName == "") && (startDate1 == null) && (endDate1 == null)
				&& (action==null || action =="")) {
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithoutAnything(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if (modulereportlist.isEmpty()) {
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			} else {
				request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}

		else if( (startDate1 == null )&& (endDate1 == null )&& (action == null || action =="" )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithOnlyModuleName(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if((moduleName == null || moduleName == "") && (endDate1 == null )&& (action == null || action =="")){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithOnlyStartDate(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if((moduleName == null || moduleName == "") && (startDate1 == null )&& (action == null || action =="" )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithOnlyEndDate(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if((moduleName == null || moduleName == "") && (endDate1 == null )&& (startDate1 == null )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithOnlyAction(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		
		else if(  (endDate1 == null )&& (action == null || action =="" )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithoutEndDate(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if(  (startDate1 == null )&& (action == null || action =="")){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithoutStartDate(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if(  (startDate1 == null )&& (endDate1 == null )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithOnlyModuleName_With_Action(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if(  (moduleName == null || moduleName == "")&& (action == null || action =="")){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithoutModuleName(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if(  (moduleName == null || moduleName == "")&&  (endDate1 == null )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithOnlyStartDate_With_Action(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if(  (moduleName == null || moduleName == "")&&  (startDate1 == null )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithOnlyEndDate_With_Action(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if( (action==null || action =="" )){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModule(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else if(  (startDate1==null)){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithoutStartDate_With_Action(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}else if(  (endDate1==null)){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithoutEndDate_With_Action(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}else if(  (moduleName == null || moduleName == "")){
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModuleWithoutModuleName_With_Action(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		else {
			ModuleReportController fetch = new ModuleReportController();
			List<ModuleReportFlatDTO> modulereportlist = new ArrayList<ModuleReportFlatDTO>();
			modulereportlist = fetch.reportModule_With_Action(modulereportdto);
			request.setAttribute("ReportList", modulereportlist);
			if(modulereportlist.isEmpty()){
				response.sendRedirect("modulereportdetail.jsp?msg=Details are not found.");
			}
			else{
			request.getRequestDispatcher("modulereportdetail.jsp").forward(request, response);
			}
		}
		
		
		}
}
