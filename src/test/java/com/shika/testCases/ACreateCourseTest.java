package com.shika.testCases;

import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.shika.DR.DataProviderClass;
import com.shika.or.admin.ACreateCoursePage;
import com.shika.testbase.TestBase;

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
