package com.shika.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.shika.DR.DataProviderClass;
import com.shika.OR.admin.ALoginPage;
import com.shika.testBase.TestBase;

public class ALoginTest extends TestBase {

	@Test(dataProvider = "adminlogin", dataProviderClass = DataProviderClass.class)

	public static void adminLogin(String testDesc, String un, String pw, String expMessage) {
		
        test = extent.createTest("adminlogin");
        
        test.info("This step shows usage of info(details)");

		driver.get(properties.getProperty("url") + "administrator");

		PageFactory.initElements(driver, ALoginPage.class);

		if (!testDesc.equals("valid")) {

			ALoginPage.submitLoginExpectingFailure(un, pw);

			Assert.assertEquals(ALoginPage.InvalidUsername(), expMessage);

		} else if (testDesc.equals("valid")) {

			ALoginPage.loginAs(un, pw);

		}

	}

}