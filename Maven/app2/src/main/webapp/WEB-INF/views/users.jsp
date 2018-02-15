<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">

		<input type="hidden" id="student_id">
		Name: <input type="text" id="name" required="required" name="name"><br>
		Email: <input type="text" id="email" required="required" name="email"><br>
		<button onclick="submit();">Submit</button>
	
		<table id="table" border=1>
			<tr> <th> Name </th> <th> Email </th> <th> Edit </th> <th> Delete </th> </tr>
		
		</table>
				
	<script type="text/javascript">
	data = "";
	submit = function(){
		 
			$.ajax({
				url:'saveOrUpdate',
				type:'POST',
				data:{student_id: $("#student_id").val(), student_name: $('#name').val(), student_email: $('#email').val()},
				success: function(response){
						alert(response.message);
						load();		
				}				
			});			
	}
	
	delete_ = function(id){		 
		 $.ajax({
			url:'delete',
			type:'POST',
			data:{student_id:id},
			success: function(response){
					alert(response.message);
					load();
			}				
		});
}
	

	edit = function (index){
		$("#student_id").val(data[index].student_id);
		$("#name").val(data[index].student_name);
		$("#email").val(data[index].student_email);
		
	}

	load = function(){	
		$.ajax({
			url:'list',
			type:'POST',
			success: function(response){
					data = response.data;
					$('.tr').remove();
					for(i=0; i<response.data.length; i++){					
						$("#table").append("<tr class='tr'> <td> "+response.data[i].student_name+" </td> <td> "+response.data[i].student_email+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].student_id+");'> Delete </a>  </td> </tr>");
					}			
			}				
		});
		
	}
		
	</script>
	
</body>
</html>
