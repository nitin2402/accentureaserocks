package com.accenture.tmt.presentation.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

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
        
        ServletContext context = getServletContext();
        String filePath = context.getInitParameter("file-upload");
        
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

            // displays done.jsp page after upload finished
            request.setAttribute("message", "File Successfully Uploaded");
            getServletContext().getRequestDispatcher("/admin_initiative.jsp").forward(
                    request, response);

        } catch (SizeLimitExceededException e){
        	request.setAttribute("message", "File size should not exceed 1 MB. Upload Unsuccessful.");
            getServletContext().getRequestDispatcher("/admin_initiative.jsp").forward(
                    request, response);
        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

}