package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.testBase.TestBase;

public class TestUtilities extends TestBase {
	static Object[][] cellData;
	public static long PAGE_LOAD_TIMEOUT = 30;//Please mind that it is in seconds
	public static long IMPLICITLY_TIMEOUT =30; //this also is in seconds
	
	
	//method frameName is for switching the frames
	public void switchToFrame(String frameName) {
		driver.switchTo().frame(frameName); //give frameName or index or Webelement
	}
	
	//method numberOfFrames is to get total number of frames present in the page.
	public void frameNumbers() {
		List <WebElement> numberOfFrames = driver.findElements(By.tagName("iframe"));
		System.out.println(numberOfFrames.size());
	}
	
	//Getting all the frames present in a WebPage
	public void getAllFrames() {
		List<WebElement> presentFrames= driver.findElements(By.tagName("iframes"));
		System.out.println(presentFrames);//this will present all the frames in one line- so the list will be long line
		
		//First Method to print the list in separate lines- use ANYONE METHOD
		for (Object vertical_Frames: presentFrames) {
			System.out.println(vertical_Frames);
		}
		//Second Method to print the list in separate lines
		// presentFrames.forEach(System.out::println);   This is showing error but it should not.
	}
	
	public static Object[][] getTestDataCRM(String sheetName)  {
		 
		FileInputStream fis= null;
		try {
		File file = new File("C:\\Users\\Lucky\\Desktop\\java and Selenium\\DataDrivenFiles\\freeCRMTestData.xlsx");
		fis = new FileInputStream(file);
		}
		catch (Exception e) {
            e.printStackTrace();
        }
		
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		org.apache.poi.ss.usermodel.Sheet contactsPagesData = wb.getSheet(sheetName);
		
		int lastRowNum = contactsPagesData.getLastRowNum();
		int totalColumn = contactsPagesData.getRow(0).getLastCellNum();
		Object[][] cellData = new Object[lastRowNum][totalColumn];
		for (int i=0; i<lastRowNum; i++) 
		{
			for (int j=0; j < totalColumn; j++)
			{
				 cellData[i][j] = contactsPagesData.getRow(i+1).getCell(j).toString();
				// System.out.println(cellData[i][j]);
			}
		}
		
		return cellData;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public String getStringShotExtentReport(String screenShotName) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		String destination = System.getProperty("user.dir")+"/failedTestScreenshots/" + screenShotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(srcFile, finalDestination);
		return destination;
	}
		

}
