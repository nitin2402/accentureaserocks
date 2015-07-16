package com.accenture.tmt.presentation.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.manager.ExcelController;
import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;



/**
 * Servlet implementation class AddEmployeeExcel
 */
public class AddEmployeeExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeExcel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try {
					
			String file1 = request.getParameter(CONSTANTS.FILE_NAME);
			String sheetno = request.getParameter(CONSTANTS.SHEET_NO); 
			FileInputStream file = new FileInputStream(file1);
			int sno =Integer.parseInt(sheetno);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet projectDetails = workbook.getSheetAt(sno-1);
			List<EmployeeDetailsDTO> listOfEmps = new ArrayList<EmployeeDetailsDTO>();
			
			EmployeeDetailsDTO empDetailsDto = null;

			boolean headerRow = true;
			for (Row rowOfEmployee1 : projectDetails) {
				
				if(headerRow != true){
					
				
				empDetailsDto = new EmployeeDetailsDTO();
				int cellCount = 0;
				for (Cell cellForEmp : rowOfEmployee1) {
					
						if (cellCount == 0 &&  cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeId")) {
							empDetailsDto.setEmpId(cellForEmp.getStringCellValue());
						} else if (cellCount == 1 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeName")) {
							empDetailsDto.setEmpName(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 2 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeDesignation")) {
							empDetailsDto.setDesignation(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 3 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeLevel")) {
							empDetailsDto.setLevel(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 4 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeExpertise")) {
							empDetailsDto.setExpertise(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 5 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeAttId")) {
							empDetailsDto.setClientId(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 6 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeEmail")) {
							empDetailsDto.setEmail(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 7 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("TeamId")) {
							empDetailsDto.setTeamId(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 8 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ProficiencyCamps")) {
							empDetailsDto.setProfCamps(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 9 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ProficiencyProject")) {
							empDetailsDto.setProfProject(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 10 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("DateofJoining")) {
							empDetailsDto.setDoj(cellForEmp.getStringCellValue());
						}
						else if (cellCount == 11 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("LastWorkingDay")) {
							empDetailsDto.setLastWD(cellForEmp.getStringCellValue());
						}
						else if (cellCount == 12 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("Billable")) {
							empDetailsDto.setIsBillable(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 13 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ActiveUser")) {
							empDetailsDto.setIsActive(cellForEmp
									.getStringCellValue());
						}
						
						else if (cellCount == 14 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("LCR")) {
							empDetailsDto.setIsActive(cellForEmp
									.getStringCellValue());
						}
						
						cellCount++;
				}
				listOfEmps.add(empDetailsDto);
				
				}else{
					
					
					headerRow = false;
				}
			}
	
			
			int c=0;
		
			ExcelController add = new ExcelController();
			
			try {
				c=add.addFromExcel(listOfEmps);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if(c !=0){
			request.setAttribute("message","Record Inserted");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		if(c ==0){
			request.setAttribute("message","Record insertion failed"+"\n"+"Please choose a excel file with correct template ");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		workbook.close();
			file.close();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in parsing XLS : ");
			e.printStackTrace();
			request.setAttribute("message","Error in parsing XLS :Please choose a excel file with correct template ");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		
		}
	}
