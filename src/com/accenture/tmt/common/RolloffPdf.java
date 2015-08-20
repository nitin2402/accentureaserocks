package com.accenture.tmt.common;

import java.io.FileOutputStream;
import java.io.IOException;
 




import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Ref;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class RolloffPdf {
 
	
    /** The resulting PDF file. */
    public static final String RESULT
        = "C:/Users/priyam.kanungo/workspace/TMT Test/WebContent/template/ExitCheckList.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 9,
    	      Font.BOLD);
    private static Font catFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 8,
  	      Font.BOLD, BaseColor.LIGHT_GRAY);
    private static Font Currier = new Font(Font.FontFamily.TIMES_ROMAN, 9,
  	     Font.NORMAL);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
    	      Font.NORMAL, BaseColor.RED);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
  	      Font.NORMAL, BaseColor.LIGHT_GRAY);
    
    private static String employeeName;
    private static String employeeDesignation;
    private static String employeeLevel;
    private static String employeeEmail;
    private static String employeeLastDay;
    private static String employeeId;
    private static String clientId;
    
    public RolloffPdf(String name, String designation, String level, String email, String lastDay, String empId, String client){
    	employeeName = name ;
    	employeeDesignation = designation ;
    	employeeLevel = level ;
    	employeeEmail = email ;
    	employeeLastDay = lastDay ;
    	employeeId = empId;
    	clientId = client;
    	
    	System.out.println(employeeName);
    }
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public void enter() throws IOException, DocumentException {
        new RolloffPdf(employeeName, employeeDesignation, employeeLevel, employeeEmail, employeeLastDay, employeeId, clientId).createPdf(RESULT);
    }
 
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        addImage(document);
        addContent(document);
      
        // step 4
        
        document.add(createFirstTable());
        document.add(createSecondTable());
        addContent1(document);
        document.add(createThirdTable());
        document.add(createFourthTable());
        addContent2(document);
        document.add(paragraph);
        document.add(paragraph1);
        addContent3(document);
        addContent4(document);
        addContent5(document);
        
        // step 5
        document.close();
    }

	
	private void addContent(Document document) throws DocumentException {
		// TODO Auto-generated method stub
	
		  Chunk sigUnderline = new Chunk("EXIT CHECKLIST - BANG 6", catFont);
		    sigUnderline.setUnderline(0.1f, -2f);
		    Paragraph para = new Paragraph();
		    para.add(sigUnderline);
		    para.setAlignment(Element.ALIGN_CENTER);
		    document.add(para);
		    
	}

	
 
    /**
     * Creates our first table
     * @return our first table
     */
    public static PdfPTable createFirstTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(20); 
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("1) Team Member Details",catFont));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        // now we add a cell with rowspan 2
    
        // we add the four remaining cells with addCell()
        table.addCell(new PdfPCell(new Phrase("Full Name",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeName,Currier)));
        table.addCell(new PdfPCell(new Phrase("Workstation No.",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Employee SAP ID",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeId,Currier)));
        table.addCell(new PdfPCell(new Phrase("Desktop DTP / Laptop LTP #",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Access Card Number",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Hostname/service tag ",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Level/Designation",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeLevel+"/"+employeeDesignation,Currier)));
        table.addCell(new PdfPCell(new Phrase("Extension Number",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Roll off/Resignation DATE",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeLastDay,Currier)));
        table.addCell(new PdfPCell(new Phrase("Mobile Number",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Roll Off / Resigned",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("ARISTOS Email ID ",Currier)));
        table.addCell(new PdfPCell(new Phrase(clientId +"@att.com",Currier)));
        table.addCell(new PdfPCell(new Phrase("Accenture Email ID",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeEmail,Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));

        return table;
    }
    
    public static PdfPTable createSecondTable() {
    	PdfPTable table = new PdfPTable(4);
    	 table.setWidthPercentage(100f);
    	PdfPCell cell;
        cell = new PdfPCell(new Phrase("2) Project Assignment",catFont));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        table.addCell(new PdfPCell(new Phrase("Domain Name",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Visa Type",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
		return table;
    	
    }
    private void addContent1(Document document) throws DocumentException {
		// TODO Auto-generated method stub
	
		  Chunk sigUnderline = new Chunk("Checklist when Contractors/Employees are Rolled-Off/Resigned:", catFont);
		    sigUnderline.setUnderline(0.1f, -2f);
		    Paragraph para = new Paragraph();
		    para.add(sigUnderline);
		    para.setAlignment(Element.ALIGN_CENTER);
		    document.add(para);
		  
	}

    public static PdfPTable createThirdTable() {
    	
 
    	float[] columnWidths = {1f, 6f, 3f, 2f, 1.5f, 2f, 1.5f};
    	
   
    	PdfPTable table = new PdfPTable(columnWidths);
    	 table.setWidthPercentage(100f);
    	table.setSpacingBefore(10); 
    	table.addCell(new PdfPCell(new Phrase("Sl",catFont)));
    	table.addCell(new PdfPCell(new Phrase("Descriptions",catFont)));
        table.addCell(new PdfPCell(new Phrase("Responsibility",catFont)));
        table.addCell(new PdfPCell(new Phrase("Extension",catFont)));
        table.addCell(new PdfPCell(new Phrase("Team",catFont)));
        table.addCell(new PdfPCell(new Phrase("Workstation #",catFont)));
        table.addCell(new PdfPCell(new Phrase("Signature",catFont)));
        table.addCell(new PdfPCell(new Phrase("1",Currier)));
        table.addCell(new PdfPCell(new Phrase("Return locker keys to F&S, Photo Id & Access cards(resigned resources) to F&S Helpdesk",Currier)));
        table.addCell(new PdfPCell(new Phrase("Self",Currier)));
    	PdfPCell cell = new PdfPCell(new Phrase(""));
    	cell.setRowspan(4);
    	table.addCell(cell);
    	PdfPCell cell1 = new PdfPCell(new Phrase(""));
    	cell1.setRowspan(4);
    	table.addCell(cell1);
    	PdfPCell cell2 = new PdfPCell(new Phrase(""));
    	cell2.setRowspan(4);
    	table.addCell(cell2);
    	PdfPCell cell3 = new PdfPCell(new Phrase(""));
    	cell3.setRowspan(4);
    	table.addCell(cell3);
    	 table.addCell(new PdfPCell(new Phrase("2",Currier)));
         table.addCell(new PdfPCell(new Phrase("SMS and MYTE is submitted & got approved",Currier)));
         table.addCell(new PdfPCell(new Phrase("Supervisor/Self",Currier)));
         table.addCell(new PdfPCell(new Phrase("3",Currier)));
         table.addCell(new PdfPCell(new Phrase("Received Assignment closure feedback from current supervisor",Currier)));
         table.addCell(new PdfPCell(new Phrase("TL/AM/PM",Currier)));
         table.addCell(new PdfPCell(new Phrase("4",Currier)));
         table.addCell(new PdfPCell(new Phrase("Tel Alerts & Outage Alerts Disable (App Ops)",Currier)));
         table.addCell(new PdfPCell(new Phrase("Supervisor/Self",Currier)));
    	table.addCell(new PdfPCell(new Phrase("5",Currier)));
        table.addCell(new PdfPCell(new Phrase("Rolled off Resources approval ",Currier)));
        table.addCell(new PdfPCell(new Phrase("Ashraf",Currier)));
        table.addCell(new PdfPCell(new Phrase("73269",Currier)));
        table.addCell(new PdfPCell(new Phrase("RMPMO",Currier)));
        table.addCell(new PdfPCell(new Phrase("B6A.05.220",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("6",Currier)));
        table.addCell(new PdfPCell(new Phrase("Disable records from MME",Currier)));
        table.addCell(new PdfPCell(new Phrase("Ashraf /Priyanka",Currier)));
        table.addCell(new PdfPCell(new Phrase("73269/73268",Currier)));
        table.addCell(new PdfPCell(new Phrase("RMPMO",Currier)));
        table.addCell(new PdfPCell(new Phrase("B6A.05.223",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("7",Currier)));
        table.addCell(new PdfPCell(new Phrase("Deactivation of Domain id, E-Mail Id (Contract Resources), Distro updation",Currier)));
        PdfPCell cell4 = new PdfPCell(new Phrase("Jagan/Chandan",Currier));
    	cell4.setRowspan(4);
    	table.addCell(cell4);
    	PdfPCell cell5 = new PdfPCell(new Phrase("41065004",Currier));
    	cell5.setRowspan(4);
    	table.addCell(cell5);
    	PdfPCell cell6 = new PdfPCell(new Phrase("PMO",Currier));
    	cell6.setRowspan(4);
    	table.addCell(cell6);
    	PdfPCell cell7 = new PdfPCell(new Phrase("BDC6A.07.140",Currier));
    	cell7.setRowspan(4);
    	table.addCell(cell7);
    	PdfPCell cell8 = new PdfPCell(new Phrase("",Currier));
    	cell8.setRowspan(4);
    	table.addCell(cell8);
        table.addCell(new PdfPCell(new Phrase("8",Currier)));
        table.addCell(new PdfPCell(new Phrase("Release WS from Abacus Capacity Planning",Currier)));
        table.addCell(new PdfPCell(new Phrase("9",Currier)));
        table.addCell(new PdfPCell(new Phrase("Access Cards-Deactivation",Currier)));
        table.addCell(new PdfPCell(new Phrase("10",Currier)));
        table.addCell(new PdfPCell(new Phrase("Return Secure ID, Project Laptop, Headset",Currier)));
        table.addCell(new PdfPCell(new Phrase("11 ",Currier)));
        table.addCell(new PdfPCell(new Phrase("Visa Status – Disabled",Currier)));
        table.addCell(new PdfPCell(new Phrase("Jagan/Chandan",Currier)));
        table.addCell(new PdfPCell(new Phrase("41065004",Currier)));
        table.addCell(new PdfPCell(new Phrase("PMO",Currier)));
        table.addCell(new PdfPCell(new Phrase("BDC6A.07.140",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("12",Currier)));
        table.addCell(new PdfPCell(new Phrase("Pager",Currier)));
        PdfPCell cell9 = new PdfPCell(new Phrase("Jagan/Chandan",Currier));
    	cell9.setRowspan(3);
    	table.addCell(cell9);
    	PdfPCell cell10 = new PdfPCell(new Phrase("41065004",Currier));
    	cell10.setRowspan(3);
    	table.addCell(cell10);
    	PdfPCell cell11 = new PdfPCell(new Phrase("PMO",Currier));
    	cell11.setRowspan(3);
    	table.addCell(cell11);
    	PdfPCell cell12 = new PdfPCell(new Phrase("BDC6A.07.140",Currier));
    	cell12.setRowspan(3);
    	table.addCell(cell12);
    	PdfPCell cell13 = new PdfPCell(new Phrase("",Currier));
    	cell13.setRowspan(3);
    	table.addCell(cell13);
        table.addCell(new PdfPCell(new Phrase("13",Currier)));
        table.addCell(new PdfPCell(new Phrase("RA Laptop, Cell Phone & Data Card (App Ops) Rental Laptop submit to DCN Team",Currier)));
        table.addCell(new PdfPCell(new Phrase("14",Currier)));
        table.addCell(new PdfPCell(new Phrase("System Format",Currier)));
        table.addCell(new PdfPCell(new Phrase("15",Currier)));
        table.addCell(new PdfPCell(new Phrase("Rolled off / Resigned Resources approval",Currier)));
        PdfPCell cell14 = new PdfPCell(new Phrase("Sushma/Niranjan/Pooja",Currier));
    	cell14.setRowspan(2);
    	table.addCell(cell14);
    	PdfPCell cell15 = new PdfPCell(new Phrase("8884402069",Currier));
    	cell15.setRowspan(2);
    	table.addCell(cell15);
    	PdfPCell cell16 = new PdfPCell(new Phrase("HR",Currier));
    	cell16.setRowspan(2);
    	table.addCell(cell16);
    	PdfPCell cell17 = new PdfPCell(new Phrase(""));
    	cell17.setRowspan(2);
    	table.addCell(cell17);
        PdfPCell cell18 = new PdfPCell(new Phrase(""));
    	cell18.setRowspan(2);
    	table.addCell(cell18);
    	
        table.addCell(new PdfPCell(new Phrase("16",Currier)));
        table.addCell(new PdfPCell(new Phrase("CV is updated in my Scheduling",Currier)));
        table.setSpacingAfter(15); 
        
        
		return table;
    }
    public static PdfPTable createFourthTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("3) Reviewed by",catFont));
        cell.setColspan(6);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        table.addCell(new PdfPCell(new Phrase("Name of Team Lead",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Name of Employee/Contractor",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Name of Project Manager",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Signature",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Signature",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Signature",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.setSpacingAfter(15);
		return table;
    
    }
    private void addContent2(Document document) throws DocumentException {
		// TODO Auto-generated method stub
	
		  Chunk sigUnderline = new Chunk("Return the Exit Checklist to PMO after getting all necessary signatures", catFont);
		    sigUnderline.setUnderline(0.1f, -2f);
		    Paragraph para = new Paragraph();
		    para.add(sigUnderline);
		    para.setAlignment(Element.ALIGN_CENTER);
		    document.add(para);
		    document.add( Chunk.NEWLINE );
		    
	}
    static Paragraph paragraph = new Paragraph("Note: As per contractual agreements, your access to the Aristos bays will be disabled on the immediate next day of your roll-off from the project"+
	"Please ensure to complete all exit formalities on time.", redFont);
    
    Paragraph paragraph1 = new Paragraph("*Imp: Please DO NOT charge to the project WBS in ARTES after the date of your roll off." +
    "Please refer to the mail from IDC Scheduling OR call the HR Helpline on 2222 to get the WBS that you need to use after your roll-off date", redFont);

    private void addContent3(Document document) throws DocumentException{
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    Paragraph paragraph = new Paragraph("PRIVATE/PROPRIETARY", catFont1);
    paragraph.setAlignment(Element.ALIGN_CENTER);
    document.add(paragraph);

    }
    private void addContent4(Document document) throws DocumentException{
    	Paragraph paragraph = new Paragraph("Contains private and/or proprietary information."+
    "\n"+ " May not be used or disclosed outside Accenture except pursuant to a written agreement", normalFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
    }
    private void addContent5(Document document) throws DocumentException{
    	document.add( Chunk.NEWLINE );
    Paragraph paragraph = new Paragraph("©1996-2003 Accenture All Rights Reserved", normalFont);
    paragraph.setAlignment(Element.ALIGN_LEFT);
    document.add(paragraph);
    }
    
    private void addImage(Document document) throws DocumentException, MalformedURLException, IOException{
    	document.add( Chunk.NEWLINE );
    	String imageUrl = "http://www.yourlocalunitedway.org/sites/main/files/imagecache/lightbox/main-images/high_res_logo_gray_cmyk.jpg";

        Image image = Image.getInstance(new URL(imageUrl));
        image.setAbsolutePosition(70f, 770f);
        image.scaleAbsolute(100f, 70f);
        document.add(image);
    }
}
    
    

package com.accenture.tmt.common;

import java.io.FileOutputStream;
import java.io.IOException;
 




import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Ref;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class RolloffPdf {
 
	
    /** The resulting PDF file. */
    public static final String RESULT
        = "C:/Users/priyam.kanungo/workspace/TMT Test/WebContent/template/ExitCheckList.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 9,
    	      Font.BOLD);
    private static Font catFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 8,
  	      Font.BOLD, BaseColor.LIGHT_GRAY);
    private static Font Currier = new Font(Font.FontFamily.TIMES_ROMAN, 9,
  	     Font.NORMAL);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
    	      Font.NORMAL, BaseColor.RED);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,
  	      Font.NORMAL, BaseColor.LIGHT_GRAY);
    
    private static String employeeName;
    private static String employeeDesignation;
    private static String employeeLevel;
    private static String employeeEmail;
    private static String employeeLastDay;
    private static String employeeId;
    private static String clientId;
    
    public RolloffPdf(String name, String designation, String level, String email, String lastDay, String empId, String client){
    	employeeName = name ;
    	employeeDesignation = designation ;
    	employeeLevel = level ;
    	employeeEmail = email ;
    	employeeLastDay = lastDay ;
    	employeeId = empId;
    	clientId = client;
    	
    	System.out.println(employeeName);
    }
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public void enter() throws IOException, DocumentException {
        new RolloffPdf(employeeName, employeeDesignation, employeeLevel, employeeEmail, employeeLastDay, employeeId, clientId).createPdf(RESULT);
    }
 
    /**
     
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        addImage(document);
        addContent(document);
      
        // step 4
        
        document.add(createFirstTable());
        document.add(createSecondTable());
        addContent1(document);
        document.add(createThirdTable());
        document.add(createFourthTable());
        addContent2(document);
        document.add(paragraph);
        document.add(paragraph1);
        addContent3(document);
        addContent4(document);
        addContent5(document);
        
        // step 5
        document.close();
    }

	
	private void addContent(Document document) throws DocumentException {
		// TODO Auto-generated method stub
	
		  Chunk sigUnderline = new Chunk("EXIT CHECKLIST - BANG 6", catFont);
		    sigUnderline.setUnderline(0.1f, -2f);
		    Paragraph para = new Paragraph();
		    para.add(sigUnderline);
		    para.setAlignment(Element.ALIGN_CENTER);
		    document.add(para);
		    
	}

	
 
    /**
     * Creates our first table
     * @return our first table
     */
    public static PdfPTable createFirstTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(20); 
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("1) Team Member Details",catFont));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        // now we add a cell with rowspan 2
    
        // we add the four remaining cells with addCell()
        table.addCell(new PdfPCell(new Phrase("Full Name",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeName,Currier)));
        table.addCell(new PdfPCell(new Phrase("Workstation No.",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Employee SAP ID",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeId,Currier)));
        table.addCell(new PdfPCell(new Phrase("Desktop DTP / Laptop LTP #",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Access Card Number",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Hostname/service tag ",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Level/Designation",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeLevel+"/"+employeeDesignation,Currier)));
        table.addCell(new PdfPCell(new Phrase("Extension Number",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Roll off/Resignation DATE",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeLastDay,Currier)));
        table.addCell(new PdfPCell(new Phrase("Mobile Number",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Roll Off / Resigned",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("ARISTOS Email ID ",Currier)));
        table.addCell(new PdfPCell(new Phrase(clientId +"@att.com",Currier)));
        table.addCell(new PdfPCell(new Phrase("Accenture Email ID",Currier)));
        table.addCell(new PdfPCell(new Phrase(employeeEmail,Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));

        return table;
    }
    
    public static PdfPTable createSecondTable() {
    	PdfPTable table = new PdfPTable(4);
    	 table.setWidthPercentage(100f);
    	PdfPCell cell;
        cell = new PdfPCell(new Phrase("2) Project Assignment",catFont));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        table.addCell(new PdfPCell(new Phrase("Domain Name",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Visa Type",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
		return table;
    	
    }
    private void addContent1(Document document) throws DocumentException {
		// TODO Auto-generated method stub
	
		  Chunk sigUnderline = new Chunk("Checklist when Contractors/Employees are Rolled-Off/Resigned:", catFont);
		    sigUnderline.setUnderline(0.1f, -2f);
		    Paragraph para = new Paragraph();
		    para.add(sigUnderline);
		    para.setAlignment(Element.ALIGN_CENTER);
		    document.add(para);
		  
	}

    public static PdfPTable createThirdTable() {
    	
 
    	float[] columnWidths = {1f, 6f, 3f, 2f, 1.5f, 2f, 1.5f};
    	
   
    	PdfPTable table = new PdfPTable(columnWidths);
    	 table.setWidthPercentage(100f);
    	table.setSpacingBefore(10); 
    	table.addCell(new PdfPCell(new Phrase("Sl",catFont)));
    	table.addCell(new PdfPCell(new Phrase("Descriptions",catFont)));
        table.addCell(new PdfPCell(new Phrase("Responsibility",catFont)));
        table.addCell(new PdfPCell(new Phrase("Extension",catFont)));
        table.addCell(new PdfPCell(new Phrase("Team",catFont)));
        table.addCell(new PdfPCell(new Phrase("Workstation #",catFont)));
        table.addCell(new PdfPCell(new Phrase("Signature",catFont)));
        table.addCell(new PdfPCell(new Phrase("1",Currier)));
        table.addCell(new PdfPCell(new Phrase("Return locker keys to F&S, Photo Id & Access cards(resigned resources) to F&S Helpdesk",Currier)));
        table.addCell(new PdfPCell(new Phrase("Self",Currier)));
    	PdfPCell cell = new PdfPCell(new Phrase(""));
    	cell.setRowspan(4);
    	table.addCell(cell);
    	PdfPCell cell1 = new PdfPCell(new Phrase(""));
    	cell1.setRowspan(4);
    	table.addCell(cell1);
    	PdfPCell cell2 = new PdfPCell(new Phrase(""));
    	cell2.setRowspan(4);
    	table.addCell(cell2);
    	PdfPCell cell3 = new PdfPCell(new Phrase(""));
    	cell3.setRowspan(4);
    	table.addCell(cell3);
    	 table.addCell(new PdfPCell(new Phrase("2",Currier)));
         table.addCell(new PdfPCell(new Phrase("SMS and MYTE is submitted & got approved",Currier)));
         table.addCell(new PdfPCell(new Phrase("Supervisor/Self",Currier)));
         table.addCell(new PdfPCell(new Phrase("3",Currier)));
         table.addCell(new PdfPCell(new Phrase("Received Assignment closure feedback from current supervisor",Currier)));
         table.addCell(new PdfPCell(new Phrase("TL/AM/PM",Currier)));
         table.addCell(new PdfPCell(new Phrase("4",Currier)));
         table.addCell(new PdfPCell(new Phrase("Tel Alerts & Outage Alerts Disable (App Ops)",Currier)));
         table.addCell(new PdfPCell(new Phrase("Supervisor/Self",Currier)));
    	table.addCell(new PdfPCell(new Phrase("5",Currier)));
        table.addCell(new PdfPCell(new Phrase("Rolled off Resources approval ",Currier)));
        table.addCell(new PdfPCell(new Phrase("Ashraf",Currier)));
        table.addCell(new PdfPCell(new Phrase("73269",Currier)));
        table.addCell(new PdfPCell(new Phrase("RMPMO",Currier)));
        table.addCell(new PdfPCell(new Phrase("B6A.05.220",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("6",Currier)));
        table.addCell(new PdfPCell(new Phrase("Disable records from MME",Currier)));
        table.addCell(new PdfPCell(new Phrase("Ashraf /Priyanka",Currier)));
        table.addCell(new PdfPCell(new Phrase("73269/73268",Currier)));
        table.addCell(new PdfPCell(new Phrase("RMPMO",Currier)));
        table.addCell(new PdfPCell(new Phrase("B6A.05.223",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("7",Currier)));
        table.addCell(new PdfPCell(new Phrase("Deactivation of Domain id, E-Mail Id (Contract Resources), Distro updation",Currier)));
        PdfPCell cell4 = new PdfPCell(new Phrase("Jagan/Chandan",Currier));
    	cell4.setRowspan(4);
    	table.addCell(cell4);
    	PdfPCell cell5 = new PdfPCell(new Phrase("41065004",Currier));
    	cell5.setRowspan(4);
    	table.addCell(cell5);
    	PdfPCell cell6 = new PdfPCell(new Phrase("PMO",Currier));
    	cell6.setRowspan(4);
    	table.addCell(cell6);
    	PdfPCell cell7 = new PdfPCell(new Phrase("BDC6A.07.140",Currier));
    	cell7.setRowspan(4);
    	table.addCell(cell7);
    	PdfPCell cell8 = new PdfPCell(new Phrase("",Currier));
    	cell8.setRowspan(4);
    	table.addCell(cell8);
        table.addCell(new PdfPCell(new Phrase("8",Currier)));
        table.addCell(new PdfPCell(new Phrase("Release WS from Abacus Capacity Planning",Currier)));
        table.addCell(new PdfPCell(new Phrase("9",Currier)));
        table.addCell(new PdfPCell(new Phrase("Access Cards-Deactivation",Currier)));
        table.addCell(new PdfPCell(new Phrase("10",Currier)));
        table.addCell(new PdfPCell(new Phrase("Return Secure ID, Project Laptop, Headset",Currier)));
        table.addCell(new PdfPCell(new Phrase("11 ",Currier)));
        table.addCell(new PdfPCell(new Phrase("Visa Status – Disabled",Currier)));
        table.addCell(new PdfPCell(new Phrase("Jagan/Chandan",Currier)));
        table.addCell(new PdfPCell(new Phrase("41065004",Currier)));
        table.addCell(new PdfPCell(new Phrase("PMO",Currier)));
        table.addCell(new PdfPCell(new Phrase("BDC6A.07.140",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("12",Currier)));
        table.addCell(new PdfPCell(new Phrase("Pager",Currier)));
        PdfPCell cell9 = new PdfPCell(new Phrase("Jagan/Chandan",Currier));
    	cell9.setRowspan(3);
    	table.addCell(cell9);
    	PdfPCell cell10 = new PdfPCell(new Phrase("41065004",Currier));
    	cell10.setRowspan(3);
    	table.addCell(cell10);
    	PdfPCell cell11 = new PdfPCell(new Phrase("PMO",Currier));
    	cell11.setRowspan(3);
    	table.addCell(cell11);
    	PdfPCell cell12 = new PdfPCell(new Phrase("BDC6A.07.140",Currier));
    	cell12.setRowspan(3);
    	table.addCell(cell12);
    	PdfPCell cell13 = new PdfPCell(new Phrase("",Currier));
    	cell13.setRowspan(3);
    	table.addCell(cell13);
        table.addCell(new PdfPCell(new Phrase("13",Currier)));
        table.addCell(new PdfPCell(new Phrase("RA Laptop, Cell Phone & Data Card (App Ops) Rental Laptop submit to DCN Team",Currier)));
        table.addCell(new PdfPCell(new Phrase("14",Currier)));
        table.addCell(new PdfPCell(new Phrase("System Format",Currier)));
        table.addCell(new PdfPCell(new Phrase("15",Currier)));
        table.addCell(new PdfPCell(new Phrase("Rolled off / Resigned Resources approval",Currier)));
        PdfPCell cell14 = new PdfPCell(new Phrase("Sushma/Niranjan/Pooja",Currier));
    	cell14.setRowspan(2);
    	table.addCell(cell14);
    	PdfPCell cell15 = new PdfPCell(new Phrase("8884402069",Currier));
    	cell15.setRowspan(2);
    	table.addCell(cell15);
    	PdfPCell cell16 = new PdfPCell(new Phrase("HR",Currier));
    	cell16.setRowspan(2);
    	table.addCell(cell16);
    	PdfPCell cell17 = new PdfPCell(new Phrase(""));
    	cell17.setRowspan(2);
    	table.addCell(cell17);
        PdfPCell cell18 = new PdfPCell(new Phrase(""));
    	cell18.setRowspan(2);
    	table.addCell(cell18);
    	
        table.addCell(new PdfPCell(new Phrase("16",Currier)));
        table.addCell(new PdfPCell(new Phrase("CV is updated in my Scheduling",Currier)));
        table.setSpacingAfter(15); 
        
        
		return table;
    }
    public static PdfPTable createFourthTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("3) Reviewed by",catFont));
        cell.setColspan(6);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(cell);
        table.addCell(new PdfPCell(new Phrase("Name of Team Lead",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Name of Employee/Contractor",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Name of Project Manager",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Signature",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Signature",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.addCell(new PdfPCell(new Phrase("Signature",Currier)));
        table.addCell(new PdfPCell(new Phrase("",Currier)));
        table.setSpacingAfter(15);
		return table;
    
    }
    private void addContent2(Document document) throws DocumentException {
		// TODO Auto-generated method stub
	
		  Chunk sigUnderline = new Chunk("Return the Exit Checklist to PMO after getting all necessary signatures", catFont);
		    sigUnderline.setUnderline(0.1f, -2f);
		    Paragraph para = new Paragraph();
		    para.add(sigUnderline);
		    para.setAlignment(Element.ALIGN_CENTER);
		    document.add(para);
		    document.add( Chunk.NEWLINE );
		    
	}
    static Paragraph paragraph = new Paragraph("Note: As per contractual agreements, your access to the Aristos bays will be disabled on the immediate next day of your roll-off from the project"+
	"Please ensure to complete all exit formalities on time.", redFont);
    
    Paragraph paragraph1 = new Paragraph("*Imp: Please DO NOT charge to the project WBS in ARTES after the date of your roll off." +
    "Please refer to the mail from IDC Scheduling OR call the HR Helpline on 2222 to get the WBS that you need to use after your roll-off date", redFont);

    private void addContent3(Document document) throws DocumentException{
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    	document.add( Chunk.NEWLINE );
    Paragraph paragraph = new Paragraph("PRIVATE/PROPRIETARY", catFont1);
    paragraph.setAlignment(Element.ALIGN_CENTER);
    document.add(paragraph);

    }
    private void addContent4(Document document) throws DocumentException{
    	Paragraph paragraph = new Paragraph("Contains private and/or proprietary information."+
    "\n"+ " May not be used or disclosed outside Accenture except pursuant to a written agreement", normalFont);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
    }
    private void addContent5(Document document) throws DocumentException{
    	document.add( Chunk.NEWLINE );
    Paragraph paragraph = new Paragraph("©1996-2003 Accenture All Rights Reserved", normalFont);
    paragraph.setAlignment(Element.ALIGN_LEFT);
    document.add(paragraph);
    }
    
    private void addImage(Document document) throws DocumentException, MalformedURLException, IOException{
    	document.add( Chunk.NEWLINE );
    	String imageUrl = "http://www.yourlocalunitedway.org/sites/main/files/imagecache/lightbox/main-images/high_res_logo_gray_cmyk.jpg";

        Image image = Image.getInstance(new URL(imageUrl));
        image.setAbsolutePosition(70f, 770f);
        image.scaleAbsolute(100f, 70f);
        document.add(image);
    }
}
    
    

