package webcomponents;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.WebUtility;

public class SignupPage extends WebUtility{

	
	@FindBy(xpath = "//a[@id = 'signin2']")
	WebElement signupLink;
	
	@FindBy(xpath = "//input[@id = 'sign-username']")
	WebElement userName;
	
	@FindBy(xpath = "//input[@id = 'sign-password']")
	WebElement password;
	
	@FindBy(xpath = "//button[text() = 'Sign up']")
	WebElement signupBtn;
	
	public SignupPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void signUp() throws Exception {
		
		String alertText = null;
		linkClick(signupLink);
		explicitWait(password, 3);
		typeText(userName, prop.getProperty("emailid"));
		typeText(password, prop.getProperty("password"));
		btnClick(signupBtn);
		Thread.sleep(3000);
		alertText = switchAlert();  //return the alert message
		alertAccept();
		Assert.assertEquals(alertText, "Sign up successful.");
	}
	
	
}
