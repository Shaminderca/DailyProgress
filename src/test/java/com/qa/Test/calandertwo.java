package com.qa.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class calandertwo extends TestBase {

	
	@BeforeMethod
	public void setUp() {
	initialisation("https://www.path2usa.com/travel-companions");
	}

	
	@Test
	public void testOne() throws InterruptedException {
		Thread.sleep(500);
		WebElement calander = driver.findElement(By.xpath("//input[@id='travel_date']"));
	//	JavascriptExecutor jse = (JavascriptExecutor) driver;
		//jse.executeScript("arguments[0].scrollIntoView(true);",calander);
		WebDriverWait  wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(calander));
		boolean flag =calander.isDisplayed();
		System.out.println(flag);
		calander.click();
        List<WebElement> dates = driver.findElements(By.cssSelector(".day"));
        int count = driver.findElements(By.cssSelector(".day")).size();
        for(int i=1;i<=count;i++) {
        String text =	driver.findElements(By.cssSelector(".day")).get(i).getText();
        if(text.equalsIgnoreCase("23")) {
        	driver.findElements(By.cssSelector(".day")).get(i).click();
        }
        
        }

	    
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
