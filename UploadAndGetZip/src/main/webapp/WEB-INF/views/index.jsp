 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>File Upload</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-4">
    <h3>Upload File</h3>
    <div class="row my-2">
        <form method="post" action="upload" enctype="multipart/form-data" class="form-control">
            <div class="col-md-4">
                <b>Upload file</b>
            </div>
            <div class="col-md-8">
                <input type="file" name="file" id="fileInput" onchange="showFilePath()">
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Upload</button>
        </form>

        <form method="get" action="download/${fileName}" class="form-control">
            <div class="col-md-4">
                <b>Download Zip File</b>
            </div>
            <br>
            <button class="btn btn-success" type="submit">Download</button>
        </form>
    </div>
</div>

<div class="container my-4">
    <h3>Uploaded Files</h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Sr. No.</th>
                    <th>File Name</th>
                </tr>
            </thead>
            <tbody>
                <%-- Iterate through the list of uploaded files and display each file name --%>
                <c:forEach var="file" items="${list}">
                    <tr>
                        <%-- Use 'varStatus' to get the current iteration count --%>
                        <td>${fileStatus.index + 1}</td>
                        <td>${file.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
</body>
</html>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 <%--  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.springframework.web.servlet.mvc.support.RedirectAttributes" %>
    <%@page import="com.app.controller.FileController" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>

 
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">


    
    
</head>
<body>
<div class="container my-4">
    <h3>Upload File</h3>
    <div class="row my-2">
        <form method="post" action="upload" enctype="multipart/form-data" class="form-control">
        
        
            <div class="col-md-4">
                <b>Upload file</b>
            </div>
            <div class="col-md-8">
                
                <input type="file" name="file" id="fileInput" onchange="showFilePath()">
            </div>
            <br>
            <button class="btn btn-primary" type="submit">Upload</button>
        </form>

        <form method="get" action="download/${fileName}" class="form-control">
            <div class="col-md-4">
                <b>Download Zip File</b>
            </div>
            <br>
            <button class="btn btn-success" type="submit">Download</button>
        </form>
        
        
        
        <div class="container my-4">
    <h3>Uploaded Files</h3>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Sr. No.</th>
                    <th>File Name</th>
                </tr>
            </thead>
             <tbody>
         
          <c:set var="i" value="1"/>
             <c:forEach var="f" items="${list}"> 
              <tr>
                <td>${i}</td>
                <td>${file.name}</td>
     
              </tr>
               <c:set var="i" value="${i+1}"/>
               </c:forEach>
       </tbody>
        </table>
    </div>
</div>

    
   
  </div>  
</div>




</body>

</html> 
 --%>


