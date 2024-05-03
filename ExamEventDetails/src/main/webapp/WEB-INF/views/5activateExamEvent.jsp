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
                <div class="col-md-8">
            <h3 class="display-6">Activate Exam Event</h3>
            </div>
                <div class="col-md-4">
            
            
    <button type="button"  name="options" id="option2" class="btn btn-success" autocomplete="off"> Expand All</button>
  
  
    <button type="button" name="options" id="option3" class="btn btn-success" autocomplete="off">Collapse All</button>
  
  
  </div>
         
            <div class="accordion" id="accordionExample">
        <div class="accordion-item">
          <h2 class="accordion-header">
            <button class="accordion-button" style="background-color: lightgray;" class="btn btn-success" type="button"
              data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
              Exam Event Details
            </button>
          </h2>
          <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionExample">
            <div class="accordion-body">

              <div class="row m-4">
                <div class="col-md-3">
                  <h6> Exam Event Code: </h6>
                </div>
                <div class="col-md-3">
                  ${examEvent.examEventCode}</div>
              </div>


              <div class="row m-4">
                <div class="col-md-3">
                  <h6> Exam Event Name: </h6>
                </div>
                <div class="col-md-3">
                  ${examEvent.name}</div>
              </div>


              <div class="row m-4">
                <div class="col-md-3">
                  <h6> Default Language: </h6>
                </div>
                <div class="col-md-3">
                  ${examEvent.defaultLanguageID}</div>
              </div>


              <div class="row m-4">
                <div class="col-md-3">
                  <h6> End Date: </h6>
                </div>
                <div class="col-md-3">
                  ${examEvent.endDate}</div>
              
                <div class="col-md-3">
                  <h6> Start Date: </h6>
                </div>
                <div class="col-md-3">
                  ${examEvent.startDate}</div>
              </div>



            </div>
          </div>
        </div>
        
        
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button class="accordion-button collapsed" style="background-color: lightgray;" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                      Paper Details
                    </button>
                  </h2>
                  <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                      
        <div class="table-responsive">
            
            <table class="table table-striped">
                <thead>
                    <th>Sr. No. </th>
                    <th>Paper ID </th>
                    <th>Paper Code</th>
                    <th>Paper Name</th>
                    <th>Paper Total Marks</th>
                    <th>The maximum time during which paper continues</th>
                </thead>

        
       
       <tbody>
            
            <jsp:useBean id= "paperservice" class= "com.app.service.PaperService" />  
             <c:set var="Paper" value="${paperservice.getAllPapersByExamEventId(examEvent.examEventID)}"></c:set>

                           
            <c:set var="i" value="1"/>
            <c:forEach var="p" items="${Paper}">
             <tr>
            <td>${i}</td>
            <td>${p.paperID}</td>
            <td>${p.code}</td>
            <td>${p.name}</td>
            <td>000</td>
            <td>000</td>
            
            </tr>
                            
                <c:set var="i" value="${i+1}"/>
                  </c:forEach>
       </tbody>
                   
                
            </table>
        </div>             
                      
                      </div>
                  </div>
                </div>
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button class="accordion-button collapsed"  style="background-color: lightgray;" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                      Schedule
                    </button>
                  </h2>
                  <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                     
                     
                     
 <div class="table-responsive">
        
        <table class="table table-striped">
            <thead>
                <th>Schedule Type </th>
                <th>Starting From </th>
                <th>Ending On</th>
                <th>No. of Schedule(s) Created</th>
                
            </thead>

            <tbody>
            
            <jsp:useBean id= "scheduleservice" class= "com.app.service.ScheduleMasterService" />  
             <c:set var="scheduleMaster" value="${scheduleservice.getAllSchedulesById(examEvent.examEventID)}"></c:set>

                           
            <c:set var="i" value="1"/>
            <c:forEach var="sm" items="${scheduleMaster}">
            <tr>
            <td>${sm.scheduleType}</td>
            <td>${sm.scheduleStart}</td>
            <td>${sm.scheduleEnd}</td>
            <td>${i}</td>
            
            </tr>
                            
                <c:set var="i" value="${i+1}"/>
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
                </div>
              </div>
              
              
              
              
              
              
         <center>
            <a href="examEvent" class="btn btn-secondary">Back</a>
            <button type="submit" class="btn btn-success">Activate Exam Event</button>
            <a href="manageExamEvent" class="btn btn-success" ">Proceed</a>
             
        </center>
    </div>
    </div>
 
                
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
   

</body>

</html>