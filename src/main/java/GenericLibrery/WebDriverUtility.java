package GenericLibrery;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is for doing the actions in webdriver
 * @author Vikas S
 *
 */
public class WebDriverUtility {
	
	/**
	 * This method is used to maximize the browser
	 * @author Vikas S
	 * @param driver
	 */
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to wait for page load
	 * @author Vikas S
	 * @param driver
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void pageLoadTimeOut(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to wait untill the element is visible
	 * @author Vikas S
	 * @param driver
	 * @param element
	 */
	public void explicitWait( WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to handle the DropDown using Index
	 * @author Vikas S
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method is used to handle the DropDown using value
	 * @author Vikas S
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used to handle the DropDown using visible text
	 * @author Vikas S
	 * @param value
	 * @param element
	 */
	public void select(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	public String fileUpload(String FilePath) {
		File f = new File(FilePath);
		String absolutePath = f.getAbsolutePath();
		return absolutePath;
	}
	
	/**
	 * This method is used to perform MouseHover action
	 * @author Vikas S
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).click().perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @author Vikas S
	 * @param driver
	 * @param src
	 * @param dest
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest);
	}
	
	/**
	 * This method will double click on WebPage
	 * @author Vikas S
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver ,WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform right click on WebPage
	 * @author Vikas S
	 * @param driver
	 */
	public void rightClick(WebDriver driver ) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on element
	 * @author Vikas S
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	/**
	 * This method will Press Enter Key using actions class
	 * @author Vikas S
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)  {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will Press Enter Key using Robot calss
	 * @author Vikas S
	 * @throws AWTException
	 */
	public void enterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterKeyRelease() throws AWTException {
		Robot r = new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameOrID) {
		driver.switchTo().frame(nameOrID);
	}
	
	public void switcToFrame(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToWindow(WebDriver driver, String partWinTitle) {
		//step1-use windowHandles to captcure all windows ID's
		Set<String> windows = driver.getWindowHandles();
		
		//step2- iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step3- check whether there is next window or not 
		while(it.hasNext()) {
			//step4- capture current window ID
			String winId = it.next();
			
			//step5- switch to current window and capture title
			String curWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step6- check whether current window is expected 
			if(curWinTitle.contains(partWinTitle)) {
				break;
			}
		}
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenshotName+".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	
	public void scrollBarAction(WebDriver driver) {
		JavascriptExecutor jExe = (JavascriptExecutor) driver;
		jExe.executeScript("window.scrollBy(0,-100)","");
	}
	
	public void scrollAction(WebDriver driver, WebElement actData) {
		JavascriptExecutor jExe = (JavascriptExecutor) driver;
		int y = actData.getLocation().getY();
	//	jExe.executeScript("window.scrollBy(0,"+y+")");
		jExe.executeScript("arguments[0].scrollIntoView(true);", actData);
	}

}
