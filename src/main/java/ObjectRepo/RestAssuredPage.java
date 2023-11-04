package ObjectRepo;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.Assert;

import GenericLibrery.DataBaseLibrery;
import GenericLibrery.EndPointsLibrery;
import GenericLibrery.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPage {
	JavaUtility jLib = new JavaUtility();
	DataBaseLibrery dLib = new DataBaseLibrery();
	public void getProject(String id ) throws Throwable {
		baseURI = "http://rmgtestingserver";
		port = 8084;
	
		Response response = when().get(EndPointsLibrery.getSingleProj+id);
		response.then().log().all();
		
	}
	
	public void verifyInDatabase(String id) throws Throwable {
		dLib.connectToDB();
		String pId = dLib.executeQueryAndGetData("select * from project;", 1, id);
		Assert.assertEquals(pId, id); 
		System.out.println();
		System.out.println("Data has been verified in Database");
	}
	
	public String createProject() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject j = new JSONObject();
		j.put("projectName", "dinga"+jLib.generateRandomNo());
		j.put("createdBy", "sampi");
		j.put("teamSize", 5);
		j.put("status", "Created");
		
		RequestSpecification req = given().body(j)
		.contentType(ContentType.JSON);
		Response resp = req.when().post(EndPointsLibrery.createProj);
		String id = resp.jsonPath().get("projectId");
		System.out.println(id);
		return id;
	}
	
	public void updateProject(String id) {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		JSONObject j = new JSONObject();
		j.put("projectName", "apple"+jLib.generateRandomNo());
		j.put("createdBy", "steve jobs");
		j.put("teamSize", 6);
		j.put("status", "Completed");
		
		given().body(j).contentType(ContentType.JSON)
		.when().put(EndPointsLibrery.updateProj+id)
		.then().log().all();
	}
	
	public void deleteProject(String id) {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().delete(EndPointsLibrery.deleteProj+id)
		.then().log().all();
	}
	
	public void verifyInDatabase1(String id) throws Throwable {
		dLib.connectToDB();
		String pId = dLib.executeQueryAndGetData("select * from project;", 1, id);
		Assert.assertEquals(pId, ""); 
		System.out.println();
		System.out.println("Project has been deleted in Database");
	}
}
