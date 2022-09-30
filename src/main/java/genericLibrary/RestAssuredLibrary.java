package genericLibrary;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	
	/**
	 * This class consists of generic methods related to restAssured
	 * @author AyushSharma
	 * @param response
	 * @param path
	 * @return jsonData
	 */
	
	public String getJsonData(Response response, String path)
	{
		String jsonData = response.jsonPath().get(path);
		return jsonData;
	}

}
