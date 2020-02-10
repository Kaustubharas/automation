package com.shika.OR.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ADashboardPage {

	private static WebDriver driver;

	public ADashboardPage(WebDriver driver) {

		ADashboardPage.driver = driver;

	}

	public static ACoursePage menuCourses() {
		
		System.out.println("ADashboardPage.. menuCourses");
		
		menu_courses.click();
		
		return new ACoursePage(driver);
	}

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Dashboard')]")

	public static WebElement menu_dashboard;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'TjDashboard')]")

	public static WebElement menu_tjdashboard;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Course Categories')]")

	public static WebElement menu_courseCategories;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Courses')]")

	public static WebElement menu_courses;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Field Groups')]")

	public static WebElement menu_courseGroupFields;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Fields')]")

	public static WebElement menu_courseFields;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Categories')]")

	public static WebElement menu_lessonCategories;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Manage Lessons (Alpha)')]")

	public static WebElement menu_manageLessons;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Question Categories')]")

	public static WebElement menu_questionCategories;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),' Question Bank')]")

	public static WebElement menu_questionBank;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Manage Enrollments')]")

	public static WebElement menu_manageEnrollments;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Certificate Templates')]")

	public static WebElement menu_certificateTemplates;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Coupons')]")

	public static WebElement menu_coupons;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Reminders')]")

	public static WebElement menu_reminders;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Orders')]")

	public static WebElement menu_orders;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Attempts')]")

	public static WebElement menu_attempts;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Notification Templates')]")

	public static WebElement menu_notifications;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Reports')]")

	public static WebElement menu_reports;

	@FindBy(how = How.XPATH, using = "//ul[@id=\"submenu\"]//a[contains(text(),'Tools')]")

	public static WebElement menu_tools;

}
