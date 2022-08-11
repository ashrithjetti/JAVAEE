package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteEmployee {
	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "password");

		Scanner s = new Scanner(System.in);
		System.out.print("Enter Employee ID: ");
		int id = s.nextInt();

		PreparedStatement ps = con.prepareStatement("delete from employees where id = ?");
		ps.setInt(1, id);

		int count = ps.executeUpdate();

		System.out.printf("Deleted Employee Successfully, Updated %d row(s)", count);

		ps.close();
		con.close();
	}
}
