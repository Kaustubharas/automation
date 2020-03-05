package com.shika.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shika.dataproviders.DataProviderClass;
import com.shika.pages.ULoginPage;
import com.shika.testbase.TestBase;

public class ULoginTest extends TestBase {

	@Test(dataProvider = "userlogin", dataProviderClass = DataProviderClass.class)

	public void userLogin(String testDesc, String un, String pw, String expMessage, Method method) {
		
		logger = extent.createTest(method.getName());

		// log.info("User Login Test case started...");

		ULoginPage login = new ULoginPage(driver);

		driver.get(properties.getProperty("url"));

		if (!testDesc.equals("valid")) {

			login.submitLoginExpectingFailure(un, pw);

			AssertJUnit.assertEquals(login.invalidUsername(), expMessage);

		} else if (testDesc.equals("valid")) {

			login.loginAs(un, pw);

		}
	}

}