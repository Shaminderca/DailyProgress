package com.qa.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HeadLessChrome {
	public static 	WebDriver driver;
//	public static WebDriverWait wait = new WebDriverWait(driver, 20);
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shami\\eclipse-workspace\\SeleniumMiscellaneousCases\\Driver\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
	    driver = new ChromeDriver(options);
	  //  driver.manage().window().maximize();
	   // driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.get("https://www.google.com/");
	    WebElement searchBox = driver.findElement(By.name("q"));
	    searchBox.sendKeys("Google");
	    WebElement namefield = driver.findElement(By.name("btnK"));
	 //   wait.until(ExpectedConditions.visibilityOf(namefield));
	    Thread.sleep(200);
	    namefield.click();
	    Thread.sleep(200);
	    WebElement element =  driver.findElement(By.id("logo"));
	    boolean flag = element.isDisplayed();
	    if(flag==true) {
	    	System.out.println("Test Pass");
	    }
	    else
	    {
	    	System.out.println("Test Fail");
	    }
	    
	    
	    driver.quit();
	    
	  
	    
	}
}
