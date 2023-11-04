package GenericLibrery;

import io.restassured.response.Response;

public class RestAssuredLibrery {

	public String getJsonData(Response response, String path) {
		
		String jsonData = response.jsonPath().get(path);
		
		return jsonData;
		
	}
}
