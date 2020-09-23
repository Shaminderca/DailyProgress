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
		initialisation(
				"https://www.google.com/flights?hl=en#flt=/m/0h7h6..2020-10-09*./m/0h7h6.2020-10-13;c:CAD;e:1;ls:1w;sd:0;t:h");
	}

	@Test
	public void testOne() {
		String month = "December";
		String date = "23";
		WebElement OptionsofWay = driver.findElement(By.xpath("//div[@class='mSPnZKpnf91__container']"));
		OptionsofWay.click();
		WebElement oneWay = driver.findElement(By
				.xpath("//div[@class='mSPnZKpnf91__menu mSPnZKpnf91__cover-button mSPnZKpnf91__open']//menu-item[2]"));
		oneWay.click();
		WebElement calander = driver.findElement(By.xpath(
				"//div[@class='gws-flights-form__input-container gws-flights__flex-box gws-flights__flex-filler gws-flights-form__calendar-input flt-body2']//div[1]"));
		calander.click();
		int size = driver.findElements(By.xpath("//month-header")).size();
		WebElement calanderFliper = driver.findElement(By.cssSelector(".njjicd.rSFy9b"));
		WebDriverWait wait = new WebDriverWait(driver, 20);

		System.out.println(driver.findElement(By.xpath("//month-header")).getText());
		while (true) {
			String text = driver.findElement(By.xpath("//month-header")).getText();
			if (text.equals(month)) {
				break;
			}

			else {
				calanderFliper.click();
			}
		}
	}

	/*
	 * for (int i = 1; i <= size; i++) { calanderFliper.click();
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
	 * "//month-header//jsl")))); if
	 * (driver.findElement(By.xpath("//calendar-month//month-header//jsl["+i+"]")).
	 * getText().equalsIgnoreCase("April 2021")) {
	 * wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath(
	 * "//calendar-week//calendar-day[@data-day='2021-04-23']"))));
	 * driver.findElement(By.xpath(
	 * "//calendar-week//calendar-day[@data-day='2021-04-23']")).click();
	 * driver.findElement(By.xpath("//*[text()='Done']")).click(); break; }
	 * 
	 * } System.out.println(size);
	 * 
	 * }
	 * 
	 * public void testOne() throws InterruptedException { Thread.sleep(500);
	 * WebElement calander =
	 * driver.findElement(By.xpath("//input[@id='travel_date']")); //
	 * JavascriptExecutor jse = (JavascriptExecutor) driver;
	 * //jse.executeScript("arguments[0].scrollIntoView(true);",calander);
	 * WebDriverWait wait = new WebDriverWait(driver, 20);
	 * wait.until(ExpectedConditions.visibilityOf(calander)); boolean flag
	 * =calander.isDisplayed(); System.out.println(flag); calander.click();
	 * List<WebElement> dates = driver.findElements(By.cssSelector(".day")); int
	 * count = driver.findElements(By.cssSelector(".day")).size(); for(int
	 * i=1;i<=count;i++) { String text =
	 * driver.findElements(By.cssSelector(".day")).get(i).getText();
	 * if(text.equalsIgnoreCase("23")) {
	 * driver.findElements(By.cssSelector(".day")).get(i).click(); }
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
