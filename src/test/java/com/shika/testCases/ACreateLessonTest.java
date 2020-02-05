package com.shika.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.shika.DR.DataProviderClass;
import com.shika.OR.admin.ACourseModulesPage;
import com.shika.testBase.TestBase;

public class ACreateLessonTest extends TestBase {

	@Test(dataProvider = "createLesson", dataProviderClass = DataProviderClass.class)

	public static void createLesson(String testDesc, String lessonFormat, String name, String filePath,
			String expMessage) {
		
		PageFactory.initElements(driver, ACourseModulesPage.class);

		driver.get("http://vowel.uniteframework.io/administrator/index.php?option=com_tjlms&view=dashboard");

		if (testDesc.equals("valid")) {

			ACourseModulesPage.createLesson(lessonFormat, name, filePath);

		}
	}

}
