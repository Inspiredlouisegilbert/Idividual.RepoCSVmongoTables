package datePicker;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
//import writeToFile.WriteToFile;

public class DatepickerDemoKeywordsNextMonth {
	
	// Selenium Functions 
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	//String pURL = "http://demo.guru99.com/test/table.html";
	String pURL = "https://demos.telerik.com/kendo-ui/datetimepicker/index";

	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
	}
	
	
	///// Run tests /////
	@BeforeTest
	public void runTestStart () {
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		//start the test
		// Set up the report
		sfSelenium.startReport("Payment Gateway Project", "Playing with the date picker");
		sfSelenium.createTest("Start Test");
	}
	
	@Test
	public void datepickerr() throws IOException, InterruptedException {
		
        //Date and Time to be set in textbox

        //button to open calendar
		sfSelenium.createTest("Run Test: DatePicker");
		navigateToURL(pURL);
		
		// Open the date selector
		WebElement selectDate = driver.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));
		selectDate.click();
		
		// click the next button
		WebElement selectDate2 = driver.findElement(By.xpath("//a[contains(@class,'k-nav-next')]"));
		selectDate2.click();
		
		
		// Click the 26th day
		WebElement selectDate3 = driver.findElement(By.xpath("//a[contains(text(),'26')]"));
		selectDate3.click();

		sfSelenium.logScreenShot();	
	}

	@AfterTest
	public void cleanup () throws IOException, InterruptedException {
		sfSelenium.createTest("Run Test: clean up");
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		sfSelenium.CloseSelenium();	
		//
	}

	
}

