package com.accenture.tmt.presentation.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.manager.ExcelController;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;

/**
 * Servlet implementation class AddModuleExcel
 */

public class AddModuleExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddModuleExcel() {
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
		
		try {
					
			String file1 = request.getParameter(CONSTANTS.FILE_NAME);
			String sheetno = request.getParameter(CONSTANTS.SHEET_NO); 
			FileInputStream file = new FileInputStream(file1);
			int sno =Integer.parseInt(sheetno);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet projectDetails = workbook.getSheetAt(sno-1);
			List<ModuleFormDTO> listOfModule = new ArrayList<ModuleFormDTO>();
			
			ModuleFormDTO moduleFormDTO = null;
		
				boolean headerRow = true;
				for (Row rowOfModule : projectDetails) {
					
					if(headerRow != true){
						
					moduleFormDTO = new ModuleFormDTO();
					int cellCount = 0;
					for (Cell cellForModule : rowOfModule) {
						
							if (cellCount == 0 &&  cellForModule.getStringCellValue() != null && !cellForModule.getStringCellValue().equalsIgnoreCase("ModuleName")) {
								moduleFormDTO.setModuleName(cellForModule.getStringCellValue());
							} else if (cellCount == 1 && cellForModule.getStringCellValue() != null && !cellForModule.getStringCellValue().equalsIgnoreCase("ProjectId")) {
								moduleFormDTO.setProjectId(cellForModule.getStringCellValue());
							} else if (cellCount == 2 && cellForModule.getStringCellValue() != null && !cellForModule.getStringCellValue().equalsIgnoreCase("ModuleId")){
								moduleFormDTO.setModuleId(cellForModule.getStringCellValue());
							} else if (cellCount == 3 && cellForModule.getStringCellValue() != null && !cellForModule.getStringCellValue().equalsIgnoreCase("ModuleDescription")) {
								moduleFormDTO.setModuleDescription(cellForModule.getStringCellValue());
							}
							else if (cellCount == 4 && cellForModule.getStringCellValue() != null && !cellForModule.getStringCellValue().equalsIgnoreCase("Status")) {
								moduleFormDTO.setStatus(cellForModule.getStringCellValue());
							}
							
							cellCount++;
					}
					
					listOfModule.add(moduleFormDTO);
					
					}
					else{
						headerRow = false;
					}
					
				} 
			
			int c=0;
			ExcelController add = new ExcelController();
			c=add.addModuleFromExcel(listOfModule);
			

			if(c!=0){
				request.setAttribute("message","Record Inserted");
				request.getRequestDispatcher("addmodulevia.jsp").forward(request, response);}
			if(c == 0){
				request.setAttribute("message","Record insertion failed");
				request.getRequestDispatcher("addmodulevia.jsp").forward(request, response);}
				
			workbook.close();
				file.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
}


