package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.testBase.TestBase;

public class GenHealthyCompareRates extends TestBase {
	
	@FindBy(xpath = "//h2[contains(text(),'We Offer')]")
	static WebElement benefitPageTitle;
	
	
	@FindBy(xpath = "(//td[contains(text(),'after')]//following-sibling::td//div[@class='plan_tickIcon'])[3]")
	static WebElement planACheck;
	
	public GenHealthyCompareRates() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean loginCheck() {
		if(benefitPageTitle.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public String xpathCreator(String columnTitle, String plan) {
		String str1 = "(//td[contains(text(),'";
		String str2 = "')]//following-sibling::td//div[@class='plan_tickIcon'])[";
		if(plan.equals("A")) {
			return str1 + columnTitle + str2 + "3" + "]";
		}
		else if(plan.equalsIgnoreCase("B")){
			return str1 + columnTitle + str2 + "2" + "]";
		}
		else return str1 + columnTitle + str2 + "1" + "]";
	}
	
	public boolean tickCheck(){
		
		if(planACheck.isDisplayed()) {
			return true;
		}
		return false;
	}
	

}
