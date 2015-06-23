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
import com.accenture.tmt.common.CONSTANTS;


/**
 * Servlet implementation class StoreServlet
 */
public class StoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int a=0;
		PrintWriter out = response.getWriter();
		try {
			Connection con = DBConnection.getConnection();
			Statement st = con.createStatement();
			//FileInputStream file = new FileInputStream(new File("C:/Users/simlee.das/Desktop/employee_details.xlsx"));
			String file21=request.getParameter(CONSTANTS.FILE_NAME);

		    FileInputStream file = new FileInputStream(file21);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// 1st table
			String sheetno = request.getParameter(CONSTANTS.SHEET_NO); 
			int sno =Integer.parseInt(sheetno);
		
			XSSFSheet empDetails = workbook.getSheetAt(sno-1);

			Iterator<Row> rowIterator = empDetails.iterator();

			while (rowIterator.hasNext()) {
				Row rowOfEmployee = rowIterator.next();

			a= st.executeUpdate(CONSTANTS.EMPLOYEE_INSERT
						+ rowOfEmployee.getCell(0) + "','"
						+ rowOfEmployee.getCell(1) + "','"
						+ rowOfEmployee.getCell(2) + "','"
						+ rowOfEmployee.getCell(3) + "','"
						+ rowOfEmployee.getCell(4) + "','"
						+ rowOfEmployee.getCell(5) + "','"
								+ rowOfEmployee.getCell(6) + "','"
										+ rowOfEmployee.getCell(7) + "')");
/*if(con != null)
a = st.executeUpdate("insert into Employee values('1.0899658E7','Surendra Kushwaha','9.0','Team Lead','BED','sk0069','surendra.kushwaha@accenture.com','TE-003')");
else
	System.out.println("no connection");*/
			}
			// 2nd table
			/*XSSFSheet projectDetails = workbook.getSheetAt(1);
			Iterator<Row> rowIterator1 = projectDetails.iterator();

			while (rowIterator1.hasNext()) {
				Row rowOfEmployee2 = rowIterator1.next();

				st.executeUpdate("insert into Table2(Name,Project_Name,Project_Manager) values('"
						+ rowOfEmployee2.getCell(0)
						+ "','"
						+ rowOfEmployee2.getCell(1)
						+ "','"
						+ rowOfEmployee2.getCell(2) + "')");
			}
			// 3rd shteet
			XSSFSheet address = workbook.getSheetAt(2);
			Iterator<Row> rowIterator2 = address.iterator();

			while (rowIterator2.hasNext()) {
				Row rowOfEmployee21 = rowIterator2.next();

				st.executeUpdate("insert into Table3(Name,Address) values('"
						+ rowOfEmployee21.getCell(0) + "','"
						+ rowOfEmployee21.getCell(1)

						+ "')");
			}
			// 4th sheet
			XSSFSheet exp = workbook.getSheetAt(3);
			Iterator<Row> rowIterator23 = exp.iterator();

			while (rowIterator23.hasNext()) {
				Row rowOfEmployee22 = rowIterator23.next();

				st.executeUpdate("insert into Table4(Name,Experience) values('"
						+ rowOfEmployee22.getCell(0) + "','"
						+ rowOfEmployee22.getCell(1)

						+ "')");

			}
			//5th sheet
			XSSFSheet phone = workbook.getSheetAt(4);
			Iterator<Row> rowIterator4 = phone.iterator();

			while (rowIterator4.hasNext()) {
				Row rowOfEmployee4 = rowIterator4.next();

				st.executeUpdate("insert into Table5(Name,Phone) values('"
						+ rowOfEmployee4.getCell(0) + "','"
						+ rowOfEmployee4.getCell(1)

						+ "')");

			}*/
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
		if(a>0)
		{
		request.setAttribute("message","Record Inserted");
		request.getRequestDispatcher("addempvia.jsp").forward(request, response);
		}
		else
		{
		request.setAttribute("message","Record Insertion Failed");
		request.getRequestDispatcher("addempvia.jsp").forward(request, response);
		}
	}
}
