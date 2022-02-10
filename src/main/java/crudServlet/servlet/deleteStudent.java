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


public class deleteStudent extends HttpServlet{
	
	
	private static final long serialVersionUID = 102831973239L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException { 
		 int stuId = Integer.parseInt(request.getParameter("stuId"));
		 Controller contrl = new Controller();
		 contrl.deleteStudent(stuId);
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();  
		 out.print("<h3> Student Removed <h3>");
		 out.print("<a href='index.html'> Main Menu</a>");
	 }
	

}
