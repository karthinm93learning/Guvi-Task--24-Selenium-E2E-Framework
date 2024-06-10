package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtility extends GendralUtility{
	
	public static WebDriver driver = null;
	public static Alert alert = null;

	public String testname ;
	
	public static void openBrowser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//test.log(Status.INFO, "Browser Opened");
	}
	
	public static void openPage() {
		
		driver.get(prop.getProperty("url"));
		//test.log(Status.INFO, "Web Page Opened");
	}
	
	public static void linkClick(WebElement ele) {
		
		ele.click();
		test.info("Link is clicked");
	}
	
	public static void typeText(WebElement ele, String text) {
		ele.sendKeys(text);
		test.info("Text has typed");
	}
	
	public static void btnClick(WebElement ele) {
		ele.click();
		test.info("Button Clicked");
	}
	
	public static String switchAlert(){
		String msg = driver.switchTo().alert().getText();
		return msg;
	}
	
	public static void alertAccept() {
		driver.switchTo().alert().accept();
	}
	
	public void explicitWait(WebElement ele, int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void takeScreenshot(String fileName) {
		
		String Location = System.getProperty("user.dir") + "/"+fileName+".png";
		TakesScreenshot ss = (TakesScreenshot) driver;
		File src = ss.getScreenshotAs(OutputType.FILE);
		File des = new File(Location);
		try {
			FileHandler.copy(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.info("Screenshot Taken");
	}
	
	public static void closeBrowser() {
		driver.quit();
		test.info("Browser Closed");
	}
	
}
