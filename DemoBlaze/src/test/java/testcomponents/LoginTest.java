package testcomponents;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import enginecomponents.BaseClass;
import webcomponents.LoginPage;

public class LoginTest extends BaseClass{
	
	@BeforeTest
	public void beforeTest() throws Exception {
		userDataFile();
		testname = "loginTest";
	}

	@Test(dependsOnMethods = "signUpTest")
	public void loginTest() throws Exception {
		LoginPage obj = new LoginPage();
		obj.login();
		test.pass("Login TestCase is Pass", 
				MediaEntityBuilder.createScreenCaptureFromPath("LoginScreenshot.png").build());
	}
}
