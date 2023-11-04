package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class deleteProj {
	@Test
	public void deleteProjTest() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		RestAssured.when()
			.delete("/projects/TY_PROJ_75575")
			.then()
				.statusCode(204)
				.log().all();
	}
}
