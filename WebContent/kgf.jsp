<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="connection.myconnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket booking</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-inverse" style="margin-bottom:0px;">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="User.jsp" style="font-size: 40px;"><b>Movies Talkies</b></a>
    </div>
    <ul class="nav navbar-nav navbar-right">
      <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span>Admin</a></li> -->
      <li><a data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-user"></span><b> Admin</b></a></li>
      <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> User Login</a></li> -->
      <li><a data-toggle="modal" data-target="#MyModal"><span class="glyphicon glyphicon-user"></span><b> User Login</b></a></li>
    </ul>
  </div>
</nav>
<body>

<div class="container">
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Admin Login</h4>
          </div>
          <div class="modal-body">
            
            <form action="Login" method="POST">
        <input type="text" name="Username" placeholder="Username">&nbsp;
        <input type="password" name="Password" placeholder="Password">
        <input type="submit" class="btn btn-primary">
    </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <div class="container">
    <!-- Modal -->
    <div class="modal fade" id="MyModal" role="dialog">
      <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">User Login</h4>
          </div>
          <div class="modal-body">
            
            <form action="Regis" method="post" >
  
  <div class="ooo">
    <h1>Register To Sign In</h1>
      Name :<br>
      <input type="text" name="name" placeholder="Enter your name" size="40"><br>
    </div>
 
    <div class="ooo">
      Email :<br>
      <input type="email" name="email" placeholder="Enter Email" size="40"><br>
    </div>

    <div class="ooo">
      City :<br>
      <input type="text" name="city" placeholder="Enter city" size="40"><br>
    </div>
    <div class="ooo">
      Password :<br>
      <input type="Password" name="pass" placeholder="Enter  password" size="40"><br>
    </div>
    
    <div class="ooo">
    <button type="submit">Login</button>
    </div>
    </form>
    </div>
    </div>
    </div>
    </div>
    </div>
    <br/>
    <br/>
    
    <div class="container movie-details">
    <div class="row">
     <div class="column left-box">
     
     <h1 id="hed1">KGF(chapter 1)</h1>
   <iframe class="center" width="860" height="415" src="https://www.youtube.com/embed/-KfsY-qwBS0" 
   frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
     </div>
     <div class="col-sm-12">
     <p>SYNOPSIS
<br/>
<br/>
    The blood-soaked land of Kolar Gold Fields (KGF) has a new overlord now - Rocky, whose name
     strikes fear in the heart of his foes. His allies look up to Rocky as their saviour, 
     the government sees him as a threat to law and order; enemies are clamouring for revenge 
     and conspiring for his downfall. Bloodier battles and darker days await as Rocky continues 
     on his quest for unchallenged supremacy. 


      </p>

     <p>CAST: </p>
     <div class="casting">
     <img src="./image/image1/yash.jpg" title="Yash">
     <img src="./image/image1/Srinidhi shetty.jpg" title="Srinidhi shetty">
     <img src="./image/image1/tamannah.jpg" title="Tamannah bhatia">
     <img src="./image/image1/anant.jpg" title="Anant nag">
     </div>
     
     </div>
     </div>
     </div>
      <br/>
     <br/>
      <form action="book" method="post">
<div>

  <div class="container" style="float:left; margin-left:100px;">
    <table class="table table-hover">
        <thead>
            <tr>
            <th>Select</th>
            <th>Movie</th>
                <th>Show Slot</th>
                <th>Duration</th>
                <th>Screen No.</th>
                <th>Available</th>
            </tr>
        </thead>
        <tbody>
           
        <%
        Connection con=myconnect.dbcon();
        String sql="select * from shows";
        PreparedStatement ps= con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
        	%>
        	
        	<%
        	   int id=rs.getInt("id");
        	   int Mid=rs.getInt("Mid");
        	   int screen=rs.getInt("screen");
        	   int slot=rs.getInt("slot");
        	   int avail=rs.getInt("booked");
        	   String sql2="select title,duration from moviedatabase where title='KGF' AND id="+Mid;
        	   PreparedStatement ps2= con.prepareStatement(sql2);
        	   ResultSet rs2=ps2.executeQuery();
        	   String moviename=null;
        	   int duration=0;
        	   boolean a=true;
        	   while(a && rs2.next()){
                   moviename = rs2.getString("title");
                   duration= rs2.getInt("duration");
                   a=false;
                 }
        	   if(moviename==null){
        		   continue;
        	   }
                 int start=0, end=0;
                 if(slot==1){
                   start=9;
                   end=1;
                 }
                 else if(slot==2){
                   start=1;
                   end=5;
                 }
                 else if(slot==3){
                   start=5;
                   end=9;
                 }
                 if(screen==1){
                 	avail=100-avail;
                 }
                 if(screen==2){
                 	avail=150-avail;
                 }
                 if(screen==3){
                 	avail=200-avail;
                 }
             
             %>
             <tr>
                <td><input type="radio" value=<%=id %> name="id"></td>
                <td><%=moviename %></td>
                <td><%=start %> to <%=end %></td>
                <td><%=duration %> minutes</td>
                <td><%=screen %></td>
                <td><%=avail %></td>
            </tr>               
             
        	<% 
        }
        %>
        
        
        </tbody>
        </table>
  </div>
</div>
<br/>
<br/>
<div class="testbox3"  style="margin: 0 auto; margin-top:100px;">
        <h1>Book Movie</h1>
       

          <input type="number" name="num" placeholder="No. Of Seats">
          <br /><br/>
          <select name="class">
              <option value="silver">Silver - Rs.100</option>
              <option value="gold">Gold - Rs.150</option>
              <option value="platinum">Platinum - Rs.200</option>
        </select>
          <br /><br />
          <input class="btn btn-primary" type="submit" value="BOOK NOW">
      
</div>
</form>
<br/>
<br/>
     
     
     <div class="container series">
     <h2 id="hed2">You might also like</h1>
     <div class="row">
     <div class="col-md-4">
     <div class="row">
     <div class="col-6"><a href="Avengers 2.jsp"><img src="./image/image1/Avengers 2.jpg"></a></div>&nbsp;
     <div class="col-6"><a href="pyaar de.jsp"><img src="./image/image1/De De Pyaar De.jpg"></a></div>
     </div>
     </div>
     <div class="col-md-4">
     <div class="col-6"><a href="phoenix.jsp"><img src="./image/image1/Dark phoenix.jpg"></a></div>&nbsp;
     <div class="col-6"><a href="#"><img src="./image/image1/Bahubali 2.jpg"></a></div>
     </div>
     <div class="col-md-4">
      <div class="col-6"><a href="#"><img src="./image/image1/Deadpool 2.jpg"></a></div>&nbsp;
     <div class="col-6"><a href="#"><img src="./image/image1/MS Dhoni.jpg"></a></div>
     </div>
     </div>
     </div>
     <br/>
     <br/>
     <br/>
     <br/>
 
  <jsp:include page="footer.jsp" />

     

</body>
<style>
*
{
margin: 0;
padding:0;
}

body{
background-image:linear-gradient(rgba(0,0,0,0.8),rgba(0,0,0,0.8)),url(/image/image1/Avengers-EndGame-Full-Movie.jpg);
background-position: center;
background-size: cover;
}
.movie-details{
margin: 3% 0
}
.left-box{
color: #fff;
}
#hed2{
color: #fff;
}
p{
padding: 70px 0px 10px 130px;
color: #fff;
}
.casting img{
margin-left: 90px;
height: 120px;
width:120px;
cursor: pointer;
}
.center{
margin: 0 auto;
display: block;
}
#hed1{
text-align: center;
}
.testbox3 {
  /*margin: 20px auto;*/
  width: 300px; 
  padding-left: 60px;
  /*height: 330px;*/ 
  -webkit-border-radius: 8px/7px; 
  -moz-border-radius: 8px/7px; 
  border-radius: 8px/7px; 
  background-color: #ebebeb; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  border: solid 1px #cbc9c9;
}

.testbox3{
  height: 185px; 
}
th,td{
color: #fff;
}

</style>

</html>