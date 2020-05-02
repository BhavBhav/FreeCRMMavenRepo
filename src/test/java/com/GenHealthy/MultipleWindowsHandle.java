package com.GenHealthy;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.testBase.TestBase;
import com.crm.qa.util.TestUtilities;

public class MultipleWindowsHandle extends TestBase {
	TestUtilities testUtil  = new TestUtilities();
	SoftAssert softAssert = new SoftAssert();
	
	public MultipleWindowsHandle() {
		super();
		initialize();
	}
	
	@Test
	public void multipleWindows() {
		String homeTabName = driver.getWindowHandle();
		System.out.println("Parent Window id is :" + homeTabName);
		TestUtilities.ClickElement("(//a[@name='link1'])[1]", "xpath");
		Set<String> activeWindowsId = driver.getWindowHandles();
		for ( String str : activeWindowsId) {
			System.out.println(str);
		}
		String currentTabName = driver.getWindowHandle();
		System.out.println("Window id of current window is : "+currentTabName );
		softAssert.assertEquals(homeTabName, currentTabName);
		TestUtilities.ClickElement("(//a[@name='link1'])[2]", "xpath");
		
		
		
		softAssert.assertAll();
	}
	
	

}
