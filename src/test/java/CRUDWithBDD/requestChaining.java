package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import PojoClassPackage.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class requestChaining extends JavaUtility {
	
	@Test
	public void staticResponceBodyValidationTest() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		Response b = when()
			.get("/projects");
		
		List<String> as = b.jsonPath().get("projectId");
		
//		b.then().log().all();
		for (String object : as) {
			System.out.println(object);
		}
				
	}
	
	@Test
	public void requestChainings() {
		PojoClass cp = new PojoClass("Vikas", "mangu"+generateRandomNo(), "on-going", 8);
		PojoClass cp1 = new PojoClass("Vikas", "gangu"+generateRandomNo(), "completed", 10);
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//create a project
		RequestSpecification req = given()
			.body(cp)
			.contentType(ContentType.JSON);
		
		Response res = req.when()
							.post("/addProject");
		
		String id = res.jsonPath()
							.getString("projectId");
		
		res.then()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThanOrEqualTo(5l), TimeUnit.SECONDS)
			.log().all();
		
		//get the project
		when()
			.get("/projects/"+id)
			.then()
				.statusCode(200)
				.contentType(ContentType.JSON)
				.time(Matchers.lessThanOrEqualTo(4l), TimeUnit.SECONDS)
				.log().all();
		
		//update thge project
		given()
			.body(cp1)
			.contentType(ContentType.JSON)
			.when()
				.put("/projects/"+id)
				.then()
					.statusCode(200)
					.contentType(ContentType.JSON)
					.time(Matchers.lessThanOrEqualTo(4l), TimeUnit.SECONDS)
					.log().all();
		
		//delete the project
		when()
			.delete("/projects/"+id)
			.then()
				.statusCode(204)
				.time(Matchers.lessThanOrEqualTo(4l), TimeUnit.SECONDS)
				.log().all();
		
	}
	
	
	String id="";
	@Test
	public void createTest() {
		PojoClass cp1 = new PojoClass("Vikas", "gangu"+generateRandomNo(), "completed", 10);
		baseURI="http://rmgtestingserver";
		port=8084;
		
		//create a project
		RequestSpecification req = given()
			.body(cp1)
			.contentType(ContentType.JSON);
		
		Response res = req.when()
							.post("/addProject");
		
		id = res.jsonPath()
							.getString("projectId");
		
		res.then()
			.statusCode(201)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThanOrEqualTo(5l), TimeUnit.SECONDS)
			.log().all();
	}
	
	@Test
	public void getTest() {
		createTest();
		when()
		.get("/projects/"+id)
		.then()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.time(Matchers.lessThanOrEqualTo(4l), TimeUnit.SECONDS)
			.log().all();
	}
	
	
}
