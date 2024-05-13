<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 		<%
 		 response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); //depends on HTTP version we are using
 		 if(session.getAttribute("username")==null){
 			 response.sendRedirect("login.jsp");
 		 }
 		%>
 		
 		Hey ${username} <br>
 		
 		<a href ="videos.jsp">Videos here</a>
 		<form action="Logout">
 			<input type ="submit" value ="LOGOUT">
 		</form>

</body>
</html>