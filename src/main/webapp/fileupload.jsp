 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>
 
    <body> 
        <div>
            <h3> Task 1:: </h3>
            <form action="upload" method="post" enctype="multipart/form-data">
               <label>Upload excel sheet with proper data</label>
                <input type="file" name="file" />
                <input type="submit" value="Upload" /><br>
                
            </form>          
        </div>
        
        <div>
            <h3> Task 2:: </h3>
            <form action="readAndWriteSheets" method="post" enctype="multipart/form-data">
                <label>Go to process</label>
                <input type="submit" value="Proceed" /><br>
                
            </form>          
        </div>
        
         <div>
            <h3> Task 3:: </h3>
            <form action="sheetsPrepare" method="post" enctype="multipart/form-data">
                <label>Send Mails</label>
                <input type="text" value="mailId">
                 
                <input type="submit" value="Proceed" /><br>
                
            </form>          
        </div>
      
    </body>
</html>
