package CRUDWithBDD;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class recrussEg {

	@Test
	public void getAll() {
		baseURI="https://reqres.in/";
		port=8084;
		
		given()
			.contentType(ContentType.JSON);
		
		Response res = when()
			.get("api/users/2");
		ResponseBody body = res.getBody();
		String json = body.asPrettyString();
		System.out.println(json);
//		try {
//		res.then().time(Matchers.lessThan(1000l),TimeUnit.MILLISECONDS);
//		}
//		finally {
//			System.out.println(res.getTime());
//		}
		
}
}
