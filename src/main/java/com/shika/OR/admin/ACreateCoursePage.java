package com.shika.OR.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ACreateCoursePage {

	private static WebDriver driver;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.save');\"]")

	public static WebElement button_course_saveAndClose;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.save2new');\"]")

	public static WebElement button_course_saveAndNew;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.cancel');\"]")

	public static WebElement button_course_cancel;

	@FindBy(how = How.ID, using = "jform_title")

	public static WebElement textbox_course_title;

	@FindBy(how = How.CSS, using = "div[id=\"jform_catid_chzn\"]")

	public static WebElement chzn_course_category;

	@FindBy(how = How.ID, using = "jform_short_desc")

	public static WebElement textarea_course_shrt_desc;

	@FindBy(how = How.ID, using = "jform_image")

	public static WebElement button_course_selectImage;

	@FindBy(how = How.CSS, using = "label[for=\"jform_state0\"]")

	public static WebElement button_course_published;

	@FindBy(how = How.CSS, using = "label[for=\"jform_state1\"]")

	public static WebElement button_course_unpublished;

	@FindBy(how = How.ID, using = "jform_start_date_btn")

	public static WebElement calendar_course_startDate;

	@FindBy(how = How.ID, using = "jform_access")

	public static WebElement select_course_access;

	@FindBy(how = How.ID, using = "jform_certificate_term")

	public static WebElement select_course_certificateTerm;

	public ACreateCoursePage(WebDriver driver) {

		ACreateCoursePage.driver = driver;
		
	}

	public static ACreateCoursePage courseTitle(String name) {

		textbox_course_title.sendKeys(name);

		return new ACreateCoursePage(driver);

	}

	public static ACoursePage courseShortDesc(String desc) {

		textarea_course_shrt_desc.sendKeys(desc);

		return new ACoursePage(driver);

	}

	public static ACoursePage courseSave() {

		button_course_saveAndClose.click();

		return new ACoursePage(driver);

	}

	public static ACoursePage createCourse(String name, String desc) {
		
		System.out.println("ACoursePage");
		
		ADashboardPage.menuCourses();
		
		ACoursePage.createCourse(driver);
		
		courseTitle(name);
		
		courseShortDesc(desc);
		
		return courseSave();

	}
}
