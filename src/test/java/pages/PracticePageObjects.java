package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticePageObjects {

	WebDriver driver = null;

	By radioBtn = By.cssSelector("input[value='radio2']");
	By textBox_autocomplete = By.cssSelector("input#autocomplete");
	By selectDropdown = By.cssSelector("select[id*=dropdown]");
	By checkbox = By.cssSelector("input#checkBoxOption2");
	By openWindowBtn = By.cssSelector("button#openwindow");
	By homePageQAclickAcademy = By.cssSelector("ul.nav.navbar-nav.navbar-right li.active a");

	public PracticePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnRadioBtn() {
		driver.findElement(radioBtn).click();
	}

	public void setTextAndAutocomplete() {
		driver.findElement(textBox_autocomplete).sendKeys("bel");
		driver.findElement(textBox_autocomplete).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(textBox_autocomplete).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(textBox_autocomplete).sendKeys(Keys.ENTER);
	}

	public void chooseOptionFromDropdownMenu() {
		WebElement staticDropdown = driver.findElement(selectDropdown);
		staticDropdown.click();
		Select selectDropdown = new Select(staticDropdown);
		selectDropdown.selectByVisibleText("Option2");
	}

	public void clickOnCheckBox() {
		driver.findElement(checkbox).click();
	}

	public void clickOnOpenWindowBtn() {
		driver.findElement(openWindowBtn).click();
	}

	public void clickOnHomePage() {
		driver.findElement(homePageQAclickAcademy).click();
	}

}
