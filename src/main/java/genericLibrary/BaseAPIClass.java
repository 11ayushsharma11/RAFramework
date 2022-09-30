package genericLibrary;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

/**
 * This class will contain basic configuration annotations
 * @author AyushSharma
 *
 */

public class BaseAPIClass {
	
	public DatabaseLibrary dbLib = new DatabaseLibrary();
	public JavaUtility jUtil = new JavaUtility();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dbLib.connectToDB();
		Reporter.log("==DB Connection Successful==");
		
		baseURI = IConstantsLibrary.appURL;
		port = IConstantsLibrary.appPort;
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dbLib.closeDB();
		Reporter.log("==db closed==", true);
	}

}
