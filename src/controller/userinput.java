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
 * Servlet implementation class userinput
 */
@WebServlet("/userinput")
public class userinput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userinput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String eid = request.getParameter("id");
		String emovie = request.getParameter("movieName");
		String egenere = request.getParameter("genere");
		String eduration = request.getParameter("duration");
		String edirector = request.getParameter("director");
		out.println("id: " + eid);
		out.println("movie: " + emovie);
		out.println("genere: " + egenere);
		
		Connection con=myconnect.dbcon();
		String sql = "insert into moviedatabase(id,title,genere,duration,director)" + "values(?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(eid));
			ps.setString(2, emovie);
			ps.setString(3, egenere);
			ps.setInt(4, Integer.parseInt(eduration));
			ps.setString(5, edirector);
			int result=ps.executeUpdate();
			if(result!=0){
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
