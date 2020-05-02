package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testBase.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[text()='New']")
	WebElement newContacts;
	
	@FindBy(name="middle_name")
	WebElement middleNameElement;
	
	@FindBy(name="last_name")
	WebElement lastNameElement;
	
	@FindBy(xpath="//div[@name='company']//input[@aria-autocomplete='list']")
	WebElement companyNameElement;
	
	@FindBy(xpath="//div//following-sibling::input[@name='value']")
	WebElement emailElement;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	
	public ContactsPage( ){
		PageFactory.initElements(driver, this);
	}
	
	public boolean ContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByNameCheckBox () {
		
		try {
			//driver.findElement(By.xpath("//input[@class='hidden']//following::input[1]")).clear();
			driver.findElement(By.xpath("//input[@class='hidden']//following::input[1]")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage()+" is the Exception");
		}	
	}
	
	//clicking on new contacts link here.
	public void clickOnNewContactsLink() {
		newContacts.click();
	}
	
	//Sending data to create new contact. 
	public void createNewContact(String firstName, String middleName, String lastName, String companyName, String email) 
	{
		 
		driver.findElement(By.name("first_name")).sendKeys(firstName); 
		middleNameElement.sendKeys(middleName);
		lastNameElement.sendKeys(lastName);
		companyNameElement.sendKeys(companyName);
		emailElement.sendKeys(email);
		
		saveButton.click();
		
		
	
	}
	
}
