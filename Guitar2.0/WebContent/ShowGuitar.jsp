<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="border:2px solid #FF0000;"> 
 	 		<tr> 
 	 			<th>编号</th> 
 	 			<th>价格</th> 
 	 			<th>制造商</th> 
 	 			<th>型号</th> 
 	 			<th>种类</th> 
 	 			<th>面板</th> 
 	 			<th>背板</th> 
 	 			<th>序号</th> 
 	 		</tr> 
 	 		 
 	 	<c:forEach var="matchingGuitar" items="${requestScope.matchingGuitar}">  
 	 		<tr> 
 	 			<td>${matchingGuitar.serialNumber}</td>
 	 			<td>${matchingGuitar.price}</td> 
 	 			<td>${matchingGuitar.spec.builder}</td>
 	 			<td>${matchingGuitar.model}</td> 
 	 			<td>${matchingGuitar.spec.type}</td>
 	 			<td>${matchingGuitar.spec.backWood}</td> 
 	 			<td>${matchingGuitar.spec.topWood}</td> 
 	 			<td>${matchingGuitar.numStrings}</td> 
 	 		</tr>			 
 	 	</c:forEach> 
 
 
 	</table> 

</body>
</html>