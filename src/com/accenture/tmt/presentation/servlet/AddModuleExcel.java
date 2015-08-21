package com.accenture.tmt.presentation.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.accenture.tmt.common.CONSTANTS;
import com.accenture.tmt.manager.ExcelController;
import com.accenture.tmt.manager.ModuleReportController;
import com.accenture.tmt.presentation.dto.ModuleFormDTO;
import com.accenture.tmt.presentation.dto.ModuleReportUpdateDTO;
import com.accenture.tmt.presentation.dto.TeamFormDTO;

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
		int maxFileSize = 5000 * 1024;
		   int maxMemSize = 5000 * 1024;


		File file=null;
		//String sheetno = null;
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request);

	        if (!isMultipart) {
	            return;
	        }
	        
		ServletContext context = getServletContext();
		String filePath = context.getInitParameter("file-upload");

		file = new File(filePath);
		FileUtils.cleanDirectory(file);

		DiskFileItemFactory factory = new DiskFileItemFactory();
		XSSFWorkbook workbook = null;
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
				    
				    
				    /*if ( filename.isFormField () )
				    
				    {
				    sheetno=filename.getString();
				    }	
				    else          	
				    {*/
		
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
				   
				   /* }*/
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
			int sno =1;
			 workbook = new XSSFWorkbook(file);
			XSSFSheet projectDetails = workbook.getSheetAt(sno-1);
			List<ModuleFormDTO> listOfModule = new ArrayList<ModuleFormDTO>();
			
			ModuleFormDTO moduleFormDTO = null;
			HttpSession session1 = request.getSession();
			ModuleReportUpdateDTO reportupdatedto = new ModuleReportUpdateDTO();
			ModuleReportController modulereportcontroller = new ModuleReportController();
			
			java.sql.Date sqlDate=null;
			
			SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			Date date = new Date();
			 String timestamp= df.format(date);
			 sqlDate= new java.sql.Date(date.getTime());
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
				if(session1!= null){
					for(int i =0;i<listOfModule.size();i++){
					reportupdatedto.setModuleId(listOfModule.get(i).getModuleId());
					reportupdatedto.setModuleName(listOfModule.get(i).getModuleName());
					reportupdatedto.setProjectId(listOfModule.get(i).getProjectId());
					reportupdatedto.setModuleDescription(listOfModule.get(i).getModuleDescription());
					reportupdatedto.setUserName((String)session1.getAttribute("user"));
					reportupdatedto.setAction("added by excel");
					reportupdatedto.setTimeStamp(timestamp);
					reportupdatedto.setDates(sqlDate);
				modulereportcontroller.updateModuleReport(reportupdatedto);
				}
				}
				request.getRequestDispatcher("addmodulevia.jsp").forward(request, response);}
			if(c == 0){
				request.setAttribute("message","Record insertion failed");
				request.getRequestDispatcher("addmodulevia.jsp").forward(request, response);}
				
			workbook.close();
				
			} catch (java.lang.IllegalArgumentException |IllegalStateException e) {
				
				e.printStackTrace();
				request.setAttribute("message","Error in parsing XLS :Please choose a excel file with correct template and proper format. ");
				request.getRequestDispatcher("admintool.jsp").forward(request, response);
			}
			
			catch (ClassNotFoundException | InvalidFormatException e) {
				
				e.printStackTrace();
				request.setAttribute("message","Error :- Please ensure that the uploaded file is in correct format ");
				request.getRequestDispatcher("admintool.jsp").forward(request, response);
			}
			catch (IOException e) {
			
				e.printStackTrace();
				request.setAttribute("message","Error in parsing XLS :Please choose a excel file with correct template ");
				request.getRequestDispatcher("admintool.jsp").forward(request, response);
			} catch (SQLException e) {
				
				e.printStackTrace();
				request.setAttribute("message",e.getMessage());
				request.getRequestDispatcher("admintool.jsp").forward(request, response);
			} catch (Exception e) {
			
				System.out.println("Error in parsing XLS : ");
				e.printStackTrace();
				request.setAttribute("message","Error in parsing XLS :Please choose a excel file with correct template ");
				request.getRequestDispatcher("admintool.jsp").forward(request, response);
				}finally {
					workbook.close();
				}
			
			}
			

	}



