package com.maven.Pages;

import org.openqa.selenium.By;

public class homePage {

	public static By txt_fromDestn;
	public static By txt_toDestn;
	public static By chk_oneWay;
	public static By txt_dateFlight;
	public static By btn_Submit;
	public static By col_today;
	public static By txt_passSelect;
	public static By btn_Continue;
	public static By col_today_button;
	
	
	public static void homePageObjcts(){
		txt_fromDestn = By.id("flightmanagerFlightsFormOrigin");
		txt_toDestn = By.id("flightmanagerFlightsFormDestination");
		chk_oneWay = By.id("lhfaToggleRoundtrip");
		txt_dateFlight = By.id("flightmanagerFlightsFormOutboundDateDisplay");
		btn_Submit = By.xpath("//button[.='Search flights']");
		col_today=By.xpath("//td[contains(@class,'day-today')]");
		col_today_button=By.xpath("//td[@class='day-body day-today']/button");
		txt_passSelect=By.xpath("//*[@id='flightmanagerFlightsFormTraveldetailsBtn']");
		btn_Continue=By.xpath("//input[@value='Continue']");
	}
	
}
