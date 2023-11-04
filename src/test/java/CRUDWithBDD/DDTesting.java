package CRUDWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericLibrery.JavaUtility;
import PojoClassPackage.PojoClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DDTesting extends JavaUtility {
	
	@DataProvider(name="dataPro")
	public Object[][] data() {
		//create an object of 3*4 
		Object[][] obj = new Object[3][4];
		
		obj[0][0]="vikas";
		obj[0][1]="pro-1";
		obj[0][2]="started";
		obj[0][3]=2;
		
		obj[1][0]="subbu";
		obj[1][1]="pro-2";
		obj[1][2]="on-going";
		obj[1][3]=3;
		
		obj[2][0]="koushi";
		obj[2][1]="pro-3";
		obj[2][2]="completed";
		obj[2][3]=4;
		
		return obj;
	}
	
	@Test(dataProvider = "dataPro")
	public void createProject(String createdBy, String projectName, String status, int teamSize) {
//		System.out.println("Name--->"+Name+" and  Place--->"+Place);
		
		//pre-conditions
		PojoClass pj = new PojoClass(createdBy, projectName+generateRandomNo(), status, teamSize);
//		createProject cp = new createProject(createdBy, projectName, status, teamSize);
		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		given()
			.body(pj)
			.contentType(ContentType.JSON)
			.when()
				.post("/addProject")
				.then()
					.statusCode(201)
					.contentType(ContentType.JSON)
					.time(Matchers.lessThanOrEqualTo(5l),TimeUnit.SECONDS)
					.log().all();
		
	}
	
}
