package com.hybrid.or.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hybrid.testbase.TestBase;

public class PickLessonTypePage extends TestBase{

	private WebDriver driver;

	LessonDetailsPage lesson;

	public PickLessonTypePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		lesson = new LessonDetailsPage(driver);

	}

	@FindBy(how = How.CSS, using = "a[data-type=\"Scorm\"]")
	public WebElement lessonTypeScorm;

	@FindBy(how = How.CSS, using = "a[data-type=\"Htmlzips\"]")
	public WebElement lessonTypeHtml;

	@FindBy(how = How.CSS, using = "a[data-type=\"Video / Audio\"]")
	public WebElement lessonTypeVideo;

	@FindBy(how = How.CSS, using = "a[data-type=\"Document\"]")
	public WebElement lessonTypeDocument;

	@FindBy(how = How.CSS, using = "a[data-type=\"Text & Media\"]")
	public WebElement lessonTypeTextNMedia;

	@FindBy(how = How.CSS, using = "a[data-type=\"Event\"]")
	public WebElement lessonTypeEvent;

	@FindBy(how = How.CSS, using = "a[data-type=\"Quiz\"]")
	public WebElement lessonTypeQuiz;

	@FindBy(how = How.CSS, using = "a[data-type=\"Exercise\"]")
	public WebElement lessonTypeExercise;

	@FindBy(how = How.CSS, using = "a[data-type=\"Feedback\"]")
	public WebElement lessonTypeFeedback;

	public void createScormTypeLesson(String name, String filePath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(lessonTypeScorm));
		
		lessonTypeScorm.click();

		lesson.lessonBasicDetails(name);

		lesson.uploadScorm(filePath);

	}

	public ACourseModulesPage createHtmlTypeLesson(String name, String filePath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(lessonTypeHtml));

		lessonTypeHtml.click();

		lesson.lessonBasicDetails(name);

		lesson.uploadHtml(filePath);

		return new ACourseModulesPage(driver);

	}

	public LessonDetailsPage createVideoTypeLesson() {

		lessonTypeVideo.click();

		return new LessonDetailsPage(driver);

	}

	public ACourseModulesPage createDocumentTypeLesson(String name, String filePath) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(lessonTypeDocument));

		lessonTypeDocument.click();

		lesson.lessonBasicDetails(name);

		lesson.uploadDocument(filePath);

		return new ACourseModulesPage(driver);

	}

	public LessonDetailsPage createTextnMediaTypeLesson() {

		lessonTypeTextNMedia.click();

		return new LessonDetailsPage(driver);

	}

	public LessonDetailsPage createEventTypeLesson() {

		lessonTypeEvent.click();

		return new LessonDetailsPage(driver);

	}

	public LessonDetailsPage createQuizTypeLesson() {

		lessonTypeQuiz.click();

		return new LessonDetailsPage(driver);

	}

	public LessonDetailsPage createExerciseTypeLesson() {

		lessonTypeExercise.click();

		return new LessonDetailsPage(driver);

	}

	public LessonDetailsPage createFeedbackTypeLesson() {

		lessonTypeFeedback.click();

		return new LessonDetailsPage(driver);

	}

	public void chooseFormat(String type, String name, String filePath) {

		if (type.equalsIgnoreCase("scorm")) {
			
			logger.info("Lesson type selected as SCORM");

			createScormTypeLesson(name, filePath);

		} else if (type.equalsIgnoreCase("html")) {

			logger.info("Lesson type selected as HTML5");
			
			createHtmlTypeLesson(name, filePath);

		} else if (type.equalsIgnoreCase("Video")) {

			logger.info("Lesson type selected as Video");
			
			createVideoTypeLesson();

		} else if (type.equalsIgnoreCase("document")) {
			
			logger.info("Lesson type selected as Document");
			
			createDocumentTypeLesson(name, filePath);

		} else if (type.equalsIgnoreCase("text and media")) {

			logger.info("Lesson type selected as Text and Media");
			
			createTextnMediaTypeLesson();

		} else if (type.equalsIgnoreCase("event")) {

			logger.info("Lesson type selected as Event as a lesson");
			
			createEventTypeLesson();

		} else if (type.equalsIgnoreCase("quiz")) {

			logger.info("Lesson type selected as Quiz");
				
			createQuizTypeLesson();

		} else if (type.equalsIgnoreCase("exercise")) {

			logger.info("Lesson type selected as Excercise");
			
			createExerciseTypeLesson();

		} else if (type.equalsIgnoreCase("feedback")) {

			logger.info("Lesson type selected as Feedback");
			
			createFeedbackTypeLesson();
		}
	}

}
