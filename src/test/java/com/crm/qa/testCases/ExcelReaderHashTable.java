package com.crm.qa.testCases;

import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.util.ExcelUtilities_Naveen;
import com.crm.qa.util.TestUtilities;

public class ExcelReaderHashTable {
	public static ExcelUtilities_Naveen excel = null;


	

	@DataProvider()
	public Object[][] getData(){
		if(excel == null) {
			excel = new ExcelUtilities_Naveen("C:\\\\Users\\\\Lucky\\\\Desktop\\\\java and Selenium\\\\DataDrivenFiles\\\\freeCRMTestData.xlsx");

		}
		String sheetName = "Contacts";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][1];
		Hashtable<String,String> table = null;
		
		for(int rowNum=2; rowNum <=rows; rowNum++) {
			table = new Hashtable<String,String>();
			for(int colNum =0; colNum<cols; colNum++) {
				//data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
				table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));
				data[rowNum-2][0] = table;
				
			}
		}
		return data;
	}

	@Test(dataProvider = "getData")
	
		public static void ExcelReader(Hashtable<String,String> data) {
			//System.out.println(firstName +"---"+ middleName);
		System.out.println(data.get("email"));
		}

	

}
