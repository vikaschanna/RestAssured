package CrudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getAllProj {
	public String s="";
	@Test
	public void getAllProjTest() {
		RequestSpecification preCon = RestAssured.given();
		Response getRes = preCon.get("http://rmgtestingserver:8084/projects");
//		String id = getRes.jsonPath().getString("[0].projectId");
		System.out.println(getRes.asPrettyString());
//		s=s+id;
//		System.out.println(id);
	}
}
