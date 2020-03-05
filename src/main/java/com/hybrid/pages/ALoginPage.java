package com.hybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.hybrid.testbase.TestBase;

public class ALoginPage extends TestBase{

	private WebDriver driver;

	public ALoginPage(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "mod-login-username")
	public WebElement uEmail;

	@FindBy(how = How.CSS, using = "div[class=\"alert-message\"]")
	public WebElement alertMessage;

	@FindBy(how = How.ID, using = "mod-login-password")
	public WebElement uPassword;

	@FindBy(how = How.CSS, using = "button[class*=\"login\"]")
	public WebElement btnLogin;

	public ALoginPage username(String username) {
		
		logger.info("Entering username as >> "+ username);

		uEmail.sendKeys(username);

		return this;

	}

	public String invalidUsername() {

		return alertMessage.getText();

	}

	public ALoginPage password(String password) {
		
		logger.info("Entering password as >> "+ password);


		uPassword.sendKeys(password);

		return this;

	}

	public String invalidPassword() {

		return alertMessage.getText();

	}

	public ADashboardPage submitLogin() {

		logger.info("Clicking on Login button");
		
		btnLogin.click();
		
		logger.log(Status.PASS, "Login Successful");

		return new ADashboardPage(driver);
	}

	public ALoginPage submitLoginExpectingFailure(String username, String password) {

		username(username);

		password(password);

		btnLogin.submit();

		logger.log(Status.FAIL, "Login Failed! Bad Credentials");
		
		return this;
	}

	public ADashboardPage loginAs(String username, String password) {

		username(username);

		password(password);

		return submitLogin();
	}

}
