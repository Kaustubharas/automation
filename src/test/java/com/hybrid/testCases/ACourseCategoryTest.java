package com.hybrid.testCases;

import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.hybrid.dataproviders.DataProviderClass;
import com.hybrid.or.admin.ACreateCourseCategoryPage;
import com.hybrid.testbase.TestBase;

public class ACourseCategoryTest extends TestBase {

	@Test(dataProvider = "createCategory", dataProviderClass = DataProviderClass.class)

	public void createCourseCategory(String testDesc, String name, String expMessage, Method method) {
		
		logger = extent.createTest(method.getName().toString());

		ACreateCourseCategoryPage categoryPage = new ACreateCourseCategoryPage(driver);

		driver.get(properties.getProperty("url")+"administrator/index.php?option=com_categories&extension=com_tjlms");
		
		if (testDesc.equals("valid")) {

			categoryPage.createCategoryAs(name);

		}
	}

}
