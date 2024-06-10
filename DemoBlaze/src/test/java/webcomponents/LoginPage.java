package webcomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WebUtility;

public class LoginPage extends WebUtility{

	@FindBy(xpath = "//a[text() = 'Log in']")
	WebElement loginLink;
	
	@FindBy(xpath = "//input[@id = 'loginusername']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id = 'loginpassword']")
	WebElement password;
	
	@FindBy(xpath = "//button[text() = 'Log in']")
	WebElement loginBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void login() throws Exception
	{
		//explicitWait(loginBtn, 5);
		linkClick(loginLink);
		typeText(userName, prop.getProperty("emailid"));
		typeText(password, prop.getProperty("password"));
		btnClick(loginBtn);
		Thread.sleep(7000);
		takeScreenshot("LoginScreenshot");
		
				
	}
	
}
