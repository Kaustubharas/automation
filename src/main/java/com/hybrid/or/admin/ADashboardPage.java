package com.hybrid.or.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ADashboardPage {

	private WebDriver driver;

	public ADashboardPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Dashboard')]")

	public WebElement menuDashboard;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'TjDashboard')]")

	public WebElement menuTjdashboard;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Course Categories')]")

	public WebElement menuCourseCategories;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Courses')]")

	public WebElement menuCourses;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Field Groups')]")

	public WebElement menuCourseGroupFields;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Fields')]")

	public WebElement menuCourseFields;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Categories')]")

	public WebElement menuLessonCategories;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Manage Lessons (Alpha)')]")

	public WebElement menuManageLessons;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Question Categories')]")

	public WebElement menuQuestionCategories;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),' Question Bank')]")

	public WebElement menuQuestionBank;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Manage Enrollments')]")

	public WebElement menuManageEnrollments;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Certificate Templates')]")

	public WebElement menuCertificateTemplates;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Coupons')]")

	public WebElement menuCoupons;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Reminders')]")

	public WebElement menuReminders;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Orders')]")

	public WebElement menuOrders;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Attempts')]")

	public WebElement menuAttempts;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Notification Templates')]")

	public WebElement menuNotifications;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Reports')]")

	public WebElement menuReports;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Tools')]")

	public WebElement menuTools;

	public ACoursePage courseMenu() {

		menuCourses.click();

		return new ACoursePage(driver);
	}
}
