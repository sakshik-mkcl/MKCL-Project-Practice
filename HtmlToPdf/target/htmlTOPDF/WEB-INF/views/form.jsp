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

<form:form action="/register" method="post" modelAttribute="user">
	<center><h2>Registration Forms</h2></center>
	<div class="container">
	<div class="row">
	<div class="col-3">
	<div class="col-6">
	
	<div>
	<label for="id">Serial ID: </label>
	<input type="text" class="form-control" id="id" name="id" placeholder="Enter Id" aria-describedBy="emailHelp" required="required"/>
	</div>
	
	<div>
	<label for="name">Name: </label>
	<input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" aria-describedBy="emailHelp" required="required"/>
	</div>
	
	<div>
	<label for="user name">user name: </label>
	<input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" aria-descriedBy="emailHelp" required="required"/>
	</div>
	
	<div>
	<label for="password" class="form-label">password: </label>
	<input type="password" class="form-control" id="password" name="password" required="required">
	</div>
	
		<div>
		<label for="gender">Gender: </label>
		<input type="radio" id="male" name="gender" value="Male">
		<label for="male">Male</label>
		<input type="radio" id="female" name="gender" value="Female">
		<label for="female">Female</label><br>
	</div>
	
	<!-- <a href="/register" class="btn btn-secondary">Reset</a> -->
	<input type="reset" class="btn btn-secondary" value="reset"/>
  <button type="submit" class="btn btn-primary">Submit</button>
	
	</div>
	</div>
	</div>
	</div>

</form:form>
</body>
</html>