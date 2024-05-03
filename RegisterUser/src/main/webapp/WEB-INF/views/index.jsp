<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>


<form action="submit" >
<div class="form-row">

<div class="form-group col-md-12">
      <label for="id">id</label>
      <input type="number" class="form-control" name="id">
    </div>
    
    <div class="form-group col-md-12">
      <label for="firstname">First Name</label>
      <input type="text" class="form-control" name="firstname">
    </div>
    
    <div class="form-row">
    <div class="form-group col-md-6">
      <label for="lastname">Last Name</label>
      <input type="text" class="form-control" name="lastname">
    </div>
    
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="email">Email</label>
      <input type="email" class="form-control" name="email">
    </div>
    
    <div class="form-group col-md-6">
      <label for="password">Password</label>
      <input type="password" class="form-control" name="password">
    </div>
  </div>
  
  
  <input type="submit" class="btn btn-primary" value="Submit">
</form>



</body>
</html>