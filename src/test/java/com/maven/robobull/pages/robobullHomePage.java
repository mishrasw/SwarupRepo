package com.maven.robobull.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class robobullHomePage {

	public static By lnk_allProduct;
	
	
	public static void roboHomePage(){
		lnk_allProduct = By.xpath("//a[data-id='All Products ']");
		
	}
	
}