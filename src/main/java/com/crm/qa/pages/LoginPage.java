package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testBase.TestBase;


public class LoginPage extends TestBase {
	//PageFactory OR ObjectRepository
		//Written by - Vibhav (23-06/19)
		
		@FindBy(xpath="//span[text()='Log In']")
		static WebElement loginbutton;
		
		@FindBy(name= "email")	
		static WebElement name;
		
		@FindBy(name="password")
		static WebElement password;
		
		@FindBy(xpath="//*[contains(@class,'ui fluid large blue submit button')]")
		static WebElement LogintoHomePage;
		
		@FindBy (xpath ="//a[text()='Sign Up']")
		static WebElement signupButton;
		
		@FindBy (xpath ="//a[text()='Sign Up']")
		static WebElement crmLogo;
		
		//Below declared is LoginPage constructor to initialize all the webelements. This is how we initialize
		//WebElements in a PageFactory.
		public LoginPage () {
			PageFactory.initElements(driver, this); 
		}
		public boolean validateCRMImage() {
			return crmLogo.isDisplayed();
		}
		
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public static HomePage login(String username, String pwd) {
			loginbutton.click();
			 name.sendKeys(username);
			 password.sendKeys(pwd);
			 LogintoHomePage.click();
			 return new HomePage();
		}
}



