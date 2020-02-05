package com.shika.OR.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ALoginPage {

	private static WebDriver driver;

	public ALoginPage(WebDriver driver) {

		ALoginPage.driver = driver;
	}

	@FindBy(how = How.ID, using = "mod-login-username")
	public static WebElement email;
	
	@FindBy(how = How.CSS, using = "div[class=\"alert-message\"]")
	public static WebElement alertMessage;

	@FindBy(how = How.ID, using = "mod-login-password")
	public static WebElement password;

	@FindBy(how = How.CSS, using = "button[class*=\"login\"]")
	public static WebElement loginBtn;

	public static ALoginPage username(String username) {

		email.sendKeys(username);

		return new ALoginPage(driver);

	}
	
	public static String InvalidUsername() {

		return alertMessage.getText();

	}

	public static ALoginPage password(String passsword) {

		password.sendKeys(passsword);

		return new ALoginPage(driver);

	}
	
	public static String invalidPassword() {

		return alertMessage.getText();

	}

	public static ADashboardPage submitLogin() {

		loginBtn.click();
		
		return new ADashboardPage(driver);
	}
	
	public static ALoginPage submitLoginExpectingFailure(String username, String password) {
		
		username(username);

		password(password);
		
		loginBtn.submit();

        return new ALoginPage(driver);	
    }

	public static ADashboardPage loginAs(String username, String password) {
		
		username(username);

		password(password);

		return submitLogin();
	}

}
