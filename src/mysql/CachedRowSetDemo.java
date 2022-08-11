package mysql;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CachedRowSetDemo {

	public static void main(String[] args) throws Exception {
		CachedRowSet rowset = RowSetProvider.newFactory().createCachedRowSet();
		rowset.setUrl("jdbc:mysql://localhost:3306/hr");
		rowset.setUsername("root");
		rowset.setPassword("password");
		rowset.setCommand("select * from employees");
		rowset.execute(); // connect and retrieve data

		while (rowset.next()) {
			System.out.printf("%-15s %8d %-5s\n", rowset.getString("fullname"), rowset.getInt("salary"),
					rowset.getString("job"));
		}

	} // end of main()

} // end of method
