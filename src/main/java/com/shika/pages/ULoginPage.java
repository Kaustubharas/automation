package com.shika.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.shika.testbase.TestBase;

public class ULoginPage extends TestBase {

	private WebDriver driver;

	public ULoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "username")
	public WebElement uEmail;

	@FindBy(how = How.CSS, using = "div.alert.alert-warning div p")
	public WebElement alertMessage;

	@FindBy(how = How.ID, using = "password")
	public WebElement uPassword;

	@FindBy(how = How.CSS, using = "button[type=\"submit\"]")
	public WebElement btnLogin;

	public ULoginPage username(String username) {

		logger.info("Entering username as >> " + username);

		uEmail.sendKeys(username);

		return this;

	}

	public String invalidUsername() {

		return alertMessage.getText();

	}

	public ULoginPage password(String password) {

		logger.info("Entering password as >> " + password);

		uPassword.sendKeys(password);

		return this;

	}

	public String invalidPassword() {

		return alertMessage.getText();

	}

	public UDashboardPage submitLogin() {
		
		logger.info("Clicking on Login button");
		
		btnLogin.click();
		
		logger.log(Status.PASS, "Login Successful");

		return new UDashboardPage(driver);
	}

	public ULoginPage submitLoginExpectingFailure(String username, String password) {

		username(username);

		password(password);

		btnLogin.submit();
		
		logger.log(Status.FAIL, "Login Failed!!! Bad Credentials");

		return this;
	}

	public UDashboardPage loginAs(String username, String password) {

		username(username);

		password(password);

		return submitLogin();
	}

}
