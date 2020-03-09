package com.shika.testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.shika.dataproviders.DataProviderClass;
import com.shika.pages.ACourseCategoryPage;
import com.shika.pages.ACreateCourseCategoryPage;
import com.shika.testbase.TestBase;

public class ACourseCategoryTest extends TestBase {

	@Test(dataProvider = "categoryList", dataProviderClass = DataProviderClass.class)

	public void courseCategory(String testDesc, String name, Method method) throws InterruptedException {
		
		logger = extent.createTest(method.getName().toString());
		
		ACourseCategoryPage categoryPage = new ACourseCategoryPage(driver);

		driver.get(properties.getProperty("url")+"administrator/index.php?option=com_categories&extension=com_tjlms");
		
		if (testDesc.equals("valid")) {

			// Unpublish single category
			categoryPage.searchCategory(name).unpublishSingleCategory();
			
			//Publish single category
			categoryPage.clearSearch().searchCategory(name).publishSingleCategory();
			
			//checkin single category
			categoryPage.clearSearch().searchCategory(name).checkinCategory();
			
			//unpublish multiple categories		
			categoryPage.clearSearch().unpublishMultipleCategories();		
										
			//publish multiple categories	
			categoryPage.publishMultipleCategories();
			
			//Delete multiple categories using Trash
			categoryPage.deleteCategories();		
			 
	    } 
		
	}
}
