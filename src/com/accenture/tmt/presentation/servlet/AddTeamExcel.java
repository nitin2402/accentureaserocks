package com.accenture.tmt.presentation.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.manager.ExcelController;
import com.accenture.tmt.presentation.dto.TeamFormDTO;

/**
 * Servlet implementation class AddTeamExcel
 */
public class AddTeamExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamExcel() {
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
		
		
					
			String file1 = request.getParameter(CONSTANTS.FILE_NAME);
			String sheetno = request.getParameter(CONSTANTS.SHEET_NO); 
			FileInputStream file = new FileInputStream(file1);
			int sno =Integer.parseInt(sheetno);
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet projectDetails = workbook.getSheetAt(sno-1);
	List<TeamFormDTO> listOfTeams = new ArrayList<TeamFormDTO>();
			
			TeamFormDTO teamFormDto = null;
			boolean headerRow = true;
			for (Row rowOfTeam1 : projectDetails) {
				
				if(headerRow != true){
					
				
				teamFormDto = new TeamFormDTO();
				int cellCount = 0;
				for (Cell cellForTeam : rowOfTeam1){
					
					if (cellCount == 0 &&  cellForTeam.getStringCellValue() != null && !cellForTeam.getStringCellValue().equalsIgnoreCase("TeamName")) {
						teamFormDto.setTeamName(cellForTeam.getStringCellValue());
					} else if (cellCount == 1 && cellForTeam.getStringCellValue() != null && !cellForTeam.getStringCellValue().equalsIgnoreCase("TeamId")) {
						teamFormDto.setTeamId(cellForTeam.getStringCellValue());
					} else if (cellCount == 2 && cellForTeam.getStringCellValue() != null && !cellForTeam.getStringCellValue().equalsIgnoreCase("ModuleId")) {
						teamFormDto.setModuleId(cellForTeam
								.getStringCellValue());
					} else if (cellCount == 3 && cellForTeam.getStringCellValue() != null && !cellForTeam.getStringCellValue().equalsIgnoreCase("TeamDescription")) {
						teamFormDto.setTeamDescription(cellForTeam
								.getStringCellValue());
					} else if (cellCount == 4 && cellForTeam.getStringCellValue() != null && !cellForTeam.getStringCellValue().equalsIgnoreCase("Status")) {
						teamFormDto.setStatus(cellForTeam
								.getStringCellValue());
					}

					cellCount++;
			}
			listOfTeams.add(teamFormDto);
			
			}else{
				headerRow = false;
			}
		}

		
		int c=0;
	
		ExcelController add = new ExcelController();
		
		try {
			c=add.addFromExcel1(listOfTeams);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	if(c !=0){
		request.setAttribute("message","Record Inserted");
		request.getRequestDispatcher("addteamexcel.jsp").forward(request, response);}
	if(c ==0){
		request.setAttribute("message","Record insertion failed");
		request.getRequestDispatcher("addteamexcel.jsp").forward(request, response);}
	workbook.close();
		file.close();
}
	
}









