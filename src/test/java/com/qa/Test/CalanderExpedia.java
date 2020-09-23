package com.qa.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class CalanderExpedia extends TestBase {

	@BeforeMethod
	void setUp(){
		initialisation("https://www.expedia.ca/?pwaLob=wizard-flight-pwa");
	   
	}

    @Test
	void TestMethod() {
    	String monthDesired = "April 2021";
		System.out.println("HEY");
		WebElement oneWay = driver.findElement(By.xpath("//div[@class='uitk-tabs-inner-container']//li[2]"));
		oneWay.click();
		WebElement calnder = driver.findElement(By.id("d1-btn"));
		calnder.click();
		
	//	System.out.println(monthField);
		WebElement arrow = driver.findElement(By.xpath("//button[@class='uitk-button uitk-button-small uitk-flex-item uitk-button-paging'][2]"));
		while(true) {
			WebElement month = driver.findElement(By.xpath("//h2[@class='uitk-new-date-picker-month-name uitk-type-medium']"));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(month));
			String monthField = driver.findElement(By.xpath("//h2[@class='uitk-new-date-picker-month-name uitk-type-medium']")).getText();
			if(monthField.equalsIgnoreCase(monthDesired))
			{
				break;
			}
			else{
				arrow.click();
			}
			}
	//	List<WebElement> allDates = driver.findElements(By.xpath("//*[@id='wizard-flight-tab-oneway']/div/div[2]/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[]/td[]/button"));
		List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='uitk-new-date-picker-month'][1]//table//tbody//tr//td//button"));
		for(WebElement i : allDates) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(i));
		String text =	i.getText();
		System.out.println(text);
		}
	
	}
    ////*[@id="wizard-flight-tab-oneway"]/div/div[2]/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[3]/td[6]/button
    
    @AfterMethod
    void tearOFF() {
  driver.quit();
    }
}
