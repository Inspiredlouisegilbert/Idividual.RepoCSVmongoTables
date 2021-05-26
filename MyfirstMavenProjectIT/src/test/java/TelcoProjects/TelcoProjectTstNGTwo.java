package TelcoProjects;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;

public class TelcoProjectTstNGTwo {
	String pURL = "http://demo.guru99.com/V1/index.php";
	boolean eleDisplayed;
	boolean eleDisplayed2;
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	WebDriver driver;
	
	public void backgroundDone() throws InterruptedException
	{
		this.driver = sfSelenium.getDriver();
		driver.get(pURL);													
		sfSelenium.clickLink("Telecom Project");							
		sfSelenium.clickLink("Add Customer");								
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
		
		//POPULATE VALID INPUT FIELDS
		driver.findElement(By.xpath("//label[@for='done']")).click();
		sfSelenium.populateInputField(By.cssSelector("#fname"), "First name");
		sfSelenium.populateInputField(By.cssSelector("#lname"), "Last name");
		sfSelenium.populateInputField(By.cssSelector("#email"), "email@gmail.com");
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), "101 Hollywood Drive New York USA");
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "0791234567");
		
		//CLICK SUBMIT
		driver.findElement(By.xpath("//section[@id='main']//form[@action='insertcustomer.php']/div[@class='row uniform']//ul[@class='actions']//input[@name='submit']")).click();
		getUserID();
		
		try
		{
			//EXPECTED TEXT VISIBLE
			eleDisplayed = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//font[.='ACTIVE']")).isDisplayed();
			System.out.println("Expected text \'ACTIVE\' is visible: " + eleDisplayed);
			sfSelenium.createTest("Active text visible as expected");
			
			//SELECT TARIFF PLAN
			driver.findElement(By.xpath("//section[@id='main']//form[@action='inserttariffplantocustomer.php']//input[@name='submit']")).click();
			eleDisplayed2 = driver.findElement(By.xpath("//section[@id='main']//h2[.='Congratulation Tariff Plan assigned']")).isDisplayed();
			System.out.println("Expected text \'Congratulation Tariff Plan assigned\' is visible: " + eleDisplayed2);
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
	}
	
	public void backgroundPending() throws InterruptedException
	{
		this.driver = sfSelenium.getDriver();
		driver.get(pURL);													
		sfSelenium.clickLink("Telecom Project");							
		sfSelenium.clickLink("Add Customer");								
		sfSelenium.startReport("Read From PDF Report", "PDF Report");
		sfSelenium.createTest("Test Started: Read From PDF Report");
		
		//POPULATE VALID INPUT FIELDS
		driver.findElement(By.xpath("//label[@for='pending']")).click();
		sfSelenium.populateInputField(By.cssSelector("#fname"), "First name");
		sfSelenium.populateInputField(By.cssSelector("#lname"), "Last name");
		sfSelenium.populateInputField(By.cssSelector("#email"), "email@gmail.com");
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), "101 Hollywood Drive New York USA");
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "0791234567");
		
		//CLICK SUBMIT
		driver.findElement(By.xpath("//section[@id='main']//form[@action='insertcustomer.php']/div[@class='row uniform']//ul[@class='actions']//input[@name='submit']")).click();
		getUserID();
		
		try
		{
			//EXPECTED TEXT VISIBLE
			eleDisplayed = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//font[.='INACTIVE']")).isDisplayed();
			System.out.println("Expected text \'INACTIVE\' is visible: " + eleDisplayed);
			sfSelenium.createTest("Inactive text visible as expected");
			
			//SELECT TARIFF PLAN
			driver.findElement(By.xpath("//section[@id='main']//form[@action='inserttariffplantocustomer.php']//input[@name='submit']")).click();
			eleDisplayed2 = driver.findElement(By.xpath("//section[@id='main']//h2[.='Congratulation Tariff Plan assigned']")).isDisplayed();
			System.out.println("Expected text \'Congratulation Tariff Plan assigned\' is visible: " + eleDisplayed2);
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
	}
	
	public void getUserID() throws InterruptedException
	{
		String sCustomerID;
		Boolean bExpectedValue = true;
		Boolean bActualValue = false;
		
		sCustomerID = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(7) div.inner div.table-wrapper table.alt.access tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h3:nth-child(1)")).getText();
		if (sCustomerID.length() > 1) {
			bActualValue = true;
			System.out.println("Customer ID: " + sCustomerID);
			
		}
		Assert.assertEquals(bExpectedValue, bActualValue);
		sfSelenium.clickLink("Telecom Project");
		sfSelenium.clickLink("Add Tariff Plan to Customer");
		driver.findElement(By.cssSelector("#customer_id")).sendKeys(sCustomerID);
		driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		Thread.sleep(5000);
	}
	
	// Run Test Section
	@BeforeTest
	public void beforeClass() throws Exception {
		//INSERT TEXT HERE
	}
	
	@Test
	public void testOne() throws Exception {
		backgroundDone();
		System.out.println("Background check has been completed: Done");
	}
	
	@Test
	public void testTwo() throws Exception {
		backgroundPending();
		System.out.println("Background check has been completed: Pending");
	}
	
	@AfterTest
	public void afterTest() throws Exception {
		System.out.println("All tests has passed");
		sfSelenium.CloseSelenium();
	}
}
