package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import pages.AddCustomerPage;
import pages.CustomerIDPage;
import pages.Guru99Telcom_LandingPage;
import pages.HomePage;
import pages.LandingPage;
//import pages.ProductSearchPage;
import pages.SignInPage;


public class LandingPageTest {
	
	// Declare an object of classes and
	// Instantiate class objects
	//SignInPage inPage = new SignInPage();              
	//LandingPage landingPage = new LandingPage();     
	Guru99Telcom_LandingPage GuruLanding = new Guru99Telcom_LandingPage();
	AddCustomerPage AddCustomer = new AddCustomerPage();
	CustomerIDPage CustomerID = new CustomerIDPage ();
	HomePage homePage = new HomePage();
	
 //@Test
    
    public void navigateTo_URL() {
    	
		String URL = "http://demo.guru99.com/telecom/index.html";
    }
    
 //@Test
    public void Add_Customer_Link() {
    	//call a method to click the Add Customer link
    	GuruLanding.ClickAddCustomer_Link();
    	
    }
    
@Test
    public void GIVEN_navigateToURL_THEN_AddCutomer() {
    	
    	//call a method to navigate to url
    	//navigateTo_URL();
    	
    	GuruLanding.getTitle();
    	
    	// Verify that Guru99 telecom Heading is available //
    	String expectedTitle = "Guru99 telecom";
        String actualTitle = GuruLanding.verifyTelcomLandingPage();
         
        Reporter.log("expected ------------------"+expectedTitle);
        Reporter.log("actual --------------------"+actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle );        				  
		
    }
    
    
 // @Test
    public  void verifyAddCustomer() {
    	//call a method to click the Add Customer link
    	GuruLanding.ClickAddCustomer_Link();
    	
	  //Verify that Add Customer Heading is available //
    	String expectedLink = "Add Customer";
	 	String actuaLink = GuruLanding.veriy_AddCustomer_Link(); 
	 	
	 	Reporter.log("expected ------------------"+expectedLink);
        Reporter.log("actual --------------------"+actuaLink);
        Assert.assertEquals(actuaLink, expectedLink );
    }
     
    
//@Test
	public void  Given_Invalid_Data_Populate_inputfields_for_billing() throws InterruptedException {
	//Populate the billing details with the INVALID Data
		String sfname= "Nyeleti";
		String slname = "Chauke";
		String semailid = "123@gmail.com";
		String saddr= "!#@### Smit steet";
		String stelephoneno= "0242353454";
			
			//call a method to populate the fields
		AddCustomer.GIVEN_populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
		
		//Call a method to click submit button
		AddCustomer.Given_Submit_button_isClicked();
		   //wait
			Thread.sleep(5000);
			
		String pExpectedMessage = "please fill all fields";
		String pActualMessage = AddCustomer.Given_Invalid_Data_When_submit_Button_IsPresedOn_Then_Alert();
			
		Reporter.log("expected ------------------"+pExpectedMessage);
	    Reporter.log("actual --------------------"+pActualMessage);
	    Assert.assertEquals(pActualMessage, pExpectedMessage );
	    
	    //Call method to click ok on the pop-up
	    AddCustomer.Click_OK_button_on_the_popo_up();
	          
	    
		}
			

//@Test
		public void  Given_Valid_Data_Populate_inputfields_for_billing() throws InterruptedException {
	
		// Call a method to click rest button
		AddCustomer.Given_Reset_button_isClicked();
	
		//Call a method to click Done option
		AddCustomer.Given_Done_radio_Option_button();
		
		//Populate the billing details with the VALID Data
		String sfname= "Nyeleti";
		String slname = "Chauke";
		String semailid = "123@gmail.com";
		String saddr= "Smit steet";
		String stelephoneno= "0242353454";
			
		//call a method to populate the fields
		AddCustomer.GIVEN_populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
		
		//Call a method to click submit button
		AddCustomer.Given_Submit_button_isClicked();
		  //wait
		Thread.sleep(5000);
			
	    // Verify that the Customer ID Page is displayed  
		String ExpectedMessage = "Access Details to Guru99 Telecom";
		String ActualMessage = CustomerID.verifyCustomerID_Heading();
		
		//CustomerID.verifyCustomerID_Heading();	
		
		Reporter.log("expected ------------------"+ExpectedMessage);
	    Reporter.log("actual --------------------"+ActualMessage);
	    Assert.assertEquals(ActualMessage, ExpectedMessage );
	    
	    //Reporter.log("The expected result is "+"Access Details to Guru99 Telecom");
	        
	    // Verify that the Customer ID Page is displayed  
	 	boolean sCustID = CustomerID.Generated_Customer_ID();
	 	//String ActualMessage = CustomerID.verifyCustomerID_Heading();
	 			      
	    Reporter.log("expected Customer ID is displayed");
	    Reporter.log("actual --------------------"+sCustID);
	    Assert.assertEquals(sCustID, true);
	    
	    //Call method to click Ok on the pop-up
	    //AddCustomer.Click_OK_button_on_the_popo_up();
	    
		}
	
		
		//@Test
		public void GIVEN_active_customer_WHEN_submit_THEN_active_is_displayed () throws InterruptedException {
	
			//String actualSlength = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).getText();	
			// Fix line 135 and 136 below
			String Cust_ID = CustomerID.Generated_Cust_ID();
			System.out.println(Cust_ID);
	
	
		}


		// @Test

		public void  Click_Home_button_CustomerIDPage() throws InterruptedException {

		// Call a method to click rest button
		CustomerID.Click_Home_button_CustomerIDPage();

		Thread.sleep(5000);

		// Verify that Guru99TelcomPage is displayed  
		String pExpectedMessage = " Guru99 telecom";
		String pActualMessage = GuruLanding.verifyTelcomLandingPage();
 
			
		Reporter.log("expected ------------------"+pExpectedMessage);
	    Reporter.log("actual --------------------"+pActualMessage);
	    Assert.assertEquals(pActualMessage, pExpectedMessage );


}

		@AfterSuite
	    public void cleanup() {
	         
	        //Instantiate SignInPage class object
	        SignInPage inPage = new SignInPage();
	        inPage.cleanUp();
	    }     
	}




      
/*
 * //@Test public void
 * GIVEN_navigateToURL_WHEN_CorrectLogin_THEN_LoginSuccessful() {
 * 
 * 
 * inPage.userSignIn("abc11001@xyz.com", "abcxyz");
 * 
 * boolean expected = true; boolean actual = homePage.verifyCorrectLogin().equals("abc xyz");
 * 
 * Reporter.log("expected ------------------"+expected);
 * Reporter.log("actual --------------------"+actual);
 * Assert.assertEquals(actual, expected); }
 */
