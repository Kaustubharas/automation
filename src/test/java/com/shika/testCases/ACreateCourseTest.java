package com.shika.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.shika.DR.DataProviderClass;
import com.shika.OR.admin.ACreateCoursePage;
import com.shika.testBase.TestBase;

public class ACreateCourseTest extends TestBase {

	@Test(dataProvider = "createCourse", dataProviderClass = DataProviderClass.class)

	public static void createCourse(String testDesc, String name, String desc, String expMessage) {

		PageFactory.initElements(driver, ACreateCoursePage.class);
		
		driver.get("http://vowel.uniteframework.io/administrator/index.php?option=com_tjlms&view=dashboard");

		if (testDesc.equals("valid")) {

			ACreateCoursePage.createCourse(name, desc);

		}
	}
}
