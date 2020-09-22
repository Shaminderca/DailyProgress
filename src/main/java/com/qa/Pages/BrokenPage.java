package com.qa.Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class BrokenPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 20);
	JavascriptExecutor jse;

	public BrokenPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "*[text()='Twitter']")
	WebElement twitter;

	@FindBy(xpath = "//li[@class='gf-li']/a")
	List<WebElement> allLinks;

	@FindBy(xpath = "//a/button[contains(text(),'Home')]")
	// @FindBy(xpath="/html/body/header/div/a/button")
	WebElement homeIcon;

	// WebElement homeIcon =
	// driver.findElement(By.xpath("//a/button[contains(text(),'Home')]"));
	public String methodOne() {

		return driver.getTitle();
	}

	public String methodtwo() {
		Actions a = new Actions(driver);
		// jse = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.visibilityOf(homeIcon));

		// jse.executeScript("arguments[0].scrollIntoView(true);", homeIcon);
		// homeIcon.click();

		a.moveToElement(homeIcon).build().perform();
		String rgba = homeIcon.getCssValue("border-color");
		String color = Color.fromString(rgba).asHex();
		return color;
	}

	public int methodthree() throws IOException   {            
		String url;
		URL objURL;
		HttpURLConnection con;
		int responseCode =0;
		for (WebElement obj : allLinks) {
			url = obj.getAttribute("href");

			objURL = new URL(url);
			con = (HttpURLConnection) objURL.openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			responseCode = con.getResponseCode();
			System.out.println(responseCode);
			
			
		}
		return responseCode;
		
	

	}
}
