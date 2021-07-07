package Assignments;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import frameworkclasses.ReusableFunctions;

public class assignment3 extends driverSetup{
	//Instantiate Selenium Functions
	ReusableFunctions sfSelenium = new ReusableFunctions();
	assignment1 clAssignment1 = new assignment1();
	assignment2 clAssignment2 = new assignment2();
	
	String sBackgroundCheck ="Done";
	
	public void SelectPayBilling() throws Exception {
		//navigate to URL
		clAssignment1.Setup();
		
		//select pay billing and assert that the heading is correct
		driver.findElement(By.cssSelector("section.wrapper:nth-child(4) div.inner.flex.flex-3 div.flex-item.right:nth-child(3) div:nth-child(2) h3:nth-child(1) > a:nth-child(1)")).click();
		String sHeadingTxt = driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner header.align-center:nth-child(1) > h1:nth-child(1)")).getText();
		Reporter.log("expected ------------------"+ "Pay Billing");
	    Reporter.log("actual --------------------"+ sHeadingTxt);
		Assert.assertEquals("Pay Billing", sHeadingTxt);
	}
	
	public void WHEN_submit_THEN_CustomerID_Displayed(String pValidation) throws Exception {
		//instantiate variables
		String sCustomerID;
		String sActualValue;
		String sExpectedValue;
		
		//call AddCustomer 
		clAssignment1.AddCustomer(sBackgroundCheck);
		
		//navigate to pay billing
		clAssignment1.Setup();
		SelectPayBilling();
		
		//reads Customer ID from file
		sCustomerID = clAssignment2.ReadCustomerIDFromFile();
		
		//populate Customer ID and submit
		clAssignment2.SubmitCustomerID(sCustomerID);
		
		//Wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
		
		//assert the CustomerID or CustomerName
		if (pValidation.equals("CustomerID")) {
			sExpectedValue = "Customer ID:- " + sCustomerID;
			sActualValue = driver.findElement(By.tagName("h3")).getText();
			sActualValue = sActualValue.substring(0, 20);
			Reporter.log("expected ------------------"+ sExpectedValue);
		    Reporter.log("actual --------------------"+ sActualValue);
			Assert.assertEquals(sExpectedValue, sActualValue);
			Thread.sleep(500);	
		}
		else {
			sExpectedValue = "Customer Name:- valid";
			sActualValue = driver.findElement(By.tagName("h3")).getText();
			sActualValue = sActualValue.substring(sActualValue.length() -21);
			Reporter.log("expected ------------------"+ sExpectedValue);
		    Reporter.log("actual --------------------"+ sActualValue);
			Assert.assertEquals(sExpectedValue, sActualValue);
			Thread.sleep(500);	
		}
		}
	
	public void CheckTariffPlanAmount() {
		//instantiate variables
		int iLocalMinutes;
		int iInternationalMinutes;
		int iSMSPack;
		int iUsageCharges;
		
		//set the variable values
		iUsageCharges = Integer.parseInt(driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(5) table.alt tbody:nth-child(2) tr:nth-child(5) td:nth-child(2) > b:nth-child(1)")).getText());
		iLocalMinutes = Integer.parseInt(driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(5) table.alt tbody:nth-child(2) tr:nth-child(1) > td:nth-child(5)")).getText());
		iInternationalMinutes = Integer.parseInt(driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(5) table.alt tbody:nth-child(2) tr:nth-child(2) td:nth-child(5) > b:nth-child(1)")).getText());
		iSMSPack = Integer.parseInt(driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(5) table.alt tbody:nth-child(2) tr:nth-child(3) td:nth-child(5) > b:nth-child(1)")).getText());
		
		//Check that the Charges add up
		int temp = iLocalMinutes + iInternationalMinutes + iSMSPack;
		Reporter.log("expected ------------------"+ iUsageCharges);
	    Reporter.log("actual --------------------"+ temp);
		Assert.assertEquals(iUsageCharges, iLocalMinutes + iInternationalMinutes + iSMSPack);
	}
	
	public void CheckTotalAmount() {
		//instantiate variables
		int iTariffPlanAmount;
		int iUsageCharges;
		int iTotalBill;
		
		//set the variable values
		iUsageCharges = Integer.parseInt(driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(5) table.alt tbody:nth-child(2) tr:nth-child(5) td:nth-child(2) > b:nth-child(1)")).getText());
		iTariffPlanAmount = Integer.parseInt(driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(5) table.alt tbody:nth-child(2) tr:nth-child(4) td:nth-child(2) > b:nth-child(1)")).getText());
		iTotalBill = Integer.parseInt(driver.findElement(By.cssSelector("body.subpage:nth-child(2) section.wrapper:nth-child(6) div.inner div.table-wrapper:nth-child(5) table.alt tbody:nth-child(2) tr:nth-child(6) td:nth-child(2) > b:nth-child(1)")).getText());
	
		//Check that the Total adds up
		int temp = iUsageCharges + iTariffPlanAmount;
		Reporter.log("expected ------------------"+ iTotalBill);
	    Reporter.log("actual --------------------"+ temp);
		Assert.assertEquals(iTotalBill, iUsageCharges + iTariffPlanAmount);
	}
	
	public void StoreBillingInfo() throws IOException {

		//write table data to file
		FileWriter myWriter = new FileWriter("StoreBillingInfo.csv");
	    myWriter.write(driver.findElement(By.cssSelector("tbody")).getText());
	    myWriter.close();
	}
}
