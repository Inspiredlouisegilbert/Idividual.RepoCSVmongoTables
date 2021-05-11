package tablesdeomo;

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

public class TablesDemo {
	
	// Selenium Functions 
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	String pURL = "http://demo.guru99.com/test/table.html";
	
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
		

		sfSelenium.createTest("Run Test: Tables");
		navigateToURL(pURL);
		String tablexpath = "//table/tbody";
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
		System.out.println("Total Number of cells in the table are: "+TotalColsList.size());
		
		List<WebElement> TotalColsListrow4 = ToGetColumns.findElements(By.xpath("tr[3]/td"));
		System.out.println("Total Number of columns in the row 4 are: "+TotalColsListrow4.size());
		WebElement getValueCell1 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]"));
		System.out.println("The cell value of row 1 column 1 is: " + getValueCell1.getText());
		WebElement getValueCell2 = driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
		System.out.println("The cell value of row 4 column 3 is: " + getValueCell2.getText());
		WebElement getValueCell3 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
		System.out.println("The cell value of row 1 column 2 is: " + getValueCell3.getText());
		
		
		
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

