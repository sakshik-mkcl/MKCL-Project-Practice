<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  
   
   <form action="handleCandidate" method="post">
   
   <center><h2>Candidate Form</h2> </center>
  
  <div class="container">
  	<div class="row">
  	<div class="col-3"></div>
  	<div class="col-6">
  
  <div >
    <label for="id" >Candidate Id: </label>
    <input type="text" class="form-control" id="id" name="id" 
    placeholder="Enter ID" aria-describedby="emailHelp">
   </div>
   
   <div >
    <label for="name" >Name: </label>
    <input type="text" class="form-control" id="name" name="name" 
    placeholder="Enter Name" aria-describedby="emailHelp">
   </div>
   
   <div class="form-group">
    <label for="username" >User Name: </label>
    <input type="text" class="form-control" id="username" name="username" 
    placeholder="Enter User Name" aria-describedby="emailHelp">
   </div>
   
   <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" id="exampleInputPassword1" name="password">
  </div>
   
  <div class="form-group">
    <label for="description" >Description: </label>
    <textarea
     class="form-control" , name="description" id="description" rows="3" placeholder="Enter Description">
    </textarea>
  </div>
  
  <div>
  <label for="gender">Gender:</label>
  <input type="radio" id="male" name="gender" value="Male">
  <label for="male">Male</label>
  <input type="radio" id="female" name="gender" value="Female">
  <label for="female">Female</label><br>
  </div>
  
  
  <br>
  
 <div>
  <label for="skills">Skills:</label><br>
  <input type="checkbox" id="ac" name="skills[]" value="Advance Computing">
  <label for="ac">Advance Computing</label><br>
  <input type="checkbox" id="db" name="skills[]" value="Database Management" >
  <label for="db">Database Management</label><br>
  <input type="checkbox" id="sd" name="skills[]" value="Software development">
  <label for="sd">Software Development</label><br><br>
</div>
 
  
  
           <div class="form-group">
                <label for="standard">Standard</label>
                <select name="standard" id="standard" class="form-control">
                    <option value="">Select Standard</option>
                    <option value="1">1st class</option>
                    <option value="2">2nd class</option>
                    <option value="2">3rd class</option>
                 </select>    
            </div>
            
            
    <div>      
    <label for="prolang">Choose a Programming Language:</label>
  <select name="prolang" id="prolang" multiple>
    <option value="c++">C++</option>
    <option value="java">Java</option>
    <option value="DotNet">DotNet</option>
    <option value="GoLang">Go </option>
  </select>
  <br><br>
  <p><i>  Hold down the Ctrl (windows) or Command (Mac) button to select multiple options.</i></p>
  </div>  
  
  <div>
  <label for="file">Select a file:</label>
  <input type="file" id="fileupload" name="fileupload"><br><br>
  </div>       
  
  
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Check me out</label>
  </div>
  
  <a href="/2MvcHibernate/addCandidate" class="btn btn-secondary">Reset</a>
  <button type="submit" class="btn btn-primary">Submit</button>
  
</form>
</div>
	<div class="col-7"></div>
</div>
</div>
    
  </body>
</html>