package mysql;

import java.sql.SQLException;
import javax.sql.rowset.Predicate;
import javax.sql.RowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.util.Scanner;

//Salary Predicate function to be used as filter
class SalaryPredicate implements Predicate {
	private int salary;

	public SalaryPredicate(int salary) {
		this.salary = salary;
	}

	// rows are selected if the condition is true and rows are omitted if the
	// condition is false
	@Override
	public boolean evaluate(RowSet rs) {
		try {
			return rs.getInt("salary") > this.salary;
		} catch (Exception ex) {
			return false;
		}
	} // end of evaluate

	@Override
	public boolean evaluate(Object arg0, int arg1) throws SQLException {
		return false;
	}

	@Override
	public boolean evaluate(Object arg0, String arg1) throws SQLException {
		return false;
	}

}
//end of class SalaryPredicate

public class ListEmployeesBySalary {

	public static void main(String[] args) throws Exception {

		try (FilteredRowSet rowSet = RowSetProvider.newFactory().createFilteredRowSet()) {
			rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
			rowSet.setUsername("root");
			rowSet.setPassword("password");
			rowSet.setCommand("select * from employees");
			rowSet.execute();

			Scanner s = new Scanner(System.in);

			// taking input from user
			while (true) {
				System.out.print("Enter the salary [0 to stop]:");
				int salary = s.nextInt();
				if (salary == 0)
					break;

				rowSet.setFilter(new SalaryPredicate(salary));
				rowSet.beforeFirst(); // go back to the beginning
				while (rowSet.next()) {
					System.out.printf("%-30s %-8d\n", rowSet.getString("fullname"), rowSet.getInt("salary"));

				}
			} // end of while

		} // end of try block

	}// end of main()

}// end of class
