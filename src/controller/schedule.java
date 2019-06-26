package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.myconnect;

/**
 * Servlet implementation class schedule
 */
@WebServlet("/schedule")
public class schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public schedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		String emovieId = request.getParameter("movieId");
		String escreen = request.getParameter("screen");
		String eslot = request.getParameter("slot");
		out.println("movie: " + emovieId);
		out.print("genere: "+ escreen + " " + eslot);
		
		Connection con=myconnect.dbcon();
		String sql="insert into shows (MId,screen,slot,booked)" + 
		"values(?, ?, ?, ?);";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(emovieId));
			ps.setInt(2, Integer.parseInt(escreen));
			ps.setInt(3, Integer.parseInt(eslot));
			ps.setInt(4, 0);
			
			int result=ps.executeUpdate();
			if(result!=0)
			{
				response.sendRedirect("option.jsp");
			}
			else{
				String htmlResponse = "<html>";
				htmlResponse +="<h2>Invalid credentials</h2>";
				htmlResponse +="<html>";
				out.println(htmlResponse);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
