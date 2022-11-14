package mysqldemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQL {

	public static void main(String[] args) throws SQLException {

		//create Connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Secret@12");
		
		//create Statement or Query
		Statement stmt=con.createStatement();
		
		String s="update students Set DOB=2001 where Name='Sphoorthi'";
		
		//Execute Query
		stmt.execute(s);
		
		//close Connection
		con.close();
		
		System.out.println("Executed");



	}

}
