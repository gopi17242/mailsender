package com.candidjava;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet to handle File upload request from Client
 * @author Javin Paul
 */
public class FileUploadHandler extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:/uploads";
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
     
     	Path workingDirectory=Paths.get(".").toAbsolutePath();
        System.out.println("current dir = " + workingDirectory.getRoot());
        System.out.println("current dir = " + workingDirectory);
     
     
    	 String path = request.getServletContext().getRealPath("/");
    	 System.out.println("path=="+path);
         File f = new File ("/mailsender/myNewFolder" +"myNewFolder");
         f.mkdir();
        
    	

		final String dir = System.getProperty("user.dir");
        System.out.println("current dir send= " + dir);
        File directory = new File(dir+"/gopinadhr");
        directory.mkdir();

    	
    	Path workingDirectory=Paths.get(".").toAbsolutePath();
        System.out.println("current dir = " + workingDirectory.getParent());
     
        ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath(File.separator);
		PrintWriter out1 = response.getWriter();
		out1.println("<br/>File system context path (in TestServlet): " + contextPath);
        System.out.println("contextPath===="+contextPath);
        OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();
    	
        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
              
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
         
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
    
        request.getRequestDispatcher("/result.jsp").forward(request, response);
     
    }
    
    private String getFileName(final Part part) {
        for (String content : part.getHeader("file").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
  
}
