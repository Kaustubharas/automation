package com.hybrid.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.hybrid.utility.ExcelUtils;

public class DataProviderClass {

	public static final String TESTDATAEXCELFILE = "testData.xlsx";

	@DataProvider(name = "adminlogin")

	public static Object[][] adminlogin() throws IOException {

		return ExcelUtils.getExcelData(TESTDATAEXCELFILE, "adminLogin");

	}

	@DataProvider(name = "userlogin")

	public static Object[][] userlogin() throws IOException {

		return ExcelUtils.getExcelData(TESTDATAEXCELFILE, "userLogin");

	}

	@DataProvider(name = "createCategory")

	public static Object[][] createCategory() throws IOException {

		return ExcelUtils.getExcelData(TESTDATAEXCELFILE, "createCategory");

	}

	@DataProvider(name = "createCourse")

	public static Object[][] createCourse() throws IOException {

		return ExcelUtils.getExcelData(TESTDATAEXCELFILE, "createCourse");

	}

	@DataProvider(name = "createLesson")

	public static Object[][] createLesson() throws IOException {

		return ExcelUtils.getExcelData(TESTDATAEXCELFILE, "createLesson");

	}

}
