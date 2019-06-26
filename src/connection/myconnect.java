package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myconnect {
    
	public static Connection dbcon(){
		
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/registration"; 
		String username="root";
		String password="password";

		
		try {
			Class.forName(driver);
			try {
				con=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
