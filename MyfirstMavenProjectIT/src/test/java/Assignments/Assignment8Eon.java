package Assignments;

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

public class Assignment8Eon {
	
	// Selenium Functions 
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
		
		// driver variable
		WebDriver driver;
		// Set URL
		
		
		String pURL = "http://demo.guru99.com/test/web-table-element.php#";
		
		// Navigate to demo.guru99.com
		public void navigateToURL(String pURL) {
			driver.get(pURL);
			//sfSelenium.maximiseBrowserWindow();
		}
		
		///// Run tests /////
		@BeforeTest
		public void runTestStart () {
			// set the value for driver
			this.driver = sfSelenium.getDriver();
			//start the test
			// Set up the report
			sfSelenium.startReport("Assignment 8", "Tables: Method to return number of rows, columns and assertions");
			sfSelenium.createTest("Start Test");
		}
		
		@Test
		public void datepicker() throws IOException, InterruptedException {

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
			WebElement getValueCell1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
			System.out.println("The cell value of column 2 row 1 is: " + getValueCell1.getText());
//			WebElement getValueCell2 = driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
//			System.out.println("The cell value of row 4 column 3 is: " + getValueCell2.getText());
//			WebElement getValueCell3 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]"));
//			System.out.println("The cell value of row 1 column 2 is: " + getValueCell3.getText());
			
			printtofile();
		}
		
		public void printtofile() {
			//PRINT ALL RECORDS THAT HAVE A PERCENTAGE CHANGE BIGGER THAN 4
//			int i= 0, j=0, max=0;
//			for(int RowNumber=1; RowNumber<=rows.size(); RowNumber++) {
//			String col=driver.findElement(By.xpath("//*/table[1]/tbody/tr["+RowNumber+"]/td[5]")).getText();
//			i=Integer.parseInt(col);
//			if(i>j){
//			max=j=i;
//			}	
//			}
//			System.out.println("Highest percentage change is:"+max);
		}

		@AfterTest
		public void cleanup () throws IOException, InterruptedException {
			sfSelenium.createTest("Run Test: clean up");
			// set the value for driver
			this.driver = sfSelenium.getDriver();
			sfSelenium.CloseSelenium();	
		}
}
