package com.accenture.tmt.presentation.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.manager.ExcelController;
import com.accenture.tmt.manager.TeamReportController;
import com.accenture.tmt.presentation.dto.TeamFormDTO;
import com.accenture.tmt.presentation.dto.TeamReportUpdateDTO;

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
		int maxFileSize = 5000 * 1024;
		   int maxMemSize = 5000 * 1024;


		File file=null;
		String sheetno = null;
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	        if (!isMultipart) {
	            return;
	        }
	        
		ServletContext context = getServletContext();
		String filePath = context.getInitParameter("file-upload");

		file = new File(filePath);
		FileUtils.cleanDirectory(file);

		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(maxMemSize);

		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(maxFileSize);
		
		
		
		
	        try {
				 List fileItems = upload.parseRequest(request);

		
				 Iterator iterator = fileItems.iterator();

     
				 while ( iterator.hasNext () ) 
				 {
				    FileItem filename = (FileItem)iterator.next();
				    
				    
				    if ( filename.isFormField () )
				    
				    {
				    sheetno=filename.getString();
				    }	
				    else          	
				    {
		
				    String fieldName = filename.getFieldName();
				    String fileName = filename.getName();
				    boolean isInMemory = filename.isInMemory();
				    long sizeInBytes = filename.getSize();
				
				    if( fileName.lastIndexOf("\\") >= 0 ){
				    file = new File( filePath + 
				    fileName.substring( fileName.lastIndexOf("\\"))) ;
				    }else{
				    file = new File( filePath + 
				    fileName.substring(fileName.lastIndexOf("\\")+1)) ;
				    }
				    filename.write( file ) ;
				   
				    }
				 }
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	        try {
					
			//String file1 = request.getParameter(CONSTANTS.FILE_NAME);
			//String sheetno = request.getParameter(CONSTANTS.SHEET_NO); 
			//FileInputStream file = new FileInputStream(file1);
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
	        
           java.sql.Date sqlDate=null;
			
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			 String timestamp= df.format(date);
			 sqlDate= new java.sql.Date(date.getTime());
			 TeamReportUpdateDTO reportupdatedto=new TeamReportUpdateDTO();
			 TeamReportController teamreportcontroller=new TeamReportController();
			int c=0;
			
			ExcelController add = new ExcelController();
			HttpSession session1 = request.getSession();
			
				c=add.addFromExcel1(listOfTeams	);
		 
				if(c !=0){
					request.setAttribute("message","Record Inserted");
					request.getRequestDispatcher("addteamexcel.jsp").forward(request, response);
					if(session1!= null){
						for(int i =0;i<listOfTeams.size();i++){
						reportupdatedto.setModuleId(listOfTeams.get(i).getModuleId());
						reportupdatedto.setTeamName(listOfTeams.get(i).getTeamName());
						reportupdatedto.setTeamId(listOfTeams.get(i).getTeamId());
						reportupdatedto.setTeamDescription(listOfTeams.get(i).getTeamDescription());
						reportupdatedto.setUsername((String)session1.getAttribute("user"));
						reportupdatedto.setAction("added by excel");
						reportupdatedto.setTimestamp(timestamp);
						reportupdatedto.setDate(sqlDate);
						teamreportcontroller.updateTeamReport(reportupdatedto);
					}
						}}
				if(c ==0){
					request.setAttribute("message","Record insertion failed");
					request.getRequestDispatcher("addteamexcel.jsp").forward(request, response);}
		workbook.close();
			//file.close();
		}catch (ClassNotFoundException | InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		
		








