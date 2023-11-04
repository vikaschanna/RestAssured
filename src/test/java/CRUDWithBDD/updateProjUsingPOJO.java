package CRUDWithBDD;

import org.testng.annotations.Test;

import PojoClassPackage.PojoClass;

import static io.restassured.RestAssured.*;

public class updateProjUsingPOJO {

	@Test
	public void updateProj() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		PojoClass pj = new PojoClass("koush", DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH, DEFAULT_PORT)
	}
}
