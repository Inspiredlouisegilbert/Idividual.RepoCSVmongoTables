package Nyeleti_Continue;


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
	
	
	public class Nyels_Assignment2  {
	
			
			
		// Declare an object of classes and
		// Instantiate class objects
	
		LandingPage landingPage = new LandingPage();     
		Guru99Telcom_LandingPage Gurulanding_page = new Guru99Telcom_LandingPage();
		NyAddCustomerPage AddCustomer = new NyAddCustomerPage();
		NyCustomerIDPage CustomerID = new NyCustomerIDPage ();
		NYAddTariffPlanToCustomerPage AddTarrifPlanToCust  = new NYAddTariffPlanToCustomerPage();
		

	
		//Navigate to http://demo.guru99.com/telecom/index.html
	    public void navigate_to_URL1() {
	    	Gurulanding_page.Navigate_to_URL();

	    	
	    	}
		
	    //Select Add Tariff Plan to Customer
	    public void Add_tarrifplantoCust() {
			
		AddTarrifPlanToCust.ClickOnAddTarrifplanto_customer_link();
			}
	    
	    @Test
	    
		//Assert Add Tariff plan to customer
		public void Verify_tarrifPlan_Heading1() {
			
			String ExpectedMessage = "Add Tariff PLan to Customer";
			String ActualMessage = AddTarrifPlanToCust.verify_Add_Tariff_PLan_to_Customer_Header();
			
		    Reporter.log("expected ------------------"+ExpectedMessage);
		    Reporter.log("actual --------------------"+ActualMessage);
		    Assert.assertEquals(ActualMessage, ExpectedMessage ); 
		}
		//Assert  Add Guru99 telecom Heading
	    public void Guru99_Telcom_Heading() throws InterruptedException {
	        String expectedTitle = "Guru99 telecom";
	        String actualTitle = AddTarrifPlanToCust.verify_Guru99telecom_Logo();
	             
	         Reporter.log("expected ------------------"+expectedTitle);
	         Reporter.log("actual --------------------"+actualTitle);
	         Assert.assertEquals(actualTitle, expectedTitle ); 
	            
	         Thread.sleep(5000);
	            
	    	    }	

	    			
			@Test
		public void  Testcase1_GIVEN_active_customer_WHEN_submit_THEN_active_is_displayed () throws InterruptedException {

				//Navigate to URL
				Gurulanding_page.Navigate_to_URL();
				//Click on Add  Customer
				Gurulanding_page.Add_customer_Link();

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
				
				
				//Gurulanding_page.ClickAddTariffPlanToCustomer_Link();
				//AddTarrifPlanToCust.Getactive_cust();
				//AddTarrifPlanToCust.Click_AddTrariffPlantoCustomerButton();
				
				//Verify Active
				//AddTarrifPlanToCust.Verify_CustomerActive();
				
				
				
				
				// Verify that the Customer ID Page is displayed  
				//String ExpectedMessage = "Access Details to Guru99 Telecom";
				//String ActualMessage = CustomerID.verifyCustomerID_Heading();

				//CustomerID.verifyCustomerID_Heading(); 
				//Reporter.log("expected ------------------"+ExpectedMessage);
				//Reporter.log("actual --------------------"+ActualMessage);
				//Assert.assertEquals(ActualMessage, ExpectedMessage );
				   			       
				// Asset for the Customer ID that keeps on Changing
				//boolean sCustID = CustomerID.Generated_Customer_ID();
							     
				//Reporter.log("expected Customer ID is displayed");
				//Reporter.log("actual --------------------"+sCustID);
				//Assert.assertEquals(sCustID, true);
				
				//Click on Home to get to main page
				//AddTarrifPlanToCust.ClickHomelink();
				
				   
		}

			@ Test 
						
			public void  Enter_Valid_customer_id_and_submit() throws InterruptedException {
				//NAvigate to URL
				Gurulanding_page.Navigate_to_URL();
				
				Gurulanding_page.ClickAddTariffPlanToCustomer_Link();
				
				
				//AddTarrifPlanToCust.ClickOnAddTarrifplanto_customer_link();
				AddTarrifPlanToCust.Getactive_cust();
				AddTarrifPlanToCust.Click_Submit_Button_on_AddTrariffPlantoCustomer();
				
				//String sCustID= "501465";
				
								
				// Verify that ACTIVE is available //
				String expectedTitle = "ACTIVE";
				String actualTitle = AddTarrifPlanToCust.Verify_CustomerActive();
				//String actualTitle = landingPage.getTitle();
							    
				Reporter.log("expected ------------------"+expectedTitle);
				Reporter.log("actual --------------------"+actualTitle);
				Assert.assertEquals(actualTitle, expectedTitle ); 
				
				
							
			}
		/////******************************************************************	

				
			@Test
			public void  Testcase2_GIVEN_Inactive_customer_WHEN_submit_THEN_INactive_is_displayed () throws InterruptedException {
				
				//Navigate to URL
				Gurulanding_page.Navigate_to_URL();
				//Click on Add  Customer
				Gurulanding_page.Add_customer_Link();
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
				//String ExpectedMessage = "Access Details to Guru99 Telecom";
				//String ActualMessage = CustomerID.verifyCustomerID_Heading();

				//CustomerID.verifyCustomerID_Heading(); 
				//Reporter.log("expected ------------------"+ExpectedMessage);
				//Reporter.log("actual --------------------"+ActualMessage);
				//Assert.assertEquals(ActualMessage, ExpectedMessage );
				   			       
				// Asset for the Customer ID that keeps on Changing
				//boolean sCustID = CustomerID.Generated_Customer_ID();
							     
				//Reporter.log("expected Customer ID is displayed");
				//Reporter.log("actual --------------------"+sCustID);
				//Assert.assertEquals(sCustID, true);
				
				//AddTarrifPlanToCust.ClickHomelink();
			  	Thread.sleep(5000);
			}   
			
	           @Test
				public void  Given_InActive_Customer_Populate_CustID() throws InterruptedException {
		        
		         Gurulanding_page.Navigate_to_URL();
		
		        Gurulanding_page.ClickAddTariffPlanToCustomer_Link();
		        //AddTarrifPlanToCust.ClickOnAddTarrifplanto_customer_link();
		       
		        AddTarrifPlanToCust.GetInactive_cust();
		        AddTarrifPlanToCust.Click_Submit_Button_on_AddTrariffPlantoCustomer();
				//String sCustID= "651073";
				
				
				// Verify that InACTIVE is available //
				String expectedTitle = "INACTIVE";
				String actualTitle = AddTarrifPlanToCust.Verify_CustomerInActive();
				
				//String actualTitle = landingPage.getTitle();
							    
				Reporter.log("expected ------------------"+expectedTitle);
				Reporter.log("actual --------------------"+actualTitle);
				Assert.assertEquals(actualTitle, expectedTitle ); 
				
				
			}	
			
	//*******************************************************************************
			@Test
			public void Test_case_3_GIVEN_active_customer_WHEN_submit_THEN_at_least_one_approved_tariff_plan_is_displayed () throws InterruptedException {
				

			//Enter an active customer id and submit
				//String sCustID= "501465";
			
				Gurulanding_page.Navigate_to_URL();
				Gurulanding_page.ClickAddTariffPlanToCustomer_Link();
				AddTarrifPlanToCust.Getactive_cust();
				AddTarrifPlanToCust.Click_Submit_Button_on_AddTrariffPlantoCustomer();
				
				//At least one approved tariff plan displayed
				String expectedTitle = "Local Minutes";
				String actualTitle = AddTarrifPlanToCust.Approved_tarrif();
			
							    
				Reporter.log("expected ------------------"+expectedTitle);
				Reporter.log("actual --------------------"+actualTitle);
				Assert.assertEquals(actualTitle, expectedTitle ); 
				
				Thread.sleep(5000);
	
								
			}
				
			@Test			
			public void Testcase4_GIVENat_leastoneapproved_tariff_plan_is_selected_WHEN_add_tariff_THEN_success_message_displayed () {
			
				Gurulanding_page.Navigate_to_URL();
				Gurulanding_page.ClickAddTariffPlanToCustomer_Link();
				AddTarrifPlanToCust.Getactive_cust();
				AddTarrifPlanToCust.Click_Submit_Button_on_AddTrariffPlantoCustomer();
				
				//Enter an active customer id 
				//String sCustID= "501465";
				
	
				AddTarrifPlanToCust.Getactive_cust();
				
				//Select the plan 
				AddTarrifPlanToCust.Given_Select_Tariff_Plan_radio_button_selected();
				// Click ADD Tariff plan to customer
				AddTarrifPlanToCust.Click_AddTrariffPlantoCustomerButton();
				
				//success message is displayed
				String expectedTitle = "Congratulation Tariff Plan assigned";
				String actualTitle = AddTarrifPlanToCust.Verify_SuccessMessage();
			
							    
				Reporter.log("expected ------------------"+expectedTitle);
				Reporter.log("actual --------------------"+actualTitle);
				Assert.assertEquals(actualTitle, expectedTitle ); 
				
				
			}
			
			
	}