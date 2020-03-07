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
			categoryPage.searchCategory(name);
			Thread.sleep(2000);
			categoryPage.unpublishSigleCategory();
			
			
			//Publish single category
			categoryPage.clearSearch();
			categoryPage.searchCategory(name);
			Thread.sleep(2000);
			categoryPage.publishSingleCategory();
		
			//checkin single category
			categoryPage.clearSearch();
		    categoryPage.searchCategory(name);
		    Thread.sleep(2000);
			categoryPage.checkinCategory();
			
			//unpublish multiple categories		
			categoryPage.clearSearch();		
			Thread.sleep(2000);		
			categoryPage.unpublishMultipleCategories();		
			
			//publish multiple categories	
			Thread.sleep(2000);
			categoryPage.publishMultipleCategories();
			
			//Change access level of multiple categories
			/* Thread.sleep(2000);
			categoryPage.changeAccessLevel(); */
			
			//Delete multiple categories using Trash	
			Thread.sleep(2000);
			categoryPage.deleteCategories();		
			 
	    } 
		
	}
}
