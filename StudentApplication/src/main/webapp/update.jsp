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
		<form action="update" method="post">
			<table>
				<tr>
					<td><b>Enter your Name:</b></td>
					<td><input type="text" name="name" value="<%=s.getName() %>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the phone number:</b></td>
					<td><input type="number" name="phone" value="<%=s.getPhone() %>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter your Mail id:</b></td>
					<td><input type="email" name="mailid" value="<%=s.getMailid() %>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter your branch:</b></td>
					<td><input type="text" name="branch" value="<%=s.getBranch() %>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter your Location:</b></td>
					<td><input type="text" name="location" value="<%=s.getLoc() %>"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				
				<tr>
					<td><input type="submit" value="update data"></td>
					<td align="right"><a href="dashboard.jsp">Back</a>
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