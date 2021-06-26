package Refactored;

import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import refactoredTelcoPagesEon.TelecomAddTariffPlan;
import refactoredTelcoPagesEon.TelecomPayBilling;
import refactoredTelcoPagesEon.TelecomReadFromFile;

import java.io.IOException;

import org.testng.annotations.AfterTest;

public class testsAssignment5 {
	
	TelecomReadFromFile readFromFile = new TelecomReadFromFile();
	TelecomAddTariffPlan addTariffPlan = new TelecomAddTariffPlan();
	TelecomPayBilling payBilling = new TelecomPayBilling();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	
  @Test
  public void Readfromfile() throws InterruptedException, IOException
  {
	  readFromFile.navigatetourl();
	  readFromFile.readfromfile();
  }

  
  @AfterTest
  public void afterTest() throws IOException {
	  sfSelenium.CloseSelenium();
  }
}