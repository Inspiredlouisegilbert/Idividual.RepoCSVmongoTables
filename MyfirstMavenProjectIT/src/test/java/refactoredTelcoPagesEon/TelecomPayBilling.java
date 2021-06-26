package refactoredTelcoPagesEon;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class TelecomPayBilling extends BasePage{
	
	String pURL = "http://demo.guru99.com/V1/index.php";
	boolean eleDisplayed;
	boolean eleDisplayed2;
	SeleniumFunctions sfSelenium = new SeleniumFunctions();

	public void backgroundDone() throws InterruptedException, IOException
	{
		driver.get(pURL);													
		sfSelenium.clickLink("Telecom Project");							
		sfSelenium.clickLink("Add Customer");								

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
	}
	
	public void payBillingVisible()
	{
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
	
	public void getUserID() throws InterruptedException, IOException
	{
		String sCustomerID;
		Boolean bExpectedValue = true;
		Boolean bActualValue = false;
		
		sCustomerID = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(7) div.inner div.table-wrapper table.alt.access tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h3:nth-child(1)")).getText();
		if (sCustomerID.length() > 1) {
			bActualValue = true;

			System.out.println("Actual Customer ID: " + sCustomerID);
			System.out.println("Expected Customer ID: " + sCustomerID);
			
			FileWriter myWriter = new FileWriter("CustomerID.csv");
			myWriter.write(sCustomerID);
			myWriter.close();
			System.out.println("Client ID exported to file: " + "CustomerID.csv");
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
	
//		String myString = "Customer ID:- 661431               Customer Name:- Thisismylongname";
//		String myString = driver.findElement(By.tagName("h3")).getText();
//		System.out.println(myString);
//		String myString2 = driver.findElement(By.tagName("h3")).getText();
//		System.out.println(myString2);
	}
	
	public void exportToFile() throws IOException
	{
		//PERFORMED IN GETUISERID METHOD
		
//		String sCustomerID = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(7) div.inner div.table-wrapper table.alt.access tbody:nth-child(1) tr:nth-child(1) td:nth-child(2) > h3:nth-child(1)")).getText();
//		FileWriter myWriter = new FileWriter("CustomerID.csv");
//		myWriter.write(sCustomerID);
//		myWriter.close();
	}
}