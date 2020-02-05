package com.shika.OR.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ACreateCourseCategoryPage {

	private static WebDriver driver;

	public ACreateCourseCategoryPage(WebDriver driver) {
		
		ACreateCourseCategoryPage.driver = driver;
		
		/*
		 * if(!"New Category".contains(driver.getTitle())) {
		 * 
		 * throw new IllegalStateException("This is not Create Category Page");
		 * 
		 * }
		 */
	}
	
	@FindBy(how = How.NAME, using = "jform[title]")

	private static WebElement textbox_Title;

	@FindBy(how = How.XPATH, using = "iframe[id=\"jform_description_ifr\"]")

	private static WebElement textbox_Description;

	@FindBy(how = How.XPATH, using = "div[id=\"jform_parent_id_chzn\"]")

	private static WebElement textbox_Parent;

	@FindBy(how = How.XPATH, using = "div[id=\"jform_access_chzn\"]")

	private static WebElement textbox_Access;

	@FindBy(how = How.XPATH, using = "div[id=\"jform_tags_chzn\"]")

	private static WebElement textbox_Tags;

	@FindBy(how = How.CSS, using = "button[onclick=\"Joomla.submitbutton('category.save');\"]")

	private static WebElement button_saveAndClose;

	@FindBy(how = How.CSS, using = "div[class*=\"alert-error\"]")

	private static WebElement alertError;

	@FindBy(how = How.CSS, using = "button[onclick=\"Joomla.submitbutton('category.cancel');\"]")
	
	private static WebElement button_cancel;
	
	@FindBy (how = How.CSS, using = "div[class=alert-message]")
	
	private static WebElement errorMessage;


	public static ACourseCategoryPage createCategoryAs(String name) {
		
		System.out.println("createCategoryAs");
		
		ACourseCategoryPage.createCategory(driver);
		
		textbox_Title.sendKeys(name);
		
		return saveCategory();
		
	}
		
	public static ACourseCategoryPage saveCategory() {
		
		
		button_saveAndClose.click();
		
		return new ACourseCategoryPage(driver);
		
	}
	
	public static ACourseCategoryPage createCategoryExpectingFailure(String name) {
		
		textbox_Title.sendKeys(name);
		
		return cancelCategoryCreation();
		
	}

	public static ACourseCategoryPage cancelCategoryCreation() {
		
		button_cancel.click();
		
		return new ACourseCategoryPage(driver);
	}
	
	public static String invalidTitle() {
		
		String error = errorMessage.getText();
		
		return error;
		
	}
	
}