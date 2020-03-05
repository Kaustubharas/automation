package com.hybrid.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.testbase.TestBase;

public class ACreateCoursePage extends TestBase {

	private WebDriver driver;

	public ACreateCoursePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.save');\"]")

	public WebElement btnCourseSaveAndClose;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.save2new');\"]")

	public WebElement btnCourseSaveAndNew;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.cancel');\"]")

	public WebElement btnCourseCancel;

	@FindBy(how = How.ID, using = "jform_title")

	public WebElement txtbxCourseTitle;

	@FindBy(how = How.CSS, using = "div[id=\"jform_catid_chzn\"]")

	public WebElement selectCourseCategory;

	@FindBy(how = How.ID, using = "jform_short_desc")

	public WebElement txtbxCourseShrtDesc;

	@FindBy(how = How.ID, using = "jform_image")

	public WebElement btnCourseSelectImage;

	@FindBy(how = How.CSS, using = "label[for=\"jform_state0\"]")

	public WebElement btnCoursePublished;

	@FindBy(how = How.CSS, using = "label[for=\"jform_state1\"]")

	public WebElement btnCourseUnpublished;

	@FindBy(how = How.ID, using = "jform_start_date_btn")

	public WebElement selectCourseStartDate;

	@FindBy(how = How.ID, using = "jform_access")

	public WebElement selectCourseAccess;

	@FindBy(how = How.ID, using = "jform_certificate_term")

	public WebElement selectCourseCertificateTerm;

	public ACreateCoursePage courseTitle(String name) {
		
		logger.info("Creating a course with name >>" + name);

		txtbxCourseTitle.sendKeys(name);

		return this;

	}

	public ACoursePage courseShortDesc(String desc) {

		logger.info("Entering Short Description for course as >> " + desc);

		txtbxCourseShrtDesc.sendKeys(desc);

		return new ACoursePage(driver);

	}

	public ACoursePage courseSave() {

		btnCourseSaveAndClose.click();
		
		logger.info("Saving the course");
		
		return new ACoursePage(driver);

	}

	public ACoursePage createCourse(String name, String desc) {

		ADashboardPage dashboardPage = new ADashboardPage(driver);

		ACoursePage coursePage = new ACoursePage(driver);

		dashboardPage.courseMenu();

		coursePage.createCourse();

		courseTitle(name);

		courseShortDesc(desc);

		return courseSave();

	}
}
