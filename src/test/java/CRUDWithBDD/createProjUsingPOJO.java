package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import PojoClassPackage.PojoClass;
import io.restassured.http.ContentType;

public class createProjUsingPOJO extends JavaUtility {
	
	@Test
	public void createProj() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		PojoClass cp = new PojoClass("Vikas", "mangu"+generateRandomNo(), "on-going", 8);
		given()
			.body(cp)
			.contentType(ContentType.JSON)
			.when()
				.post("/addProject")
				.then()
					.statusCode(201)
					.contentType(ContentType.JSON)
					.time(Matchers.lessThanOrEqualTo(5l), TimeUnit.SECONDS)
					.log().all();
		
					
					
	}
}
