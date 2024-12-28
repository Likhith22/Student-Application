package com.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ForgetPin")
public class ForgetPin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Collect the data from users
		
		String phonenumber = req.getParameter("phone");
		String mailid = req.getParameter("mail");
		String Pass = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm");
		
		//conversion of datatypes
		long phone = Long.parseLong(phonenumber);
		PrintWriter out=resp.getWriter();
		
		//JDBC Implemetation
		StudentDAO sd=new StudentDAOImp();
		Student s=sd.getStudent(phone,mailid);
		if(s!=null&&Pass.equals(confirmPassword)) {
			s.setPhone(phone);
			s.setMailid(mailid);
			s.setPass(confirmPassword);
			boolean result=sd.updateStudent(s);
			if(result) {
				req.setAttribute("success", "Update Successful");
				RequestDispatcher rd=req.getRequestDispatcher("ForgetPin.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("failure", "Update Failed");
				RequestDispatcher rd=req.getRequestDispatcher("ForgetPin.jsp");
				rd.forward(req, resp);
			}
		}
	}
}