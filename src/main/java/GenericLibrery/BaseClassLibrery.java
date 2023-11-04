package GenericLibrery;

import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepo.LoginPage;
import ObjectRepo.ProjectsPage;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassLibrery {
	public WebDriverUtility wLib = new WebDriverUtility();
	public DataBaseLibrery dLib = new DataBaseLibrery();
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredLibrery rLib = new RestAssuredLibrery();
	public RequestSpecification req;
	public ResponseSpecification resp;
	public WebDriver driver;
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		dLib.connectToDB();
		req = new RequestSpecBuilder()
				.setBaseUri("http://rmgtestingserver")
				.setContentType(ContentType.JSON)
				.setPort(8084).build();
		
		resp = new ResponseSpecBuilder()
				.expectResponseTime(Matchers.lessThanOrEqualTo(5l),TimeUnit.SECONDS)
				.expectStatusCode(201)
				.expectStatusLine("HTTP/1.1 201 ")
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	@AfterSuite
	public void asCongif() throws Throwable {
		dLib.closeDB();
	}
	
	@BeforeMethod
	public void bmConfig() {
		driver.get(IConstantsLibrery.appURL);
		new LoginPage(driver).login();
	}
	
	@AfterMethod
	public void amConfig() {
		new ProjectsPage(driver).getLogoutBtn().click();
	}
	
	@BeforeClass
	public void bcConfig() {
		driver = new ChromeDriver();
		wLib.maximize(driver);
		wLib.implicitWait(driver);
	}
	
	@AfterClass
	public void acConfig() {
		driver.quit();
	}
}
