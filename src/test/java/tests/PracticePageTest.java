package tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

		// Thread.sleep(3000);

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

	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();
		System.out.println("Test is successfully completed");

	}

}
