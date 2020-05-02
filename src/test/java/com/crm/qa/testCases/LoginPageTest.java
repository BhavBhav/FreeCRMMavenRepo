package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	static ExtentTest test;
	static ExtentReports report;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialize(); 
		loginPage = new LoginPage();
		/*report = new ExtentReports(System.getProperty("user.dir")+"\\Extent.html");
		test = report.startTest("ExtentDemo");*/
		
	}
	//@Test(priority=1,retryAnalyzer=retryAnalyzer.RetryAnalyzer.class)
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title= loginPage.validateLoginPageTitle();
		/*if(title.equalsIgnoreCase("Free CRM #1 cloud software for any business large or small")) {
			test.log(LogStatus.PASS, "Title matched");
		}
		else {
			test.log(LogStatus.FAIL, "Title did not match");
		}*/
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
		
	}
	
	 @Test(priority=2)
	 public void titleCheck(){
		 Boolean trueFlag = loginPage.validateCRMImage();
		 /*if(trueFlag == true) {
			 test.log(LogStatus.PASS, "title image found too" );
		 }
		 else {
			 test.log(LogStatus.FAIL, "Title image not found");
		 }*/
		 Assert.assertTrue(trueFlag);
		 
	 }
	 
	 @Test(priority=3)
	 public void loginTest() throws InterruptedException{
		
		 homePage= LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 boolean check = true;
		 /*if( check == true) {
			 test.log(LogStatus.PASS, "Login passed" );
		 }
		 else {
			 test.log(LogStatus.FAIL, "Login failed");
		 }*/
		 Thread.sleep(3000);
		
	 }
	 
	 
	
	@AfterMethod
	public void tearDown(){
		/*report.endTest(test);
		report.flush();*/
		driver.quit();
}
	
	
}

