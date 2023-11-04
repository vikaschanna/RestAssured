package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import io.restassured.http.ContentType;

public class createProjUsingHashMap extends JavaUtility{

	@Test
	public void createProj() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		HashMap<String, Object> obj = new HashMap<String, Object>();
		obj.put("createdBy", "koush");
		obj.put("projectName", "channu"+generateRandomNo());
		obj.put("status", "created");
		obj.put("teamSize", 34);
		
		given()
			.body(obj)
			.contentType(ContentType.JSON)
			.when()
				.post("/addProject")
				.then()
					.statusCode(201)
					.contentType(ContentType.JSON)
					.time(Matchers.lessThanOrEqualTo(6l), TimeUnit.SECONDS)
					.log().all();
}
}
