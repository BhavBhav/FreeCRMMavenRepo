package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testBase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//div[contains(text(),'Deals Summary')]")
	WebElement homePageStatusCheck;
	
	@FindBy(xpath="//span[contains(text(),'Vibhav Kumar')]")
	WebElement userDisplayCheck;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsPageLink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsPageLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksPageLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public Boolean homePageOpenStatus() {
		Boolean homePageStatus = homePageStatusCheck.isDisplayed();
		return homePageStatus;
	}
	
	public Boolean userCheckonHomePage() {
		Boolean userDiplay = userDisplayCheck.isDisplayed();
		return userDiplay;
	}
	
	public DealsPage dealsPage() {
		dealsPageLink.click();
		return new DealsPage();
	}
	
	public ContactsPage contactsPageLabelonHomePage() {
		contactsPageLink.click();
		return new ContactsPage();
	}
	
	public TasksPage tasksPage() {
		tasksPageLink.click();
		return new TasksPage();
	}
	
	
}
