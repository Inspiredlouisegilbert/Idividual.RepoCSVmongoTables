package newToursTests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import refactoredTelcoPagesEon.TelecomAddCustomer;

public class testsNewToursSearch {

	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	String pURL = "http://demo.guru99.com/V1/index.php";
	
	@Test
	public void testsOne() throws InterruptedException
	{

	}
	
	@Test
	public void testTwo() throws InterruptedException, IOException
	{

	}
	
  @AfterTest
  public void afterTest() throws Exception {
//	  TelecomAddCustomer.testOne();
//	  TelecomAddCustomer.testTwo();
	  sfSelenium.CloseSelenium();
  }
}