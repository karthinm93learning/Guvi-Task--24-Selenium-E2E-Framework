package testcomponents;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import enginecomponents.BaseClass;
import webcomponents.SignupPage;

public class SignUpTest extends BaseClass{
	
	@BeforeTest
	public void beforeTest() throws Exception {
		userDataFile();
		testname = "signUpTest";
	}

	@Test
	public void signUpTest() throws Exception {
		SignupPage obj = new SignupPage();
		obj.signUp();
		test.pass("SignUpTestCase is Pass");
	}
	
}
