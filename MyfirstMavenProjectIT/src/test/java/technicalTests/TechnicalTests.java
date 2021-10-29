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
	public void GIVEN_LandingPage_WHEN_ProductSearchTshirts_THEN_ValidateCategoryName() throws InterruptedException, IOException
	{
		techLanding.landingpage();
		System.out.println("Test passed: Menu navigation tests passed");
	}
	
	@Test
	public void GIVEN_ProductSearch_WHEN_PrintedDress_THEN_ValidateDisplayedResults() throws InterruptedException, IOException
	{
		techLanding.searchproduct();
		System.out.println("Test passed: Product search test passed");
	}
	
	@Test
	public void GIVEN_ProductSearch_WHEN_PrintedDress_THEN_ValidateDisplayedResultsNegativeTest() throws InterruptedException, IOException
	{
		techLanding.searchproductNegativeTest();
		System.out.println("Test passed: Negative test roduct search test passed");
	}
	
	@Test
	public void GIVEN_SendMessage_WHEN_Submit_THEN_validateSuccessMessage() throws InterruptedException, IOException
	{
		techLanding.ContactUs();
	}
	
	@Test
	public void GIVEN_Registration_WHEN_RegistrationCompleted_THEN_ValidateSuccess() throws InterruptedException, IOException
	{
		techLanding.registration();
	}
	
  @AfterTest
  public void afterTest() throws Exception {
//	  TelecomAddCustomer.testOne();
//	  TelecomAddCustomer.testTwo();
	  sfSelenium.CloseSelenium();
  }
}