package CrudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getSingleProj extends CreateProject{
	
	@Test
	public void getSingleProjTest() {
		RequestSpecification preCon = RestAssured.given();
		
		Response getRes = preCon.get("http://rmgtestingserver:8084/projects/"+createProjTest());
		
		getRes.then().log().all();
//		System.out.println(getRes.asPrettyString());
		
		
	}
}
