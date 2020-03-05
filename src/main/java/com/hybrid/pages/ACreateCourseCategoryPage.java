package com.hybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.hybrid.testbase.TestBase;

public class ACreateCourseCategoryPage extends TestBase {

	private WebDriver driver;

	public ACreateCourseCategoryPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.NAME, using = "jform[title]")

	private WebElement txtbxTitle;

	@FindBy(how = How.XPATH, using = "iframe[id=\"jform_description_ifr\"]")

	private WebElement txtbxDescription;

	@FindBy(how = How.XPATH, using = "div[id=\"jform_parent_id_chzn\"]")

	private WebElement selectParent;

	@FindBy(how = How.XPATH, using = "div[id=\"jform_access_chzn\"]")

	private WebElement selectAccess;

	@FindBy(how = How.XPATH, using = "div[id=\"jform_tags_chzn\"]")

	private WebElement selectTags;

	@FindBy(how = How.CSS, using = "button[onclick=\"Joomla.submitbutton('category.save');\"]")

	private WebElement btnSaveAndClose;

	@FindBy(how = How.CSS, using = "div[class*=\"alert-error\"]")

	private WebElement alertError;

	@FindBy(how = How.CSS, using = "button[onclick=\"Joomla.submitbutton('category.cancel');\"]")

	private WebElement btnCancel;

	@FindBy(how = How.CSS, using = "div[class=alert-message]")

	private WebElement errorMessage;

	public ACourseCategoryPage createCategoryAs(String name) {

		ACourseCategoryPage categoryPage = new ACourseCategoryPage(driver);

		categoryPage.createCategory();

		txtbxTitle.sendKeys(name);

		logger.info("Creating a category with name " + name);

		return saveCategory();

	}

	public ACourseCategoryPage saveCategory() {

		btnSaveAndClose.click();
		if (invalidTitle().startsWith("Save failed")) {
			logger.log(Status.DEBUG, invalidTitle());
		} else {
			logger.log(Status.PASS, "Category saved successfully");

		}

		return new ACourseCategoryPage(driver);

	}

	public ACourseCategoryPage createCategoryExpectingFailure(String name) {

		txtbxTitle.sendKeys(name);

		logger.info("Entering Category name " + name);

		return cancelCategoryCreation();

	}

	public ACourseCategoryPage cancelCategoryCreation() {

		btnCancel.click();

		logger.log(Status.FAIL, "Something went wrong while ssaving the category");

		return new ACourseCategoryPage(driver);
	}

	public String invalidTitle() {

		return errorMessage.getText();

	}

}