package Refactored;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import refactoredTelcoPagesEon.TelecomAddCustomer;

public class testsAssignment1 {
	
	// Declare an object of classes and
	// Instantiate class objects
	TelecomAddCustomer addCustomer = new TelecomAddCustomer();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	String pURL = "http://demo.guru99.com/V1/index.php";
	
	@Test
	public void testsOne()
	{
//		sfSelenium.startReport("Telco  Project", "Generate invalid input data");
//		sfSelenium.createTest("Start Test");
		addCustomer.navigateToURL(pURL);
		addCustomer.clickBankProject();
		addCustomer.generateInvalidInputData();
		System.out.println("Invalid data test passed");
	}
	
	@Test
	public void testTwo() throws InterruptedException
	{
//		sfSelenium.startReport("Telco  Project", "Generate valid input data"); 
//		sfSelenium.createTest("Start Test");
		addCustomer.generatevalidInput();
		System.out.println("Valid data test passed");
		addCustomer.getUserID();
		System.out.println("Get User ID test passed");
	}
	
  @AfterTest
  public void afterTest() throws Exception {
//	  TelecomAddCustomer.testOne();
//	  TelecomAddCustomer.testTwo();
	  sfSelenium.CloseSelenium();
  }
}