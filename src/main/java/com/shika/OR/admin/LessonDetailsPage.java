package com.shika.OR.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LessonDetailsPage {

	private static WebDriver driver;

	static Select sc;

	public LessonDetailsPage(WebDriver driver) {

		LessonDetailsPage.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_title\"]")
	public static WebElement lessonName;

	@FindBy(how = How.XPATH, using = "//fieldset[@id=\"jform_state\"]")
	public static WebElement lessonStatus;

	@FindBy(how = How.XPATH, using = "//select[@id=\"jform_catid\"]")
	public static WebElement lessonCategory;

	@FindBy(how = How.XPATH, using = "//textarea[@id=\"jform_description\"]")
	public static WebElement lessonDesc;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_start_date\"]")
	public static WebElement lessonStartDate;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_end_date\"]")
	public static WebElement lessonEndDate;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_image\"]")
	public static WebElement lessonImage;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_no_of_attempts\"]")
	public static WebElement lessonAttempts;

	@FindBy(how = How.XPATH, using = "jform_attempts_grade")
	public static WebElement lessonAttemptsGrading;

	@FindBy(how = How.XPATH, using = "//input[@value=\"Type or select some options\"]")
	public static WebElement lessonPrerequisites;

	@FindBy(how = How.XPATH, using = "//fieldset[@id=\"jform_consider_marks\"]")
	public static WebElement lessonConsiderForPassing;

	@FindBy(how = How.XPATH, using = "//fieldset[@id=\"jform_in_lib\"]")
	public static WebElement lessonShowInLibrary;

	@FindBy(how = How.XPATH, using = "//input[@id=\"jform_ideal_time\"]")
	public static WebElement lessonIdealTime;

	@FindBy(how = How.XPATH, using = "//select[@id=\"jform_params_lesson_layout\"]")
	public static WebElement lessonLayout;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()=\"Save & Next\"]")
	public static WebElement lessonNext;

	@FindBy(how = How.CSS, using = "button[onclick=\"Joomla.submitbutton('lesson.save')\"]")
	public static WebElement lessonSave;

	@FindBy(how = How.XPATH, using = "//input[@id=\"scorm_upload\"]")
	public static WebElement uploadScrom;

	@FindBy(how = How.XPATH, using = "//input[@id=\"tjhtmlzips_upload\"]")
	public static WebElement uploadHtml;

	@FindBy(how = How.XPATH, using = "//input[@id=\"document_upload\"]")
	public static WebElement uploadDocument;

	@FindBy(how = How.XPATH, using = "//div[contains(text(), \"Successfully uploaded the\")]")

	public static WebElement msgSuccess;

	@FindBy(how = How.CSS, using = "select[id=\"lesson_formatsubformat\"]")

	public static WebElement lessonSubFormat;

	public static LessonDetailsPage lessonBasicDetails(String name) {

		lessonName.sendKeys(name);

		return lessonNext();
	}

	public static LessonDetailsPage lessonNext() {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		lessonNext.click();

		return new LessonDetailsPage(driver);
	}

	public static ACourseModulesPage uploadScrom(String filePath) {

		uploadScrom.sendKeys(filePath);

		if (msgSuccess.isDisplayed()) {

			lessonNext.click();
		}

		return lessonSave();

	}

	private static ACourseModulesPage lessonSave() {

		lessonSave.click();

		return new ACourseModulesPage(driver);

	}

	public static ACourseModulesPage uploadHtml(String filePath) {

		uploadHtml.sendKeys(filePath);

		if (msgSuccess.isDisplayed()) {

			lessonNext.click();
		}

		return lessonSave();

	}

	public static ACourseModulesPage uploadDocument(String filePath) {

		sc = new Select(lessonSubFormat);

		sc.selectByValue("boxapi2");

		uploadDocument.sendKeys(filePath);

		if (msgSuccess.isDisplayed()) {

			lessonNext.click();
		}

		return lessonSave();

	}

}
