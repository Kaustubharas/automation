package com.shika.OR.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ACourseCategoryPage {

	private static WebDriver driver;

	public ACourseCategoryPage(WebDriver driver) {

		ACourseCategoryPage.driver = driver;
		
		/*
		 * if(!"Course Categories".contains(driver.getTitle())) {
		 * 
		 * throw new IllegalStateException("This is not Course Category Page");
		 * 
		 * }
		 */
		
	}

	@FindBy(how = How.CSS, using = "button[onclick*='category.add']")

	private static WebElement create;

	@FindBy(how = How.ID, using = "toolbar-edit")

	private static WebElement edit;

	@FindBy(how = How.ID, using = "toolbar-publish")

	private static WebElement publish;

	@FindBy(how = How.ID, using = "toolbar-unpublish")

	private static WebElement unpublish;

	@FindBy(how = How.ID, using = "toolbar-archive")

	private static WebElement archive;

	@FindBy(how = How.ID, using = "toolbar-checkin")

	private static WebElement checkIn;

	@FindBy(how = How.ID, using = "toolbar-trash")

	private static WebElement trash;

	@FindBy(how = How.ID, using = "filter_search")

	private static WebElement textbox_search;

	@FindBy(how = How.CSS, using = "button[data-original-title=\"Search\"]")

	public static WebElement button_search;

	@FindBy(how = How.CSS, using = "button[data-original-title=\"Clear\"]")

	public static WebElement button_clear;

	@FindBy(how = How.XPATH, using = "//tbody[@class=\"ui-sortable\"]/tr/td/a[contains(text(),\"Soft Skills\")]")

	private static WebElement searchRes;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()=\"Search Tools\"]")

	public static WebElement searchTools;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"- Select Status -\"]")

	public static WebElement selectStatus;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"- Select Access -\"]")

	public static WebElement selectAccess;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"- Select Tag -\"]")

	public static WebElement selectTag;
	
	@FindBy (how = How.XPATH, using ="//span[normalize-space()=\"Ordering ascending\"]")
	
	public static WebElement selectOrdering;
	
	@FindBy (how = How.XPATH, using = "//span[@class=\"icon-menu-2\"]")
	
	public static WebElement enableSorting;
	

	public static ACreateCourseCategoryPage createCategory(WebDriver driver) {

		System.out.println("createCategory");
		
		create.click();

		return new ACreateCourseCategoryPage(driver);

	}

	public static ACourseCategoryPage searchCategory(String text) {
		

		textbox_search.sendKeys(text);

		button_search.click();

		return new ACourseCategoryPage(driver);

	}

	public static ACourseCategoryPage clearSearch() {

		button_clear.click();

		return new ACourseCategoryPage(driver);

	}

}
