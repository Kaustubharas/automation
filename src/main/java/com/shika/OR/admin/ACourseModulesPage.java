package com.shika.OR.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ACourseModulesPage {

	private static WebDriver driver;

	public ACourseModulesPage(WebDriver driver) {

		ACourseModulesPage.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()=\"Back to courses\"]")
	public static WebElement btn_backToCourses;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Add Module\"]")
	public static WebElement btn_addModule;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Create Lesson\"]")
	public static WebElement btn_createLesson;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Add existing quiz\"]")
	public static WebElement btn_addExistingQuiz;

	public static ACourseModulesPage createModule() {

		btn_addModule.click();

		return new ACourseModulesPage(driver);
	}

	public static ACourseModulesPage createLesson(String lessonFormat, String name, String filePath) {
		
		ADashboardPage.menu_courses.click();
		
		ACoursePage.button_manage_training_material.click();
		
		try {
			
			btn_createLesson.click();
			
		}catch (Exception e) {
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			btn_createLesson.click();
			
			driver.navigate().forward();
		}
		
		PickLessonTypePage.chooseFormat(lessonFormat, name, filePath);

		return new ACourseModulesPage(driver);
	}

	public static AddQuizPage addExistingQuiz() {

		btn_createLesson.click();

		return new AddQuizPage(driver);
	}

}
