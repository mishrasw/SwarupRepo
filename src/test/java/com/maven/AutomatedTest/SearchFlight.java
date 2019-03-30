package com.maven.AutomatedTest;

import java.text.ParseException;
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
import com.relevantcodes.extentreports.LogStatus;

public class SearchFlight extends driver {
	
	public homePage obj=new homePage();

	
	@Test(dataProvider="getSearchTextValue")
	public void flghtTestCase(String From_Destn,String To_Destn) throws Exception{
		
			
		test = extent.startTest("Flght Test", "Sample description");
		 	 
		obj.homePageObjcts();
		this.WebDriver.findElement(homePage.txt_fromDestn).sendKeys(From_Destn);
		this.WebDriver.findElement(homePage.txt_toDestn).sendKeys(To_Destn);
		this.WebDriver.findElement(homePage.chk_oneWay).click();
		this.WebDriver.findElement(homePage.txt_dateFlight).clear();
		this.WebDriver.findElement(homePage.txt_dateFlight).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String untildate = this.WebDriver.findElement(homePage.col_today).getAttribute("data-kosa-calendar-date");
		//String untildate="2011-10-08";//can take any date in current format    
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );   
		Calendar cal = Calendar.getInstance();    
		cal.setTime( dateFormat.parse(untildate));    
		cal.add( Calendar.DATE, 2 );    
		String convertedDate=dateFormat.format(cal.getTime());    
		//System.out.println("Date increase by one.."+convertedDate);
		this.WebDriver.findElement(By.xpath("//td[@data-kosa-calendar-date='"+convertedDate+"']/button")).click();
		Thread.sleep(3000);
		this.WebDriver.findElement(homePage.btn_Submit).click();
		String screenshotPath = TakeSnapshot.getScreenhot(this.WebDriver, "test");
		test.log(LogStatus.PASS, "Flght Test passed");
		test.log(LogStatus.PASS, "Snapshot below: " + test.addScreenCapture(screenshotPath));
        logger.info("Flight Test : *************Test Passed****************");
        extent.endTest(test);  
        extent.flush();	
     
	}
	
	@DataProvider
	public Object[][] getSearchTextValue() throws Throwable
	{
		Object[][] data=xlsrdr.getDataArrayBySheet("FlightSearch");
		System.out.println(data);
		return data;
	}
	
	

}
