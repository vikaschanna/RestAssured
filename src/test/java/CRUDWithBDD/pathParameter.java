package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import PojoClassPackage.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class pathParameter extends JavaUtility {
	@Test
	public void pathParam() {
		PojoClass pj = new PojoClass("vikas", "dingri"+generateRandomNo(), "on-going", 6);
		baseURI="http://rmgtestingserver:8084";
		port=8084;
		
		RequestSpecification req = given().body(pj).contentType(ContentType.JSON);
		
		Response pro = req.when().post("/addProject");
		Object id = pro.jsonPath().get("projectId");
		
		pro.then().log().all();
		given().pathParam("pid", id)
		.when().get("/projects/{pid}")
			.then().log().all();
		
	}
	
	@Test
	public void queryParameter() {
		baseURI="https://reqres.in/";
		given().queryParam("pages", 2)
		.when().get("api/users").then().log().all();
		
	}
	
	@Test
	public void formParameter() {
		baseURI="https://reqres.in/";
		
		given().formParam("createdBy", "vikas");
		given().formParam("projectName", "p-01");
		given().formParam("status", "completed");
		given().formParam("teamSize", 1);
		RequestSpecification req = given().contentType(ContentType.JSON);
		
		req.when().post("/api/users")
			.then().log().all();
		
	}
	
}
