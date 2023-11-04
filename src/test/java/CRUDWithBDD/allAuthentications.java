package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.List;

public class allAuthentications {
	
	@Test
	public void basic() {
		baseURI = "http://rmgtestingserver";
		port=8084;
		given().auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
		
	}
	
	@Test
	public void preemptiveAuth() {
		baseURI = "http://rmgtestingserver";
		port=8084;
		given().auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login").then().log().all();
		
	}
	
	@Test
	public void digestiveAuth() {
		baseURI = "http://rmgtestingserver";
		port=8084;
		given().auth().digest("rmgyantra", "rmgy@9999")
		.when().get("/login").then().log().all();
		
	}
	int i;
	@Test
	public void bearerTocken() {
		baseURI = "https://api.github.com";
		
		JSONObject json = new JSONObject();
		json.put("name", "subbuGithubAccount");
		
		RequestSpecification body = given()
			.auth().oauth2("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")
			.body(json);
			Response req = body.when().post("/user/repos");
			Integer id = req.jsonPath().get("id");
			i=i+id;
			System.out.println(i);
			System.out.println(id);
			req.then().log().all();
	}
	
	@Test
	public void bearerTockenVerification() {
		bearerTocken();
		
		baseURI = "https://api.github.com";
		
//		JSONObject json = new JSONObject();
//		json.put("name", "subbuGithubAccount");
		
		given()
			.auth().oauth2("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");
		
			Response req = when().get("/user/repos");
			
			List<Integer> ids = req.jsonPath().get("id");
			for(Integer all:ids) {
				System.out.println(all);
			}
			for(Integer all:ids) {
			if(i==all) {
				System.out.println("id has been verified");
			}
			}
	}
}
