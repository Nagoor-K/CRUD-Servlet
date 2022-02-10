package crudServlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudServlet.controller.Controller;
import crudServlet.entity.Address;
import crudServlet.entity.Course;
import crudServlet.entity.Student;


public class addStudent extends HttpServlet{
	
	
	private static final long serialVersionUID = 102831973239L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException { 
		 
		 String street = request.getParameter("street");
		 String city = request.getParameter("city");
		 String state = request.getParameter("state");
		 String zipcode = request.getParameter("zipcode");
		 
		 Address address = new Address(street,city,state,zipcode);
		 
		 Controller contrl = new Controller();
		 contrl.addAddress(address);
		 
		 String course1 = request.getParameter("course1");
		 double fee1 = Double.parseDouble(request.getParameter("fee1"));
		 String course2 = request.getParameter("course2");
		 double fee2 = Double.parseDouble(request.getParameter("fee2"));
		 
		 Course eng = new Course(course1,fee1);
     	 Course maths = new Course(course2,fee2);
    	 Set<Course> courses = new HashSet();
    	 courses.add(eng);
    	 courses.add(maths);
    	 
    	 String fName = request.getParameter("first");
    	 String lName = request.getParameter("last");
    	 String sCity = request.getParameter("Studentcity");
		 
		 Student stu = new Student(fName,lName,sCity,address,courses);
		 int id=contrl.addStudent(stu);
		 response.setContentType("text/html");  
		 PrintWriter out=response.getWriter();  
		 out.print("<h3> Student Added with id :</h3>");
		 out.print(id);
		 out.print("<a href='index.html'> Main Menu</a>");
	 }
	

}
