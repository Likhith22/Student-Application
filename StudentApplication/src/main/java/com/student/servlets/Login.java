package com.student.servlets;

import java.io.IOException;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Creating session object
		HttpSession session=req.getSession();
		//Collect the data from users
		String mailid=req.getParameter("mail");
		String Pass=req.getParameter("password");
		
		//PrintWriter out=resp.getWriter();
		StudentDAO sd=new StudentDAOImp();
		Student s=sd.getStudent(mailid,Pass);
		if(s!=null) {
			session.setAttribute("Student",s);
			RequestDispatcher rd=req.getRequestDispatcher("dashboard.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("failure", "Login Failed");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}
}