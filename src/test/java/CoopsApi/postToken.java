package CoopsApi;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class postToken {
	String token;
	@Test
	public void postTest() {
		
		Response resp = given().formParam("client_id", "sdet-50-vikas")
		.formParam("client_secret", "cb694da9815a9b1670cdd70398914df7")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://cooper.com")
		.formParam("code", "authorization_code")
		.when().post("http://coop.apps.symfonycasts.com/token");
		
		token =resp.jsonPath().get("access_token");
		System.out.println(token);
	}
	
	@Test
	public void postUnlockTheBorn() {
		postTest();

		baseURI = "http://coop.apps.symfonycasts.com";
		
		given().auth().oauth2(token).pathParam("id", 4679)
		.when().post("/api/{id}/barn-unlock")
		.then().log().all();
	}
	
	@Test
	public void postPutTheToiletSeatDown() {
		postTest();
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		given().auth().oauth2(token).pathParam("id", 4679)
		.when().post("/api/{id}/toiletseat-down")
		.then().log().all();
	}
	
	@Test
	public void postFeedYourChicken() {
		postTest();
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		given().auth().oauth2(token).pathParam("id", 4679)
		.when().post("/api/{id}/chickens-feed")
		.then().log().all();
	}
	
	@Test
	public void postCollectEggsFromYourCheckens() {
		postTest();
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		given().auth().oauth2(token).pathParam("id", 4679)
		.when().post("/api/{id}/eggs-collect")
		.then().log().all();
	}
	
	@Test
	public void postGetNoOfEggsCollectedToday() {
		postTest();
		
		baseURI = "http://coop.apps.symfonycasts.com";
		
		Response resp = given().auth().oauth2(token).pathParam("id", 4679)
		.when().post("/api/{id}/eggs-count");
		String msg = resp.jsonPath().get("message");
		System.out.println(msg);
		resp.then().log().all();
	}
	
	@Test
	public void get() {
		postTest();
		baseURI = "http://coop.apps.symfonycasts.com";
		
		 given().formParam("client_id", "sdet-50-vikas")
				.formParam("response_type", token)
				.formParam("redirect_uri", "http://cooper.com")
				.formParam("scope", "eggs-count profile")
				.when().get("/authorize")
				.then().log().all();
		 
	}
	
}
