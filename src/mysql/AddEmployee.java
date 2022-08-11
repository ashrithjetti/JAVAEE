package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class AddEmployee {

	public static void main(String[] args) throws Exception {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "password")) {
			Scanner s = new Scanner(System.in);

			System.out.println("Enter fullname: ");
			String name = s.nextLine();

			System.out.println("Enter Job: ");
			String job = s.nextLine();

			System.out.println("Enter Salary: ");
			int salary = s.nextInt();

			PreparedStatement ps = con.prepareStatement("insert into employees (fullname, salary, job) values (?,?,?)");
			ps.setString(1, name);
			ps.setInt(2, salary);
			ps.setString(3, job);

			int count = ps.executeUpdate(); //Execute DML commands - Insert and Update

			System.out.printf("Added Employee successfully, Updated %d row(s)", count);

			ps.close();
		} // end of try
	}// end of main()

}// end of method
