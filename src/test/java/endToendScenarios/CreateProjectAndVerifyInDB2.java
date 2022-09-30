package endToendScenarios;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClassWithSpecBuilder;
import genericLibrary.EndPointsLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.CreateProjectPayload;

public class CreateProjectAndVerifyInDB2 extends BaseAPIClassWithSpecBuilder {
	
	@Test
	public void createProject() throws SQLException
	{
		// Create Prerequisites
		
		CreateProjectPayload pojo = new CreateProjectPayload("Ayush", "SDET200" + jUtil.getRandomNumber(), "Created", 14);
		
		//send the post request
		
		Response resp = given()
				.spec(requestSpecification)
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
