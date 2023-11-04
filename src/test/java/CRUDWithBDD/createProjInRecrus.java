package CRUDWithBDD;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class createProjInRecrus extends JavaUtility {
	@Test
	public void createProj() {
		baseURI = "https://reqres.in";
		
		JSONObject json = new JSONObject();
		json.put("name", "ningu"+generateRandomNo());
		json.put("job", "engineer");
		
		given()
			.body(json)
			.contentType(ContentType.JSON)
			.when()
				.post("/api/users")
				.then()
					.statusCode(201)
					.contentType(ContentType.JSON)
					.time(Matchers.lessThanOrEqualTo(3l),TimeUnit.SECONDS)
					.log().all();
	}
}
