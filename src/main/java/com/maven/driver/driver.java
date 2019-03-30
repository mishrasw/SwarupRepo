package com.maven.driver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import io.appium.java_client.AppiumDriver;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;




import com.maven.Utilities.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//import com.beust.jcommander.Parameters;

public class driver {
	protected AppiumDriver appiumDriver = null;
	protected WebDriver WebDriver = null;
	protected static ExtentReports extent;
    protected static ExtentTest test;
    final String filePath = "Reports\\ExecutionResult.html";
    protected static Logger logger ;
	
	/* cloud platform */
	public String browser = null;
	public String version = null;
	public String platform = null;
	public String environment = null;
	public String localBaseUrl = null;
	public static ExcelReader xlsrdr = new ExcelReader(System.getProperty("user.dir") + "\\TestData\\TestData.xls",	"Test_Data");
	
	@BeforeSuite
	public void befSuite(){
		
		extent = new ExtentReports(filePath, true);
		PropertyConfigurator.configure("log4j.properties");
		logger=LogManager.getLogger(driver.class);
		
		//PropertyConfigurator.configure("\\log4j.properties");
	}
	
	
	@BeforeTest(alwaysRun = true)
	@Parameters({ "automationName", "browser", "browserVersion",  "platformName","environment" })
	public void beforeSuite(ITestContext ctx, String automationName,  String browser, String browserVersion,
			 String platformName, String environment) throws Throwable {
		
		WebDriver Driver = null;
		this.browser = browser;
		this.version = browserVersion;
		this.platform = platformName;
		this.environment = environment;
		
		// this.nodeUrl = nodeUrl;
		System.out.println(environment);

		if (environment.equalsIgnoreCase("local")) {
			this.setWebDriverForLocal(browser);
		}
		

		
		//Driver = this.WebDriver;
		//this.WebDriver.get("https://www.lufthansa.com/online/portal/lh/uk/homepage");
		this.WebDriver.get("http://robobull.com/");
		this.WebDriver.manage().window().maximize();
		
	}

	



	
	@Parameters({ "browser", "browserVersion",  "environment" })
	@BeforeMethod
	public void beforeMethod(Method method,String browser, String browserVersion,
			 String environment) {
		
		logger.info("Start Test Execution");

		
	}

	@AfterClass

	public void afterMethod(ITestContext ctx) throws Throwable {
		//Driver.manage().deleteAllCookies();
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws Exception
	{
		        
	       	

	}
	
	@AfterTest
	public void afterClass() throws Exception{
		
		
	}
	
	@AfterSuite
	public void afterSuite(){
		extent.close();
	}
	
	
	private void setWebDriverForLocal(String browser) throws IOException, InterruptedException {
		switch (browser) {
		case "firefox":

			this.WebDriver = new FirefoxDriver();

			break;
		case "ie":
			DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
			capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			DesiredCapabilities.internetExplorer().setCapability("ignoreProtectedModeSettings", true);
			// capab.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
			// INIT_PAGE);

			File file = new File("Drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			capab.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capab.setJavascriptEnabled(true);
			capab.setCapability("requireWindowFocus", true);
			capab.setCapability("enablePersistentHover", false);

			this.WebDriver = new InternetExplorerDriver(capab);
			Thread.sleep(1000);
			break;
		case "chrome":

			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			this.WebDriver = new ChromeDriver(capabilities);

			break;
		

		}

	}
	
	
}
