package com.qa.Test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class Calander extends TestBase{
	@BeforeMethod
	void setUp() {
		initialisation("https://www.spicejet.com/");
	}
	
	@Test
	void Test() 
	{
		System.out.println("Hey There");
		driver.findElement(By.xpath("//div[@id='flightSearchContainer']//div[4]//button[@class='ui-datepicker-trigger']")).click();
	    String value=	driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).getText();
	    System.out.println(value);
	}

	@AfterMethod
	void tearDown()
	{
		//driver.quit();
	}
}
