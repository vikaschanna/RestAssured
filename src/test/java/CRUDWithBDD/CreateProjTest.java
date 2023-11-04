package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import io.restassured.http.ContentType;

public class CreateProjTest extends JavaUtility {
	@org.testng.annotations.Test
	public void createProj() {
		baseURI="http://rmgtestingserver";
		port=8084;
		JSONObject json=new JSONObject();
		json.put("createdBy", "Vikas");
		json.put("projectName", "dinga"+generateRandomNo());
		json.put("status", "created");
		json.put("teamSize", 4);
		
		
		// step-1 pre-condtions
		given()
			.contentType(ContentType.JSON)
			.body(json)
			
		//step-2 actions
		.when()
			.post("/addProject")
			
			
		//step-3 validation
		.then()
			.assertThat()
		
				.contentType(ContentType.JSON)
				.statusCode(201)
				.log().all();
//		String id = post().jsonPath().getString("projectId");
//		System.out.println(id);
		
		
			
	}
	
}
