package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePageObjects {

	WebDriver driver = null;

	By radioBtn = By.cssSelector("input[value='radio2']");

	public PracticePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnRadioBtn() {
		driver.findElement(radioBtn).click();
	}

}
