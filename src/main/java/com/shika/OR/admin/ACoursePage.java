package com.shika.OR.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ACoursePage {
	
	private static WebDriver driver;
	
	@FindBy (how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.add');\"]")
	
	private static WebElement create;
	
	@FindBy (how = How.CSS, using ="button[onclick*=\"Joomla.submitbutton('courses.publish');\"]")
	
	public static WebElement button_course_publish;
	
	@FindBy (how = How.CSS, using ="button[onclick*=\"Joomla.submitbutton('courses.unpublish');\"]")
	
	public static WebElement button_course_unpublish;
	
	@FindBy (how = How.CSS, using ="button[onclick*=\"Joomla.submitbutton('courses.trash');\"]")
	
	public static WebElement button_course_trash;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"btn-group\"]//a[@title=\"Manage Training Material\"][1]")
	
	public static WebElement button_manage_training_material;
	
	@FindBy(how = How.XPATH, using = "//div[@class=\"btn-group\"]//a[@title=\"Enroll/Assign Users \"][1]")
	
	public static WebElement button_enroll_assign_users;

	@FindBy(how = How.XPATH, using = "//div[@class=\"btn-group\"]//a[@title=\"View Report\"][1]")
	
	public static WebElement button_reports;
	
	@FindBy (how = How.NAME, using = "filter[search]")
	
	public static WebElement txtbox_search;
	
	@FindBy (how = How.XPATH, using= "//button[@data-original-title=\"Search\"]")
	
	public static WebElement btn_search;
	
	@FindBy(how = How.ID, using ="list_limit_chzn")
	
	public static WebElement limit;
	
	public ACoursePage(WebDriver driver) {
				
		ACoursePage.driver = driver;
		
		PageFactory.initElements(driver, ACoursePage.class);

	}

	public static ACreateCoursePage createCourse(WebDriver driver) {

		ADashboardPage.menuCourses();
		
		create.click();

		return new ACreateCoursePage(driver);

	}

	public static ACoursePage searchCategory(String text) {

		txtbox_search.sendKeys(text);

		btn_search.click();

		return new ACoursePage(driver);

	}

	public static ACoursePage clearSearch() {

		ACourseCategoryPage.button_clear.click();

		return new ACoursePage(driver);

	}

	public static ACourseModulesPage addTrainingMaterial() {

		button_manage_training_material.click();

		return new ACourseModulesPage(driver);

	}
}
