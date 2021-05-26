package Assignments;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;
import org.junit.Assert;

public class assignment1  extends DriverSetup{
	
String pURL = "http://demo.guru99.com/telecom/index.html";
	
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	//global variable
	String sBackgroundCheck;
	
	// Run Test Section
	@BeforeTest
	public void beforeTest() throws Exception {
		this.driver = sfSelenium.getDriver();
	}
	
	//navigate to URL and assert logo
	@BeforeClass
	public void beforeClass() throws Exception {
		//Navigate to URL a
		driver.get(pURL);
		String sLogoTxt = driver.findElement(By.cssSelector("body:nth-child(2) span:nth-child(3) nav.left > a.logo:nth-child(2)")).getText();
		Assert.assertEquals("Guru99 telecom", sLogoTxt);
		//click add customer
		driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.left:nth-child(1) div:nth-child(1) h3:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(500);	 
	}
	
	@Test
	public void testFirst() throws Exception {
		
		this.driver = sfSelenium.getDriver();
		//instantiate variables
		Boolean bFnameValid;
		Boolean bLnameValid;
		Boolean bEmailValid;
		Boolean bAddressValid;
		Boolean bTelephonenoValid;
		Boolean bExpectedValue = true;
		
		//clear input fields
		driver.findElement(By.cssSelector("#fname")).clear();
		driver.findElement(By.cssSelector("#lname")).clear();
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]")).clear();
		driver.findElement(By.cssSelector("#telephoneno")).clear();
		
		//populate input fields
		sfSelenium.populateInputField(By.cssSelector("#fname"), "!not valid!", driver);
		sfSelenium.populateInputField(By.cssSelector("#lname"), "1not valid1", driver);
		sfSelenium.populateInputField(By.cssSelector("#email"), "Not@Valid", driver);
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), " ", driver);
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "!not valid!", driver);
		
		//check if warning messages are displayed
		bFnameValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[4]/label[1]")).isDisplayed();
		bLnameValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[5]/label[1]")).isDisplayed();
		bEmailValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[6]/label[1]")).isDisplayed();
		bAddressValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/label[1]")).isDisplayed();
		bTelephonenoValid = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[8]/label[1]")).isDisplayed();
		
		//do assertions on the warning messages
		Assert.assertEquals(bExpectedValue, bFnameValid);
		Assert.assertEquals(bExpectedValue, bLnameValid);
		Assert.assertEquals(bExpectedValue, bEmailValid);
		Assert.assertEquals(bExpectedValue, bAddressValid);
		Assert.assertEquals(bExpectedValue, bTelephonenoValid);
	}
	
	@Test
	public void testSecond() throws Exception {
		//click the Submit Button
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[9]/ul[1]/li[1]/input[1]")).click();
		
		//handle the alert
		Alert alert = this.driver.switchTo().alert();
		String sAlertMessage = alert.getText();
		Assert.assertEquals("please fill all fields", sAlertMessage);
		alert.accept();
	}
	
	@Parameters({ "BackgroundCheck" })
	@Test 
	public void testThird(String pBackgroundCheck) throws Exception {
		//instantiate variables
		String sCustomerID;
		Boolean bExpectedValue = true;
		Boolean bActualValue = false;
		
		//clear input fields
		driver.findElement(By.cssSelector("#fname")).clear();
		driver.findElement(By.cssSelector("#lname")).clear();
		driver.findElement(By.cssSelector("#email")).clear();
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]")).clear();
		driver.findElement(By.cssSelector("#telephoneno")).clear();
		
		//populate input fields
		sfSelenium.populateInputField(By.cssSelector("#fname"), "valid", driver);
		sfSelenium.populateInputField(By.cssSelector("#lname"), "name", driver);
		sfSelenium.populateInputField(By.cssSelector("#email"), "Valid@test.com", driver);
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), "37 Test Street Suburb", driver);
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "0112223333", driver);
		
		//select Background Check
		driver.findElement(By.xpath("//label[contains(text(),'" + pBackgroundCheck +"')]")).click();
		//sets the global variable to the value of the parameter passed
		sBackgroundCheck = pBackgroundCheck;
		
		//click the Submit Button
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[9]/ul[1]/li[1]/input[1]")).click();
		
		//Store Customer ID and validate that it is not empty
		sCustomerID = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/h3[1]")).getText();
		if (sCustomerID.length() > 1) {
			bActualValue = true;		
			//System.out.println("Customer ID: " + sCustomerID);
			
			FileWriter myWriter = new FileWriter("CustomerID.csv");
		    myWriter.write(sCustomerID);
		    myWriter.close();
		}
		Assert.assertEquals(bExpectedValue, bActualValue);
	}
	
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium(driver);
	}

}