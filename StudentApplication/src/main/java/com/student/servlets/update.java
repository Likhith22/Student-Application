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

@WebServlet("/update")
public class update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Collect the data from users
		String name=req.getParameter("name");
		String phonenumber = req.getParameter("phone");
		String mailid = req.getParameter("mailid");
		String branch=req.getParameter("branch");
		String location=req.getParameter("location");
		//conversion of datatypes
		long phone = Long.parseLong(phonenumber);
		
		//Creating session object
		HttpSession session=req.getSession(false);
		Student s=(Student)session.getAttribute("Student");
		
		StudentDAO sd=new StudentDAOImp();

		if(s!=null) {
			s.setName(name);
			s.setPhone(phone);
			s.setMailid(mailid);
			s.setBranch(branch);
			s.setLoc(location);

			boolean result=sd.updateData(s);
			
			if(result) {			
				req.setAttribute("success", "Updated Successful");
				RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("failure", "Update Failed");
				RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
				rd.forward(req, resp);
			}
		}else {
			req.setAttribute("failure", "Give proper data");
			RequestDispatcher rd=req.getRequestDispatcher("update.jsp");
			rd.forward(req, resp);
		}
	}
}