package com.qa.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {
	public static WebDriver driver;
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shami\\eclipse-workspace\\SeleniumMiscellaneousCases\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.get("https://www.facebook.com/");
	    WebElement name=   driver.findElement(By.name("email"));
	    WebElement pass = driver.findElement(By.name("pass"));
	    WebElement login = driver.findElement(By.name("login"));
	    boolean flagOne = name.isDisplayed();
	    boolean flagTwo = pass.isDisplayed();
	    boolean flagThree = login.isDisplayed();
	    boolean flagFour = name.isEnabled();
	    boolean flagfive = pass.isEnabled();
	    boolean flagSix = login.isEnabled();
	    
	    if(flagOne== true && flagFour==true )
	    {
	    	name.sendKeys("abc@gmail.com");
	    }
	    else {
	    	System.out.println("Condtions Not Fulfilled");
	    }
	    if(flagTwo== true && flagfive==true )
	    {
	    	pass.sendKeys("GHKAHD");
	    }
	    else {
	    	System.out.println("Condtions Not Fulfilled");
	    }
	    login.click();
	    driver.quit();
	    
	    
	    
	    
	}

}
