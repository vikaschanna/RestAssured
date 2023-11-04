package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class getOneProj {
	@Test
	public void getOne() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
			when()
				.get("/projects/TY_PROJ_75575")
				.then()
//					.contentType(ContentType.JSON)
//					.statusCode(200)
//					.time(lessThan(3), TimeUnit.SECONDS);
					.log().all();
	}
}
