package com.GenHealthy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testBase.TestBase;

public class ApplyNowPage extends TestBase {
	
	@FindBy(xpath = "//h1[contains(text(),'Welcome')]")
	WebElement applyNowPageTitleElement;
	
	@FindBy(xpath = "//span[contains(text(),'10%')]")
	WebElement progressStateElement;
	
	@FindBy(xpath = "//input[contains(@id,'firstName')]")
	WebElement firstNameElement;
	
	@FindBy(xpath = "//input[contains(@id,'middle')]")
	WebElement middleNameElement;
	
	@FindBy(xpath = "//input[contains(@id,'lastName')]")
	WebElement lastNameElement;
	
	@FindBy(xpath = "//input[contains(@id,'Date')]")
	WebElement dateOfBirthElement;
	
	@FindBy(xpath = "//input[contains(@id,'phone')]")
	WebElement phoneNumberElement;
	
	@FindBy(xpath = "//input[contains(@id,'zip')]")
	WebElement zipCodeElement;
	
	@FindBy(xpath = "//input[contains(@id,'emailAddress')]")
	WebElement emailAddressElement;
	
	public ApplyNowPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isApplyNowDisplayed() {
		return applyNowPageTitleElement.isDisplayed();
	}
	
	public MedicareStatus EnterData() {
		return new MedicareStatus();
	}
	
	
	
}
