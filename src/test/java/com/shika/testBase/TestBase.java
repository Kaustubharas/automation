package com.shika.testBase;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {

	public static Properties properties;

	protected static WebDriver driver;

	// final Logger log = LogManager.getLogger(this.getClass());

	protected static ExtentHtmlReporter htmlReporter;

	protected static ExtentReports extent;

	protected static ExtentTest test;

	@BeforeSuite
	public void beforeSuite() throws Exception {

		htmlReporter = new ExtentHtmlReporter("extent.html");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		properties = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/com/shika/config/properties.properties");

		properties.load(fis);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		WebDriver driver = new ChromeDriver(options);

		// log.info("Chrome Browser is running...");

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

//		log.info("Closing Chrome Browser...");

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
