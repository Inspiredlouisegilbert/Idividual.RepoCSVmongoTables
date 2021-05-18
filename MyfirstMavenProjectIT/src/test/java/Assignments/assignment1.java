package Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import junit.framework.Assert;

public class assignment1 {
	
String pURL = "http://demo.guru99.com/telecom/index.html";
	
	//Instantiate Selenium Functions
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	
	// driver variable
	WebDriver driver;
	
	// Run Test Section
	@BeforeTest
	public void beforeTest() throws Exception {
		this.driver = sfSelenium.getDriver();
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
	}
	
	@BeforeClass
	public void beforeClass() throws Exception {
		driver.get(pURL);
		String sLogoTxt = driver.findElement(By.cssSelector("body:nth-child(2) span:nth-child(3) nav.left > a.logo:nth-child(2)")).getText();
		Assert.assertEquals("Guru99 telecom", sLogoTxt);
		driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.left:nth-child(1) div:nth-child(1) h3:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[contains(text(),'Done')]")).click();
	}
	
	//navigate to URL and assert logo
	@Test
	public void testFirst() throws Exception {
		//instantiate variables
		Boolean bFnameValid;
		Boolean bLnameValid;
		Boolean bEmailValid;
		Boolean bAddressValid;
		Boolean bTelephonenoValid;
		Boolean bExpectedValue = true;
		
		//populate input fields
		sfSelenium.populateInputField(By.cssSelector("#fname"), "!not valid!");
		sfSelenium.populateInputField(By.cssSelector("#lname"), "1not valid1");
		sfSelenium.populateInputField(By.cssSelector("#email"), "Not@Valid");
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), " ");
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "!not valid!");
		
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
	
	@Test
	public void testThird() throws Exception {
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
		sfSelenium.populateInputField(By.cssSelector("#fname"), "valid");
		sfSelenium.populateInputField(By.cssSelector("#lname"), "name");
		sfSelenium.populateInputField(By.cssSelector("#email"), "Valid@test.com");
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), "37 Test Street Suburb");
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "0112223333");
		
		//click the Submit Button
		driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[9]/ul[1]/li[1]/input[1]")).click();
		
		//Store Customer ID and validate that it is not empty
		sCustomerID = driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/h3[1]")).getText();
		if (sCustomerID.length() > 1) {
			bActualValue = true;
			System.out.println("Customer ID: " + sCustomerID);
		}
		Assert.assertEquals(bExpectedValue, bActualValue);
	}
	
	
	@AfterTest
	public void afterTest() throws Exception {
		sfSelenium.CloseSelenium();
	}

}