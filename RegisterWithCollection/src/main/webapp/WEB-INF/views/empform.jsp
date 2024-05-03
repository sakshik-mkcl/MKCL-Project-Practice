<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>empform</title>
</head>
<body>

<form:form method="post" action="save"> 
<table>
<tr>
<td>Id: </td>
<td> <input id="id",type="text", name="id" ></td>
</tr>

<tr>
<td>Name: </td>
<td> <input id="name",type="text", name="name" ></td>
</tr>

<tr>
<td>Salary: </td>
<td><input id="salary",type="text", name="salary" ></td>
</tr>

<tr>    
<td>Designation :</td>   
<td><input id="designation",type="text", name="designation" ></td>  
</tr>  

<tr>
 <td colspan="2"><input type="submit" value="Save" /></td>    
</tr>

</table>
</form:form>


</body>
</html>