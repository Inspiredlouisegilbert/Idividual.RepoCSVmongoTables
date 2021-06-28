package tablesdeomo;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.javac.util.Convert;

import frameworkclasses.SeleniumFunctions;
//import writeToFile.WriteToFile;

public class TablesTestEON {
	
	// Selenium Functions 
	//SeleniumFunctions sfSelenium = new SeleniumFunctions("gecko");
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	// Set URL
	
	
	String pURL = "http://demo.guru99.com/test/table.html";
	String mURL = "http://demo.guru99.com/telecom/assigntariffplantocustomer.php";
	
	// Navigate to demo.guru99.com
	public void navigateToURL(String pURL) {
		driver.get(pURL);
		sfSelenium.maximiseBrowserWindow();
	}
	
	public void getmaxValues() {
		
		String maxURL = "http://demo.guru99.com/test/web-table-element.php#";
		int max=0;
		
		navigateToURL(maxURL);
		String tablexpath = "//table/tbody";
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
		System.out.println("Total Number of cells in the table are: "+ TotalColsList.size());
		
		//STORE TABLE SIZE
		WebElement percentagecolumn = driver.findElement(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(5) > .green"));
		
		//GET DATA FROM PERCENTAGE CHANGE COLUMN
		List<WebElement> colsWithData = percentagecolumn.findElements(By.cssSelector("tr:nth-of-type(1) > td:nth-of-type(5) > .green"));
		

		//PRINT DATA
		System.out.println("Percentage change column: " + colsWithData);
        for(int index =0; index<colsWithData.size(); index++) {
         System.out.println(colsWithData.get(index).getText());
        }
//		
//		int max=0;
//		String percentagechange = null;
//		List<WebElement> storeRows = storesTable.findElements(By.cssSelctor("table tr"));
//		for(int i=0; i<storeRows.size();i++{
//		WebElement columnValue = storeRows.findElement(By.xpath("\td[3]"));
//		WebElement percentageElem = storeRows.findElement(By.xpath("\td[1]"));
//		if(Integer.parseInt(columnValue.getText()) > max){
//			percentagechange = percentageElem.getText();
//		   max = Integer.parseInt(columnValue.getText());
//		    }
//		}
//		System.out.println("For Percentage Change " + percentagechange + " are the highest change = " + max);
	}
	
	///// Run tests /////
	@BeforeTest
	public void runTestStart () {
		// set the value for driver
		this.driver = sfSelenium.getDriver();
		//start the test
		// Set up the report
		sfSelenium.startReport("Eon Tables Tests", "Playing with the tables");
		sfSelenium.createTest("Start Test");
	}
	
	public void eontables() throws IOException {

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
		
		WebElement getValueR1C2 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
		System.out.println("The cell value of row 1 column 2 is: " + getValueR1C2.getText());
		
		WebElement getValueR2C3 = driver.findElement(By.xpath("//tbody/tr[2]/td[3]"));
		System.out.println("The cell value of row 2 column 3 is: " + getValueR2C3.getText());
		
		//DO CALCULATION INCORRECT
		String valueone = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText().toString();
		String valuetwo = driver.findElement(By.xpath("//tbody/tr[2]/td[3]")).getText().toString();
		String combined = valueone + valuetwo;		//SIMPLY ADS THE TWO NEXT TO EACH OTHER
		System.out.println("Sum: " + combined);
		
		//DO CALCULATION CORRECT
		//PARSEINT IS USED TO GET THE PRIMITIVE TYPE OF A STRING
		try
		{
			int ivalueone = Integer.parseInt(valueone.trim());
			int ivaluetwo = Integer.parseInt(valuetwo.trim());
			int icombined = ivalueone + ivaluetwo;
			System.out.println("first number is " + ivalueone);
			System.out.println("second number is " + ivaluetwo);
			System.out.println("Sum is " + icombined);
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		sfSelenium.logScreenShot();	
	}
	
	public void getMaxvalues() {
		driver.get(mURL);
		
		String tablexpath = "//table/tbody";
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
		System.out.println("Total Number of cells in the table are: "+TotalColsList.size());
	}
	
	@Test
	public void datepicker() throws IOException, InterruptedException {
//		getmaxValues();
//		eontables();
		getMaxvalues();
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

