package Nyeleti_Continue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import frameworkclasses.BasePage;
import pages.AddCustomerPage;
import pages.CustomerIDPage;
import pages.Guru99Telcom_LandingPage;
import pages.LandingPage;
import pages.SignInPage;


public class Nyels_Assignment1 {
	
	
	// Declare an object of classes and
	// Instantiate class objects
            
	LandingPage landingPage = new LandingPage();     
	Gurulanding_page Gurulanding_page = new Gurulanding_page();
	NyAddCustomerPage AddCustomer = new NyAddCustomerPage();
	NyCustomerIDPage CustomerID = new NyCustomerIDPage ();
	//ProductSearchPage pr = new ProductSearchPage();

		
	//Ask Louise for help on this not sure if its done right
	
	
    //Navigate to http://demo.guru99.com/telecom/index.html
    public void navigate_to_URL() {
    	Gurulanding_page.Navigate_to_URL();
	
	}
				
		
	//Select Add Customer
		
	public void Add_customer_Link() {
		Gurulanding_page.Add_customer_Link();
	
	}
	
	@Test
		
	//Assert  Add Customer Heading
	public void Verify_Addcust_Heading1() throws InterruptedException {
		navigate_to_URL();
		Add_customer_Link();
		
	String ExpectedMessage = "Add Customer";
	String ActualMessage = Gurulanding_page.Verify_Addcust_Heading();
		
	Reporter.log("expected ------------------"+ExpectedMessage);
	Reporter.log("actual --------------------"+ActualMessage);
	Assert.assertEquals(ActualMessage, ExpectedMessage ); 
	
    String expectedTitle = "Guru99 telecom";
    String actualTitle = Gurulanding_page.Guru99_Telcom_Heading();
     
    Reporter.log("expected ------------------"+expectedTitle);
    Reporter.log("actual --------------------"+actualTitle);
    Assert.assertEquals(actualTitle, expectedTitle ); 
    
    //wait
	Thread.sleep(5000);
	}
	
@Test
	 
		public void  Testcase1_GIVEN_invalid_data_entered_THEN_warning_message_displayed() throws InterruptedException {
	
	    navigate_to_URL();
	    Add_customer_Link();
	    //wait
	
	//Populate the billing details with the INVALID Data
		String sfname= "Nyeleti";
		String slname = "Chauke";
		String semailid = "123@gmail.com";
		String saddr= "!#@### Smit steet";
		String stelephoneno= "0242353454";
		
		// Click on background check "Done"
		AddCustomer.Given_Done_radio_Option_button();
			
		//call a method to populate the fields
		AddCustomer.GIVEN_populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
		 //wait
		Thread.sleep(5000);
		
				
		String pExpectedMessage = "Special characters are not allowed";
		String pActualMessage = AddCustomer.verifySpeacialChr_warning_message();
			
		Reporter.log("expected ------------------"+pExpectedMessage);
	    Reporter.log("actual --------------------"+pActualMessage);
	    Assert.assertEquals(pActualMessage, pExpectedMessage );      
	    
		}

@Test
			
		public void  Testcase2_GIVEN_invalid_data_entered_WHEN_Submit_button_is_pressed_THEN_alert () throws InterruptedException {
			
		    navigate_to_URL();
		    Add_customer_Link();
		    //wait
			//Populate the billing details with the INVALID Data
				String sfname= "Nyeleti";
				String slname = "Chauke";
				String semailid = "123@gmail.com";
				String saddr= "!#@### Smit steet";
				String stelephoneno= "0242353454";
				
				// Click on background check "Done"
				AddCustomer.Given_Done_radio_Option_button();
					
				//call a method to populate the fields
				AddCustomer.GIVEN_populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
				
				//Call a method to click submit button
				AddCustomer.Given_Submit_button_isClicked();
											
				String pExpectedMessage = "please fill all fields";
				String pActualMessage = AddCustomer.Given_Invalid_Data_When_submit_Button_IsPresedOn_Then_Alert();
					
				Reporter.log("expected ------------------"+pExpectedMessage);
			    Reporter.log("actual --------------------"+pActualMessage);
			    Assert.assertEquals(pActualMessage, pExpectedMessage );
			    
			    //Call method to click ok on the pop-up
				AddCustomer.Click_OK_button_on_the_popo_up();
				   //wait
			   
		}
		
		
        @Test
        		
		public void  TestCase3_GIVEN_valid_data_entered_WHEN_Submit_button_is_pressed_THEN_id_displayed () throws InterruptedException {
	
		    navigate_to_URL();
		    Add_customer_Link();
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
		String ActualMessage = CustomerID.verify_AccessDetails_to_Guru99_Telecomn();
		
		//CustomerID.verifyCustomerID_Heading();	
		
		Reporter.log("expected ------------------"+ExpectedMessage);
	    Reporter.log("actual --------------------"+ActualMessage);
	    Assert.assertEquals(ActualMessage, ExpectedMessage );
	    

	 	boolean sCustID = CustomerID.Generated_Customer_ID();
	 	//String ActualMessage = CustomerID.verifyCustomerID_Heading();
	 			      
	    Reporter.log("expected Customer ID is displayed");
	    Reporter.log("actual --------------------"+sCustID);
	    Assert.assertEquals(sCustID, true);
	    
		}

}
