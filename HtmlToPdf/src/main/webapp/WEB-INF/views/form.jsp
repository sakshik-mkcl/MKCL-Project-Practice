<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>Registration Form</title>
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<form:form action="form" method="post" modelAttribute="user">
<div class="container mt-3">
   <div class="row p-4 border shadow-sm">
	
	
	   <h1 class="display-6">Registration Forms</h1>
              <div class="row m-4">
                  <div class="col-md-4">
                    <label for="id">Serial ID:<span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-8" >
                    <input type="text" class="form-control" id="id" name="id" placeholder="Enter Id" aria-describedBy="emailHelp" required="required"/>
	               </div>
              </div>
	
	
	         <div class="row m-4">
                  <div class="col-md-4">
                    <label for="name">Name: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-8" >
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" aria-describedBy="emailHelp" required="required"/>
	                </div>
              </div>
              
              
              <div class="row m-4">
                  <div class="col-md-4">
                    <label for="user name">user name: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-8" >
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" aria-descriedBy="emailHelp" required="required"/>
	</div>
              </div>
	
	
	
	<div class="row m-4">
                  <div class="col-md-4">
                    <label for="password" class="form-label">password: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-8" >
                   <input type="password" class="form-control" id="password" name="password" required="required">
	</div>
              </div>
	
	
	<div class="row m-4">
                  <div class="col-md-4">
                    <label for="gender">Gender: <span class="text-danger">*</span></label>
                    </div> 
               <div class="col-md-8" >
                   <input type="radio" id="male" name="gender" value="Male" required>
		<label for="male">Male </label><br>
		<input type="radio" id="female" name="gender" value="Female" required>
		<label for="female">Female </label><br>
		<input type="radio" id="others" name="gender" value="others" required>
		<label for="others">Other </label><br>
	</div>
              </div>
	
	</div>
	
	<center>
	<input type="reset" class="btn btn-secondary" value="reset"/>
  <button type="submit" class="btn btn-primary">Submit</button>
	</center>
	
	</div>

</form:form>
</body>
</html>