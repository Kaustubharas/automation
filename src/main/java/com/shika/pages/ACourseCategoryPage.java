package com.shika.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.shika.testbase.TestBase;

public class ACourseCategoryPage extends TestBase {

	private WebDriver driver;

	public ACourseCategoryPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "button[onclick*='category.add']")

	private WebElement create;

	@FindBy(how = How.ID, using = "toolbar-edit")

	private WebElement edit;

	@FindBy(how = How.ID, using = "toolbar-publish")

	private WebElement publish;

	@FindBy(how = How.ID, using = "toolbar-unpublish")

	private WebElement unpublish;

	@FindBy(how = How.ID, using = "toolbar-archive")

	private WebElement archive;

	@FindBy(how = How.ID, using = "toolbar-checkin")

	private WebElement checkIn;

	@FindBy(how = How.ID, using = "toolbar-trash")

	private WebElement trash;

	@FindBy(how = How.ID, using = "filter_search")

	private WebElement textboxSearch;

	@FindBy(how = How.CSS, using = "button[data-original-title=\"Search\"]")

	public WebElement buttonSearch;

	@FindBy(how = How.CSS, using = "button[data-original-title=\"Clear\"]")

	public WebElement buttonClear;

	@FindBy(how = How.XPATH, using = "//tbody[@class=\"ui-sortable\"]/tr/td/a[contains(text(),\"Soft Skills\")]")

	private WebElement searchRes;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()=\"Search Tools\"]")

	public WebElement searchTools;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"- Select Status -\"]")

	public WebElement selectStatus;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"- Select Access -\"]")

	public WebElement selectAccess;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"- Select Tag -\"]")

	public WebElement selectTag;

	@FindBy(how = How.XPATH, using = "//span[normalize-space()=\"Ordering ascending\"]")

	public WebElement selectOrdering;

	@FindBy(how = How.XPATH, using = "//span[@class=\"icon-menu-2\"]")

	public WebElement enableSorting;

	public ACreateCourseCategoryPage createCategory() {

		logger.info("Creating course category");

		create.click();

		logger.info("Clicked on Create button to create new category");

		return new ACreateCourseCategoryPage(driver);

	}

	public ACourseCategoryPage searchCategory(String catName) {

		logger.info("Searching for a category with name >> " + catName);

		textboxSearch.sendKeys(catName);

		buttonSearch.click();
		
		logger.info("Clicked on Search button");

		return this;

	}

	public ACourseCategoryPage clearSearch() {

		buttonClear.click();

		logger.info("Clicked on Clear button");
		
		return this;

	}

}
