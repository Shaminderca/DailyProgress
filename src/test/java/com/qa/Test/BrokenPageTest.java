package com.qa.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.Pages.BrokenPage;
import com.qa.base.TestBase;

public class BrokenPageTest extends TestBase {
	BrokenPage bp;

	@BeforeMethod
	void setUp() {
		initialisation("https://rahulshettyacademy.com/AutomationPractice/");
		bp = new BrokenPage();
	}

	@Test
	void testone() {
		String color = bp.methodtwo();
		Assert.assertEquals("#0062cc", color);

	}

	@Test
	void testthree() throws IOException {
		SoftAssert obj = new SoftAssert();
		int code = bp.methodthree();
		obj.assertTrue(code<400);
		obj.assertAll();

	}

	@AfterMethod
	void tearDown() {
		driver.quit();
	}
}
