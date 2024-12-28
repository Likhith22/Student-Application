<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.student.dto.Student" %>
<%@ page import="com.student.dao.StudentDAO" %>
<%@ page import="com.student.dao.StudentDAOImp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initialscale=1.0">
<title>Student Management</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<%Student s=(Student)session.getAttribute("Student"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Welcome <%=s.getName() %></a>
			<button class="navbar-toggler" type="button" data-bstoggle="collapse" data-bs-target="#navbarNav" aria controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
				<%if(s.getId()==1){%>
				<li class="nav-item"> 
           		 <a class="nav-link" href="dashboard.jsp">Back</a> 
          		</li> 
          		<%}%>
					<li class="nav-item"><a class="nav-link" href="ForgetPin.jsp">ResetPassword</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="update.jsp">UpdateData</a></li>
					<li class="nav-item">
					<form action="Logout" method="post"><input class="btn btn-danger" type="submit" name="Logout" value="Logout"></form>
					
					</li>
				</ul>
			</div>
		</div>
	</nav>
	</div>
	<div class="container mt-4">
		<h1 class="text-center mb-4">Dashboard</h1>
	</div>
	<%String success=(String)request.getAttribute("success"); 
  if(success!=null){%> 
  <h3 class="success"><%=success%></h3>  
  <%}%> 
  <%String failure=(String)request.getAttribute("failure"); 
  if(failure!=null){%> 
  <h3 class="failure"><%=failure%></h3>  
  <%}%>
	<!-- User Section -->
	<div class="row">
		<div class="col-md-12">
			<h3>View Your Data</h3>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Phone</th>
						<th>Mail ID</th>
						<th>Branch</th>
						<th>Location</th>
						<th>Remove</th>
					</tr>
				</thead>
				<tbody>
                        <% 
                            // Instantiate DAO and fetch student list
                            StudentDAO dao = new StudentDAOImp();
                            List<Student> students = dao.getStudent();
                         
                            if (students != null && !students.isEmpty() ) {
                                for (Student s1 : students) {
                        %>
                        <tr>
                            <td><%= s1.getId() %></td>
                            <td><%= s1.getName() %></td>
                            <td><%= s1.getPhone() %></td>
                            <td><%= s1.getMailid() %></td>
                            <td><%= s1.getBranch() %></td>
                            <td><%= s1.getLoc() %></td>
                            <td><form action="viewUsers" method="post">
                            	<input type="hidden" name="id" value="<%=s1.getId()%>">
                            	<input type="hidden" name="mail" value="<%=s1.getMailid()%>">
                            	<input class="btn btn-danger" type="submit" value="Delete">
                            	</form>
                        </tr>
                        <% 
                                }
                            } else { 
                        %>
                        <tr>
                            <td colspan="6" class="text-center">No data available</td>
                        </tr>
                        <% } %>
                    </tbody>
			</table>
		</div>
</body>
</html>