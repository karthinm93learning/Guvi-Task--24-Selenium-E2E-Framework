package utils;

import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GendralUtility {

	public static ExtentReports reports = null;
	public static ExtentTest test;
	public static Properties prop = null;
	
	public static void reportInit() {
		
		//String path = System.getProperty("user.dir") + "/Reports.html";
		ExtentSparkReporter html = new ExtentSparkReporter("./Reports.html");
		reports = new ExtentReports();
		reports.attachReporter(html);
	}
	
	public static void userDataFile() throws Exception {
		
		FileInputStream file = new FileInputStream("E:\\Selenium Projects\\DemoBlaze\\config.properties");
		prop = new Properties();
		prop.load(file);
	}
		
}
