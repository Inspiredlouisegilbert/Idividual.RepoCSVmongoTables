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

public class DatepickerDemoKeywordsEnterDate {
	
	// Selenium Functions 
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	String pURL = "http://demo.guru99.com/test/";
	
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
		

        //button to open calendar
		sfSelenium.createTest("Run Test: DatePicker");
		navigateToURL(pURL);
		
		
		//Find the date time picker control

        WebElement dateBox = driver.findElement(By.xpath("//input[@name='bdaytime']"));

        //Enter the year
        dateBox.sendKeys("1980");

        //Press tab to to enter month and day
        dateBox.sendKeys(Keys.TAB);
        dateBox.sendKeys("1105");

        //Fill time as 08:37 PM
        dateBox.sendKeys("0837AM");
		
        // Click submit
        this.driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        //Check 
        String getOutput = this.driver.findElement(By.xpath("//body/div[2]")).getText();
		Assert.assertEquals(getOutput, "Your Birth Date is 1980-11-05\nYour Birth Time is 08:37");
		
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

