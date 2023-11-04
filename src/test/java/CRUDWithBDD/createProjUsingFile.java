package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

class createProjUsingFile {
	@Test
	public void createProj() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File file = new File("./file.json");
		given()
			.body(file)
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
