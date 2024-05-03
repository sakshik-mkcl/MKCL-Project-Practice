<%@page isELIgnored="false" %>

<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>

<body>
 <body>
        <div class="container">
            <h1>DropDown List</h1>
            <div class="form-group">
                <label for="country">Country</label>
                <select name="country" id="country" class="form-control">
                    <option value="">Select Country</option>
                    <option value="1">India</option>
                    <option value="2">USA</option>
                    
                     </select>    
            </div>
              <div class="form-group">
                <label for="state">State</label>
                <select name="state" id="state" class="form-control">
                 @if($country $value=={{1}})
                  <option value="">Select States</option>
                    <option value="1">Maharashtra</option>
                    <option value="2">Gujrat</option>   
                </select>    
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <select name="city" id="state" class="form-control">
                <option value="">Select City</option>   
                </select>    
            </div>
        </div>
       <script>

       $(document).ready(function(){
           
           $.ajax({
               url: 'http://localhost:8080/RegistrationAjaxx/getCountry',
               type: 'GET',
               contentType: 'json',
               success: function(data){
                   data = data.substring(1,data.length-1);
        
                   const arr = data.split(",");
                   $.each(arr, function(index, country){
                       $('#country').append('<option value="' + country.trim() + '">' + country.trim() + '</option>');
                   });
               },
               error: function(xhr, status, error) {
                   console.error("Failed to fetch countries: " + error);
               }
           });

         
           $('#country').change(function(){
               console.log("hiiii");
               var countryId = $(this).val();
               if(countryId){
                   $.ajax({
                       url: 'http://localhost:8080/RegistrationAjaxx/getState',
                       type: 'GET',
                       data: { cname: countryId },
                       contentType: 'json',
                       success: function(data){
                       	data = data.substring(1,data.length-1);
                       	console.log(data);
                           const arr = data.split(",");
                           $('#state').empty(); 
                           $('#state').append('<option value="" disabled selected>Select a state</option>');
                           $.each(arr, function(index, state){
                               $('#state').append('<option value="' + state + '">' + state + '</option>');
                           });
                       },
                       error: function(xhr, status, error) {
                           console.error("Failed to fetch states: " + error);
                       }
                   });
               } else {
                   $('#state').empty(); 
                   $('#state').append('<option value="" disabled selected>Select a state</option>');
               }
           });
       });
          
       
       </script>
    </body>
</html>
