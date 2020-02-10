package com.shika.OR.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PickLessonTypePage {

	private static WebDriver driver;

	public PickLessonTypePage(WebDriver driver) {

		PickLessonTypePage.driver = driver;

	}

	@FindBy(how = How.CSS, using = "a[data-type=\"Scorm\"]")
	public static WebElement lessontype_scorm;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Htmlzips\"]")
	public static WebElement lessontype_html;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Video / Audio\"]")
	public static WebElement lessontype_video;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Document\"]")
	public static WebElement lessontype_document;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Text & Media\"]")
	public static WebElement lessontype_textNMedia;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Event\"]")
	public static WebElement lessontype_event;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Quiz\"]")
	public static WebElement lessontype_quiz;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Exercise\"]")
	public static WebElement lessontype_exercise;
	
	@FindBy(how = How.CSS, using = "a[data-type=\"Feedback\"]")
	public static WebElement lessontype_feedback;

	public static void createScormTypeLesson(String name, String filePath) {		

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(lessontype_scorm));
		
		lessontype_scorm.click();
			
		LessonDetailsPage.lessonBasicDetails(name);
		
		LessonDetailsPage.uploadScrom(filePath);

	}

	public static ACourseModulesPage createHtmlTypeLesson(String name, String filePath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(lessontype_html));
		
		lessontype_html.click();
		
		LessonDetailsPage.lessonBasicDetails(name);
		
		LessonDetailsPage.uploadHtml(filePath);

		return new ACourseModulesPage(driver);

	}

	public static LessonDetailsPage createVideoTypeLesson() {

		lessontype_video.click();

		return new LessonDetailsPage(driver);

	}

	public static ACourseModulesPage createDocumentTypeLesson(String name, String filePath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		wait.until(ExpectedConditions.elementToBeClickable(lessontype_document));
		
		lessontype_document.click();
		
		LessonDetailsPage.lessonBasicDetails(name);
		
		LessonDetailsPage.uploadDocument(filePath);

		return new ACourseModulesPage(driver);

	}

	public static LessonDetailsPage createTextnMediaTypeLesson() {

		lessontype_textNMedia.click();

		return new LessonDetailsPage(driver);

	}

	public static LessonDetailsPage createEventTypeLesson() {

		lessontype_event.click();

		return new LessonDetailsPage(driver);

	}

	public static LessonDetailsPage createQuizTypeLesson() {

		lessontype_quiz.click();

		return new LessonDetailsPage(driver);

	}

	public static LessonDetailsPage createExerciseTypeLesson() {

		lessontype_exercise.click();

		return new LessonDetailsPage(driver);

	}

	public static LessonDetailsPage createFeedbackTypeLesson() {

		lessontype_feedback.click();

		return new LessonDetailsPage(driver);

	}
	
	public static void chooseFormat(String type, String name, String filePath) {
				
		if(type.equalsIgnoreCase("scorm")) {
						
			createScormTypeLesson(name, filePath);
			
		}else if(type.equalsIgnoreCase("html")) {
			
			createHtmlTypeLesson(name, filePath);
			
		}else if(type.equalsIgnoreCase("Video")) {
			
			createVideoTypeLesson();
			
		}else if(type.equalsIgnoreCase("document")) {
			
			createDocumentTypeLesson(name, filePath);
			
		}else if(type.equalsIgnoreCase("text and media")) {
			
			createTextnMediaTypeLesson();
			
		}else if(type.equalsIgnoreCase("event")) {
			
			createEventTypeLesson();
			
		}else if(type.equalsIgnoreCase("quiz")) {
			
			createQuizTypeLesson();
			
		}else if(type.equalsIgnoreCase("exercise")) {
			
			createExerciseTypeLesson();
			
		}else if(type.equalsIgnoreCase("feedback")) {
			
			createFeedbackTypeLesson();
		}
	}

}
