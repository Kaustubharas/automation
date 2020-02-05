package com.shika.DR;

import org.testng.annotations.DataProvider;

import com.shika.utility.ExcelUtils;

public class DataProviderClass {
	
	@DataProvider (name = "adminlogin")
	
	public static Object[][] adminlogin() throws Exception{
				
		Object[][] adminloginData = ExcelUtils.getExcelData("testData.xlsx", "adminLogin");
		
		return adminloginData;
		
	}
	
	@DataProvider (name = "userlogin")
	
	public static Object[][] userlogin() throws Exception{
				
		Object[][] userloginData = ExcelUtils.getExcelData("testData.xlsx", "userLogin");
		
		return userloginData;
		
	}
	
	@DataProvider (name = "createCategory")
	
	public static Object[][] createCategory() throws Exception{
				
		Object[][] createCategoryData = ExcelUtils.getExcelData("testData.xlsx", "createCategory");
		
		return createCategoryData;
		
	}
	
	@DataProvider (name = "createCourse")
	
	public static Object[][] createCourse() throws Exception{
				
		Object[][] createCourseData = ExcelUtils.getExcelData("testData.xlsx", "createCourse");
		
		return createCourseData;
		
	}
	
	@DataProvider (name = "createLesson")
	
	public static Object[][] createLesson() throws Exception{
				
		Object[][] createLessonData = ExcelUtils.getExcelData("testData.xlsx", "createLesson");
		
		return createLessonData;
		
	}

}
