package com.shika.testCases;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.shika.dataproviders.DataProviderClass;
import com.shika.pages.ACourseCategoryPage;
import com.shika.testbase.TestBase;

public class ACourseCategoryTest extends TestBase {

	@Test(dataProvider = "createCategory", dataProviderClass = DataProviderClass.class)

	public void courseCategory(String testDesc, String name, String expMessage, Method method)
			throws InterruptedException {

		logger = extent.createTest(method.getName().toString());

		ACourseCategoryPage categoryPage = new ACourseCategoryPage(driver);

		driver.get(properties.getProperty("url") + "administrator/index.php?option=com_categories&extension=com_tjlms");

		if (testDesc.equals("valid")) {
			
			//UnPublish Single Category
			categoryPage.searchCategory(name).unpublishSigleCategory();
			
			// Publish Single Category
			categoryPage.clearSearch().searchCategory(name).publishSingleCategory();

			// Check-in single category
			categoryPage.clearSearch().searchCategory(name).checkinCategory();

			// UnPublish multiple categories
			categoryPage.clearSearch().unpublishMultipleCategories();

			// Publish multiple categories
			categoryPage.publishMultipleCategories();

			// Delete multiple categories using Trash
			categoryPage.deleteMultipleCategories();

		}
	}

}
