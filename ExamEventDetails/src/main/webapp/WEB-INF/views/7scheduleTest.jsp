<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
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
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>



<body>
    <div class="container mt-3">
        <div class="row p-4 border shadow-sm">

            <h1 class="display-6">Schedule Test</h1>
           


            <form action="saveScheduleTest">
              

              <div class="row m-4">
                <div class="col-md-4">
                  <label for="eventName">Exam Event: <span class="text-danger">*</span> </label>
                </div>
             
              <div class="col-md-8 ">
                
                <jsp:useBean id="eventservice" class="com.app.service.ExamEventDetailService" />
                <c:set var="event"
								value="${eventservice.getAllExamEvent()}"></c:set>
                
                    <select class="form-select" name="fkExamEventID" id="eventName" style="width:70%" required>
                        
                        <c:forEach var="e" items="${event}">
                            <option value="${e.examEventID}" name="${e.name}">${e.name}</option>
                            </c:forEach>
                      
                    </select>
                </div>
              
              
             </div> 
            
             <div class="row m-4">
                  <div class="col-md-4">
                     <label for="eventName">Date: <span class="text-danger">*</span> </label>
                  </div>         
               <div class="col-md-8" >
                    <select class="form-select" name="fkScheduleID" id="date" style="width:70%" required>
                       
                    </select>
                </div>
            </div> 
              
<br>
<br>
                
                
                
            <div class="row">
                <div class="alert alert-success text-primary fw-bold my-3 mb-0 "
                    style="border: 1px solid rgb(2, 2, 96);color: rgb(2, 2, 96)!important;">You can schedule unlimited papers.
                </div>
            </div>
            
            
            <div class="table-responsive">
            
            <table class="table table-striped">
                <thead>
                    <th>Display category </th>
                    <th>Paper </th>
                    <th>Add More</th>
                </thead>

                <tbody >
                   
                        <tr>
                            <td>English</td>
                <td>
                             <div class="col-md-8">
                    <select class="form-select" name="fkPaperID" id="papers" style="width:100%" required>
                        
                    </select>
                </div>
                            
               </td>
                            <td> <button class="btn btn-success">Add More</button></td>
                        </tr>
                   
                 </tbody>
                   
                
            </table>
            
        </div>
                <center>
                      <button type="submit" class="btn btn-success">Schedule</button>
                </center>
                
                
               
                <div class="table-responsive">
            
            <table class="table table-striped">
                <thead>
                    <th>Sr. No. </th>
                    <th>Exam Event Name </th>
                    <th>Paper Name</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </thead>

        
       
       <tbody>
            
            <jsp:useBean id= "service" class= "com.app.service.SchedulePaperAssociationService" />  
             <c:set var="Association" value="${service.getAllExamEventnamePapersScheculeAllIds()}"></c:set>

                           
            <c:set var="i" value="1"/>
            <c:forEach var="p" items="${Association}">
             <tr>
            <td>${i}</td>
            <td>${p.getEventName()}</td>
            <td>${p.getPaperName()}</td>
            <td>${p.getStartDate()}</td>
            <td>${p.endDate}</td>
            
            
            </tr>
                            
                <c:set var="i" value="${i+1}"/>
                  </c:forEach>
       </tbody>
                   
                
            </table>
        </div>  
                
               

            </form>
        </div>
    </div>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
   
<script>


$(document).ready(function() {
    $('#eventName').change(function() {
        var eventId = $(this).val();
        $.ajax({
            method: 'GET',
            url: 'http://localhost:8081/ExamEventDetails/schedulelist/' + eventId,
            contentType: 'application/json',
            dataType: 'json',
            success: function(result) {
                console.log(result); 
                $('#date').empty();
                $.each(result, function(index, schedule) {
                    $('#date').append($('<option>', {
                        value: schedule.scheduleID,
                        text: 'Start Date: ' + schedule.scheduleStart + ' End Date: ' + schedule.scheduleEnd
                    }));
                });
            },
            error: function(jqXHR) {
                console.error('Error: ', jqXHR.responseText);
            }
        });
    });
});



$(document).ready(function() {
    $('#eventName').change(function() {
        var eventId = $(this).val();
        $.ajax({
            method: 'GET',
            url: 'http://localhost:8081/ExamEventDetails/paperlist/' + eventId,
            contentType: 'application/json',
            dataType: 'json',
            success: function(result) {
                console.log(result); 
                $('#papers').empty();
                $.each(result, function(index, paper) {
                    $('#papers').append($('<option>', {
                        value: paper.paperID,
                        text: paper.name
                    }));
                });
            },
            error: function(jqXHR) {
                console.error('Error: ', jqXHR.responseText);
            }
        });
    });
});


</script>

</body>

</html>