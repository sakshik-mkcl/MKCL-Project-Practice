<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
   <%@page isELIgnored="false" %>
   
   <html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Cabin+Sketch" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
  <div class="container mt-3">
    <div class="row p-4 border shadow-sm">

      <div class="row m-4">
                  <div class="col-md-10">
                    <h3 class="display-6">Manage Exam Event</h3>
                    </div> 
               <div class="col-md-2" >
                     <a href="scheduleTest" class="btn btn-success" >Schedule Test</a>
                </div>
              </div>
              
              

      <div class="table-responsive" >
        
        <table class="table table-striped" border="1">
            <thead>
                <th>Exam Event ID </th>
                <th>Exam Event Name </th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Completion Status</th>
                <th>Update</th>
                
            </thead>

            <tbody>
            
            <jsp:useBean id= "exameventservice" class= "com.app.service.ExamEventDetailService" />  
             <c:set var="ExamEvent" value="${exameventservice.getAllExamEvent()}"></c:set>

            
            <c:forEach var="sm" items="${ExamEvent}">
            <tr>
            <td>${sm.examEventID}</td>
            <td>${sm.name}</td>
            <td>${sm.startDate}</td>
            <td>${sm.endDate}</td>
            <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="green" class="bi bi-check-circle" viewBox="0 0 16 16">
  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
  <path d="m10.97 4.97-.02.022-3.473 4.425-2.093-2.094a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05"/>
</svg></td>
            <td><button class="btn btn-success">Update</button></td>
            
            
            </tr>

                
             </c:forEach>
            </tbody>
            
           
            
            
            
            
           </table>
 </div>

      
     
      
    </div>
  </div>


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


</body>

</html>