package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DatabaseLibrary {
	
	private Driver driverRef;
	private Connection con;
	
	public void connectToDB() throws SQLException
	{
		driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstantsLibrary.dbURL, IConstantsLibrary.dbUsername, IConstantsLibrary.dbPassword);
	}
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
	
	public String executeQueryAndReturnData(String query, int columnIndex, String expectedData) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		String actualData = " ";
		while(result.next())
		{
			actualData = result.getString(columnIndex);
			if(expectedData.equalsIgnoreCase(actualData))
			{
				flag = true;
			}
		}
		
		if(flag)
		{
			System.out.println("==The data is verified==");
			return actualData;
		}
		else
		{
			System.out.println("==The data is not verified==");
		}
		return actualData;
	}

}
