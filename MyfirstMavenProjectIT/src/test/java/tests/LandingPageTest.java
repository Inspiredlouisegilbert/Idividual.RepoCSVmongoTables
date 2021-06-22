package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import pages.AddCustomerPage;
import pages.Guru99Telcom_LandingPage;
import pages.HomePage;
import pages.LandingPage;
//import pages.ProductSearchPage;
import pages.SignInPage;


public class LandingPageTest {
	
	// Declare an object of classes and
	// Instantiate class objects
	SignInPage inPage = new SignInPage();              
	LandingPage landingPage = new LandingPage();     
	Guru99Telcom_LandingPage GuruLanding = new Guru99Telcom_LandingPage();
	AddCustomerPage AddCustomer = new AddCustomerPage();
	
	//ProductSearchPage pr = new ProductSearchPage();
	HomePage homePage = new HomePage();
	
	//@Test
    public void GIVEN_navigateToURL_THEN_TitleMyStore() {
        String expectedTitle = "My Store";
        String actualTitle = landingPage.getTitle();
         
        Reporter.log("expected ------------------"+expectedTitle);
        Reporter.log("actual --------------------"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle ); 
        
	}
	

	
	//Copied from Add customer page
	
		
	/*
	 * // function to populate an input field using multiple By clauses
	 * 
	 * public void populateInputField(By byClause, String inputValue) {
	 * driver.findElement(byClause).sendKeys(inputValue); //*********** Question= do
	 * we need to use driver.find in a test? }
	 */
	
	/*
	 * //Populate the billing details public void GIVEN_populate_biling_data(String
	 * sfname,String slname, String semailid,String saddr,String stelephoneno ) {
	 * 
	 * populateInputField(By.name("fname"),sfname);
	 * populateInputField(By.name("lname"),slname);
	 * populateInputField(By.name("emailid"),semailid);
	 * populateInputField(By.name("addr"),saddr);
	 * populateInputField(By.name("telephoneno"),stelephoneno);
	 * 
	 * }
	 */

		
		@Test
		
		public void  Given_Invalid_Data_Populate_inputfields_for_billing() throws InterruptedException {
	//Populate the billing details with the INVALID Data
		String sfname= "Nyeleti";
		String slname = "Chauke";
		String semailid = "123@gmail.com";
		String saddr= "!#@### Smit steet";
		String stelephoneno= "0242353454";
			
			//call a method to populate the fields
		AddCustomer.GIVEN_populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
		
		AddCustomer.Given_Submit_button_isClicked();
		   //wait
			Thread.sleep(5000);
			
		String pExpectedMessage = "please fill all fields";
		String pActualMessage = AddCustomer.Given_Invalid_Data_When_submit_Button_IsPresedOn_Then_Alert();
			
		Reporter.log("expected ------------------"+pExpectedMessage);
	    Reporter.log("actual --------------------"+pActualMessage);
	    Assert.assertEquals(pActualMessage, pExpectedMessage );
	    
		
		}
		
		@Test
		
		public void  Given_Valid_Data_Populate_inputfields_for_billing() {
	//Populate the billing details with the INVALID Data
			String sfname= "Nyeleti";
			String slname = "Chauke";
			String semailid = "123@gmail.com";
			String saddr= "Smit steet";
			String stelephoneno= "0242353454";
			
			//call a method to populate the fields
			Given_Valid_Data_Populate_inputfields_for_billing(sfname,slname,semailid,saddr,stelephoneno);
			//wait
			Thread.sleep(5000);
			
		
		}
	
	@Test 
	public void navigateToGuru99TelcomLandingPage () {
		
		GuruLanding.navigateToGuru99LandingPage();
		
		GuruLanding.getTitle();
		 String expectedTitle = "Guru99 Telecom";
	     String actualTitle = landingPage.getTitle();
	     
	     Reporter.log("expected ------------------"+expectedTitle);
	     Reporter.log("actual --------------------"+actualTitle);
	     Assert.assertEquals(actualTitle, expectedTitle ); 
	}
	
	
	
	
	@Test
    public void GIVEN_navigateToURL_WHEN_searchProduct_THEN_ProductDisplayed() {

       // landingPage.searchProduct();
        String expected = "Printed Summer Dress";
       // String actual = pr.getProductSearchResult();
        
        Reporter.log("expected ------------------"+expected);
       // Reporter.log("actual --------------------"+actual);
       // Assert.assertEquals(actual, expected); 
	}
        
	//@Test
	public void GIVEN_navigateToURL_WHEN_CorrectLogin_THEN_LoginSuccessful() {


          inPage.userSignIn("abc11001@xyz.com", "abcxyz");
          
            boolean expected = true;
            boolean actual = homePage.verifyCorrectLogin().equals("abc xyz");
            
            Reporter.log("expected ------------------"+expected);
            Reporter.log("actual --------------------"+actual);
            Assert.assertEquals(actual, expected);
        }
	
	//@Test
	public void GIVEN_navigateToURL_WHEN_InCorrectLogin_THEN_LoginUnSuccessful() {


          inPage.userSignIn("abc11001@xyz.com", "abcxyz");
         

            
            boolean expected = true;
            boolean actual = inPage.verifyInCorrectLogin().equals("AUTHENTICATION");
            
            Reporter.log("expected to find the AUTHENTICATION error "+expected);
            Reporter.log("actual --------------------"+actual);
            Assert.assertEquals(actual, expected);
        }
	
	//@Test
    public void GIVEN_navigateToURL_THEN_ExpectedTofail() {
        String expectedTitle = "My St";
        Reporter.log("expected ------------------"+expectedTitle);
        String actualTitle = landingPage.getTitle();
        
        
        Reporter.log("actual --------------------"+actualTitle);
        Assert.assertEquals(expectedTitle, actualTitle);   
        
	}
	
	@Parameters({"xyz"})
	//@Test
    public void Use_Parameters_from_testng_XML_file(String xyz) {
		Reporter.log("This parameter comes from the testNG xml file: "+xyz);
	}
	
	//@Test  
    public void Use_utilities() {
		String browserValue = landingPage.getDataConfigProperties("browser");
		Reporter.log("The browser we are using is "+browserValue);
	}

	@AfterSuite
    public void cleanup() {
         
        //Instantiate SignInPage class object
        SignInPage inPage = new SignInPage();
        inPage.cleanUp();
    }     
}