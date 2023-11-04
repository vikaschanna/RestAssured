package ByUsingGenericLibreries;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericLibrery.BaseClassLibrery;
import GenericLibrery.EndPointsLibrery;
import PojoClassPackage.PojoClass;
import io.restassured.response.Response;

public class CreateProj extends BaseClassLibrery {


	@Test
	public void create() throws Throwable {
		
		//create pre requisites
		PojoClass pj = new PojoClass("channu", "ch-"+jLib.generateRandomNo(), "on-going", 4);
		
		//send the req
		Response reqst = given().spec(req).body(pj)
			.when().post(EndPointsLibrery.createProj);
		
		//capture the project Id
		String id = rLib.getJsonData(reqst, "projectId");
		System.out.println(id);
		
		//validate the id in DB
		String query = "select * from project;";
		String actId = dLib.executeQueryAndGetData(query, 1, id);
		Assert.assertEquals(id, actId);
		System.out.println("TsetCase pass");
		
		reqst.then().log().all();
	}
}
