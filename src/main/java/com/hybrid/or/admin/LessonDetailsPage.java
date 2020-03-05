package com.hybrid.or.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.hybrid.testbase.TestBase;

public class LessonDetailsPage extends TestBase {

	private WebDriver driver;

	Select sc;

	public LessonDetailsPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_title\"]")
	public WebElement lessonName;

	@FindBy(how = How.XPATH, using = "//fieldset[@id=\"jform_state\"]")
	public WebElement lessonStatus;

	@FindBy(how = How.XPATH, using = "//select[@id=\"jform_catid\"]")
	public WebElement lessonCategory;

	@FindBy(how = How.XPATH, using = "//textarea[@id=\"jform_description\"]")
	public WebElement lessonDesc;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_start_date\"]")
	public WebElement lessonStartDate;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_end_date\"]")
	public WebElement lessonEndDate;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_image\"]")
	public WebElement lessonImage;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_no_of_attempts\"]")
	public WebElement lessonAttempts;

	@FindBy(how = How.XPATH, using = "jform_attempts_grade")
	public WebElement lessonAttemptsGrading;

	@FindBy(how = How.XPATH, using = "//input[@value=\"Type or select some options\"]")
	public WebElement lessonPrerequisites;

	@FindBy(how = How.XPATH, using = "//fieldset[@id=\"jform_consider_marks\"]")
	public WebElement lessonConsiderForPassing;

	@FindBy(how = How.XPATH, using = "//fieldset[@id=\"jform_in_lib\"]")
	public WebElement lessonShowInLibrary;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_ideal_time\"]")
	public WebElement lessonIdealTime;

	@FindBy(how = How.XPATH, using = "//select[@id=\"jform_params_lesson_layout\"]")
	public WebElement lessonLayout;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()=\"Save & Next\"]")
	public WebElement btnLessonNext;

	@FindBy(how = How.CSS, using = "button[onclick=\"Joomla.submitbutton('lesson.save')\"]")
	public WebElement lessonSave;

	@FindBy(how = How.XPATH, using = "//input[@id=\"scorm_upload\"]")
	public WebElement uploadScormFile;

	@FindBy(how = How.XPATH, using = "//input[@id=\"tjhtmlzips_upload\"]")
	public WebElement uploadHtmlFile;

	@FindBy(how = How.XPATH, using = "//input[@id=\"document_upload\"]")
	public WebElement uploadDocumentFile;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), \"Successfully uploaded the\")]")

	public WebElement msgSuccess;

	@FindBy(how = How.CSS, using = "select[id=\"lesson_formatsubformat\"]")

	public WebElement lessonSubFormat;

	public LessonDetailsPage lessonBasicDetails(String name) {

		logger.info("Creating a lesson with name >>" + name);

		lessonName.sendKeys(name);

		return lessonNext();
	}

	public LessonDetailsPage lessonNext() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		btnLessonNext.click();

		logger.info("Clicking on Next button");

		return this;
	}

	public ACourseModulesPage uploadScorm(String filePath) {

		logger.info("About to upload the SCORM");

		uploadScormFile.sendKeys(filePath);

		if (msgSuccess.isDisplayed()) {

			logger.log(Status.PASS, "SCORM file uploaded successfully");

			btnLessonNext.click();

			logger.info("Cliking on next button");
		}

		return lessonSave();

	}

	private ACourseModulesPage lessonSave() {

		logger.info("Saving the lesson");

		lessonSave.click();

		logger.info("Lesson Saved Successfully");

		return new ACourseModulesPage(driver);

	}

	public ACourseModulesPage uploadHtml(String filePath) {

		logger.info("About to upload the HTML5 file");

		uploadHtmlFile.sendKeys(filePath);

		if (msgSuccess.isDisplayed()) {

			logger.log(Status.PASS, "HTML5 file uploaded successfully");

			btnLessonNext.click();

			logger.info("Cliking on next button");
		}

		return lessonSave();

	}

	public ACourseModulesPage uploadDocument(String filePath) {

		logger.info("About to upload the Document type file");

		uploadDocumentFile.sendKeys(filePath);

		if (msgSuccess.isDisplayed()) {

			logger.log(Status.PASS, "Document file uploaded successfully");

			btnLessonNext.click();

			logger.info("Cliking on next button");

		}

		return lessonSave();

	}

}
