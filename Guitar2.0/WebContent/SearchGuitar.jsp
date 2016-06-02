<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="searchGuitar" method="post"> 
 	 		<label>Builder:</label> 
 	 		<select name="builder"> 
 	 			<option value=""></option> 
 	 			<option value="GIBSON">GIBSON</option> 
 	 			<option value="OLSON">OLSON</option> 
 	 		</select> 
 	 		 
 	 		<label>Type:</label> 
 	 		<select name="type"> 
 	 			<option value=""></option> 
	 			<option value="ACOUSTIC">ACOUSTIC</option> 
 	 			<option value="ELECTRIC">ELECTRIC</option> 
 	 		</select> 
 	 		 
 	 		<label>BackWood:</label> 
 	 		<select name="backwood"> 
 	 			<option value=""></option> 
 	 			<option value="INDIAN_ROSEWOOD">INDIAN_ROSEWOOD</option>  
 				<option value="ALDER">ALDER</option> 
 				 
 	 		</select> 
 	 		 
 	 		<label>TopWood:</label> 
 	 		<select name="topwood"> 
 	 			<option value=""></option> 
 				<option value="MAPLE">MAPLE</option>  
 				<option value="ALDER">ALDER</option> 
 	 		</select> 
 	 		<input type="submit" name="search" value="Search"/>	 		 
 	 	</form> 

</body>
</html>