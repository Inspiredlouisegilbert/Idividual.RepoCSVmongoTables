package Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;

public class assignment2 extends driverSetup{
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	assignment1 clAssignment1 = new assignment1();
	
	//global variables
	//String sCustomerID;
	String sBackgroundCheck = "Done"; 
	Boolean bAvaliableTariffPlan;
	
	public void submitCustomerID(String pBackgroundCheck) throws Exception {
		//instantiate variables
		String sCustomerID;
		String sActualValue;
		
		//call AddCustomer 
		clAssignment1.AddCustomer(pBackgroundCheck);
		
		//Navigate to URL
		clAssignment1.Setup();
		
		//click Add Tariff Plan to Customer
		driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.left:nth-child(1) div:nth-child(2) h3:nth-child(1) > a:nth-child(1)")).click();
		
		//reads Customer ID from file
		sCustomerID = ReadCustomerIDFromFile();
		
	    //populate Customer ID and submit
		SubmitCustomerID(sCustomerID);

		//Wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("font")));
		
		//assert that the user is active/inactive 
		sActualValue = driver.findElement(By.tagName("font")).getText();
		if (pBackgroundCheck.equals("Done")) {
			Reporter.log("expected ------------------"+ "ACTIVE");
		    Reporter.log("actual --------------------"+ sActualValue);
			Assert.assertEquals("ACTIVE", sActualValue);
		}
		else { 
			Reporter.log("expected ------------------"+ "INACTIVE");
		    Reporter.log("actual --------------------"+ sActualValue);
			Assert.assertEquals("INACTIVE", sActualValue);
		}
		Thread.sleep(500);	
	}
	
	public void CheckForTariffPlan(String pBackgroundCheck) throws Exception {
		//instantiate variables
		String sBackgroundCheck = pBackgroundCheck;
		
		submitCustomerID(sBackgroundCheck);
		
		try {
			bAvaliableTariffPlan = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")).isDisplayed();
		}
		catch(Exception e) {
			bAvaliableTariffPlan = false;
		}
		Reporter.log("expected ------------------"+ true);
	    Reporter.log("actual --------------------"+ bAvaliableTariffPlan);
		Assert.assertEquals(true, bAvaliableTariffPlan);
	}
	
	public void AssertAddedTariffPlan() throws Exception {
		//instantiate variables
		String sExpectedValue = "Congratulation Tariff Plan assigned";
		String sActualValue;

		if (bAvaliableTariffPlan = true) {
			//click add tariff plan
			driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[2]/input[1]")).click();
					
			//assert successful addition of tariff plan
			sActualValue = driver.findElement(By.tagName("h2")).getText();
			Reporter.log("expected ------------------"+ sExpectedValue);
		    Reporter.log("actual --------------------"+ sActualValue);
			Assert.assertEquals(sExpectedValue, sActualValue);
		}
		else {
			throw new Exception("Tariff Plan not added successfully!");
		}
		
	}
	
	public String ReadCustomerIDFromFile() throws IOException {
		//instantiate variables
		String sCustomerID;
		
		//creates a file object
		File CustomerID = new File("CustomerID.csv");	
		CustomerID.createNewFile();
		
		//read Customer ID from file
		Scanner myReader = new Scanner(CustomerID);
		sCustomerID = myReader.nextLine();
		myReader.close();
		
		//returns the Customer ID
		return sCustomerID;
	}
	
	public void SubmitCustomerID(String pCustomerID) throws InterruptedException {
		//populate Customer ID and submit
		sfSelenium.populateInputField(By.cssSelector("#customer_id"), pCustomerID);
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[6]/input[1]")).click();
		Thread.sleep(500);
	}
}
