<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="connection.myconnect" %>
<%@ page import="java.sql.Connection" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddData" method="post" enctype="multipart/form-data">
<table>
<tr><td>Enter First name :</td><td><input type="text" name="fname"></td></tr>
<tr><td>Enter Last name :</td><td><input type="text" name="lname"></td></tr>
<tr><td>Upload Image :</td><td><input type="file" name="file"></td></tr>
<tr><td><input type="submit" value="Save"></td></tr>
</table>
</form>
</body>
</html>