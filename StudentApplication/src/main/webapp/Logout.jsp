<%@ page import="com.student.dto.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.heading {
	color: #000080;
}

.sub {
	color: #1e90ff;  
}
</style>
</head>
<body bgcolor='#add8e6'>
	<div align="center">
		<h1 class="heading">Pentagon Space</h1>
		<h3 class="sub">Update your data</h3>
		<% Student s=(Student)session.getAttribute("Student");%>
		<% String success= (String) request.getAttribute("success");
		if(success!=null){%>
		<%=success%>
		<%}%>
		
		<% String failure= (String) request.getAttribute("failure");
		if(failure!=null){%>
		<%=failure%>
		<%}%>
		<form action="Logout" method="post">
			<table>
				<tr>
					<td><input type="submit" value="update data"></td>
					<td align="right"><a href="Login.jsp">Back</a>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>