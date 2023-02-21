package org.mechit.LoginApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	

	/**
	 * 
	 */
	private static final long id  = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String username=req.getParameter("username");
		
		String password=req.getParameter("password");
		
			
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=dinga");
			
			pstmt=con.prepareStatement("INSERT INTO STUDENT.logindata VALUES(?,?)");
			
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			
			pstmt.executeUpdate();
			PrintWriter 
			out=resp.getWriter();
			 out.println("<html><body bgcolor='orange'>"
			                         
			 + "<h1>Registration done succesfully</h1>"
		                       
			 + 
			"</body></html>");
			 out.flush();
			 out.close();
			System.out.println("Data inserted");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			PrintWriter 
			out=resp.getWriter();
			 out.println("<html><body bgcolor='orange'>"
                     
			 + "<h1>Username already exists</h1>"
		                       
			 + 
			"</body></html>");
			 out.flush();
			 out.close();
		}
		
		finally {
			

			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				}
			
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			
			
			
		}
	}
	}}
	
	
	
	

