 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <table id="fileTable" class="table table-striped">
            <thead>
                <tr>
                    <th>Sr. No.</th>
                    <th>File Name</th>
                </tr>
            </thead>
            <tbody>
            <jsp:useBean id="DS" class="com.app.entity.DataStore"/>
            <c:set var="list" value="${DS.list}"/>
            <c:set var="i"  value="1"/>
                <c:forEach var="fileName" items="${list}">
                    <tr>
                        <td>${i}</td>
                        <td>${fileName}</td>
                    </tr>
                    <c:set var="i" value="${i+1}"/>
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