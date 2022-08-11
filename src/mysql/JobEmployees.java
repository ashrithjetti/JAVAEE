package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JobEmployees {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "password");

		Scanner s = new Scanner(System.in);
		// taking input from user
		System.out.print("Enter Job ID: ");
		String job = s.nextLine();

		PreparedStatement ps = con.prepareStatement("select fullname from employees where job = ?");
		ps.setString(1, job);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			System.out.printf("%s\n", rs.getString("fullname"));

		}

		rs.close();
		con.close();
	}
}
