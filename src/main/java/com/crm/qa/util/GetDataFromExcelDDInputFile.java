package com.crm.qa.util;

import java.util.ArrayList;

public class GetDataFromExcelDDInputFile {
	static ExcelUtilities_Naveen reader;
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>(); 
		try {
			reader = new ExcelUtilities_Naveen("C:\\Users\\Lucky\\eclipse-workspace\\SeleniumLearning\\src\\com\\testData\\halfebayTest.xlsx");
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		for (int rowNum=2; rowNum<=reader.getRowCount("ebayTestData"); rowNum++) {
			String firstName= reader.getCellData("ebayTestData", "FirstName", rowNum);
			String lastName= reader.getCellData("ebayTestData", "LastName", rowNum);
			String email= reader.getCellData("ebayTestData", "Email", rowNum);
			String password= reader.getCellData("ebayTestData", "Password", rowNum);
			
			Object[] ob= {firstName,lastName,email,password};
			myData.add(ob);
		}
		return myData;
	}


}
