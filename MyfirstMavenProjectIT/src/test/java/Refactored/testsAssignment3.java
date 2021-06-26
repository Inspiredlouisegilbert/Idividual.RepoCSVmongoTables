package Refactored;

import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import refactoredTelcoPagesEon.TelecomAddTariffPlan;
import refactoredTelcoPagesEon.TelecomPayBilling;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class testsAssignment3 {
	
	TelecomAddTariffPlan addTariffPlan = new TelecomAddTariffPlan();
	TelecomPayBilling payBilling = new TelecomPayBilling();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	String pURL = "http://demo.guru99.com/V1/index.php";
	
  @Test
  public void Given_AddCustomer_When_Submit_Then_CustomeridDisplayed() throws InterruptedException, IOException
  {
	  payBilling.backgroundDone();
  }
  
  @Test
  public void Given_AddCustomer_When_Submit_Then_CustomerNameDisplayed() throws InterruptedException
  {
	  payBilling.getClientName();
  }
  
//  @Test
  public void Given_AddCustomer_When_Submit_Then_TariffPlanAmountDisplayed() throws InterruptedException
  {
	  payBilling.payBillingVisible();
  }
  
//  @Test
  public void Given_AddCustomer_When_Submit_Then_TotalBillAmountDisplayed() throws InterruptedException
  {
	  payBilling.payBillingVisible();
  }
  
  @Test
  public void ExportToFile() throws InterruptedException, IOException
  {
	  payBilling.exportToFile();
  }
  
  @AfterTest
  public void afterTest() throws IOException {
	  sfSelenium.CloseSelenium();
  }
}