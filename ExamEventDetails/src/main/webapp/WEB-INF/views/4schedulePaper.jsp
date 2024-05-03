<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.app.model.ExamEvent" %>
<%@page import="java.util.*"  %>
<%@page import="com.app.service.ScheduleMasterService"  %>
<%@page import="com.app.model.ScheduleMaster"  %>
<%@page isELIgnored="false" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Schedule</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-3">
    <div class="row p-4 border shadow-sm">
        <h2 class="display-6">Schedule</h2>
        <br>
        <div class="alert alert-primary my-2" role="alert">
            <div class="row my-2">
                <div class="col-md-3 col-12 fw-bold">
                    Exam event
                </div>
                <div class="col-md-9 col-12 ">
                    ${examEvent.name}
                </div>
            </div>
            <div class="row my-2">
                <div class="col-md-6 col-12 ">
                    <div class="row">
                        <div class="col-6 fw-bold">Event Start Date</div>
                        <div class="col-6">${examEvent.startDate}</div>
                    </div>
                </div>
                <div class="col-md-6 col-12 ">
                    <div class="row">
                        <div class="col-6 fw-bold">Event End Date</div>
                        <div class="col-6">${examEvent.endDate}</div>
                    </div>
                </div>
            </div>
        </div>

     <form id="scheduleForm" action="saveSchedule"> 
        
            
            
            
            <div class="row m-4">
                  <div class="col-md-4">
                      <label for="scheduleType">Schedule Type <span class="text-danger">*</span>: </label>
                    </div> 
               <div class="col-md-8" >
                 <select name="scheduleType" id="scheduleType" style="width:70%" required>
                    <option value="">Enter Schedule type</option>
                    <option value="DAY">Day</option>
                    <option value="WEEK">Week</option>
                    <option value="CUSTOM">Custom</option>
                </select>
                </div>
              </div>
              
            
            <div class="row m-4">
                  <div class="col-md-4">
                      <label for="maxNumberOfPapers">No of paper(s) that can be scheduled <span class="text-danger">*</span>: </label>
                    </div> 
               <div class="col-md-8" >
                 <input type="number" id="maxNumberOfPapers" name="maxNumberOfPapers" value="0" style="width:20%" min="0" required>
                <span class="text-black font-italic"> Note: if kept 0 then unlimited paper(s) will be allowed for schedule</span>
                </div>
              </div>
              
             
             
              <div class="row m-4">
                  <div class="col-md-4">
                      <label for="scheduleStart">Start Date <span class="text-danger">*</span>: </label>
                    </div> 
               <div class="col-md-8" >
                 <input type="datetime-local" id="scheduleStart" name="scheduleStart" style="width:60%" required>
            </div>
              </div>
              
            

           <div class="row m-4">
                  <div class="col-md-4">
                      <label for="scheduleEnd">End Date <span class="text-danger">*</span>: </label>
                    </div> 
               <div class="col-md-8" >
                <input type="datetime-local" id="scheduleEnd" name="scheduleEnd" style="width:60%" required>
               </div>
          </div>
              
              
            <center>
                <a href="examEvent" class="btn btn-secondary">Back</a>
                <button id="submitBtn" type="submit" class="btn btn-success">Save Schedule</button>
                <a href="activateExamEvent" class="btn btn-success">Proceed</a>
            </center> 
        </form>

        
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <th>Schedule Type</th>
                    <th>Starting From</th>
                    <th>Ending On</th>
                    <th>No. of Schedule(s) Created</th>
                    <th>Update</th>
                    <th>Delete</th>
                </thead>
                <tbody>
                    <jsp:useBean id="scheduleservice" class="com.app.service.ScheduleMasterService" />  
                    <c:set var="scheduleMaster" value="${scheduleservice.getAllSchedulesById(examEvent.examEventID)}"></c:set>
                    <c:forEach var="sm" items="${scheduleMaster}" varStatus="loop">
                        <tr>
                            <td>${sm.scheduleType}</td>
                            <td>${sm.scheduleStart}</td>
                            <td>${sm.scheduleEnd}</td>
                            <td>${loop.index}</td>
                            <td>
                               
                                 
                                 <form action="update/${sm.scheduleID}" method="get">
                                    <button type="submit" class="btn btn-success">Update</button>
                                </form>  
                                
                            </td>
                            <td>
                                <form action="delete/${sm.scheduleID}" method="get">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td colspan="2"><small><i>Allow Schedule Extension No</i></small></td>
                            <td colspan="3"><small><i>Max No. of paper(s) that can be scheduled:<span class="text-danger">${sm.maxNumberOfPapers}</span></i></small></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        
    </div>
    
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<script>
$(document).ready(function() {
    // Event listener for update button clicks
    $('.update-btn').click(function() {
        var scheduleID = $(this).data('schedule-id');
        var scheduleType = $(this).closest('tr').find('.schedule-type').text(); 
        var maxNumberOfPapers = $(this).closest('tr').find('.max-number-of-papers').text(); 
        var scheduleStart = $(this).closest('tr').find('.schedule-start').text(); 
        var scheduleEnd = $(this).closest('tr').find('.schedule-end').text(); 
        
        // Populate form fields with schedule data
        $('#scheduleID').val(scheduleID);
        $('#scheduleType').val(scheduleType);
        $('#maxNumberOfPapers').val(maxNumberOfPapers);
        $('#scheduleStart').val(scheduleStart);
        $('#scheduleEnd').val(scheduleEnd);
        
        // Set form action for update
        $('#scheduleForm').attr('action', 'update/' + scheduleID);
    });
});
</script>


</body>
</html>