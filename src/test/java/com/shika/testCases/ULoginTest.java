package com.shika.testCases;

import java.lang.reflect.Method;
import java.util.Map;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.shika.dataproviders.DataProviderClass;
import com.shika.pages.ULoginPage;
import com.shika.testbase.TestBase;

public class ULoginTest extends TestBase {

	@Test(dataProvider = "datasupplier", dataProviderClass = DataProviderClass.class)

	public void userLogin(Map<Object, Object> map, Method method) {
		
		logger = extent.createTest(method.getName());

		// log.info("User Login Test case started...");

		ULoginPage login = new ULoginPage(driver);

		driver.get(properties.getProperty("url"));

		if (!map.get("TestDesc").toString().equals("valid")) {

			login.submitLoginExpectingFailure(map.get("UserName").toString(), map.get("Password").toString());

			AssertJUnit.assertEquals(login.invalidUsername(), map.get("Message"));

		} else if (map.get("TestDesc").toString().equals("valid")) {

			login.loginAs(map.get("UserName").toString(), map.get("Password").toString());

		}
	}

}