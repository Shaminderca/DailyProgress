 package com.qa.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class NavigationCommands {
	public static WebDriver driver; 
	public static  void main(String args[]) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shami\\eclipse-workspace\\SeleniumMiscellaneousCases\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.get("https://nptel.ac.in/");
	    String title =driver.getTitle();
	    System.out.println(title);
	    driver.navigate().to("https://www.facebook.com/");
	    String currentURL = driver.getCurrentUrl();
	    System.out.println(currentURL);
	  //  String PageSource =   driver.getPageSource();
	  //  System.out.println(PageSource);
	    String title2 = driver.getTitle();
	    System.out.println(title2);
	    driver.navigate().back();
	    String title3 = driver.getTitle();
	    System.out.println(title3);
	    driver.navigate().refresh();
	    driver.quit();
	}

}
