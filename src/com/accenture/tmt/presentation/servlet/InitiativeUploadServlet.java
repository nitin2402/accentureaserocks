package com.accenture.tmt.presentation.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.accenture.tmt.common.DBConnection;


/**
 * Servlet implementation class UploadServlet
 * This is to upload a PDF file from Initiatives.jsp file
 * and that file will be renamed as 'sample.pdf' and stored inside the project itself
 * Then control will return to Initiatives.jsp and display the new document
 */

public class InitiativeUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return;
        }
        
        Properties prop=new Properties();
    	prop.load(DBConnection.class.getClassLoader()
                .getResourceAsStream("config.properties"));
    	String filePath = prop.getProperty("file-upload");
        
        File file = new File(filePath);
        FileUtils.cleanDirectory(file);

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

       /* String absoluteFilePath = getServletContext().getRealPath(DATA_DIRECTORY);*/

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);

        try {
            // Parse the request
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
            	FileItem item = (FileItem)iter.next();
                if (!item.isFormField()) {
                	String fileName = item.getName();
             
                    
                	File uploadedFile = new File( filePath + File.separator +
                            fileName.substring(fileName.lastIndexOf("\\")+1) );
             
                    item.write(uploadedFile);
                    File renameFile = new File( filePath + File.separator +
                            "Sample3.pdf" );
                   	uploadedFile.renameTo(renameFile);
                }
            }
          
            HttpSession Session = request.getSession(true);
            Session.setAttribute("reload", 1);
            response.sendRedirect("admin_initiative.jsp");

        } catch (SizeLimitExceededException e){
        	HttpSession session = request.getSession(false);
        	//save message in session
        	session.setAttribute("message", "File size should not exceed 1 MB. Upload Unsuccessful.");
        	response.sendRedirect("admin_initiative.jsp");
            
        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

}