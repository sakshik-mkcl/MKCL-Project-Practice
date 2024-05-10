
<%@page import="org.hibernate.Session" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
</head>

<body>
    <div class="container mt-3">
        <div class="row p-4 border shadow-sm">

            <h1 class="display-6">Exam Event Details</h1>
            <div class="row">
                <div class="alert alert-success text-primary fw-bold my-3 mb-0 "
                    style="border: 1px solid rgb(2, 2, 96);color: rgb(2, 2, 96)!important;">License End Date
                </div>
            </div>


            <form action="saveExamEvent" id="examForm">
                
                
              
              <div class="row m-4">
                  <div class="col-md-4">
                    <label for="name">Exam Event Name: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-8" >
                    <input type="text" id="name" name="name" style="width:80%"  required>
                </div>
              </div>
            

                
                <div class="row m-4">
                  <div class="col-md-4">
                   <label for="name">Exam Event Code: <span class="text-danger">*</span></label>
                   </div> 
               <div class="col-md-8" >
                    <input type="text" id="examEventCode" name="examEventCode" style="width:80%" required>
                </div>
            </div>
            
               
                
                <div class="row m-4">
                  <div class="col-md-4">
                   <label for="standard">Default Language: <span class="text-danger">*</span> </label>
                   </div> 
               <div class="col-md-8" >
                    <select name="defaultLanguageID" id="language" class="language" style="width:80%" required>   
                    </select>
                </div>
            </div> 
            
            
                
                <div class="row m-4">
                  <div class="col-md-4">
                   <label for="name">Start Date: <span class="text-danger">*</span></label>
                  </div>         
               <div class="col-md-8" >
                    <input type="datetime-local" id="startDate" name="startDate" style="width:80%" required>
                </div>
            </div> 
            
  
                <div class="row m-4">
                  <div class="col-md-4">
                    <label for="name">End Date: <span class="text-danger">*</span></label>
                  </div>         
               <div class="col-md-8" >
                    <input type="datetime-local" id="endDate" name="endDate" style="width:80%" required>
                </div>
            </div> 
               
                
                
<br>
                <center>
                   
                    <a href="addPaper" id="proceedBtn" class="btn btn-success">Proceed</a>
                    
                     <button type="submit" class="btn btn-success">Save</button>
                </center>
                <br>
     
              <div class="row m-4">
                  <div class="col-md-4">
                     <label for="eventName">Select Event Name:  </label>
                  </div>         
               <div class="col-md-8" >
                    <select  id="eventName" class="eventName" style="width:80%">
                    </select>
                </div>
            </div> 
            
            
            </form>
        </div>
    </div>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){

                const fetchEvent = function(){
                                var event = document.getElementById("eventName");
                                var selectedEvent = event.options[event.selectedIndex].text;
                                console.log("Selected event: "+selectedEvent);
                                saveEvent(selectedEvent);
                        }
            
            

            const saveEvent = function(name) {
               var data={name:name}
                $.ajax({
                    url: 'http://localhost:8081/ExamEventDetails/saveEventOnProceed', 
                    type: 'GET',
                    contentType: 'application/json',
                    data: data, 
                    success: function(response) {
                        console.log("Event saved successfully:", response);
                        
                    },
                    error: function(xhr, status, error) {
                        console.error("Failed to save event: " + error);
                        
                    }
                });
            }
            
            $("#proceedBtn").click(function() {
                fetchEvent(); 
            });
        });
            </script>

<script>



            $(document).ready(function () {
                    
                $.ajax({
                    method: 'GET',
                    url: 'http://localhost:8081/ExamEventDetails/langlist',
                    contentType: 'application/json',
                    success: function (result) {
                        console.log(result);
                        let string = ``;
                        document.getElementById("language").innerHTML = string;
                        result = result.substring(1, result.length - 1);
                        const arr = result.split(",");
                        console.log("Clicked");
                        console.log(arr);
                        for (let i = 0; i < arr.length; i++) {
                            var element = arr[i];

                            string += "<option value=" + element + ">" + element + "</option>"

                        }
                        console.log(string);
                        document.getElementById("language").innerHTML = string;
                    },
                    error: function ajaxError(jqXHR) {
                        console.error('Error: ', jqXHR.responseText);
                    }
                });

            });
            
            
            
             $(document).ready(function () {

                $.ajax({
                    method: 'GET',
                    url: 'http://localhost:8081/ExamEventDetails/eventName',
                    contentType: 'application/json',
                    success: function (result) {
                        console.log(result);
                        let string = ``;
                        document.getElementById("eventName").innerHTML = string;
                        result = result.substring(1, result.length - 1);
                        const arr = result.split(",");
                        console.log("Clicked");
                        console.log(arr);
                        for (let i = 0; i < arr.length; i++) {
                            var element = arr[i];

                            string += "<option value=" + element + ">" + element + "</option>"

                        }
                        console.log(string);
                        document.getElementById("eventName").innerHTML = string;
                    },
                    error: function ajaxError(jqXHR) {
                        console.error('Error: ', jqXHR.responseText);
                    }
                });
               

            }); 
            
             

              

           
        </script>

</body>

</html>