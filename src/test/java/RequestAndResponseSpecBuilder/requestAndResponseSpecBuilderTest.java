package RequestAndResponseSpecBuilder;

import org.hamcrest.Matchers;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import PojoClassPackage.PojoClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class requestAndResponseSpecBuilderTest extends JavaUtility {

	@Test
	public void createProjUsingReqAndRespSpecBuilder()  {
		
		PojoClass pojo = new PojoClass("vikas", "v-001"+generateRandomNo(), "on-going", 4);
		
		RequestSpecification req = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver")
				.setContentType(ContentType.JSON)
				.setPort(8084).build();
		
		ResponseSpecification resp = new ResponseSpecBuilder()
				.expectResponseTime(Matchers.lessThanOrEqualTo(5l),TimeUnit.SECONDS)
				.expectStatusCode(201)
				.expectStatusLine("HTTP/1.1 201 ")
				.expectContentType(ContentType.JSON)
				.build();
		
		Response reqst = given().spec(req).body(pojo)
		.when().post("/addProject");
		Object id = reqst.jsonPath().get("projectId");
		System.out.println("Proje ID is --> "+id);
		reqst.then().spec(resp).log().all();
		
	}
}
