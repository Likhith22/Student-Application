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
		<h3 class="sub">Application form</h3>
		<% String success= (String) request.getAttribute("success");
		if(success!=null){%>
		<h3 class="success"> <%=success%></h3>
		<%}%>
		
		<% String failure= (String) request.getAttribute("failure");
		if(failure!=null){%>
		<h3 class="failure"> <%=failure%></h3>
		<%}%>
		<form action="Signup" method="post">
			<table>
				<tr>
					<td><b>Enter your Name:</b></td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Phone number:</b></td>
					<td><input type="tel" name="phone"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Mail ID:</b></td>
					<td><input type="email" name="mail"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Branch:</b></td>
					<td><input type="text" name="branch"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><b>Enter the Location:</b></td>
					<td><input type="text" name="loc"></td>
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
					<td><b>Confirm the password:</b></td>
					<td><input type="password" name="confirm"></td>
				</tr>
				<tr>
					<td><br></td>
					<td><br></td>
				</tr>
				<tr>
					<td><input type="submit" value="create account"></td>
					<td><b>already have a account? </b><a href="Login.jsp">login</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>