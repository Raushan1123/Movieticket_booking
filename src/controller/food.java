package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class food
 */
@WebServlet("/food")
public class food extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public food() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // read form fields
    	int foodcost=0;
        String foodId = request.getParameter("id");
        if(foodId.equals("food1")){
        	foodcost=100;
        }
        else if(foodId.equals("food2")){
        	foodcost=150;
        }
        else if(foodId.equals("food3")){
        	foodcost=200;
        }
        // do some processing here...
        try
        {
        	int total= foodcost+book.cost;
        	PrintWriter writer = response.getWriter();
            String htmlRespone = "<html>";   
            htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>BILL</h2><hr><br/><h3>Tickets: " + book.cost + "</h3><h3>Food Combo: " + foodcost + "</h3><hr><h3>Total: " + total + "</h3><br></div></center>"; 
          htmlRespone += "<h2>Bill</h2><br/>";
            htmlRespone += "<h2>Tickets: "+ book.cost +"</h2><br/>";
            htmlRespone += "<h2>Food: "+ foodcost +"</h2><br/>";
            htmlRespone += "<h2>Total: "+ total +"</h2><br/>";
            htmlRespone+="</html>";
            writer.println(htmlRespone);
            htmlRespone="<br><center><br><a href='NewFile.jsp'><button>Back</button></a></center>";
            writer.println(htmlRespone);
            htmlRespone="<br><center><br><br><a  href=\"payment.html\"><button>Pay Now</button></a></center>";
	          writer.println(htmlRespone);
         }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
      
}
	}


