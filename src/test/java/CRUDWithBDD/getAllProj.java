package CRUDWithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getAllProj {
	@Test
	public void getAll() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
			.contentType(ContentType.JSON);
		
		when()
			.get("/projects")
		
		.then()
//			.assertThat()
			.statusCode(200)
			.log().all();
			
	}
}
