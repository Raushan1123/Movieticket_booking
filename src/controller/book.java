package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.myconnect;
import controller.movie;
import controller.screen.screen1;
import controller.screen.screen2;
import controller.screen.screen3;
import controller.timeslot.timeslot1;
import controller.timeslot.timeslot2;
import controller.timeslot.timeslot3;
import controller.show.showS1T1;
import controller.show.showS1T2;
import controller.show.showS1T3;
import controller.show.showS2T1;
import controller.show.showS2T2;
import controller.show.showS2T3;
import controller.show.showS3T1;
import controller.show.showS3T2;
import controller.show.showS3T3;

/**
 * Servlet implementation class book
 */
@SuppressWarnings("unused")
@WebServlet("/book")
public  class book extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static int cost;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public book() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String eshowId = request.getParameter("id");
		String enumber = request.getParameter("num");
		String eclass = request.getParameter("class");
		out.println(eclass);
		
		Connection con=myconnect.dbcon();
		String sql = "select MId,screen,slot,booked from shows where id="+eshowId;
        out.println(eshowId);
        int screen=0, slot=0, booked=0, MId=0;
        PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = null;
			rs = ps.executeQuery();
	        String htmlResponse = "<html>";
	        
	        if(rs==null){
	        	htmlResponse += "<h2>Wrong Entry</h2><br>";
	        }
	        while(rs.next()){
	         screen = rs.getInt("screen");
	      	 slot = rs.getInt("slot");
	      	  booked = rs.getInt("booked");
	      	   MId = rs.getInt("MId");
	        }
	        sql = "select * from moviedatabase where id="+MId;
	        PreparedStatement ps1=con.prepareStatement(sql);
	        ResultSet rs1=ps1.executeQuery();
	        String name=null,genere=null,director=null;
	        int duration=0;
	        while(rs1.next()){
	        	 name = rs1.getString("title");
	       	  genere = rs1.getString("genere");
	       	  duration = rs1.getInt("duration");
	       	  director = rs1.getString("director");
	        }
	        String htmlResponse2;
	        // return response
	          
	          if(eclass.equals("silver")){
	        	  cost=100;
	          }
	          else if(eclass.equals("gold")){
	        	  cost=150;
	          }
	          else if(eclass.equals("platinum")){
	        	  cost=200;
	          }
	          int number=Integer.parseInt(enumber);
	          cost*=number;
	          out.println(cost);
	         show s = new show();
	         
	          
	          switch(screen){
	          	case 1: if(slot==1)
	          			{
	          		showS1T1 m = s.new showS1T1(name, genere, duration, director);
	          			m.booked=booked;
	          			if(!m.bookNew(number)){
	          				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	          			}
	          			else{
	          				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
	  	          			sql = " update shows set booked="+m.booked+" where id="+eshowId;
	  	          		out.println(sql);
	  	          		PreparedStatement preparedStmt = con.prepareStatement(sql);
	  	          	preparedStmt.execute();
	          			}
	          			}
	          			else if(slot==2){
	          				showS1T2 m=s.new showS1T2(name, genere, duration, director);
	          				m.booked=booked;
	          				if(!m.bookNew(number)){
	              				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	              			}
	              			else{
	              				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
	      	          		sql = " update shows set booked="+m.booked+" where id="+eshowId;
	      	          	out.println(sql);
	      	          		PreparedStatement preparedStmt = con.prepareStatement(sql);
	      	  	          	preparedStmt.execute();
	              			}
	          			}
	          			else{
	          				showS1T3 m=s.new showS1T3(name, genere, duration, director);
	          				m.booked=booked;
	          				if(!m.bookNew(number)){
	              				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	              			}
	              			else{
	              				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
	      	          		sql = " update shows set booked="+m.booked+" where id="+eshowId;
	      	          	out.println(sql);
	      	          	PreparedStatement preparedStmt = con.prepareStatement(sql);
	      	          	preparedStmt.execute();
	              			}
	          			}
	          			break;
	          			
	          	case 2: if(slot==1){
	          		showS2T1 m=s.new showS2T1(name, genere, duration, director);
	          		m.booked=booked;
	          		if(!m.bookNew(number)){
	      				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	      			}
	      			else{
	      				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
		          			sql = " update shows set booked="+m.booked+" where id="+eshowId;
		          			out.println(sql);
		          			PreparedStatement preparedStmt = con.prepareStatement(sql);
		      	          	preparedStmt.execute();
	      			}
	          		}
	  					else if(slot==2){
	  						showS2T2 m=s.new showS2T2(name, genere, duration, director);
	  						m.booked=booked;
	  						if(!m.bookNew(number)){
	  	          				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	  	          			}
	  	          			else{
	  	          				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
	  	  	          		sql = " update shows set booked="+m.booked+" where id="+eshowId;
	  	  	          	out.println(sql);
	  	  	          	PreparedStatement preparedStmt = con.prepareStatement(sql);
	  	  	          	preparedStmt.execute();
	  	          			}
	  					}
	  					else{
	  						showS2T3 m=s.new showS2T3(name, genere, duration, director);
	  						m.booked=booked;
	  						if(!m.bookNew(number)){
	  	          				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	  	          			}
	  	          			else{
	  	          				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
	  	  	          		sql = " update shows set booked="+m.booked+" where id="+eshowId;
	  	  	          	out.println(sql);
	  	  	          	PreparedStatement preparedStmt = con.prepareStatement(sql);
	  	  	          	preparedStmt.execute();
	  	          			}
	  					}
	  					break;
	  					
	          	case 3: if(slot==1){
	          		showS3T1 m=s.new showS3T1(name, genere, duration, director);
	          		m.booked=booked;
	          		if(!m.bookNew(number)){
	      				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	      			}
	      			else{
	      				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
		          			sql = " update shows set booked="+m.booked+" where id="+eshowId;
		          			out.println(sql);
		          			PreparedStatement preparedStmt = con.prepareStatement(sql);
		      	          	preparedStmt.execute();
	      			}
	          	}
	  					else if(slot==2){
	  						showS3T2 m=s.new showS3T2(name, genere, duration, director);
	  						m.booked=booked;
	  						if(!m.bookNew(number)){
	  	          				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	  	          			}
	  	          			else{
	  	          				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
	  	  	          		sql = " update shows set booked="+m.booked+" where id="+eshowId;
	  	  	          	out.println(sql);
	  	  	          	PreparedStatement preparedStmt = con.prepareStatement(sql);
	  	  	          	preparedStmt.execute();
	  	          			}
	  					}
	  					else{
	  						showS3T3 m=s.new showS3T3(name, genere, duration, director);
	  						m.booked=booked;
	  						if(!m.bookNew(number)){
	  	          				htmlResponse += "<center><h2>Show Full</h2><br/></center>"; 
	  	          			}
	  	          			else{
	  	          				htmlResponse += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +eclass+" tickets<br>Movie: "+name+"- ("+duration+" minutes)</p><h2>Screen: "+screen+"</h2><br><h2>Slot: "+slot+"</h2></div></center>"; 
	  	          		sql = " update shows set booked="+m.booked+" where id="+eshowId;
	  	          		out.println(sql);
	  	          	PreparedStatement preparedStmt = con.prepareStatement(sql);
	  	          	preparedStmt.execute();
	  	          			}
	  					}
	  					break;
	  					
	  			default: htmlResponse += "<center><h2>Wrong Input</h2><br/></center>"; 
	 
	          }
	          
	          con.close();
	          htmlResponse += "</html>";
	          out.println(htmlResponse);
	          htmlResponse="<br><center><a href=\"food.jsp\"><button>Order Meal</button></a></center>";
	          out.println(htmlResponse);
	          htmlResponse="<br><center><br><br><a href=\"NewFile.jsp\"><button>Back</button></a></center>";
	          out.println(htmlResponse);
	          htmlResponse="<br><center><br><br><a  href=\"payment.html\"><button>Pay Now</button></a></center>";
	          out.println(htmlResponse);
	        }


		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
        