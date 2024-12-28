package com.student.dao;

import java.util.List;

import com.student.dto.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean updateData(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail,String pass);
	public List<Student> getStudent();
	public Student getStudent(long phone, String mailid);
}
