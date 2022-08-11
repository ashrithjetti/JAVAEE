package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "password");
		System.out.println("Connected to HR database of MySQL");
		con.close();

	} // end of main()

} // end of method
