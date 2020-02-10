package com.shika.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.shika.DR.DataProviderClass;
import com.shika.OR.admin.ACourseModulesPage;
import com.shika.OR.admin.ACoursePage;
import com.shika.OR.admin.ADashboardPage;
import com.shika.OR.admin.LessonDetailsPage;
import com.shika.OR.admin.PickLessonTypePage;
import com.shika.testBase.TestBase;

public class ACreateLessonTest extends TestBase {

	@Test(dataProvider = "createLesson", dataProviderClass = DataProviderClass.class)

	public static void createLesson(String testDesc, String lessonFormat, String name, String filePath, String expMessage) {

		PageFactory.initElements(driver, ACoursePage.class);
		
		PageFactory.initElements(driver, ADashboardPage.class);
		
		PageFactory.initElements(driver, ACourseModulesPage.class);
		
		PageFactory.initElements(driver, PickLessonTypePage.class);
		
		PageFactory.initElements(driver, LessonDetailsPage.class);
		
		driver.get("http://vowel.uniteframework.io/administrator/index.php?option=com_tjlms&view=dashboard");
		
		if (testDesc.equals("valid")) {
			
			ACourseModulesPage.createLesson(lessonFormat, name, filePath);

		}
	}

}
