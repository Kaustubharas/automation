package com.shika.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.shika.dataproviders.DataProviderClass;
import com.shika.or.admin.ALoginPage;
import com.shika.testbase.TestBase;

public class ALoginTest extends TestBase {

	@Test(dataProvider = "adminlogin", dataProviderClass = DataProviderClass.class)

	public void adminLogin(String testDesc, String un, String pw, String expMessage, Method method) {
		
		logger = extent.createTest(method.getName().toString());

		ALoginPage login = new ALoginPage(driver);

		driver.get(properties.getProperty("url") + properties.getProperty("admin"));

		if (!testDesc.equals("valid")) {

			login.submitLoginExpectingFailure(un, pw);

			AssertJUnit.assertEquals(login.invalidUsername(), expMessage);

		} else if (testDesc.equals("valid")) {

			login.loginAs(un, pw);

		}

	}

}