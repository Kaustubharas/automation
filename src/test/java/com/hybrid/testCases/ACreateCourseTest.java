package com.hybrid.testCases;

import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.hybrid.dataproviders.DataProviderClass;
import com.hybrid.pages.ACreateCoursePage;
import com.hybrid.testbase.TestBase;

public class ACreateCourseTest extends TestBase {

	@Test(dataProvider = "createCourse", dataProviderClass = DataProviderClass.class)

	public void createCourse(String testDesc, String name, String desc, String expMessage, Method method) {
		
		logger = extent.createTest(method.getName().toString());

		ACreateCoursePage coursePage = new ACreateCoursePage(driver);
		
		driver.get(properties.getProperty("url")+"administrator/index.php?option=com_tjlms&view=dashboard");
		
		if (testDesc.equals("valid")) {

			coursePage.createCourse(name, desc);

		}
	}

}
