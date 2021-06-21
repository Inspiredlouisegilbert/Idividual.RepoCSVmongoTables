package Refactored;

import org.testng.annotations.Test;

import frameworkclasses.Utilities;
import refactoredTelcoPagesEon.TelecomAddCustomer;


public class testsAssignment1 {
	
	// Declare an object of classes and
	// Instantiate class objects
	TelecomAddCustomer addCustomer = new TelecomAddCustomer();
	Utilities clUtilities = new Utilities();
	
  @Test
  public void afterTest() throws Exception {
	  TelecomAddCustomer.testOne();
	  TelecomAddCustomer.testTwo();
  }
}