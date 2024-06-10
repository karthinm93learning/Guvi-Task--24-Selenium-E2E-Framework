package enginecomponents;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import utils.WebUtility;

public class BaseClass extends WebUtility{

	@BeforeSuite
	public void beforeSuit() {
		
		reportInit();// config the extent report - step 1
	}
	
	@BeforeClass
	public void beforeClass() {	
		test = reports.createTest(testname); // create the test - step 2
	}
	
	@BeforeMethod
	public void beforeMethod() {
		openBrowser();
		openPage();
	}
	
	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}
	
	
	@AfterSuite
	public void afterSuit() {
		reports.flush();  // write the logs to the report - step 4/last
	}
}
