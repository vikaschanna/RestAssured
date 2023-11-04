package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath = "//a[.='Projects']")
	private WebElement projectsLink;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjectsLink() {
		return projectsLink;
	}
	
	//business logic
	public void clickOnProjLink() {
		projectsLink.click();
	}
}
