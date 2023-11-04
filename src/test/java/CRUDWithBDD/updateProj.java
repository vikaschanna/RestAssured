package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateProj extends JavaUtility {
	@Test
	public void update() {
		baseURI="http://rmgtestingserver";
		port=8084;
		JSONObject json = new JSONObject();
				json.put("createdBy", "Vikas");
		json.put("projectName", "manga"+generateRandomNo());
		json.put("status", "on-going");
		json.put("teamSize", 5);
		given()
			.body(json)
			.contentType(ContentType.JSON)
			.when()
				.put("/projects/TY_PROJ_75575")
				.then()
					.statusCode(200)
					.contentType(ContentType.JSON)
					.log().all();
	}
}
