package CRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class dataMasking extends JavaUtility{
	
	@Test
	public void dataMaskingTest() {
		JSONObject j = new JSONObject();
		j.put("createdBy", "Vikas");
		j.put("projectName", "v-12"+generateRandomNo());
		j.put("status", "completed");
		j.put("teamSize", 4);
		
		
		given().config(RestAssured.config.logConfig(LogConfig.logConfig()
				.blacklistHeader("Content-Type")))
				.body(j).contentType(ContentType.JSON).log().all()
				.when().post("http://rmgtestingserver:8084/addProject")
				.then().log().all();
	}
}
