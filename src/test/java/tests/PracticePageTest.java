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

	}

	@Test
	public void clickOnRadionBtn() throws InterruptedException {

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		PracticePageObjects ppo = new PracticePageObjects(driver);
		ppo.clickOnRadioBtn();
		Thread.sleep(3000);

	}

	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();
		System.out.println("Test is successfully completed");

	}

}
