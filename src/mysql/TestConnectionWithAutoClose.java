package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectionWithAutoClose {

	public static void main(String args[]) throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "password")) {
			System.out.println("Connected to HR database of MySQL");
		}
	} // end of main
}// end of method
