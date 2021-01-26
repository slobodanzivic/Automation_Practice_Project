package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();
		System.out.println("Test is successfully completed");

	}

}
