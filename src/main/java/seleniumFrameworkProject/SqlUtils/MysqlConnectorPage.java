package seleniumFrameworkProject.SqlUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class MysqlConnectorPage {
	@Test
	public void getSqlConnection() throws SQLException {
		
		String host = "localhost";
		String port = "3306";
		String database = "world";
		String query = "select * from city where `Name` in ('Hyderabad')";
		
		Connection cn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+database, "root", "Thelappas@0924");
		
		Statement st = cn.createStatement();
		ResultSet rs=st.executeQuery(query);
		ResultSetMetaData rsmd = rs.getMetaData(); 
		int columnCount = rsmd.getColumnCount(); 
		// Print column names 
		for (int i = 1; i <= columnCount; i++) { 
			System.out.print(rsmd.getColumnName(i) + "\t"); 
			}
		System.out.println(); 
		// Process the ResultSet and print data 
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) { 
				System.out.print(rs.getString(i) + "\t"); 
				} 
			System.out.println();
				}
	}
	
}
