<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
     
    
</head>
    <title>Write In Excel</title>
</head>
<body>
    <form action="downloadExcel" method="post">
    <br>
    <br>
    <center><h3>Write Text here and Download it into an Excel File</h3></center>
                  
    <div class="row m-4">
                  <div class="col-md-4"> </div>
                  <div class="col-md-8">
                  <br>
                  
                  <textarea name="inputText" rows="5" cols="50"></textarea>
        <br/>
        </div>
        <center>
        <span class="text-danger"><small>Note: 1) Each line represents a row in the Excel sheet.<br>
2) If text is comma-separated, each element representing<br> a column in the Excel sheet.<br>
        </small></span>
        <input type="submit" class="btn btn-success" value="Download Excel File">
        </center>
        
                  
   
    </div>
    </form>
</body>
</html>