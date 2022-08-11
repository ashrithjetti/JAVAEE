package mysql;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.RowSetProvider;
import java.util.Scanner;

public class FilteredRowSetDemo {

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		// taking input from user
		System.out.print("Enter the Job ID:");
		String job = s.nextLine();

		FilteredRowSet rowSet = RowSetProvider.newFactory().createFilteredRowSet();
		rowSet.setUrl("jdbc:mysql://localhost:3306/hr");
		rowSet.setUsername("root");
		rowSet.setPassword("password");
		rowSet.setCommand("select fullname,salary from employees where job = ?");
		rowSet.execute();
		
		while(rowSet.next())
		{
			System.out.printf("%-20s %-5d\n", rowSet.getString("fullname"), rowSet.getInt("salary"));
		}
	}

}
