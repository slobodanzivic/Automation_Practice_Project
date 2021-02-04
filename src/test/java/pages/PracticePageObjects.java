package pages;

import java.util.List;
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
	By openWindowBtn = By.cssSelector("fieldset button#openwindow");
	By loginBtn = By.cssSelector("nav.pull-right ul li:nth-child(4) a");
	By openTab = By.cssSelector("fieldset #opentab");
	By alertBtn = By.cssSelector("input#alertbtn");
	By enterTextforAlert = By.cssSelector("input[name='enter-name']");
	By confirmBtn = By.cssSelector("input[value='Confirm']");
	By columnCourses = By.cssSelector("table[name='courses'] tbody tr td:nth-child(2)");
	By pythonCourseName = By.xpath("//table[@name='courses']/tbody/tr[9]/td[2]");

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

	public void clickOnLoginBtn() {
		driver.findElement(loginBtn).click();
	}

	public void clickOnOpenTabBtn() {
		driver.findElement(openTab).click();
	}

	public void clickOnALertBtn() {
		driver.findElement(alertBtn).click();
	}

	public void setTextForAlert() {
		driver.findElement(enterTextforAlert).sendKeys("Slobodan Zivic");
	}

	public void clickOnConfirmBtn() {
		driver.findElement(confirmBtn).click();
	}

	public void getValuesFromTable() {

		List<WebElement> myElements = driver.findElements(columnCourses);
		for (int i = 0; i < myElements.size(); i++) {
			String courseName = myElements.get(i).getText();
			System.out.println(courseName);
		}
	}

	public void printFullNameForPythonCourse() {
		List<WebElement> myElements = driver.findElements(columnCourses);
		for (int i = 0; i < myElements.size(); i++) {
			String courseName = myElements.get(i).getText();
			if (courseName.contains("Python")) {
				String fullNameOfCourse = driver.findElements(columnCourses).get(i).getText();
				System.out.println(fullNameOfCourse);
			}
		}
	}

	public void verifyPriceForPythonCourse() {
		List<WebElement> myElements = driver.findElements(columnCourses);
		for (int i = 0; i < myElements.size(); i++) {
			String courseName = myElements.get(i).getText();
			if (courseName.contains("Python")) {
				String price = driver
						.findElement(By.xpath("//table[@name='courses']/tbody/tr[9]/td[2]/following-sibling::td[1]"))
						.getText();
				System.out.println(price);
			}
		}
	}
}
