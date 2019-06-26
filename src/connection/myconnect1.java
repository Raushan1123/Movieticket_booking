package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class myconnect1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/registration"; 
		String username="root";
		String password="password";

		
		try {
			Class.forName(driver);
			try {
				con=DriverManager.getConnection(url,username,password);
				if(con!=null)
				{
					System.out.println("success");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
