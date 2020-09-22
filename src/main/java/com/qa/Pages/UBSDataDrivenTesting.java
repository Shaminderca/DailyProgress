package com.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class UBSDataDrivenTesting extends TestBase {

	public UBSDataDrivenTesting() {
		PageFactory.initElements(driver, this);
	}

	public static WebDriverWait wait = new WebDriverWait(driver, 20);
	public static JavascriptExecutor jse;

//Object Repositry
//by css only

	@FindBy(xpath = "//*[text()='Confirm']")
	WebElement confirmationButton;

	@FindBy(css = "input[name='Email']")
	WebElement emailFiled;

	@FindBy(xpath = "//label[@for='Salutation_2']")
	WebElement radioButtonSecond;

	// @FindBy(css = "label#Salutation_2")
	// WebElement radioButtonSecond;

	@FindBy(css = "input[name='Firstname']")
	WebElement nameField;

	@FindBy(css = "input[name='Lastname']")
	WebElement lastNameFied;

	@FindBy(css = "input[name='Company']")
	WebElement companyField;

	@FindBy(css = "select[name='Country']")
	WebElement countryField;

	@FindBy(css = "select[name='Investor']")
	WebElement investorField;

	@FindBy(xpath = "//input[@id='Accept_1']")
	WebElement acceptField;

	@FindBy(xpath = "//*[text()='Submit']")
	WebElement submitButton;

	public void inputValuesInForm(String email, String fname, String lname, String comapny) {

		confirmationButton.click();
		wait.until(ExpectedConditions.visibilityOf(emailFiled));
		emailFiled.sendKeys(email);
		radioButtonSecond.click();
		nameField.sendKeys(fname);
		lastNameFied.sendKeys(lname);
		companyField.sendKeys(comapny);
	}

	public void selectCountryField() {

		Select obj = new Select(countryField);
		obj.selectByIndex(2);
	}

	public void selectInvestorField() {
		Select obj2 = new Select(investorField);
		obj2.selectByIndex(2);
	}

	public void submitingForm() {
		// wait.until(ExpectedConditions.visibilityOf(acceptField));
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", acceptField);
		acceptField.click();
		submitButton.click();

	}

}
