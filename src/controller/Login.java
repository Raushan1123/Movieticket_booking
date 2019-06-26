package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		String euser=request.getParameter("Username");
		String epass=request.getParameter("Password");
		
		out.println("Username admin: " + euser);
		out.println("Username admin: " + epass);
		
		if(euser.equals("admin") && epass.equals("12345")){
			response.sendRedirect("option.jsp");
		}
		else{
			String htmlResponse = "<html>";
			htmlResponse +="<h2>Invalid credentials</h2>";
			htmlResponse +="<html>";
			out.println(htmlResponse);
		}
		
	}

}
