package CrudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteProj extends getAllProj{
	@Test
	public void getSingleProjTest() {
		
		RequestSpecification preCon = RestAssured.given();
		Response getRes = preCon.put("http://rmgtestingserver:8084/projects/"+s);
		JSONObject json =new JSONObject();
		json.put("createdBy", "Vikas");
		json.put("projectName", "mummyProj1");
		json.put("status", "onGoing");
		json.put("teamSize", 5);
		
		preCon.body(json);
		preCon.contentType(ContentType.JSON);
		getRes.then().log().all();
}
}
