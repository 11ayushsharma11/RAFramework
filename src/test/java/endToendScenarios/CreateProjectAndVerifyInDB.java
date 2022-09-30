package endToendScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.CreateProjectPayload;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;

public class CreateProjectAndVerifyInDB extends BaseAPIClass{
	
	@Test
	public void createProject() throws SQLException
	{
		// Create Prerequisites
		
		CreateProjectPayload pojo = new CreateProjectPayload("Ayush", "SDET200" + jUtil.getRandomNumber(), "Created", 14);
		
		//send the post request
		
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(pojo)
				.when()
				.post(EndPointsLibrary.createProject);
		
		//capture the project id
		
		String expData = rLib.getJsonData(resp, "projectId");
		System.out.println(expData);
		
		//verify the projectId in DB
		
		String query = "Select * from project";
		String actualData = dbLib.executeQueryAndReturnData(query, 1, expData);
		Assert.assertEquals(actualData, expData);
		
	}

}
