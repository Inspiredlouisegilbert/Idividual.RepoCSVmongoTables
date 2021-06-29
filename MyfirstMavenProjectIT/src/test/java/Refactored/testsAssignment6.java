package Refactored;

import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import refactoredTelcoPagesEon.TelecomAddTariffPlan;
import refactoredTelcoPagesEon.TelecomMaxFieldValues;
import refactoredTelcoPagesEon.TelecomPayBilling;
import refactoredTelcoPagesEon.TelecomReadFromFile;

import java.io.IOException;
import java.text.ParseException;

import org.testng.annotations.AfterTest;

public class testsAssignment6 {
	
	TelecomReadFromFile readFromFile = new TelecomReadFromFile();
	TelecomAddTariffPlan addTariffPlan = new TelecomAddTariffPlan();
	TelecomPayBilling payBilling = new TelecomPayBilling();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	TelecomMaxFieldValues clMaxFieldvalues = new TelecomMaxFieldValues();
	
  @Test
  public void getMaxvalues() throws InterruptedException, IOException, ParseException
  {
//	  clMaxFieldvalues.navigatetourl();
//	  clMaxFieldvalues.readfromfile();
//	  clMaxFieldvalues.captureID(null);
	  clMaxFieldvalues.getMaxvaluesMonthlyRentals();
	  clMaxFieldvalues.getMaxvaluesLocalMinutes();
	  clMaxFieldvalues.getMaxvaluesInternationalMinutes();
	  clMaxFieldvalues.getMaxvaluesSMSPack();
	  clMaxFieldvalues.getMaxvaluesPerLocalMinutesCharges();
	  clMaxFieldvalues.getMaxvaluesPerInternationalMinutesCharges();
	  clMaxFieldvalues.getMaxvaluesPerSMSCharge();
  }

  
  @AfterTest
  public void afterTest() throws IOException, InterruptedException {
	  sfSelenium.CloseSelenium();
  }
}