package com.servlet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SUBMIT")

public class registerservlet extends HttpServlet {
	private static final String INSERT_QUERY = "INSERT INTO information(FirstName,LastName,Email,Mobile,University,Degree,Domain,year,Skills) VALUES(?,?,?,?,?,?,?,?,?)";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String FirstName = req.getParameter("FirstName");
		String LastName = req.getParameter("LastName");
		String Email = req.getParameter("Email");
		String numericField= req.getParameter("numericField");
		String University = req.getParameter("University");
		String Degree = req.getParameter("Degree");
		String domain = req.getParameter("domain");
		String year = req.getParameter("year");
		String Skills = req.getParameter("Skills");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///registerform", "root", "Root");
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);) {
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setString(3, Email);
			ps.setString(4, numericField);
			ps.setString(5,University);
			ps.setString(6, Degree);
			ps.setString(7, domain);
			ps.setString(8, year);
			ps.setString(9, Skills);

			int count = ps.executeUpdate();
			if (count == 0) {
				pw.println("Record not stored into Database");
			} else {
				pw.println("<html><body>");
			    pw.println("<table border=\"1\"><tr><th>Name</th><th>Email</th><th>Mobile</th><th>University</th><th>Degree</th><th>Domain</th><th>Year</th><th>Skills</th></tr>");
				pw.println("<tr><td>"+FirstName+LastName+"</td>"+"<td>"+Email+"</td>"+"<td>"+numericField+"</td>"+"<td>"+University+"</td>"+"<td>"+Degree+"</td>"+"<td>"+domain+"</td>"+"<td>"+year+"</td>"+"<td>"+Skills+"</td></tr>");
				pw.println("</table>");
				pw.println("</body></html>");
				
			}
		} catch (SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		} catch (Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		 
		

		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
