package com.shika.testbase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties properties;

	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;

	public static ExtentReports extent;

	public static  ExtentTest logger;

	@BeforeSuite
	public void beforeSuite() throws Exception {
				
		htmlReporter = new ExtentHtmlReporter("AutomationReport.html");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		properties = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/shika/config/properties.properties");

		properties.load(fis);

		WebDriverManager.chromedriver().setup();

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * 
		 * System.setProperty("webdriver.chrome.args", "--disable-logging");
		 * 
		 * System.setProperty("webdriver.chrome.silentOutput", "true");
		 * 
		 * options.addArguments("--headless", "--log-level=3", "--no-sandbox",
		 * "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
		 * 
		 * driver = new ChromeDriver(options);
		 */

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));

	}

	@BeforeClass
	public void beforeClass() {

	}
	

	@AfterMethod
	public void afterMethod() {

	}

	@AfterClass
	public void afterClass() {

	}

	@AfterSuite
	public void afterSuite() {

		driver.close();

		extent.flush();

	}
}
