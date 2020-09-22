package com.qa.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableTest extends TestBase {

	@BeforeMethod
    void setup()
    { 
    	initialisation("https://www.w3schools.com/html/html_tables.asp");
    }

	@Test
	void testOne() {
	  int rows= driver.findElements(By.xpath("//table[@id='customers']//tbody//tr")).size();
	  int col = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr//th")).size();
	  System.out.println(rows);
	  System.out.println(col);
	  for(int i=2 ; i<= rows ; i++)
	  {
		  for(int j=1; j<=col;j++)
		  {
			 String textOftable=  driver.findElement(By.xpath("//table[@id='customers']//tbody//tr["+i+"]//td["+j+"]")).getText();
			 System.out.print(textOftable + "   ");
		  }  
		  System.out.println();
	  }
	 
	}
	 
	
	
	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}

