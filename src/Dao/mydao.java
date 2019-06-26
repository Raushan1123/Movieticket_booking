package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.mybean;
import connection.myconnect;

public class mydao {
Connection con=myconnect.dbcon();
PreparedStatement ps=null;
int result;
ResultSet rs;
public int insert(mybean b){
	String sql="insert into registration values(?,?,?,?,?,?,?,?,?,?)";
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1, b.getEfirst());
		ps.setString(2, b.getElast());
		ps.setString(3, b.getEadd());
		ps.setString(4, b.getEmail());
		ps.setString(5, b.getEcontact());
		ps.setString(6,b.getEdob());
		ps.setString(7, b.getEgender());
		ps.setString(8, b.getEstate());
		ps.setString(9, b.getEcity());
		ps.setString(10, b.getEpass());
		
		result=ps.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}
public ResultSet userlogin(mybean b)
{
	String sql="select * from registration where Firstname=? and Password=?";
	try{
	ps=con.prepareStatement(sql);
	ps.setString(1, b.getEfirst());
	ps.setString(2, b.getEpass());
	rs = ps.executeQuery();
}catch(SQLException e){
	e.printStackTrace();
}

   return rs;
}
}
