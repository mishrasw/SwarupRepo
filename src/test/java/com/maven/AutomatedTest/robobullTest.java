package com.maven.AutomatedTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Keyboard;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




import com.maven.Pages.homePage;
import com.maven.Utilities.TakeSnapshot;
import com.maven.driver.driver;
import com.maven.robobull.pages.robobullHomePage;
import com.relevantcodes.extentreports.LogStatus;

public class robobullTest extends driver {
	
	public robobullHomePage obj=new robobullHomePage();

	
	@Test
	public void roboTestCase() throws Exception{
		
			
		test = extent.startTest("Robobull Test", "Sample description");
		 	 
		obj.roboHomePage();
		//this.WebDriver.switchTo().frame("lsChannel");
		this.WebDriver.findElement(obj.lnk_allProduct).click();;
		
		String screenshotPath = TakeSnapshot.getScreenhot(this.WebDriver, "test");
		test.log(LogStatus.PASS, "Robo teST PASS");
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenshotPath));
        logger.info("Flight Test : *************Test Passed****************");
        extent.endTest(test);  
        extent.flush();	
     
	}
	

}
