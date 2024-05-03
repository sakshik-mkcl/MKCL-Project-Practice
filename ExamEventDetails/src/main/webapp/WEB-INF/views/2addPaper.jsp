<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


        <!-- Load icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>

<form action="saveSelectedPapers">
    <div class="container mt-3">
        <div class="row p-4 border shadow-sm">

            <h1 class="display-6">Exam Event - Add Paper</h1>
            <div class="alert alert-primary my-2" role="alert">
                <div class="row my-2">
                    <div class="col-md-3 col-12 fw-bold">
                        Exam event
                    </div>
                    <div class="col-md-9 col-12 " id="eventName">
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

            

            <div >
                
    
                <!-- Trigger Button -->
                <button id="view_paper" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                View Paper<span id="count"
               class="bg-white text-black rounded px-1 fw-bold">0</span></button>
            
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Paper List</h5>
                                
                                 <!-- Close Button with Cross Symbol -->
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                
                                
                            </div>
                            
                          
                            
                            <div class="modal-body" class="table-responsive">
                                <table class="table table-striped" >
                                    <tr>
                                      <th>Sr.no.</th>
                                      <th>Paper Name</th>
                                      <th>Remove Paper</th>
                                    </tr>
                            <tbody id="modalTableBody">
                            
                            <c:forEach var="paper" items="${selectedPapers}">
                <tr>
                    <td>${paper.paperID}</td>
                    <td>${paper.name}</td>
                    <td>
                       
                       <%--  <button type="button" onclick="removePaper(${paper.paperId})" class="btn btn-danger">Remove</button> --%>
                        <form action="remove/${paper.PAPERID}" method="get">
                                    <button type="submit" class="btn btn-danger">Remove</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
                             
                            </tbody>      
                                  </table>
                            </div>
                            <div class="modal-footer">
                               <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>

                            </div>
                        </div>
                    </div>
                </div>
            </div>




                <div class="col-10 col-md-6 ">
                    <div class="row text-end">
                        <div class="col-md-10 text-end m-0 p-0 w-50">
                            <input type="text" placeholder="Search" class=" form-control rounded-end">
                        </div>
                        <div class="col-md-1 p-0 m-0 text-start">
                            <input type="text" class="btn btn-success px-0" value="GO!">
                        </div>
                    </div>
                </div>
            </div>



            <div class="row">
                <div class="alert alert-success text-primary fw-bold my-3 mb-0 "
                style="border: 1px solid rgb(2, 2, 96);color: rgb(2, 2, 96)!important;">Latest Published Paper List
            </div>
        </div>
        
        
        
                                  
        <sql:setDataSource
               var="myDS"
               driver="com.mysql.jdbc.Driver"
               url="jdbc:mysql://10.2.10.57/PROJECT_TRAINEE_2024?useUnicode=true&amp;characterEncoding=utf-8"
               user="pta2024" password="pta2024"  />                          
        
        <sql:query var="paperList"  dataSource="${myDS}">
        SELECT * FROM PAPER;
       </sql:query>
    
    
        <div class="table-responsive">
            
            <table class="table table-striped">
                <thead>
                    <th>Paper Code </th>
                    <th>Paper Name </th>
                    <th>Paper Abbreviation</th>
                    <th>Add</th>
                </thead>

                <tbody id="mainTableBody">
                    <c:forEach var="paper" items="${paperList.rows}">
                        <tr>
                            <td><c:out value="${paper.CODE}" /></td>
                            <td><c:out value="${paper.NAME}" /></td>
                            <td><c:out value="${paper.ABBREVIATION}" /></td>
                            <td> <input id="checkbox" type="checkbox" class="checkbox" value="${paper.PAPERID}"  onchange="updateSelectedPapers()"
                            
                            onclick="updateCount()" class="switch-input" ></td>
                        </tr>
                    </c:forEach>
                 </tbody>
                    <thead>
                        <th>Paper Code </th>
                        <th>Paper Name </th>
                        <th>Paper Abbreviation</th>
                        <th>Add</th>
                    </thead>
                
            </table>
             <input type="hidden" id="selectedPapers" name="selectedPapers">
        </div>
    </div>
    <center>
        <a href="examEvent" class="btn btn-secondary">Back</a>
        <a href="addPaperConfiguration" class="btn btn-success" onclick="redirectToNextPage()">Proceed</a>
        <button type="submit" class="btn btn-success" >Save</button> 
    </center>   
    </form>

    </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>





<script>
function updateSelectedPapers() {
    var selectedIDs = [];
    var checkboxes = document.querySelectorAll('.checkbox:checked');
    checkboxes.forEach(function(checkbox) {
        selectedIDs.push(checkbox.value);
    });
    document.getElementById('selectedPapers').value = selectedIDs.join(',');
}
</script>



<script>
function getCheckedNames(){
	var checkedNames=[];
	var checkboxes=document.getElementByClassName("checkbox");
	for(var i=0;i< checkboxes.length ;i++){
		if(checkboxes[i].checked){
			checkedNames.push(checkboxes[i].value);
           }
		}
	return checkedNames;
}

function redirectToNextPage(){
	var selectedNames= getCheckedNames();
	window.location.href="addPaperConfiguration?seletedNames=" +JSON.stringify(selectedNames);
}





</script>

 <script>
    function updateCount() {
        var checkboxes = document.querySelectorAll('.checkbox:checked');
        var countSpan = document.getElementById('count');
        countSpan.textContent = checkboxes.length;
    }
        
  </script> 
 
 <script>

$(document).ready(function() {
    $('#eventName').change(function() {
        var eventId = $(this).val();
        $.ajax({
            method: 'GET',
            url: 'http://localhost:8081/ExamEventDetails/paperlist/' + eventId,
            contentType: 'application/json',
            dataType: 'json',
            success: function(result) {
                console.log(result); 
                $('#exampleModal').empty();
                $.each(result, function(index, paper) {
                    $('#exampleModal').append($('<option>', {
                        value: paper.paperID,
                        text: paper.name
                    }));
                });
            },
            error: function(jqXHR) {
                console.error('Error: ', jqXHR.responseText);
            }
        });
    });
});






    $(document).ready(function() {
        
        $('#mainTableBody').on('change', '.checkbox', function() {
            if (this.checked) {
                var row = $(this).closest('tr').clone();
                $(this).closest('tr').remove();
                // Increment Sr.no. in modal table
                row.find('td:first').text($('#modalTableBody tr').length + 1);
                // Add Remove button to the row
                
                row.find('td:last').append('<td><button type="button" onclick="updateCount()" class="btn btn-danger remove-paper">Remove</button></td>');
                $('#modalTableBody').append(row);
                 
                // Update count
                updateCount();
            }
        });

      
       
        $('#modalTableBody').on('click', '.remove-paper', function() {

            var row = $(this).closest('tr').clone();
            $(this).closest('tr').remove();
            // Remove the Remove button
            row.find('td:last').remove();
         
             row.find('.checkbox').prop('checked', false);

            
            // Append the removed row back to the main table
            $('#mainTableBody').append(row);
            
            // Update count
            updateCount();
        });
    });
</script> 


</body>

</html>
