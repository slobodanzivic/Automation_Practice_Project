package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PracticePageObjects {

	static String projectPath = System.getProperty("user.dir");

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
	By inputTextFieldShowHide = By.cssSelector("input[name='show-hide']");
	By hideBtn = By.cssSelector("input[onclick='hideElement()']");
	By showBtn = By.cssSelector("input[onclick='showElement()']");
	By mouseoverBtn = By.cssSelector("button#mousehover");
	By topOptionOnMouseOver = By.cssSelector("div[class*='mouse-hover-content'] a:nth-child(1)");
	By latestNewsColumn = By.cssSelector("div#gf-BIG tbody tr td:nth-child(2) ul");
	By socialMediaColumn = By.cssSelector("div#gf-BIG tbody tr td:nth-child(4) ul");
	By priceForCourses = By.cssSelector("table[name = courses] tbody td:nth-child(3)");

	public PracticePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnRadioBtn() {
		driver.findElement(radioBtn).click();

	}

	public boolean isRadioBtnSelected() {
		WebElement radioBtn = driver.findElement(By.cssSelector("input[value='radio2']"));
		boolean actualValue = radioBtn.isSelected();
		return actualValue;
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

	public boolean isCheckBoxChecked() {
		WebElement checkBox = driver.findElement(By.cssSelector("input#checkBoxOption2"));
		boolean actualValue = checkBox.isSelected();
		return actualValue;
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

	public String verifyPriceForPythonCourse() {

		List<WebElement> myElements = driver.findElements(columnCourses);

		String coursePrice = null;

		for (int i = 0; i < myElements.size(); i++) {
			String courseName = myElements.get(i).getText();
			if (courseName.contains("Python")) {
				String price = driver
						.findElement(By.xpath("//table[@name='courses']/tbody/tr[9]/td[2]/following-sibling::td[1]"))
						.getText();
				System.out.println(price);

				coursePrice = price;
			}
		}
		return coursePrice;
	}

	public Boolean visibilityOfInputFieldShowHide() {

		if (driver.findElement(inputTextFieldShowHide).isDisplayed()) {
			System.out.println("Input field is visible");
			return true;

		} else {
			System.out.println("Input field is not visible");
			return false;
		}
	}

	public String setTextInInputFieldShowHide(String text) {

		driver.findElement(inputTextFieldShowHide).sendKeys(text);
		return text;
	}

	public void clickOnHideBtn() {
		driver.findElement(hideBtn).click();
	}

	public void clickOnShowBtn() {
		driver.findElement(showBtn).click();
	}

	public int printCountOfLinksOnThePage() {

		int totalCountOfLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Total number of links on the web page are: " + totalCountOfLinks);
		return totalCountOfLinks;
	}

	public void scrollingDownOnHomePage() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
	}

	public void scrollingDownToTheBottomOfPage() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);
	}

	public void scrollingDownOnTable() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		Thread.sleep(2000);
	}

	public void clickOnMouseOverBtn() {
		driver.findElement(mouseoverBtn).click();
	}

	public void clickOnTopOptionOnMouseOver() throws InterruptedException {

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("button#mousehover"))).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class*='mouse-hover-content'] a:nth-child(1)")).click();
		Thread.sleep(3000);

	}

	public void scrollingDownToFrame() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(3000);
	}

	public void switchToIframe() {
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#courses-iframe")));
	}

	public void printAllLinksFromColumnLatestNews() {

		List<WebElement> allLinks = driver.findElements(latestNewsColumn);

		for (int i = 0; i < allLinks.size(); i++) {
			String nameOfLink = allLinks.get(i).getText();
			System.out.println(nameOfLink);
		}
	}

	public void printAllLinksFromColumnSocialMedia() {

		List<WebElement> allLinks = driver.findElements(socialMediaColumn);

		for (int i = 0; i < allLinks.size(); i++) {
			String nameOfLinks = allLinks.get(i).getText();
			System.out.println(nameOfLinks);
		}
	}

	public void sumOfPricesForAllCourses() {

		int sum = 0;

		List<WebElement> prices = driver.findElements(priceForCourses);

		for (int i = 0; i < prices.size(); i++) {
			String price = prices.get(i).getText();
			int a = Integer.parseInt(price);
			sum = sum + a;

		}

		System.out.println("Total price for all courses in Web table Example is: " + sum);
	}

}
