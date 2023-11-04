package CRUDWithBDD;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class toCheckTheResponseIsInArrayOfObjectOrNot {
	
	//if the response is in Array Of Object
	@Test
	public void get1() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().get("/projects")
		.then().assertThat().body("", Matchers.instanceOf(List.class))
		.log().all();
	}
	
	//if the response is in only Object
	@Test
	public void get2() {
		baseURI = "http://rmgtestingserver";
		port = 8084;
		when().get("/projects")
		.then().assertThat().body("", Matchers.instanceOf(Map.class))
		.log().all();
	}
}
