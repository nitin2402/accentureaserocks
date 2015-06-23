package com.accenture.tmt.presentation.servlet;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.tmt.common.DBConnection;


/**
 * Servlet implementation class StoreTeam
 */
public class StoreTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreTeam() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String password = "";
			String dbName = "C:/Users/devraj.bisi/Desktop/Database5.accdb";
			String bd = dbName + ";PWD=" + password;
			String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="
					+ bd + ";";*/
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			//FileInputStream file = new FileInputStream(new File("C:/Users/simlee.das/Desktop/employee_details.xlsx"));
			String file21=request.getParameter("file1");

		    FileInputStream file = new FileInputStream(file21);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// 1st table
			String sheetno = request.getParameter("sheetno"); 
			int sno =Integer.parseInt(sheetno) ;
		
			XSSFSheet empDetails = workbook.getSheetAt(sno-1);

			Iterator<Row> rowIterator = empDetails.iterator();

			while (rowIterator.hasNext()) {
				Row rowOfEmployee = rowIterator.next();

				st.executeUpdate("insert into Team(TeamName,ModuleId,TeamId,TeamDescription) values('"
						+ rowOfEmployee.getCell(0) + "','"
						+ rowOfEmployee.getCell(3)  + "','"
						+ rowOfEmployee.getCell(1)  + "','"
						+ rowOfEmployee.getCell(2)  + "')");
			}
			
			out.print("DATA STORED SUCCESSFULY...PLEASE RETURN");
			workbook.close();
			file.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
response.sendRedirect("addteamvia.jsp");
	}

}
