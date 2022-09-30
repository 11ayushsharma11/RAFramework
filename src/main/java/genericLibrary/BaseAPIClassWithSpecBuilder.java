package genericLibrary;

import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPIClassWithSpecBuilder {
	
	public DatabaseLibrary dbLib = new DatabaseLibrary();
	public JavaUtility jUtil = new JavaUtility();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	public RequestSpecification requestSpecification;
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		dbLib.connectToDB();
		Reporter.log("==DB Connection Successful==");
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder(); 
		requestSpecBuilder.setBaseUri(IConstantsLibrary.appURL);
		requestSpecBuilder.setPort(8084);
		requestSpecBuilder.setContentType(ContentType.JSON);
		
		requestSpecification = requestSpecBuilder.build();
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		dbLib.closeDB();
		Reporter.log("==db closed==", true);
	}
}
