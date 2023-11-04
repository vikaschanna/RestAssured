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

public class fetchDataProviderInfoInAnotherClass extends JavaUtility {
	@Test(dataProviderClass = DDTesting.class,dataProvider = "dataPro")
	public void createProject(String createdBy, String projectName, String status, int teamSize) {
		
		//pre-conditions
		PojoClass pj = new PojoClass(createdBy, projectName+generateRandomNo(), status, teamSize);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
			.body(pj)
			.contentType(ContentType.JSON)
			.when()
				.post("/addProject")
				.then()
					.statusCode(201)
					.contentType(ContentType.JSON)
					.time(Matchers.lessThanOrEqualTo(5l),TimeUnit.SECONDS)
					.log().all();
}
}
