package Refactored;

import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import refactoredTelcoPagesEon.TelecomAddTariffPlan;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class testsAssignment2 {
	
	TelecomAddTariffPlan addTariffPlan = new TelecomAddTariffPlan();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	String pURL = "http://demo.guru99.com/V1/index.php";
	
  @Test
  public void testsBackgroundCheckDone() throws InterruptedException
  {
	addTariffPlan.backgroundDone();
	System.out.println("Background check DONE has been completed: Done");
	System.out.println("Tariff plan has been successfully added");
  }
  
  @Test
  public void testsBackgroundCheckPending() throws InterruptedException
  {
	addTariffPlan.backgroundPending();
	System.out.println("Background check PENDING has been completed: Done");
	System.out.println("Tariff plan has been successfully added");
  }
  
  @AfterTest
  public void afterTest() throws IOException {
	  sfSelenium.CloseSelenium();
  }
}