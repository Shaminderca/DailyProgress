package com.qa.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.Pages.UBSDataDrivenTesting;
import com.qa.base.TestBase;

public class UBSDataDrivenTestingTEST extends TestBase {
	UBSDataDrivenTesting ubs;

	@BeforeMethod
	void startUp() {
		initialisation(
				"https://www.ubs.com/global/en/asset-management/insights/sustainable-and-impact-investing/contact-form.html");
		ubs = new UBSDataDrivenTesting();
	}

	@Test(dataProvider = "DataProviderMethod")
	void methodtTest(String email, String fname, String lname, String comapny) {
		ubs.inputValuesInForm(email, fname, lname, comapny);
		ubs.selectCountryField();
		ubs.selectInvestorField();
		ubs.submitingForm();

		
	}

	/*
	 * @DataProvider(name="TestDataProviderFromExcel") 
	 * String[][] TestDataProvider()
	 * { String filePath = "./ExcelData\\CarboniteData.xlsx"; 
	 * int row =
	 * ExcelUtility.getRowCount(filePath, "DataExcel"); 
	 * int col =
	 * ExcelUtility.getCellCount(filePath, "DataExcel", 1); 
	 * String[][]
	 * SignUpTestData = new String[row][col]; 
	 * for (int i = 1; i <= row; i++)
	 *  { for
	 * (int j = 0; j < col; j++)
	 *  { SignUpTestData[i - 1][j] =
	 * ExcelUtility.getCellData(filePath, "DataExcel", i, j); }
	 * 
	 * } return SignUpTestData; }
	 */

	@DataProvider(name="DataProviderMethod")
	String[][] TestDataProvider() {
		String filePath = "./ExcelData\\TestDataUBS.xlsx";
		int row = com.qa.Utils.ExcelUtility.getRowCount(filePath, "Sheet1");
		int col = com.qa.Utils.ExcelUtility.getCellCount(filePath, "Sheet1", 1);
		String[][] data = new String[row][col];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j < col; j++) {
				data[i-1][j]= com.qa.Utils.ExcelUtility.getCellData(filePath,"Sheet1", i, j);
			}
		}
		return data;

	}

	@AfterMethod
	void TearDown() {
		// driver.quit();
	}

}
////*[@id="_content_sites_global_en_asset-management_sustainability-insights_contact-form_jcr_content_mainpar_toplevelgrid_1923968615_col1_start"]/div[2]/div[4]/fieldset/div[2]/fieldset/ul/li[2]/label