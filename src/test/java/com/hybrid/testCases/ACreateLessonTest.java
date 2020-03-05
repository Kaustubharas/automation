package com.hybrid.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.hybrid.dataproviders.DataProviderClass;
import com.hybrid.pages.ACourseModulesPage;
import com.hybrid.testbase.TestBase;

public class ACreateLessonTest extends TestBase {

	@Test(dataProvider = "createLesson", dataProviderClass = DataProviderClass.class)

	public void createLesson(String testDesc, String lessonFormat, String name, String filePath,
			String expMessage, Method method) {
		
		logger = extent.createTest(method.getName().toString());
		
		ACourseModulesPage modules = new ACourseModulesPage(driver);

		driver.get(properties.getProperty("url")+"administrator/index.php?option=com_tjlms&view=dashboard");

		if (testDesc.equals("valid")) {
			
			modules.createLesson(lessonFormat, name, System.getProperty("user.dir") + "/" + filePath);

		}
	}

}
