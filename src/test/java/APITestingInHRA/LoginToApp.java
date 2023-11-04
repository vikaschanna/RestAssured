package APITestingInHRA;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LoginToApp {
	@Test
	public void login() {
		baseURI = "http://rmgtestingserver/domain/House_Rental_Application/";
		
		
		
		JSONObject json = new JSONObject();
		json.put("UN", "admin");
		json.put("pwd", "admin");
		
		given().body(json);
	}
}
