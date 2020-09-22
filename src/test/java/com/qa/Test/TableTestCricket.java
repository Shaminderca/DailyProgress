package com.qa.Test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class TableTestCricket extends TestBase{
	@BeforeMethod
	void startUp() {
		initialisation("https://www.cricbuzz.com/live-cricket-scorecard/30235/eng-vs-aus-3rd-odi-australia-tour-of-england-2020");
		
	}
	
	@Test
	void methodOne() {
	 int row =	driver.findElements(By.xpath("//div[@id='innings_1']//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'][1]//div[@class='cb-col cb-col-100 cb-scrd-itms']")).size();
	 int col =  driver.findElements(By.xpath("//div[@id='innings_1']//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'][1]//div[@class='cb-col cb-col-100 cb-scrd-itms'][1]//div")).size();
	 for(int i = 1;i<=row-3;i++)
	 {
		 for(int j= 1; j<=col ; j++)
		 {
	     String value = driver.findElement(By.xpath("//div[@id='innings_1']//div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'][1]//div[@class='cb-col cb-col-100 cb-scrd-itms']["+i+"]//div["+j+"]")).getText();
	     System.out.print( " " + value + " ");
		 }
		 System.out.println();
	 }
	 System.out.println(row);
	 System.out.println(col);
	}
	
	@AfterTest
	void tearDown() {
		driver.quit();
	}

}
