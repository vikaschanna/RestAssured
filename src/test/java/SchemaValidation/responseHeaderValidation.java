package SchemaValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class responseHeaderValidation {
	
	@Test
	public void validation() {
		baseURI = "http://rmgtestingserver";
		port=8084;
		
		String Exp_StatusLine = "HTTP/1.1 200 ";
		String Exp_Vary = "Access-Control-Request-Headers";
		String Content_Type = "application/json";
		String Connection = "keep-alive";
		int StatusCode = 200;
		
		Response res = when().get("/projects/TY_PROJ_9938");
		String act_contentType = res.getContentType();
		Assert.assertEquals(Content_Type, act_contentType);
		
		int act_statusCode = res.getStatusCode();
		Assert.assertEquals(StatusCode, act_statusCode);
		System.out.println(act_statusCode);
		
		String act_statusLine = res.getStatusLine();
		Assert.assertEquals(Exp_StatusLine, act_statusLine);
		System.out.println(act_statusLine);
		
		String act_vary = res.header("Vary");
		Assert.assertEquals(Exp_Vary, act_vary);
		System.out.println(act_vary);
		
		String act_connection = res.getHeader("Connection");
		Assert.assertEquals(Connection, act_connection);
		System.out.println(act_connection);
	}
}
