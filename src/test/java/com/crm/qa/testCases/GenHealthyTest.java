package com.crm.qa.testCases;

import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.GenHealthyCompareRates;
import com.crm.qa.testBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenHealthyTest extends TestBase {
	GenHealthyCompareRates genHealthyCompareRates;
	ExtentReports report;
	ExtentTest test;
	public GenHealthyTest() {
		super();
	}
	
	@BeforeMethod
	public void extenReportCheck() {
		initialize();
		genHealthyCompareRates = new GenHealthyCompareRates();
		report = new ExtentReports(System.getProperty("user.dir")+"\\Extent_GH.html");
		test = report.startTest("ExtentDemo_Vibhav");
	}
	
	
	
	@Test(priority = 1)
	public void loginCheck() {
		Assert.assertTrue(genHealthyCompareRates.loginCheck());
		if(genHealthyCompareRates.loginCheck()== true) {
			test.log(LogStatus.PASS, "Logged in");
		}
		else test.log(LogStatus.FAIL, "did not logged in");
	}
	
	@Test(priority = 2)
	public void tickCheckForPlaA() {
		Assert.assertTrue(genHealthyCompareRates.tickCheck());
		if(genHealthyCompareRates.tickCheck() == true) {
			test.log(LogStatus.PASS, "Plan A is Checked");
		}
		else test.log(LogStatus.FAIL, "Plan Not Checked");
	}
	
	@AfterMethod
	public void tearDown(){
		report.endTest(test);
		report.flush();
		driver.quit();
}
	
	

}
