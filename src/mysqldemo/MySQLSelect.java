package mysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLSelect {

	public static void main(String[] args) throws SQLException {

		//create Connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Secret@12");

		//create Statement or Query
		Statement stmt=con.createStatement();

		String s="SELECT SNo,Name FROM Students";

		//Execute Query
		ResultSet rs=stmt.executeQuery(s);

		while(rs.next()) {
			int sno=rs.getInt("SNo");
			String nam=rs.getString("Name");
			
			System.out.println(sno+"   "+nam);
		}

		//close Connection
		con.close();

		System.out.println("Executed");


	}

}
