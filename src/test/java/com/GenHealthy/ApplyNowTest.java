package com.GenHealthy;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.testBase.TestBase;


public class ApplyNowTest extends TestBase {
	ApplyNowPage applynow;
	SoftAssert softAssert = new SoftAssert();
	
	public ApplyNowTest() {
		super();
	}
	
	@BeforeMethod
	public void initialiseApplyNowPage() {
		initialize();
		applynow = new ApplyNowPage();
	}
	
	@Test
	public void pageDisplay() {
		softAssert.assertEquals(applynow.isApplyNowDisplayed(), true);
		softAssert.assertAll();
	}
	
	@DataProvider
	public Object[][] dataProvider(){
		
		return new Object[][] {
			{"Vibhav", "", "Kumar" , "9156244"},
			
			};
	}
	
	@Test(dependsOnMethods = "pageDisplay" )
	public void fillData() {
		
	}
	
}
