package TelcoProjects;

import static org.testng.Assert.fail;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;

public class TelcoProjectTstNGThree {
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
		sfSelenium.populateInputField(By.cssSelector("#fname"), "Eon");
		sfSelenium.populateInputField(By.cssSelector("#lname"), "Kruger");
		sfSelenium.populateInputField(By.cssSelector("#email"), "email@gmail.com");
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), "101 Hollywood Drive New York USA");
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "0791234567");
		
		//CLICK SUBMIT
		driver.findElement(By.xpath("//section[@id='main']//form[@action='insertcustomer.php']/div[@class='row uniform']//ul[@class='actions']//input[@name='submit']")).click();
		getUserID();
		//getClientName();
		
		try
		{
//			String path = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner > h3:nth-child(2)")).getText();
//			if (path.length() > 30)
//				path = path.substring(0,130);
//			System.out.println(path);
//			String segments[] = path.split("-");
//			String document = segments[segments.length-1];
//			System.out.println("Stripped client ID is: " + document);
			
			//EXPECTED TEXT VISIBLE
			eleDisplayed = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Pay Billing']")).isDisplayed();
			System.out.println("Expected text \'Pay Billing\' is visible: " + eleDisplayed);
			sfSelenium.createTest("Active text visible as expected");
			
			//ROW4 COLUMN 2 VALLUE IS 500
			WebElement getTariffPlanAmount = driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));
			System.out.println("Tariff Plan Amount: " + getTariffPlanAmount.getText());
			
			//ROW5 COLUMN 2 VALLUE IS 250
			WebElement getUsageCharges = driver.findElement(By.xpath("//tbody/tr[5]/td[2]"));
			System.out.println("Usage Charges: " + getUsageCharges.getText());
			
			//ROW6 COLUMN 2 VALLUE IS 750
			WebElement getTotalBill = driver.findElement(By.xpath("//tbody/tr[6]/td[2]"));
			System.out.println("Usage Charges: " + getTotalBill.getText());
			
			convertToInt();

		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
	}
	
	public void convertToInt()
	{
		String sTariffPlanAmount = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText().toString();
		String susageCharges = driver.findElement(By.xpath("//tbody/tr[5]/td[2]")).getText().toString();
		String sTotalCharges = driver.findElement(By.xpath("//tbody/tr[6]/td[2]")).getText().toString();
		
		try
		{
			int ivalueone = Integer.parseInt(sTariffPlanAmount.trim());
			int ivaluetwo = Integer.parseInt(susageCharges.trim());
			int ivaluetthree = Integer.parseInt(sTotalCharges.trim());
			int icombined = ivalueone + ivaluetwo;
			
			System.out.println("Tariff plan amount is " + ivalueone);
			System.out.println("Usage charges is " + ivaluetwo);
			System.out.println("Usage charges is " + ivaluetthree);
			System.out.println("Sum is " + icombined);
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
		sfSelenium.populateInputField(By.cssSelector("#fname"), "Eon");
		sfSelenium.populateInputField(By.cssSelector("#lname"), "Kruger");
		sfSelenium.populateInputField(By.cssSelector("#email"), "email@gmail.com");
		sfSelenium.populateInputField(By.xpath("/html[1]/body[1]/section[1]/div[1]/form[1]/div[1]/div[7]/textarea[1]"), "101 Hollywood Drive New York USA");
		sfSelenium.populateInputField(By.cssSelector("#telephoneno"), "0791234567");
		
		//CLICK SUBMIT
		driver.findElement(By.xpath("//section[@id='main']//form[@action='insertcustomer.php']/div[@class='row uniform']//ul[@class='actions']//input[@name='submit']")).click();
		getUserID();
		//getClientName();
		
		try
		{
			//EXPECTED TEXT VISIBLE
			eleDisplayed = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Pay Billing']")).isDisplayed();
			System.out.println("Expected text \'Pay Billing\' is visible: " + eleDisplayed);
			sfSelenium.createTest("Active text visible as expected");
			
			//ROW4 COLUMN 2 VALLUE IS 500
			WebElement getTariffPlanAmount = driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));
			System.out.println("Tariff Plan Amount: " + getTariffPlanAmount.getText());
			
			//ROW5 COLUMN 2 VALLUE IS 250
			WebElement getUsageCharges = driver.findElement(By.xpath("//tbody/tr[5]/td[2]"));
			System.out.println("Usage Charges: " + getUsageCharges.getText());
			
			convertToInt();

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
			System.out.println("Actual Customer ID: " + sCustomerID);
			System.out.println("Expected Customer ID: " + sCustomerID);
			getClientName();
		}
		Assert.assertEquals(bExpectedValue, bActualValue);
		sfSelenium.clickLink("Telecom Project");
		sfSelenium.clickLink("Pay Billing");
		driver.findElement(By.cssSelector("#customer_id")).sendKeys(sCustomerID);
		driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='billing.php']//input[@name='submit']")).click();
		Thread.sleep(5000);
	}
	
	public void getClientName()
	{
//		String sstrippedclientname = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(7) div.inner div.table-wrapper table.alt.access tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h3:nth-child(1)")).getText();
//		sstrippedclientname = sstrippedclientname.substring(sstrippedclientname.lastIndexOf(" ")+1);
//		System.out.println("Client Name is: " + sstrippedclientname);
		
//		String myString = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(7) div.inner div.table-wrapper table.alt.access tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h3:nth-child(1)")).getText();;
//		String[] splitString = myString.split(":- ");
//
//		for (String s : splitString) {
//		    System.out.println(s);
//		}
		
//		sstrippedclientname = sstrippedclientname.substring(sstrippedclientname.lastIndexOf(":- ")+1);
//		System.out.println(sstrippedclientname.substring(sstrippedclientname.lastIndexOf(":- ") + 1).trim());
//		System.out.println(sstrippedclientname.substring(sstrippedclientname.lastIndexOf(" ") + 2));
//		sstrippedclientname.substring(sstrippedclientname.indexOf(":- ") + 3 , sstrippedclientname.length());
//		System.out.println("Customer Name ATTEMPT: " + sstrippedclientname);
//		System.out.println("Customer Name extracted: " + sstrippedclientname);
	
		String myString = "Customer ID:- 661431               Customer Name:- Thisismylongname";
		int vFirst = myString.indexOf("Customer");
		int vSecond = myString.indexOf("Customer", myString.indexOf("Customer") + 1);
		String vFirstStr = myString.substring(vFirst, vSecond);
		String vSecondStr = myString.substring(vSecond);
		String[] vSplitFirst = vFirstStr.split(":- ");
		String[] vSplitSecondSpl = vSecondStr.split(":- ");
		System.out.println(vSplitFirst[0].trim() + " - " + vSplitFirst[1].trim());
		System.out.println(vSplitSecondSpl[0].trim() + " - "+ vSplitSecondSpl[1].trim());
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
