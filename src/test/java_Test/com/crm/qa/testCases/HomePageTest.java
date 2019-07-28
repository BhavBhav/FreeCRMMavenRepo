package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	//test cases should be independent to each other. 
	//before every browser launch the browser and login.
	//after each test case close the browser.
	
	@BeforeMethod
	public  void homePageBeforeMethod() {
		initialize();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage= LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle= driver.getTitle();
		Assert.assertEquals(homePageTitle, "CRM","Title is not matching");
	}
	
	@Test(priority=2)
	public void pageLandingStatusTest () throws InterruptedException	{
		Assert.assertTrue(homePage.homePageOpenStatus(), "Well title of the HomePage is not matching..!!"); 
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void userNameTest() throws InterruptedException  {
		Boolean userNameflag= homePage.userCheckonHomePage();
		Assert.assertTrue(userNameflag,"UserName is not Vibhav Kumar");
		Thread.sleep(5000);
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.contactsPageLabelonHomePage();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
}
