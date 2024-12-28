package com.student.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

public class StudentDAOapp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		StudentDAO sdao =new StudentDAOImp();
		
		/*System.out.println("Enter the name");
		//String name=sc.next();
		//s.setName(name);
		//To reduce the unnecessary storing in different variable. Directly use it in a setName 
		s.setName(sc.next());
		
		System.out.println("Enter the phone number");
		s.setPhone(sc.nextLong());
		System.out.println("Enter the mailId");
		s.setMailid(sc.next());
		System.out.println("Enter the branch");
		s.setBranch(sc.next());
		System.out.println("Enter the location");
		s.setLoc(sc.next());
		System.out.println("Enter the password");
		String pass=sc.next();
		System.out.println("Confirm the password");
		String conPass=sc.next();
		if(pass.equals(conPass)) {
			s.setPass(pass);
			
			StudentDAOImp st=new StudentDAOImp();
			boolean insert=st.insertStudent(s);
			if(insert) {
				System.out.println("Data added successfully");
			}
			else {
				System.out.println("Data was not added");
			}
		}
		else {
			System.out.println("Password missmatch");
		}*/
		
		List<Student> studentList=sdao.getStudent();
		Iterator<Student> st=studentList.iterator();
		while(st.hasNext()) {
			Student s=st.next();
			System.out.println(s);
		}
		
		sc.close();
		
	}

}
