package mysql;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class UpdateSalary {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "password");
		PreparedStatement ps = con.prepareStatement("update employees set salary = ? where id = ?");
		ps.setInt(1, 550000); // salary
		ps.setInt(2, 2); // id

		int count = ps.executeUpdate();

		System.out.printf("Updated %d row(s)", count);

		ps.close();
		con.close();

	}

}
