package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.myconnect;

/**
 * Servlet implementation class Regis
 */
@WebServlet("/Regis")
public class Regis extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String ename=request.getParameter("name");
		String email=request.getParameter("email");
		String ecity=request.getParameter("city");
		String epass=request.getParameter("pass");
		
		out.println(ename);
		out.println(email);
		out.println(ecity);
		out.println(epass);
		
		Connection con=myconnect.dbcon();
		
		
		String  sql="insert into users values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, ename);
			ps.setString(2, email);
			ps.setString(3, ecity);
			ps.setString(4, epass);
			int result=ps.executeUpdate();
			if(result!=0)
			{
				out.println("Successfully login");
				response.sendRedirect("NewFile.jsp");
			}else
			{
				String htmlResponse = "<html>";
				htmlResponse +="<h2>Invalid credentials</h2>";
				htmlResponse +="<html>";
				out.println(htmlResponse);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


