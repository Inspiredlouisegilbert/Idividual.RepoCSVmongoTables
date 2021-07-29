package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Nyeleti_Continue.TestData.NyAddCustomerPage;
import frameworkclasses.BasePage;
import pages.LandingPage;
import pages.NyCustomerIDPage;
import pages.ReadFromFile_Page;

public class Assignment5_readfrom_csv {

	//LandingPage landingPage = new LandingPage();     
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
    
	}
	
	@Test
	//createTest("Run Test: Read From File");
	public void runTestReadFromFile () throws IOException, InterruptedException {       
         // Input test Data
          String sfname = "";
          String slname = "";
          String semailid = "";
          String saddr = "";
          String stelephoneno ="";
          
          //this getDataConfigProperties("csvdir") it can be called from any of the pages.//
          // because the pages extends BasePage (function) and ...........................//
          // csvdir is parameter from the config.properties file..........................//
          String csvdir = AddCustomer.getDataConfigProperties("csvdir");
                        
         BufferedReader br = new BufferedReader(new FileReader(csvdir));

          String line;
          while ((line = br.readLine()) != null) { 

             if(line.length() > 0) {
            	 
             // use ; as separator.
             String[] cols = line.split(";");
             

             System.out.println(cols[0]);
             sfname = cols[0];
             slname = cols[1];
             semailid = cols[2];
             saddr = cols[3];
             stelephoneno = cols[4];
             
            // Navigate to the Add Customer
            navigate_to_URL();
     		Add_customer_Link();
     		
             // call a method to click on Done radio button
             AddCustomer.Given_Done_radio_Option_button();
                                
             //populate details
             //call a method to populate the fields
             AddCustomer.GIVEN_populate_biling_data(sfname,slname,semailid,saddr,stelephoneno);
             
           //Call a method to click submit button
			AddCustomer.Given_Submit_button_isClicked();
            Thread.sleep(300);
            
			try {
				  //  Block of code to try
	
			
			String pPopup = AddCustomer.Given_Invalid_Data_When_submit_Button_IsPresedOn_Then_Alert();
			if (pPopup != null) {
			
				String pExpectedMessage = "please fill all fields";
				String pActualMessage = pPopup;
					
				Reporter.log("expected ------------------"+pExpectedMessage);
			    Reporter.log("actual --------------------"+pActualMessage);
			    Assert.assertEquals(pActualMessage, pExpectedMessage );
			    
			    //Call method to click ok on the pop-up
				//AddCustomer.Click_OK_button_on_the_popo_up();
				
				// Call a method to click rest button
				AddCustomer.Given_Reset_button_isClicked();
				}
			
						
             }
			
			catch(Exception e) {
				  //  Block of code to handle errors
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
           }
            
		 }
	
	@AfterSuite
	
	public void cleanup() {
		AddCustomer.Cleanup();
	}
	
	
	
}
            
