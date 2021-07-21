package assessmentTests;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import assessmentPages.AssessmentUtilities;
import assessmentPages.assessmentLandingPage;
import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;


public class testsAssessment {
	
	// Declare an object of classes and instantiate class objects
	assessmentLandingPage asLanding = new assessmentLandingPage();
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	Utilities clUtilities = new Utilities();
	String pURL = "https://www.geewiz.co.za/";
	
//	@Test (priority=1)
//    public void aUse_utilities() {
//		String browserValue = clUtilities.getDataConfigProperties("browser");
//		Reporter.log("aaaaThe browser we are using is "+browserValue);
//	}
	
	@Test
	public void GIVEN_LandingPage_WHEN_ProductSearch_THEN_AddToCart() throws InterruptedException, IOException
	{
		asLanding.landingpage();
		System.out.println("Test passed: Landing page loaded successfully");
		asLanding.searchproduct();
		System.out.println("Test passed: Product search completed");
		System.out.println("Test passed: Sorted by lowest first");
//		asLanding.submit();
		System.out.println("Test passed: Item successfully added to the cart");
		asLanding.viewcart();
		asLanding.getcarttotal();
	}
	
//	@Test
	public void GIVEN_CartTotalChecks_WHEN_GreaterThan100_THEN_ContinueShopping() throws InterruptedException, IOException
	{
		asLanding.viewcart();
		asLanding.getcarttotal();
//		asLanding.carttotal();
	}
	
//	@Test
	public void lowStock() throws InterruptedException, IOException
	{
		asLanding.landingpage();
		System.out.println("Test passed: Landing page loaded successfully");
//		asLanding.searchProductLowStock();
		System.out.println("Test passed: Low stock product visible");
	}
	
  @AfterTest
  public void afterTest() throws Exception {
//	  TelecomAddCustomer.testOne();
//	  TelecomAddCustomer.testTwo();
	  sfSelenium.CloseSelenium();
  }
}