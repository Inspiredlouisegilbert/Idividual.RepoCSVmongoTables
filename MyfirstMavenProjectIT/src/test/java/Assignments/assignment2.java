package Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;

import java.io.File;
import java.util.Scanner;

import org.junit.Assert;

public class assignment2 extends DriverSetup{
	
	String pURL = "http://demo.guru99.com/telecom/index.html";
	
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	
	//global variables
	String sCustomerID;
	String sBackgroundCheck;
	
	// Run Test Section
	@BeforeTest
	public void beforeTest() throws Exception {
		this.driver = sfSelenium.getDriver();
	}
	
	//navigate to URL and assert logo
	@BeforeClass
	public void beforeClass() throws Exception {
		driver.get(pURL);
		String sLogoTxt = driver.findElement(By.cssSelector("body:nth-child(2) span:nth-child(3) nav.left > a.logo:nth-child(2)")).getText();
		Assert.assertEquals("Guru99 telecom", sLogoTxt);
		driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.left:nth-child(1) div:nth-child(2) h3:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(500);
	}
	
	@Parameters ({ "BackgroundCheck" })
	@Test (priority = 2)
	public void testFirst(String pBackgroundCheck) throws Exception {
		//instantiate variables
		String sCustomerID;
		String sActualValue;
		
		//creates a file object
		File CustomerID = new File("CustomerID.csv");	
		CustomerID.createNewFile();
		//read Customer ID from file
		Scanner myReader = new Scanner(CustomerID);
		sCustomerID = myReader.nextLine();
	    myReader.close();
		
	    //populate Customer ID and submit
		sfSelenium.populateInputField(By.cssSelector("#customer_id"), sCustomerID, driver);
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[6]/input[1]")).click();
		Thread.sleep(500);

		//assert that the user is active/inactive 
		sActualValue = driver.findElement(By.tagName("font")).getText();
		if (pBackgroundCheck.equals("Done")) {
			Assert.assertEquals("ACTIVE", sActualValue);
		}
		else {
			Assert.assertEquals("INACTIVE", sActualValue);
		}
		
	}
	
	@Test (priority = 3)
	public void testSecond() throws Exception {
		Boolean bAvaliableTariffPlan;
		try {
			bAvaliableTariffPlan = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).isDisplayed();
		}
		catch(Exception e) {
			bAvaliableTariffPlan = false;
		}
		Assert.assertEquals(true, bAvaliableTariffPlan);
		driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(2) table.alt tbody:nth-child(2) tr:nth-child(1) td:nth-child(1) > label:nth-child(2)")).click();
		Thread.sleep(10000);
	}
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium(driver);
	}
}
