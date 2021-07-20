package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import pages.AddCustomerPage;
import pages.AddTariffPlanToCustomerPage;
import pages.CustomerIDPage;
import pages.Guru99Telcom_LandingPage;
import pages.HomePage;
import pages.LandingPage;
//import pages.ProductSearchPage;
import pages.SignInPage;


public class Assignment_2 {
	
	// Declare an object of classes and
	// Instantiate class objects
	SignInPage inPage = new SignInPage();              
	//LandingPage landingPage = new LandingPage();     
	Guru99Telcom_LandingPage GuruLanding = new Guru99Telcom_LandingPage();
	AddCustomerPage AddCustomer = new AddCustomerPage();
	AddTariffPlanToCustomerPage AddTariffPlan_To_Customer = new AddTariffPlanToCustomerPage();   
	CustomerIDPage CustomerID = new CustomerIDPage ();
	//ProductSearchPage pr = new ProductSearchPage();
	HomePage homePage = new HomePage();  

	//@Test
    //public void GIVEN_navigateToURL_THEN_TitleMyStore() {
       // String expectedTitle = "My Store";
        //String actualTitle = landingPage.getTitle();
         
        //Reporter.log("expected ------------------"+expectedTitle);
       // Reporter.log("actual --------------------"+actualTitle);
       // Assert.assertEquals(actualTitle, expectedTitle ); 
        
	//}
	
		
		@Test
	public void  Given_Valid_Data_Populate_inputfields_for_billing() throws InterruptedException {

			// Call a method to click rest button
			//AddCustomer.Given_Reset_button_isClicked();

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
			   			       
			// Asset for the Customer ID that keeps on Changing
			boolean sCustID = CustomerID.Generated_Customer_ID();
						     
			Reporter.log("expected Customer ID is displayed");
			Reporter.log("actual --------------------"+sCustID);
			Assert.assertEquals(sCustID, true);
			
			   
	}

		public void NavigateTo_LandingPage () {
			
	
	 // call a method to Click on Home button
	  CustomerID.Click_Home_button_CustomerIDPage();
	 
	}
		
		//Verify the correct Assersetion fo the Landingpage
	 /* // Verify that Guru99 telecom Heading is available // String expectedTitle =
	 * "Guru99 telecom"; String actualTitle =
	 * AddTariffPlan_To_Customer.verify_Guru99telecom_Logo(); //String actualTitle =
	 * landingPage.getTitle();
	 * 
	 * Reporter.log("expected ------------------"+expectedTitle);
	 * Reporter.log("actual --------------------"+actualTitle);
	 * Assert.assertEquals(actualTitle, expectedTitle );
	 * 
	 * }
	 * 
	 * public void VerifyTo_AddTariff_to_Customer () { // Verify that Add Tariff
	 * Plan To Customer link is available // String expectedTitle =
	 * "Add Tariff Plan To Customer"; String actualTitle =
	 * AddTariffPlan_To_Customer.verify_Add_Tariff_PLan_to_Customer_Header();
	 * //String actualTitle = landingPage.getTitle();
	 * 
	 * Reporter.log("expected ------------------"+expectedTitle);
	 * Reporter.log("actual --------------------"+actualTitle);
	 * Assert.assertEquals(actualTitle, expectedTitle );
	 * 
	 * }
	 */
		
		
		
		@Test
		//call a method to click on the Add Tariff Plan To Customer link
		public void  Given_Active_Customer() throws InterruptedException {

			//call a method to click on the Add Tariff Plan To Customer link
			GuruLanding.ClickAddTariffPlanToCustomer_Link();
			 //wait
			Thread.sleep(5000);
			
			
			// Verify that Guru99 telecom Heading is available //
			String expectedTitle = "Guru99 telecom";
			String actualTitle = AddTariffPlan_To_Customer.verify_Guru99telecom_Logo();
			//String actualTitle = landingPage.getTitle();
						    
			Reporter.log("expected ------------------"+expectedTitle);
			Reporter.log("actual --------------------"+actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle ); 
						
							
		//public void Verify_AddTariff_to_Customer_Header () {
		// Verify that Add Tariff Plan To Customer link is available //
		String pexpectedTitle = "Add Tariff Plan To Customer";
		String pactualTitle = AddTariffPlan_To_Customer.verify_Add_Tariff_PLan_to_Customer_Header();
		//String actualTitle = landingPage.getTitle();
							    
		Reporter.log("expected ------------------"+pexpectedTitle);
		Reporter.log("actual --------------------"+pactualTitle);
		Assert.assertEquals(pactualTitle, pexpectedTitle ); 
							
		}

		
		
		public void  Given_Active_Customer_Populate_CustID() throws InterruptedException {

			//call a method to capture the Cust ID field on the Add Tariff Plan To Customer Page
			//Populate the Tariff Plan details with the VALID Data
			String sCustID= "501465";
			
			//call a method to populate the fields
			AddTariffPlan_To_Customer.AddGenerated_Cust_ID(sCustID);

			//Call a method to click submit button
			AddTariffPlan_To_Customer.Click_Submit_Button_on_AddTrariffPlantoCustomer();
			
			
			// Verify that ACTIVE is available //
			String expectedTitle = "ACTIVE";
			String actualTitle = AddTariffPlan_To_Customer.Verify_CustomerActive();
			//String actualTitle = landingPage.getTitle();
						    
			Reporter.log("expected ------------------"+expectedTitle);
			Reporter.log("actual --------------------"+actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle ); 
						
		}
	/////******************************************************************	
	// Test Case 3
		@Test
		public void  GIVEN_active_customer_WHEN_submit_THEN_at_least_one_approved_tariff_plan_is_displayed() throws InterruptedException {
		// Verify that ACTIVE is available //
					String expectedTitle = "ACTIVE"; //data into the table
					String actualTitle = AddTariffPlan_To_Customer.Verify_CustomerActive();
					//String actualTitle = landingPage.getTitle();
								    
					Reporter.log("expected ------------------"+expectedTitle);
					Reporter.log("actual --------------------"+actualTitle);
					Assert.assertEquals(actualTitle, expectedTitle ); 
		
		}
		
	//*************///*******************************    //*******************************	
		
		//test case 2
			
		@Test
		public void  GIVEN_Inactive_customer_WHEN_submit_THEN_INactive_is_displayed () throws InterruptedException {

			// Call a method to click rest button
			//AddCustomer.Given_Reset_button_isClicked();

			//Call a method to click Done option
			AddCustomer.Given_Pending_radio_Option_button();

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
			   			       
			// Asset for the Customer ID that keeps on Changing
			boolean sCustID = CustomerID.Generated_Customer_ID();
						     
			Reporter.log("expected Customer ID is displayed");
			Reporter.log("actual --------------------"+sCustID);
			Assert.assertEquals(sCustID, true);
			
		}   
		
		// call a method to Click on Home button
		public void NavigateTo_HomePage () {
			
			// call a method to Click on Home button
			CustomerID.Click_Home_button_CustomerIDPage();
		}
	
		
		//Verify the correct Assersetion fo the Landingpage
	 /* // Verify that Guru99 telecom Heading is available // String expectedTitle =
	 * "Guru99 telecom"; String actualTitle =
	 * AddTariffPlan_To_Customer.verify_Guru99telecom_Logo(); //String actualTitle =
	 * landingPage.getTitle();
	 * 
	 * Reporter.log("expected ------------------"+expectedTitle);
	 * Reporter.log("actual --------------------"+actualTitle);
	 * Assert.assertEquals(actualTitle, expectedTitle );
	 * 
	 * }
	 * 
	 * public void VerifyTo_AddTariff_to_Customer () { // Verify that Add Tariff
	 * Plan To Customer link is available // String expectedTitle =
	 * "Add Tariff Plan To Customer"; String actualTitle =
	 * AddTariffPlan_To_Customer.verify_Add_Tariff_PLan_to_Customer_Header();
	 * //String actualTitle = landingPage.getTitle();
	 * 
	 * Reporter.log("expected ------------------"+expectedTitle);
	 * Reporter.log("actual --------------------"+actualTitle);
	 * Assert.assertEquals(actualTitle, expectedTitle );
	 * 
	 * }
	 */
		
		
		
		@Test
		//call a method to click on the Add Tariff Plan To Customer link
		public void  Given_InActive_Customer() throws InterruptedException {

			//call a method to click on the Add Tariff Plan To Customer link
			GuruLanding.ClickAddTariffPlanToCustomer_Link();
			 //wait
			Thread.sleep(5000);
			
			
			// Verify that Guru99 telecom Heading is available //
			String expectedTitle = "Guru99 telecom";
			String actualTitle = AddTariffPlan_To_Customer.verify_Guru99telecom_Logo();
			//String actualTitle = landingPage.getTitle();
						    
			Reporter.log("expected ------------------"+expectedTitle);
			Reporter.log("actual --------------------"+actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle ); 
						
							
		//public void Verify_AddTariff_to_Customer_Header () {
		// Verify that Add Tariff Plan To Customer link is available //
		String pexpectedTitle = "Add Tariff Plan To Customer";
		String pactualTitle = AddTariffPlan_To_Customer.verify_Add_Tariff_PLan_to_Customer_Header();
		//String actualTitle = landingPage.getTitle();
							    
		Reporter.log("expected ------------------"+pexpectedTitle);
		Reporter.log("actual --------------------"+pactualTitle);
		Assert.assertEquals(pactualTitle, pexpectedTitle ); 
							
		}

		
		public void  Given_InActive_Customer_Populate_CustID() throws InterruptedException {

			//call a method to capture the Cust ID field on the Add Tariff Plan To Customer Page
			//Populate the Tariff Plan details with the VALID Data
			String sCustID= "651073";
			
			//call a method to populate the fields
			AddTariffPlan_To_Customer.AddGenerated_Cust_ID(sCustID);

			//Call a method to click submit button
			AddTariffPlan_To_Customer.Click_Submit_Button_on_AddTrariffPlantoCustomer();
			
			
			// Verify that ACTIVE is available //
			String expectedTitle = "INACTIVE";
			String actualTitle = AddTariffPlan_To_Customer.Verify_CustomerInActive();
			//String actualTitle = landingPage.getTitle();
						    
			Reporter.log("expected ------------------"+expectedTitle);
			Reporter.log("actual --------------------"+actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle ); 
						
		}	
		
//*******************************************************************************
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			        
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
