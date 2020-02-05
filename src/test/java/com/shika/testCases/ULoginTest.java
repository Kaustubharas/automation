package com.shika.testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.shika.DR.DataProviderClass;
import com.shika.OR.user.ULoginPage;
import com.shika.testBase.TestBase;

public class ULoginTest extends TestBase {

	@Test(dataProvider = "userlogin", dataProviderClass = DataProviderClass.class)

	public void userLogin(String testDesc, String un, String pw, String expMessage) {
		
		driver.get(properties.getProperty("url"));
		
		PageFactory.initElements(driver, ULoginPage.class);

		if (!testDesc.equals("valid")) {

			ULoginPage.submitLoginExpectingFailure(un, pw);

			//Assert.assertEquals(ULoginPage.InvalidUsername(), expMessage);

		} else if (testDesc.equals("valid")) {

			ULoginPage.loginAs(un, pw);

		}
	}

}