package com.shika.OR.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ULoginPage {

	static WebDriver driver;

	public ULoginPage(WebDriver driver) {

		ULoginPage.driver = driver;

	}

	@FindBy(how = How.ID, using = "username")
	public static WebElement email;

	@FindBy(how = How.CSS, using = "div.alert.alert-warning div p")
	public static WebElement alertMessage;

	@FindBy(how = How.ID, using = "password")
	public static WebElement password;

	@FindBy(how = How.CSS, using = "button[type=\"submit\"]")
	public static WebElement loginBtn;

	public static ULoginPage username(String username) {

		email.sendKeys(username);

		return new ULoginPage(driver);

	}

	public static String InvalidUsername() {

		return alertMessage.getText();

	}

	public static ULoginPage password(String passsword) {

		password.sendKeys(passsword);

		return new ULoginPage(driver);

	}

	public static String invalidPassword() {

		return alertMessage.getText();

	}

	public static UDashboardPage submitLogin() {

		loginBtn.click();

		return new UDashboardPage(driver);
	}

	public static ULoginPage submitLoginExpectingFailure(String username, String password) {
		
		username(username);

		password(password);
		
		loginBtn.submit();

		return new ULoginPage(driver);
	}

	public static UDashboardPage loginAs(String username, String password) {

		username(username);

		password(password);

		return submitLogin();
	}

}
