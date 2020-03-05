package com.shika.or.admin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.shika.testbase.TestBase;

public class ACourseModulesPage extends TestBase {

	private WebDriver driver;

	public ACourseModulesPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[normalize-space()=\"Back to courses\"]")
	public WebElement btnBackToCourses;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Add Module\"]")
	public WebElement btnAddModule;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Create Lesson\"]")
	public WebElement btnCreateLesson;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Add existing quiz\"]")
	public WebElement btnAddExistingQuiz;

	public ACourseModulesPage createModule() {

		btnAddModule.click();

		return this;
	}

	public ACourseModulesPage createLesson(String lessonFormat, String name, String filePath) {

		ADashboardPage dashboardPage = new ADashboardPage(driver);

		ACoursePage coursePage = new ACoursePage(driver);

		dashboardPage.menuCourses.click();

		logger.info("Clicking on Courses Menu");

		coursePage.buttonManageTrainingMaterial.click();

		logger.info("Clicking on Manage Training Material button");

		try {

			btnCreateLesson.click();

			logger.info("Clicking on Create Lesson button");

		} catch (Exception e) {

			logger.info("Create Lesson Button not visible on window, now Scrolling down..");

			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			logger.info("Create Lesson button is now visible");

			btnCreateLesson.click();

			logger.info("Clicking on Create Lesson button");

			driver.navigate().forward();
		}

		PickLessonTypePage lesson = new PickLessonTypePage(driver);

		lesson.chooseFormat(lessonFormat, name, filePath);

		logger.info("Creating a " + lessonFormat + " lesson " + "with name " + name);

		return this;
	}

	public AddQuizPage addExistingQuiz() {

		btnCreateLesson.click();

		return new AddQuizPage(driver);
	}

}
