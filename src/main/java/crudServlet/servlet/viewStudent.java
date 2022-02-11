package crudServlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudServlet.controller.Controller;
import crudServlet.entity.Student;


public class viewStudent extends HttpServlet{
	
	
	private static final long serialVersionUID = 102831973239L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
	         throws ServletException, IOException { 
		 int stuId = Integer.parseInt(request.getParameter("stuId"));
		 Controller contrl = new Controller();
		 Student s = contrl.viewStudent(stuId);
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 out.print("<p>");
		 out.print("<br>");
		 out.print("Student Id :"+s.getId());
		 out.print("<br>");
		 out.print("Student First Name :"+s.getFirstName());
		 out.print("<br>");
		 out.print("Student last Name :"+s.getLastName());
		 out.print("<br>");
		 out.print("Student City :"+s.getCity());
		 out.print("<br>");
		 out.print("</p>");
		 out.print("<a href='index.html'> Main Menu </a>");
	 }
	

}

