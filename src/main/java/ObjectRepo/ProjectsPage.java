package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import GenericLibrery.FileUtility;
import GenericLibrery.JavaUtility;

public class ProjectsPage {
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	
	
	//decleration
	@FindBy(xpath = "//span[.='Create Project']")
	private WebElement createProjBtn;
	
	@FindBy(xpath = "//input[@name='projectName']")
	private WebElement projectName;
	
	@FindBy(xpath = "//input[@name='createdBy']")
	private WebElement createdBy;
	
	@FindBy(xpath = "//label[.='Project Status ']/..//select[@name='status']")
	private WebElement dropdown;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement logoutBtn;
	

	//initialization
	public ProjectsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateProjBtn() {
		return createProjBtn;
	}

	public WebElement getProjectName() {
		return projectName;
	}

	public WebElement getCreatedBy() {
		return createdBy;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	//business logic
	public String createProj(WebDriver driver) throws Throwable {
		String name = fLib.readDataFromPropertyFile("projectName")+jLib.generateRandomNo();
		createProjBtn.click();
		projectName.sendKeys(name);
		createdBy.sendKeys(fLib.readDataFromPropertyFile("createdBy"));
		Select s = new Select(dropdown);
		s.selectByVisibleText(fLib.readDataFromPropertyFile("status"));
		submitBtn.click();
		String id = driver.findElement(By.xpath("//td[.='"+name+"']/preceding-sibling::td")).getText();
		return id;
	}
	
	
	
}
