package tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.PracticePageObjects;
import pages.PropertiesFile;

public class PracticePageTest {

	ExtentHtmlReporter htmlReporter = null;
	ExtentReports extent = null;

	static WebDriver driver = null;
	public static String browserName = null;

	@BeforeSuite
	public void setUpExtentReports() {
		
		htmlReporter = new ExtentHtmlReporter("extentReports.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() throws IOException {
		
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");
			driver = new ChromeDriver();
			
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver");
			driver = new FirefoxDriver();
			
		}
		
		 ExtentTest test = extent.createTest("Open the web site"); 
		 test.log(Status.INFO, "Starting test"); test.info("Starting test");
		 
		 driver.get("https://rahulshettyacademy.com/AutomationPractice");                    
		 test.pass("Navigated to url: https://rahulshettyacademy.com/AutomationPractice/ ");
		 
		 driver.manage().window().maximize(); 
		 test.pass("Maximize the window");
		 
		 test.info("Test is completed.");
	
	}

	@Test(priority = 1)
	public void clickOnRadionBtn() {

		ExtentTest test1 = extent.createTest("clickOnRadioBtn");
		test1.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnRadioBtn();

		test1.pass("Checkbox is checked");
		test1.info("Test clickOnRadionBtn is completed.");

	}

	@Test(priority = 2)
	public void enterTextInTextBox() {

		ExtentTest test2 = extent.createTest("enterTextInTextBox");
		test2.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.setTextAndAutocomplete();

		test2.pass("Text is entered in the text box");
		test2.info("Test enterTextInTextBox is completed.");

	}

	@Test(priority = 3)
	public void selectOptionFromStaticDropdownMenu() {

		ExtentTest test3 = extent.createTest("selectOptionFromStaticDropdownMenu");
		test3.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.chooseOptionFromDropdownMenu();

		test3.pass("Option 2 is selected");
		test3.info("Test selectOptionFromStaticDropdownMenu is completed.");

	}

	@Test(priority = 4)
	public void click_on_checkBox() {

		ExtentTest test4 = extent.createTest("click_on_checkBox");
		test4.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnCheckBox();

		test4.pass("Option 2 is checked");
		test4.info("Test click_on_checkBox is completed.");
	}

	@Test(priority = 5)
	public void switchWindow() throws InterruptedException {

		ExtentTest test5 = extent.createTest("switchWindow");
		test5.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnOpenWindowBtn();

		Set<String> window = driver.getWindowHandles();

		Iterator<String> it = window.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);
		test5.pass("Child window is in focus.");

		System.out.println("Test switchWindow - page title is: " + driver.getTitle());
		test5.pass("Page title of child window is printed.");

		driver.close(); // closing child window
		test5.pass("Child window is closed.");

		driver.switchTo().window(parentWindowId);
		test5.pass("Parent window is now in focus.");

		System.out.println("Test switchWindow - page title is: " + driver.getTitle());
		test5.pass("Page title of parent window is printed.");

		test5.info("Test switchWindow is completed.");

	}

	@Test(priority = 6)
	public void switchTab() {

		ExtentTest test6 = extent.createTest("switchTab");
		test6.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnOpenTabBtn();
		
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		
	    driver.switchTo().window(tabs2.get(1));
	    test6.pass("Child tab is in focus.");
	    
	    driver.close();
	    test6.pass("Child tab is closed.");
	    
	    driver.switchTo().window(tabs2.get(0));
	    test6.pass("Parent tab is now in focus.");
		
	    
	    System.out.println("Test switchTab - page title is: " + driver.getTitle());
		test6.pass("Page title of parent tab is printed.");
		
		test6.info("Test switchTab  is completed.");

	}

	@Test(priority = 7)
	public void click_OK_onAlert() {

		ExtentTest test7 = extent.createTest("click_OK_onAlert");
		test7.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.setTextForAlert();
		test7.pass("Text is entered.");

		ppo.clickOnALertBtn();
		test7.pass("Alert button is clicked.");

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Test click_OK_onAlert - message alert is: " + alertMessage);
		test7.pass("Message alert is printed.");

		driver.switchTo().alert().accept();
		test7.pass("Ok is clicked on the alert.");

		test7.info("Test click_OK_onAlert is completed.");

	}

	@Test(priority = 8)
	public void click_Cancel_onAlert() {

		ExtentTest test8 = extent.createTest("click_Cancel_onAlert");
		test8.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.setTextForAlert();
		test8.pass("Text is entered.");

		ppo.clickOnConfirmBtn();
		test8.pass("Confirm button is clicked.");

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Test click_Cancel_onAlert - message alert is: " + alertMessage);
		test8.pass("Alert message is printed.");

		driver.switchTo().alert().dismiss();
		test8.pass("Cancel is clicked on the alert");

		test8.info("Test click_Cancel_onAlert is completed.");
	}

	@Test(priority = 9)
	public void printCoursesNameFromTable() {

		ExtentTest test9 = extent.createTest("printCoursesNameFromTable");
		test9.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		System.out.println("Test printCoursesNameFromTable - We have the following courses:  ");
		test9.pass("Message _We have the following courses_ is printed. ");

		System.out.println("=================================================================");
		ppo.getValuesFromTable();
		test9.pass("Course's name from table is printed.");
		System.out.println("=================================================================");

		test9.info("Test printCoursesNameFromTable is completed. ");

	}

	@Test(priority = 10)
	public void printCourseNameForPyhton() {

		ExtentTest test10 = extent.createTest("printCourseNameForPyhton");
		test10.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		System.out.print("Test printCourseNameForPython - Full name for Python course is : ");
		test10.pass("Message _Full name for Python course is :_ is printed.");

		ppo.printFullNameForPythonCourse();
		test10.pass("Full name for Python course is printed.");

		test10.info("Test printCourseNameForPyhton is completed. ");

	}

	@Test(priority = 11)
	public void verifyPythonPrice() {

		ExtentTest test11 = extent.createTest("verifyPythonPrice");
		test11.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		System.out.print("Test verifyPythonPrice - Price for Python course is : ");
		test11.pass("Message _Test verifyPythonPrice - Price for Python course is :_ is printed.");

		Assert.assertEquals(ppo.verifyPriceForPythonCourse(), "25");
		test11.pass("Test validation is successful.");

		test11.info("Test verifyPythonPrice is completed. ");

	}

	@Test(priority = 12)
	public void VerifyIfInputTextFieldIsVisibleOrNot() {

		ExtentTest test12 = extent.createTest("VerifyIfInputTextFieldIsVisibleOrNot");
		test12.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.visibilityOfInputFieldShowHide();
		test12.pass("Check if input field is displayed.");

		ppo.setTextInInputFieldShowHide("Slobodan Zivic");
		test12.pass("Text _Slobodan Zivic_ is entered in the text box. ");

		ppo.clickOnHideBtn();
		test12.pass("Hide button is clicked.");

		ppo.visibilityOfInputFieldShowHide();
		test12.pass("Check if input field is displayed.");

		test12.info("Test VerifyIfInputTextFieldIsVisibleOrNot is completed.");
	}

	@Test(priority = 13)
	public void printTotalNumberOfLinks() {

		ExtentTest test13 = extent.createTest("printTotalNumberOfLinks");
		test13.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		Assert.assertEquals(ppo.printCountOfLinksOnThePage(), 27);
		test13.pass("Test validation is successful.");

		test13.info("Test printTotalNumberOfLinks is completed.");
	}

	@Test(priority = 14)
	public void scrollingDown_OnTable() throws InterruptedException {

		ExtentTest test14 = extent.createTest("scrollingDown_OnTable");
		test14.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.scrollingDownOnTable();
		test14.pass("Scrolling successfully to the web table with fixed header.");

		test14.info("Test scrollingDown_OnTable is completed.");
	}

	@Test(priority = 15)
	public void clickOnMouseHover() throws InterruptedException {

		ExtentTest test15 = extent.createTest("clickOnMouseHover");
		test15.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.scrollingDownOnHomePage();
		test15.pass("Scrolling successfully to the mouse over button.");

		ppo.clickOnTopOptionOnMouseOver();
		test15.pass("Top option from menu is clicked.");

		test15.info("Test clickOnMouseHover is completed.");

	}

	@Test(priority = 16)
	public void switchToFrame() throws InterruptedException {

		ExtentTest test16 = extent.createTest("switchToFrame");
		test16.log(Status.INFO, "Starting test");

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.scrollingDownToFrame();
		test16.pass("Scrolling successfully to the frame.");

		ppo.switchToIframe();
		test16.pass("Successfully switched to frame.");

		ppo.scrollingDownOnHomePage();
		test16.pass("Successfully scrolling in the frame.");

		driver.switchTo().defaultContent(); // go back to the parent frame or main page
		test16.pass("Successfully switched to the main page.");

		test16.info("Test switchToFrame is completed. ");

	}

	@Test(priority = 17)
	public void printNamesOfLinksFromColumnLatestNews() throws InterruptedException {
		
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.scrollingDownToTheBottomOfPage();
		System.out.println("*******************************************");
		System.out.println("Names of links from column Latest News are: ");
		System.out.println("===========================================");
		ppo.printAllLinksFromColumnLatestNews();
		System.out.println("===========================================");
	}

	@Test(priority = 18)
	public void printNamesOfLinksFromColumnSocialMedia() throws InterruptedException {
		
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.scrollingDownToTheBottomOfPage();
		System.out.println("*******************************************");
		System.out.println("Names of links from column Social Media are: ");
		System.out.println("===========================================");
		ppo.printAllLinksFromColumnSocialMedia();
		System.out.println("===========================================");
	}

	@Test(priority = 19)
	public void sumPricesForAllCourses() {
		
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.sumOfPricesForAllCourses();
	}

	@AfterTest
	public void tearDown() {

		ExtentTest test17 = extent.createTest("tearDown");
		test17.log(Status.INFO, "Starting test");

		driver.close();
		test17.pass("Driver is closed.");

		System.out.println("----------------------------------------------------------");

		System.out.println("Test is successfully completed");
		test17.pass("Message _Test is successfully completed_ is printed.");

		System.out.println("----------------------------------------------------------");

		test17.info("Test tearDownis completed. ");

	}

	@AfterSuite
	public void endTest() {
		
		extent.flush();
	}
}
