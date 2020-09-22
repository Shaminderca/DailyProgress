package com.qa.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;



public class Utils extends TestBase{

	public static long IMPLICIT_WAIT = 10;
	public static long PAGE_LOADOUT_WAIT = 60;

	public static String randomEmailGenerator() {
		String randomEmailPortion = RandomStringUtils.randomNumeric(3);
		String email = "manish" + randomEmailPortion + "@gmail.com";
		return email;

	}

	public static String randomPasswordGenerator() {
		String randomPasswordPortion = RandomStringUtils.randomNumeric(4);
		String passowrd = "Shamind@1" + randomPasswordPortion;
		return passowrd;

	}
	
	
	public static void failedTestScreenShot(String testMethodName) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File screenShotFfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./ScreeShot\\" + "" + testMethodName + "" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}
	}
	
}
//C:\Project\CarboniteQA\src\test\java\com\carbonite\qa\testcases\StartTrialHomeBackupPageTest.java