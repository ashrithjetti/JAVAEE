package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessDemo {

	public static void main(String[] args) throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "root", "password");
		con.setAutoCommit(false); // start transaction
		Statement st = con.createStatement();

		try {

			// add command to batch
			st.addBatch("update employees set salary = salary +25000 where salary <= 500000");

			// add another command to batch
			st.addBatch("update employees set salary = salary +50000 where salary > 500000");

			int[] uc = st.executeBatch(); // statement to execute batch commands
			//con.commit(); commit has been kept on hold

			for (int i = 0; i < uc.length; i++) {
				System.out.print(i + ":" + uc[i] + "\n"); // UC - updated count
			} // end of FOR loop

		} // end of try block

		catch (SQLException ex) {
			System.out.println("Exception :" + ex.getMessage());
			con.rollback();
		} // end of catch block
	}
}
