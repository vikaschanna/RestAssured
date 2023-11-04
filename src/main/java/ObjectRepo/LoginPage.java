package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericLibrery.IConstantsLibrery;

public class LoginPage {
	
	//declaration
	@FindBy(id = "usernmae")
	private WebElement userName;
	
	@FindBy(id = "inputPassword")
	private WebElement password;
	
	@FindBy(xpath  = "//button[@type='submit']")
	private WebElement loginBtn;

	//initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//business libreries
	public void login() {
		userName.sendKeys(IConstantsLibrery.appUN);
		password.sendKeys(IConstantsLibrery.appPwd);
		loginBtn.click();
	}
}
