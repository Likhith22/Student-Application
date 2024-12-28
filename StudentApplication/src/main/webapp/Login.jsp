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
		<h3 class="sub">Login</h3>
		<% String success= (String) request.getAttribute("success");
		if(success!=null){%>
		<h3 class="success"> <%=success%></h3>
		<%}%>
		
		<% String failure= (String) request.getAttribute("failure");
		if(failure!=null){%>
		<h3 class="failure"> <%=failure%></h3>
		<%}%>
		<form action="Login" method="post">
			<table>
				<tr>
					<td><b>Enter your Mail id:</b></td>
					<td><input type="email" name="mail"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				<tr>
					<td><b>Enter the password:</b></td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Login"></td>
					<td><a href="ForgetPin.jsp">forget pin?</a></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
			</table>
			Don't have a account?<a href="Signup.jsp">signup</a>
		</form>
	</div>
</body>
</html>