package com.accenture.tmt.presentation.servlet;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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

import com.accenture.tmt.manager.ExcelController;
import com.accenture.tmt.manager.ReportController;

import com.accenture.tmt.presentation.dto.EmployeeDetailsDTO;
import com.accenture.tmt.presentation.dto.EmployeeReportUpdateDTO;




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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException ,IllegalStateException{
		
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
				    
				    
				  /*  if ( filename.isFormField () )
				    
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
				   
				    /*}*/
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
			//int sno =Integer.parseInt(sheetno);
			int sheetnum=1;
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet projectDetails = workbook.getSheetAt(sheetnum-1);
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
						} else if (cellCount == 5 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeClientId")) {
							empDetailsDto.setClientId(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 6 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("EmployeeEmail")) {
							empDetailsDto.setEmail(cellForEmp
									.getStringCellValue());
						} else if (cellCount == 7 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ProjectName")) {
							empDetailsDto.setProjectName(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 8 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ModuleNmae")) {
							empDetailsDto.setModuleName(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 9 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("TeamName")) {
							empDetailsDto.setTeamName(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 10 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ProficiencyCamps")) {
							empDetailsDto.setProfCamps(cellForEmp.getStringCellValue());
						}
						else if (cellCount == 11 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ProficiencyProject")) {
							empDetailsDto.setProfProject(cellForEmp.getStringCellValue());
						}
						else if (cellCount == 12 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("DateofJoining")) {
							empDetailsDto.setDoj(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 13 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("LastWorkingDay")) {
							empDetailsDto.setLastWD(cellForEmp
									.getStringCellValue());
						}
						
						else if (cellCount == 14 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("Billable")) {
							empDetailsDto.setIsBillable(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 15 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("ActiveUser")) {
							empDetailsDto.setIsActive(cellForEmp
									.getStringCellValue());
						}
						else if (cellCount == 16 && cellForEmp.getStringCellValue() != null && !cellForEmp.getStringCellValue().equalsIgnoreCase("LCR")) {
							empDetailsDto.setCost(cellForEmp
									.getStringCellValue());
						}
						
						cellCount++;
							
						
				}
				ExcelController fetchTeamId = new ExcelController();
				empDetailsDto.setTeamId(fetchTeamId.detailsFromExcel(empDetailsDto));
				listOfEmps.add(empDetailsDto);
				
				}else{
					
					
					headerRow = false;
				}
			}
	
			
			int c=0;
		
			ExcelController add = new ExcelController();
			
			HttpSession session1 = request.getSession();
			
					c=add.addFromExcel(listOfEmps);


				  java.sql.Date sqlDate=null;
					
					SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
					Date date = new Date();
					 String timestamp= df.format(date);
					 sqlDate= new java.sql.Date(date.getTime());
					 EmployeeReportUpdateDTO reportupdatedto=new EmployeeReportUpdateDTO();
					ReportController reportcontroller=new ReportController();

		if(c !=0){
			request.setAttribute("message","Record Inserted");
			
			request.getRequestDispatcher("admintool.jsp").forward(request, response);
			if(session1!= null){
				for(int i =0;i<listOfEmps.size();i++){
					reportupdatedto.setEmpId(listOfEmps.get(i).getEmpId());
					reportupdatedto.setEmpName(listOfEmps.get(i).getEmpName());
					reportupdatedto.setDesignation(listOfEmps.get(i).getDesignation());
					reportupdatedto.setLevel(listOfEmps.get(i).getLevel());
					reportupdatedto.setExpertise(listOfEmps.get(i).getExpertise());
					reportupdatedto.setClientId(listOfEmps.get(i).getClientId());
					reportupdatedto.setEmail(listOfEmps.get(i).getEmail());
					 reportupdatedto.setTeamId(listOfEmps.get(i).getTeamId());
					reportupdatedto.setProfCamps(listOfEmps.get(i).getProfCamps());
					reportupdatedto.setProfProject(listOfEmps.get(i).getProfProject());
					reportupdatedto.setDoj(listOfEmps.get(i).getDoj());
					reportupdatedto.setLastWD(listOfEmps.get(i).getLastWD());
					reportupdatedto.setIsBillable(listOfEmps.get(i).getIsBillable());
					reportupdatedto.setIsActive(listOfEmps.get(i).getIsActive());
					reportupdatedto.setCost(listOfEmps.get(i).getCost());
				reportupdatedto.setUserName((String)session1.getAttribute("user"));
				reportupdatedto.setAction("added by excel");
				reportupdatedto.setTimeStamp(timestamp);
				reportupdatedto.setDate(sqlDate);
				reportcontroller.updateEmpreport(reportupdatedto);
			}
				}
			}
		if(c ==0){
			request.setAttribute("message","Record insertion failed"+"\n"+"Please choose a excel file with correct template ");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		workbook.close();
			//file.close();
		}
		catch (java.lang.IllegalArgumentException |IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","Error in parsing XLS :Please choose a excel file with correct template and proper format. ");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);
		}
		
		catch (ClassNotFoundException | InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","Error :- Please ensure that the uploaded file is in correct format ");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","Error in parsing XLS :Please choose a excel file with correct template ");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message",e.getMessage());
			request.getRequestDispatcher("admintool.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error in parsing XLS :Please choose a excel file with correct template ");
			e.printStackTrace();
			request.setAttribute("message","Error in parsing XLS :Please choose a excel file with correct template ");
			request.getRequestDispatcher("admintool.jsp").forward(request, response);}
		
		}
		
		}

	
		
		
		
	
