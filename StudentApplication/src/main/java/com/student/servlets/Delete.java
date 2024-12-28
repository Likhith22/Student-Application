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

@WebServlet("/viewUsers")
public class Delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);

		StudentDAO sd=new StudentDAOImp();
		HttpSession session=req.getSession(false);
		Student s=(Student)session.getAttribute("Student");
		if(s!=null) {
			s.setId(id);
			boolean result=sd.deleteStudent(s);
			if(id!=1) {			
				req.setAttribute("failure", "admin can not be deleted");
				RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");
				rd.forward(req, resp);
			} else {
				if(result) {
					req.setAttribute("Student",sd.getStudent());
					req.setAttribute("success", "delete successfull");
					RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");
					rd.forward(req, resp);
				}else {
					req.setAttribute("failure", "delete unsuccessful");
					RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");
					rd.forward(req, resp);
				}
			}
		}
	}
}