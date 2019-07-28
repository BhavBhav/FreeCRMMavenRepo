package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.testBase.TestBase;
import com.crm.qa.util.TestUtilities;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtilities testUtilities;
	String sheetName1 = "Contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void contactsPageBeforeMethod() {
		initialize();
		loginPage = new LoginPage();
		contactsPage= new ContactsPage();
		homePage= LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.contactsPageLabelonHomePage();
		
	}
	
	@Test(priority=1)
	public void contactsPageLandingTest() {
		Assert.assertTrue(contactsPage.ContactsLabel(),"Contacts page failed to open");
	}
	
	@Test(priority=2)
	public void clickingOnCheckListTest() {
		contactsPage.selectContactsByNameCheckBox(); 
	}
	
	@DataProvider(name = "getCRMTestDataTest")
	public Object[][] getCRMTestDataTest() {
			Object[][] data1 = TestUtilities.getTestDataCRM(sheetName1);
		return  data1;
		
	}
	//When we are using Data provider, all column names should be present as parameter in calling method of
	// data provider. Else it will be give column mismatch error. 
	
	@Test (priority=3, dataProvider= "getCRMTestDataTest" )
	public void validateCreateNewContact(String firstName, String middleName, String lastName, String company, String email) {
		contactsPage.clickOnNewContactsLink();
		//contactsPage.createNewContact("tom", "dick", "harry", "Google", "vibhavkumar94@yahoo.com");
		contactsPage.createNewContact(firstName,middleName,lastName,company,email);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	
	 
}
