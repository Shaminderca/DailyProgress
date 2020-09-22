package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Utils.Utils;




public class TestBase {
	

public static Properties prop;
public static WebDriver driver;



public TestBase() {
	
	
	
	prop = new Properties();
	FileInputStream fis;//this should be discussed
	
	try {
		fis = new FileInputStream("C:\\Users\\shami\\eclipse-workspace\\SeleniumMiscellaneousCases\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


public String initialisation(String url)  {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\shami\\eclipse-workspace\\SeleniumMiscellaneousCases\\Driver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    driver.get(url);
	return url;
	
	 
	

}
}
