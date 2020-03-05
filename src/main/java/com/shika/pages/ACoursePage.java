package com.shika.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.shika.testbase.TestBase;

public class ACoursePage extends TestBase{

	private WebDriver driver;

	public ACoursePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('course.add');\"]")

	private WebElement create;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('courses.publish');\"]")

	public WebElement buttonCoursePpublish;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('courses.unpublish');\"]")

	public WebElement buttonCourseUnpublish;

	@FindBy(how = How.CSS, using = "button[onclick*=\"Joomla.submitbutton('courses.trash');\"]")

	public WebElement buttonCourseTrash;

	@FindBy(how = How.XPATH, using = "//div[@class=\"btn-group\"]//a[@title=\"Manage Training Material\"][1]")

	public WebElement buttonManageTrainingMaterial;

	@FindBy(how = How.XPATH, using = "//div[@class=\"btn-group\"]//a[@title=\"Enroll/Assign Users \"][1]")

	public WebElement buttonEnrollAssignUsers;

	@FindBy(how = How.XPATH, using = "//div[@class=\"btn-group\"]//a[@title=\"View Report\"][1]")

	public WebElement buttonReports;

	@FindBy(how = How.NAME, using = "filter[search]")

	public WebElement txtboxSearch;

	@FindBy(how = How.XPATH, using = "//button[@data-original-title=\"Search\"]")

	public WebElement btnSearch;

	@FindBy(how = How.ID, using = "list_limit_chzn")

	public WebElement limit;

	public ACreateCoursePage createCourse() {

		ADashboardPage dashboardPage = new ADashboardPage(driver);

		dashboardPage.courseMenu();
		
		logger.info("Clicking on Courses Menu");
		
		create.click();
		
		logger.info("Cliking on Create button to create a new course");

		return new ACreateCoursePage(driver);

	}

	public ACoursePage searchCategory(String text) {

		txtboxSearch.sendKeys(text);

		btnSearch.click();

		return new ACoursePage(driver);

	}

	public ACoursePage clearSearch() {

		ACourseCategoryPage categoryPage = new ACourseCategoryPage(driver);

		categoryPage.buttonClear.click();

		return this;

	}

	public ACourseModulesPage addTrainingMaterial() {

		buttonManageTrainingMaterial.click();

		return new ACourseModulesPage(driver);

	}
}
