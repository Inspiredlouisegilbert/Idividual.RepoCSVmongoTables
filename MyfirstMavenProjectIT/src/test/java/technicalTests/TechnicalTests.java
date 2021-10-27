package technicalTests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import assessmentPages.AssessmentUtilities;
import assessmentPages.assessmentLandingPage;
import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;
import technicalPages.TechnicalLandingPage;


public class TechnicalTests {
	
	// Declare an object of classes and instantiate class objects
	TechnicalLandingPage techLanding = new TechnicalLandingPage();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	String pURL = "http://automationpractice.com/index.php";
	
//	@Test (priority=1)
//    public void aUse_utilities() {
//		String browserValue = clUtilities.getDataConfigProperties("browser");
//		Reporter.log("aaaaThe browser we are using is "+browserValue);
//	}
	
	@Test
	public void GIVEN_LandingPage_WHEN_ProductSearch_THEN_AddToCart() throws InterruptedException, IOException
	{
		techLanding.landingpage();
		System.out.println("Test passed: ");
	}
	
//	@Test
	public void GIVEN_CartTotalChecks_WHEN_GreaterThan100_THEN_ContinueShopping() throws InterruptedException, IOException
	{

	}
	
//	@Test
	public void lowStock() throws InterruptedException, IOException
	{

	}
	
  @AfterTest
  public void afterTest() throws Exception {
//	  TelecomAddCustomer.testOne();
//	  TelecomAddCustomer.testTwo();
	  sfSelenium.CloseSelenium();
  }
}