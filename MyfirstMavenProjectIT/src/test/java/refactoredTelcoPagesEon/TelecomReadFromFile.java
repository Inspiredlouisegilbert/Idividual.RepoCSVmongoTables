package refactoredTelcoPagesEon;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.SignInPage;
import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Refactored.testsAssignment3;

public class TelecomReadFromFile extends BasePage{
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	testsAssignment3 clAssignment3 = new testsAssignment3();
	
	String pURL = "http://demo.guru99.com/telecom/assigntariffplantocustomer.php";

	public void navigatetourl()
	{
		driver.get(pURL);
	}
	
	public void readfromfile() throws IOException 
	{
		String readfromdir = getDataConfigProperties("readfromdir");
		String pCustomerID = "";
		
		BufferedReader br = new BufferedReader(new FileReader(readfromdir)); 
		String line;
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
		    // use xx as separator.
			    String[] cols = line.split(";"); 
			    System.out.println(cols[0]); 
				pCustomerID = cols[0];
				
				captureID(line);
				submit();   
				System.out.println("CustomerID successfully imported from selected CSV file");
			}
		}
		// close the buffer
		br.close();
	}
	
	public void captureID(String pClientID) {
		sfSelenium.populateInputField(By.cssSelector("#customer_id"), pClientID);
		submit();
	}
	
	public void submit() {
		this.driver.findElement(By.tagName("input")).click();
	}
	
	public void getMaxMonthlyRental() {
		
		String tablexpath = "//table/tbody";
		WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		
		WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
		List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
		System.out.println("Total Number of cells in the table are: "+TotalColsList.size());
		

	}
	
	//GET MAX MONTHLY RENTAL
	//GET MAX LOCAL MINUTES
	//GET MAX INTERNATIONAL MINUTES
	//GET MAX SMS PACK
	//GET MAX PER LOCAL MINUTES CHARGES
	//GET MAX PER INTERNATIONAL MINUTES CHANGRES
	//GET MAX PER SMS PACK
}