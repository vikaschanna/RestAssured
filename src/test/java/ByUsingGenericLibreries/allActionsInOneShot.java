package ByUsingGenericLibreries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import GenericLibrery.BaseClassLibrery;
import ObjectRepo.HomePage;
import ObjectRepo.ProjectsPage;
import ObjectRepo.RestAssuredPage;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class allActionsInOneShot extends BaseClassLibrery {
	RestAssuredPage rest = new RestAssuredPage();
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	@Test
	public void createProjUsingGUIGetUsingAPI() throws Throwable {
		new HomePage(driver).clickOnProjLink();
		String id = new ProjectsPage(driver).createProj(driver);
		System.out.println(id);
		
		rest.getProject(id);
		rest.verifyInDatabase(id);
		
	}
	
	@Test
	public void createProjUsingApiGetUsingGUI() throws Throwable {
		String id = new RestAssuredPage().createProject();
		new HomePage(driver).clickOnProjLink();
//		 WebElement data = driver.findElement(By.xpath("//td[.='"+id+"']/.."));
		 List<WebElement> data2 = driver.findElements(By.xpath("//td[.='"+id+"']/../td"));
		
		for (WebElement element : data2) {
			System.out.println(element.getText());
		}
//		 System.out.println(data.getText());
		rest.verifyInDatabase(id);
		
	}
	
	@Test
	public void createProjUsingGUIUpdateUsingApi() throws Throwable {
		new HomePage(driver).clickOnProjLink();
		String id = new ProjectsPage(driver).createProj(driver);
		System.out.println(id);
		
		rest.updateProject(id);
		
		rest.verifyInDatabase(id);
	}
	
	@Test
	public void createProjUsingGUIDeleteUsingAPI() throws Throwable {
		new HomePage(driver).clickOnProjLink();
		String id = new ProjectsPage(driver).createProj(driver);
		System.out.println(id);
		
		rest.deleteProject(id);
		
		rest.verifyInDatabase1(id);
	}
	
	
}
