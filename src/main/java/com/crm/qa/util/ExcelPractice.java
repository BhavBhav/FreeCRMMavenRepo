package com.crm.qa.util;

import java.util.HashMap;

public class ExcelPractice {
	public static HashMap<String,String> map = new HashMap<String,String>();
	
	public ExcelPractice() {
		 
	}
	
	public static String fetchRates(String state, String Plan, String zipCode, String gender,int age) {
		ExcelUtilities_Naveen reader = new ExcelUtilities_Naveen("C:\\Users\\Lucky\\Desktop\\RatesGH.xlsx");
		int rowsCount = reader.getRowCount("Rates");
		String answer= "";
		for (int i = 2; i < rowsCount; i++) {
			String stateCheck=  reader.getCellData("Rates", "State", i);
			if(!stateCheck.equalsIgnoreCase(state)){
				continue;
			}
			String planCodeCheck = reader.getCellData("Rates", "Plan", i);
			if(!planCodeCheck.equalsIgnoreCase(Plan)){
				continue;
			}
			String zipCodeCheck = reader.getCellData("Rates", "Zip Code", i);
			if(!zipCodeCheck.equalsIgnoreCase(zipCode)){
				continue;
			}
			String genderCheck = reader.getCellData("Rates", "Gender", i);
			if(!genderCheck.equalsIgnoreCase(gender)){
				continue;
			}
			String ageCheckString =  reader.getCellData("Rates", "Age", i);
			double doubleVar = Double.parseDouble(ageCheckString);
			int ageCheckInt = (int) doubleVar;
			if(!String.valueOf(ageCheckInt).equalsIgnoreCase(String.valueOf(age))){
				continue;
			}
			answer  =  reader.getCellData("Rates", "Rate", i);
			
		}
		return answer;
	}
	
	public static void mapData() {
		ExcelUtilities_Naveen reader = new ExcelUtilities_Naveen("C:\\Users\\Lucky\\Desktop\\RatesGH.xlsx");
		int rowsCount = reader.getRowCount("Rates");
		
		String answer= "";
		for (int i = 2; i < rowsCount; i++) {
			String stateCheck=  reader.getCellData("Rates", "State", i);
			String planCodeCheck = reader.getCellData("Rates", "Plan", i);
			String zipCodeCheck = reader.getCellData("Rates", "Zip Code", i);
			String genderCheck = reader.getCellData("Rates", "Gender", i);
			String ageCheckString =  reader.getCellData("Rates", "Age", i);
			answer  =  reader.getCellData("Rates", "Rate", i);
			String mapKey = stateCheck+ planCodeCheck + zipCodeCheck + genderCheck + ageCheckString;
			map.put(mapKey, answer);
		}
		
	}

	public static void main(String[] args) {
		String data = fetchRates("AL", "B", "High", "M", 68);
		System.out.println(data);
		mapData();
		System.out.println(map.get("ALBHighM68.0"));

	}

}
