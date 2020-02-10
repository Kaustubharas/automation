package com.shika.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.shika.DR.DataProviderClass;
import com.shika.OR.admin.ACourseCategoryPage;
import com.shika.OR.admin.ACreateCourseCategoryPage;
import com.shika.testBase.TestBase;

public class ACourseCategoryTest extends TestBase {

	@Test(dataProvider = "createCategory", dataProviderClass = DataProviderClass.class)

	public static void createCourseCategory(String testDesc, String name, String expMessage) {

		PageFactory.initElements(driver, ACourseCategoryPage.class);

		PageFactory.initElements(driver, ACreateCourseCategoryPage.class);

		driver.get("http://vowel.uniteframework.io/administrator/index.php?option=com_categories&extension=com_tjlms");
		
		if (testDesc.equals("valid")) {

			ACreateCourseCategoryPage.createCategoryAs(name);

		}
	}

}
