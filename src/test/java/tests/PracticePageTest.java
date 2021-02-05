package tests;

import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.PracticePageObjects;

public class PracticePageTest {

	static WebDriver driver = null;

	@BeforeTest
	public void setUp() {

		String projectPath = System.getProperty("user.dir");
		// System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

	}

	@Test
	public void clickOnRadionBtn() {

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnRadioBtn();

	}

	@Test
	public void enterTextInTextBox() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.setTextAndAutocomplete();

	}

	@Test
	public void selectOptionFromStaticDropdownMenu() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.chooseOptionFromDropdownMenu();

	}

	@Test
	public void click_on_checkBox() {

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnCheckBox();
	}

	@Test
	public void switchWindow() throws InterruptedException {

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnOpenWindowBtn();

		Set<String> window = driver.getWindowHandles();

		Iterator<String> it = window.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);
		System.out.println("Test switchWindow - page title is: " + driver.getTitle());

		driver.close(); // closing child window

		driver.switchTo().window(parentWindowId);
		System.out.println("Test switchWindow - page title is: " + driver.getTitle());

	}

	@Test
	public void switchTab() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnOpenTabBtn();

		Set<String> tab = driver.getWindowHandles(); // [parentTabId, childTabId]

		Iterator<String> it = tab.iterator();
		String parentTabId = it.next();
		String childTabId = it.next();

		driver.switchTo().window(childTabId);
		System.out.println("Test switchTab - page title is: " + driver.getTitle());
		driver.close();

		driver.switchTo().window(parentTabId);
		System.out.println("Test switchTab - page title is: " + driver.getTitle());

	}

	@Test
	public void click_OK_onAlert() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.setTextForAlert();
		ppo.clickOnALertBtn();

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Test click_OK_onAlert - message alert is: " + alertMessage);
		driver.switchTo().alert().accept();

	}

	@Test
	public void click_Cancel_onAlert() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.setTextForAlert();
		ppo.clickOnConfirmBtn();

		String alertMessage = driver.switchTo().alert().getText();
		System.out.println("Test click_Cancel_onAlert - message alert is: " + alertMessage);
		driver.switchTo().alert().dismiss();
	}

	@Test
	public void printCoursesNameFromTable() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		System.out.println("Test printCoursesNameFromTable - We have the following courses:  ");
		System.out.println("=================================================================");
		ppo.getValuesFromTable();
		System.out.println("=================================================================");

	}

	@Test
	public void printCourseNameForPyhton() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		System.out.print("Test printCourseNameForPython - Full name for Python course is : ");
		ppo.printFullNameForPythonCourse();

	}

	@Test
	public void verifyPythonPrice() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		System.out.print("Test verifyPythonPrice - Price for Python course is : ");
		Assert.assertEquals(ppo.verifyPriceForPythonCourse(), "25");

	}

	@Test
	public void VerifyIfInputTextFieldIsVisibleOrNot() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.visibilityOfInputFieldShowHide();
		ppo.setTextInInputFieldShowHide();
		ppo.clickOnHideBtn();
		ppo.visibilityOfInputFieldShowHide();
	}

	@Test
	public void printTotalNumberOfLinks() {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		Assert.assertEquals(ppo.printCountOfLinksOnThePage(), 27);
	}

	@Test
	public void scrollingDown_OnTable() throws InterruptedException {
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.scrollingDownOnTable();
	}

	@Test
	public void clickOnMouseHover() throws InterruptedException {

		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.scrollingDownOnHomePage();
		ppo.clickOnTopOptionOnMouseOver();

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();

		System.out.println("----------------------------------------------------------");
		System.out.println("Test is successfully completed");
		System.out.println("----------------------------------------------------------");

	}
}
