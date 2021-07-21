package Nyeleti_Continue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.LandingPage;

public class ReadTofromAssignment5 {

	LandingPage landingPage = new LandingPage();     
	Gurulanding_page Gurulanding_page = new Gurulanding_page();
	NyAddCustomerPage AddCustomer = new NyAddCustomerPage();
	NyCustomerIDPage CustomerID = new NyCustomerIDPage ();
	ReadFromFile_Page ReadFromfile =new ReadFromFile_Page();
	
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
    
    
    AddCustomer.Given_Done_radio_Option_button();
        
    //wait
	Thread.sleep(5000);
	}
	
	public void  Testcase1_run_test_from_file() throws InterruptedException {
		
	//Populate the billing details with the INVALID Data
	
	   ReadFromfile.getDataConfigProperties(null);
	   
	    
		
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

	
}
