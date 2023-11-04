package SchemaValidation;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

import java.io.File;

public class jsonSchemaValidation {
	
	@Test
	public void jsonSchema() {
		File f = new File("./data.json");
		when().get("https://reqres.in/api/users?page=2")
		.then().body(JsonSchemaValidator.matchesJsonSchema(f))
		.log().all();
	}
}
