<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.app.model.Paper" %>
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

</head>

<body>
    <div class="container mt-3">
        <div class="row p-4 border shadow-sm">

            <h2 class="display-6">Exam Event- Paper Configuration details</h2>
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


            <form action="saveExamEventPaperDetails" >
                        
    


<div class="row m-4">
                  <div class="col-md-6">
                     <label for="fkPaperID">Select Paper: <span class="text-danger">*</span> </label>
                    </div> 
               <div class="col-md-6" >
                  <select name="fkPaperID" id="paperName" class="paperName" style="width:80%" required>
        <jsp:useBean id="paperservice" class="com.app.service.PaperService" />
        <c:set var="papers" value="${paperservice.getAllPapersByExamEventId(examEvent.examEventID)}" />
        <c:forEach var="p" items="${papers}">
            <option value="${p.paperID}">${p.name}</option>
        </c:forEach>
    </select>
                </div>
              </div>
              
              

                    
                    <br>
                    <div class="alert alert-secondary my-3" role="alert">
                        <div class="row my-20">
                            <div class="col-md-3 col-5 fw-bold">
                                General Settings
                            </div>
                        </div>
                    </div>
                
                
                 <div class="row m-4">
                  <div class="col-md-6">
                      <label for="standard">Exam Type: <span class="text-danger">*</span> </label>
                    </div> 
               <div class="col-md-6" >
                  <select name="eventType" id="examType" class="examType" style="width:80%" required>
                       <option >Select Exam type </option>
                       <option value="Practice">Practice</option>
                       <option value="Main">Main</option>
                    </select>
                </div>
              </div>
                  
            
            
            <div class="row m-4">
                  <div class="col-md-6">
                     <label for="noOfAttempts">No. Of Attempts: <span class="text-danger">*</span> </label>
                    </div> 
               <div class="col-md-6" >
                  <select name="noOfAttempts" id="standard" style="width:80%" required>
                                    <option value="1">1 </option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                 </select>
                </div>
              </div>
                    
               
                
                 <div class="row m-4">
                  <div class="col-md-6">
                    <label for="que">Identical Question Paper to all Candidate: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                  <input type="radio" id="yes" name="isIdenticalItems" value="Yes" required>
                  <label for="yes">Yes</label>
                  <input type="radio" id="no" name="isIdenticalItems" value="No" required>
                  <label for="no">No</label><br>
                </div>
              </div>
            
            
            
                
                
                
                <div class="row m-4">
                  <div class="col-md-6">
                    <label for="item">Identical Item Sequence to all Candidate: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                  <input type="radio" id="yes" name="isIdenticalItemSequence" value="Yes" required>
                  <label for="yes">Yes <span id="random"
               class="text-black font-italic">(No Randomization)</span></label>
                  <input type="radio" id="no" name="isIdenticalItemSequence" value="No" required>
                  <label for="no">No (Randomization)</label><br>
                </div>
              </div>
              

                <div class="alert alert-secondary my-3" role="alert">
                  <div class="row my-20">
                      <div class="col-md-3 col-5 fw-bold">
                          Exam Screen Settings
                      </div>
                  </div>
              </div>
            
              
                
                
                <div class="row m-4">
                  <div class="col-md-6">
                    <label for="option">Option Randomization: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                  <input type="radio" id="yes" name="isRandomOption" value="Yes" required>
                  <label for="yes">Yes</label>
                  <input type="radio" id="no" name="isRandomOption" value="No" required>
                  <label for="no">No</label><br>
                </div>
              </div>

                <div class="alert alert-secondary my-3" role="alert">
                  <div class="row my-20">
                      <div class="col-md-3 col-5 fw-bold">
                          Exam Interface Control Settings
                      </div>
                  </div>
              </div>
            
               
                
                <div class="row m-4">
                  <div class="col-md-6">
                    <label for="pallet">Disable Pallet Navigation: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                  <input type="radio" id="yes" name="palletNavigation" value="Yes" required>
                  <label for="yes">Yes</label>
                  <input type="radio" id="no" name="palletNavigation" value="No" required>
                  <label for="no">No</label><br>
                </div>
              </div>
            
                
                
                <div class="row m-4">
                  <div class="col-md-6">
                    <label for="skip">Skip Question: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                  <input type="radio" id="yes" name="isSkipQuestion" value="Yes" required>
                  <label for="yes">Yes</label>
                  <input type="radio" id="no" name="isSkipQuestion" value="No" required>
                  <label for="no">No</label><br>
                </div>
              </div>
              
            
               
                
                <div class="row m-4">
                  <div class="col-md-6">
                    <label for="changed">Answer Option Can be changed after Attempt: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                  <input type="radio" id="yes" name="isAnswerChange" value="Yes" required>
                  <label for="yes">Yes</label>
                  <input type="radio" id="no" name="isAnswerChange" value="No" required>
                  <label for="no">No</label><br>
                </div>
              </div>
            
                
                <div class="row m-4">
                  <div class="col-md-6">
                    <label for="reset">Show Reset Answer Option: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                   <input type="radio" id="yes" name="reset" value="Yes" required>
                  <label for="yes">Yes</label>
                  <input type="radio" id="no" name="reset" value="No" required>
                  <label for="no">No</label><br>
                </div>
              </div>
            
            
            
            
             <div class="row m-4">
                  <div class="col-md-6">
                    <label for="notepad">Show Notepad: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-6" >
                    <input type="radio" id="yes" name="showNotepad" value="Yes" required>
                  <label for="yes">Yes</label>
                  <input type="radio" id="no" name="showNotepad" value="No" required>
                  <label for="no">No</label><br>
                </div>
              </div>
            
                  
            
                      
                  <center>
                 
                  <a href="examEvent" class="btn btn-secondary">Back</a>
                  <a href="schedulePaper" class="btn btn-success">Proceed</a>
                  <button type="submit" class="btn btn-success">Save</button>
                </center>
                  
                </form>

            </form>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>






 
</body>

</html>