package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemo {
	
	static WebDriver driver = null;

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it   
        ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");
        
        
        String projectPath = System.getProperty("user.dir");
		// System.out.println(projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting test case");
		driver.get("https://www.google.com");
		test1.pass("Navigated to www.google.com");
		driver.manage().window().maximize();
		test1.pass("Maximaize the window successsfully");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered the text in the searchbox");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		test1.pass("Pressed Enter on keyboard");
		
		driver.close();
		test1.pass("Close the browser");
		
		test1.info("Test completed");
		
		// calling flush writes everything to the log file
        extent.flush();
		

	}

}
