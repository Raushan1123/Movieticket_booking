<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="connection.myconnect"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.lang.*"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie Talkies</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-inverse" style="margin-bottom:0px;">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="NewFile.jsp" style="font-size: 40px;"><b>Movies Talkies</b></a>
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
    <!-- Modal -->l-header">
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
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
  </div>
<center>

<div id="carousel-example-generic" class="carousel slide container-fluid" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
     <li data-target="#carousel-example-generic" data-slide-to="3"></li>
      <li data-target="#carousel-example-generic" data-slide-to="4"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="./image/mo3.jpg" alt="..." style="width:800px; height:500px;">
      <div class="carousel-caption">
        <b>Movie 1</b>
      </div>
    </div>
    <div class="item">
      <img src="./image/mo2.jpg" alt="..." style="width:800px;height:500px;">
      <div class="carousel-caption">
       <b>Movie 2</b>
      </div>
    </div>
    <div class="item">
      <img src="./image/mo1.jpg" alt="..." style="width:800px;height:500px;">
      <div class="carousel-caption">
      <b>Movie 3</b>
      </div>
    </div>
    <div class="item">
      <img src="./image/mo4.jpg" alt="..." style="width:800px;height:500px;">
      <div class="carousel-caption">
      <b>Movie 4</b>
      </div>
    </div>
    <div class="item">
      <img src="./image/mo5.jpg" alt="..." style="width:800px;height:500px;">
      <div class="carousel-caption">
      <b>Movie 5</b>
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<br>
<br>
<br>


<div class="popover _location-popup" id="locationPopup">
        <div class="location-header struktur">
            <span class="__dismiss">
				<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">
					<use xlink:href="/icons/common-icons.svg#icon-cancel"></use>
				</svg>
			</span>
        	<span class="__icon-back">
				<svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">
					<use xlink:href="/icons/common-icons.svg#icon-go-back"></use>
				</svg>
			</span>
			<span class="__text" id="spnRgnHeadTxt">PICK YOUR STATE</span>
            <span class="twitter-typeahead" style="position: relative; display: inline-block;"><input class="form-input .l-input _dos tt-hint" type="text" style="position: absolute; top: 0px; left: 0px; border-color: transparent; box-shadow: none; opacity: 1; background: rgb(255, 255, 255) none repeat scroll 0% 0%;" readonly="" autocomplete="off" spellcheck="false" tabindex="-1" dir="ltr"><input class="form-input .l-input _dos tt-input" type="text" placeholder="ENTER YOUR CITY" id="inp_RegionSearch" autocomplete="off" spellcheck="false" dir="auto" style="position: relative; vertical-align: top; background-color: transparent;"><pre aria-hidden="true" style="position: absolute; visibility: hidden; white-space: pre; font-family: Roboto, sans-serif; font-size: 14px; font-style: normal; font-variant: normal; font-weight: 400; word-spacing: 0px; letter-spacing: 0px; text-indent: 0px; text-rendering: optimizelegibility; text-transform: none;"></pre><div class="tt-menu" style="position: absolute; top: 100%; left: 0px; z-index: 100; display: none;"><div class="tt-dataset tt-dataset-result"></div></div></span>
            <div data-id="inp_RegionSearch" class="inp-rgn-callout">
    			<ul></ul>
    		</div>
        </div>

        <div class="location-container">
        	<div class="location-pill-container" id="div_States"></div>

			<div class="city-list">
				<div class="__city-banner"></div>
				<div class="__list" id="div_CityName"></div>
			</div>
		</div>
    </div>
    </center>
    <div class="popular-listing popular-movies">
    <h2>Movies</h2><h3></h3>
   </div>&nbsp;
   <%
   Connection con = myconnect.dbcon();
   String sql="select * from cust ";
   PreparedStatement ps=con.prepareStatement(sql);
   ResultSet rs=ps.executeQuery();
   %>
   <table>
    <div class="row">
   <div class="column">
   <tr>
   <th></th>
   <th></th>
   <th></th>
   </tr>
   <tr>
   <td>
   <% 
   while(rs.next())
   {	
   	String picname=rs.getString(3);
   	String fname=rs.getString(1);
   %>
     <%String newpicadd= picname.substring(picname.lastIndexOf('\\')+1,picname.length()); %>
     <%	if(newpicadd.equals("Avengers 2.jpg")){
	%>
	<a href="Avengers 2.jsp">
	<img src="${pageContext.request.contextPath}/image/image1/<%=newpicadd %>" hspace="20">
	</a>
	<%}%>
       
       <%	if(newpicadd.equals("Dark phoenix.jpg")){
	%>
	<a href="phoenix.jsp">
	<img src="${pageContext.request.contextPath}/image/image1/<%=newpicadd %>" hspace="20">
	</a>
	<%}%>
	
	<%	if(newpicadd.equals("De De Pyaar De.jpg")){
	%>
	<a href="pyaar de.jsp">
	<img src="${pageContext.request.contextPath}/image/image1/<%=newpicadd %>" hspace="20">
	</a>
	<%}%>
	
	<%	if(newpicadd.equals("KGF.jpg")){
	%>
	<a href="kgf.jsp">
	<img src="${pageContext.request.contextPath}/image/image1/<%=newpicadd %>" hspace="20">
	</a>
	<%}%>

   <%}
   %>
   </td>
   </tr>
   </div>
   </div>
   </table>
   <br/>
   <table>
   <h2>COMING SOON</h2>
   <div class="row">
   <div class="column">&nbsp;&nbsp;&nbsp;
   <a href="#">
   <img src="./image/image1/conjuring3.jpg" hspace="20">
   </a>
   <a href="#">
   <img src="./image/image1/tomb.jpg" hspace="20">
   </a>
   <a href="#">
   <img src="./image/image1/Aladdin.jpg" hspace="20">
   </a>
   <a href="#">
   <img src="./image/image1/83.jpg" hspace="20">
   </a>
   </div>
   </div>
   </div>
   </table>
   <br/>
   <br/>
   <br/>
   <jsp:include page="footer.jsp" />
   </body>
    <style>
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, p, blockquote, th, td { 
  padding:0;
  margin:0;}

body,
input,
textarea,
select {
  font-family: 'Open Sans', sans-serif;
  font-size: 16px;
  color: #4c4c4c;
}

h1,h2 {
  font-size: 32px;
  font-weight: 300;
  color: #4c4c4c;
  text-align: center;
  padding-top: 10px;
  margin-bottom: 10px;
}

.testbox3{
  /*margin: 20px auto;*/
  width: 300px;
  float: left; 
   margin-left:50px;
  /*height: 330px;*/ 
  -webkit-border-radius: 8px/7px; 
  -moz-border-radius: 8px/7px; 
  border-radius: 8px/7px; 
  background-color: #22EAF; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  border: solid 1px #cbc9c9;
}

.testbox3{
  height: 300px; 
}
form{
  margin: 0 30px;
}


   /* .btn-group{
        float: left;
         position: relative;
         z-index: 597;
         margin-left:50px;
      }*/



input[type=text],input[type=password]{
  width: 200px; 
  height: 39px; 
  -webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  -moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px; 
  border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  background-color: #fff; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  border: solid 1px #cbc9c9;
  margin-left: -5px;
  margin-top: 13px; 
  padding-left: 10px;
}

input[type=password]{
  margin-bottom: 25px;
}

</style>
<script id="gs-sdk" src='//www.buildquickbots.com/botwidget/v3/demo/static/js/sdk.js?v=3' 
key="55a7189e-28ce-4eea-94a3-2b97a701aa36" ></script>

    </html>