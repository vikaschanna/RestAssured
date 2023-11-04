package CrudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject extends JavaUtility {
	static RequestSpecification preCon = RestAssured.given();
		
	@Test
	public String createProjTest()  {
		
		JSONObject json = new  JSONObject();
		json.put("createdBy", "Vikas");
		json.put("projectName", "dummy"+generateRandomNo());
		json.put("status", "Created");
		json.put("teamSize", 4);
		
		preCon.body(json);
		preCon.contentType(ContentType.JSON);
		Response res = preCon.post("http://rmgtestingserver:8084/addProject");
		String id = res.jsonPath().getString("projectId");
		
		
		res.then().log().all();
		System.out.println(id);
		return id;
		
//		System.out.println(res.asPrettyString());
//		preCon.then().log().everything();
	}
}
