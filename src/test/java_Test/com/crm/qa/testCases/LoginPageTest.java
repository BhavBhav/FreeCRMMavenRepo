package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		initialize(); 
		loginPage = new LoginPage();
		
	}
	//@Test(priority=1,retryAnalyzer=retryAnalyzer.RetryAnalyzer.class)
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software for any Business");
	}
	
	 @Test(priority=2)
	 public void titleCheck(){
		 Boolean trueFlag = loginPage.validateCRMImage();
		 Assert.assertTrue(trueFlag);
	 }
	 
	 @Test(priority=3)
	 public void loginTest() throws InterruptedException{
		 homePage= LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 Thread.sleep(3000);
	 
	 }
	 
	 
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
}
	
	
}

