package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.connectors.ConnectionFactory;
import com.student.dto.Student;

public class StudentDAOImp implements StudentDAO{
	private Connection con;
	

	public StudentDAOImp() {
		this.con = ConnectionFactory.requestConnection();
	}

	@Override
	public boolean insertStudent(Student s) {
		// JDBC logics for insert operation
		
		String query="INSERT INTO STUDENT VAlUES(0,?,?,?,?,?,?,SYSDATE())";
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getMailid());
			ps.setString(4,s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setString(6, s.getPass());
			res=ps.executeUpdate();
		}catch( SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement("UPDATE STUDENT SET PASSWORD=? WHERE PHONE=? AND MAILID=?");
			ps.setString(1, s.getPass());
			ps.setLong(2,s.getPhone());
			ps.setString(3, s.getMailid());
			
			res=ps.executeUpdate();
		}catch( SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		
		return false;

	}
	

	@Override
	public boolean deleteStudent(Student s) {
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement("DELETE FROM STUDENT WHERE ID=?");
			ps.setInt(1,s.getId());
			res=ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		return false;
	}

	@Override
	public Student getStudent(String mail, String pass) {
		String query="SELECT * FROM STUDENT WHERE MAILID=? AND PASSWORD=?";
		PreparedStatement ps =null;
		ResultSet rs=null;
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				
				//String name=rs.getString("name");
				//s.setName(name);
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPass(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		}catch( SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Student> getStudent() {
		ArrayList<Student> students=new ArrayList<>();
		Student s=null;
		String query="SELECT * FROM STUDENT";
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				
				//String name=rs.getString("name");
				//s.setName(name);
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPass(rs.getString("password"));
				s.setDate(rs.getString("date"));
				students.add(s);
			}
		}catch( SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public Student getStudent(long phone, String mailid) {
		Student s=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("SELECT * FROM STUDENT WHERE PHONE=? AND MAILID=?");
			ps.setLong(1, phone);
			ps.setString(2, mailid);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				
				//String name=rs.getString("name");
				//s.setName(name);
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLoc(rs.getString("location"));
				s.setPass(rs.getString("password"));
				s.setDate(rs.getString("date"));
				
			}
		}catch( SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public boolean updateData(Student s) {
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement("UPDATE STUDENT SET NAME=?,PHONE=?,MAILID=?,BRANCH=?,LOCATION=? WHERE ID=?");
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMailid());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLoc());
			ps.setInt(6,s.getId());
			
			res=ps.executeUpdate();
		}catch( SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		
		return false;
	}

}
