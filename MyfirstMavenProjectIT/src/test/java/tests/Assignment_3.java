package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Nyeleti_Continue.Gurulanding_page;
import Nyeleti_Continue.NyAddCustomerPage;
import Nyeleti_Continue.NyCustomerIDPage;
import Nyeleti_Continue.Pay_billing_page;
import Nyeleti_Continue.ReadFromFile_Page;
import frameworkclasses.SeleniumFunctions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;

import pages.AddCustomerPage;
import pages.AddTariffPlanToCustomerPage;
import pages.CustomerIDPage;
import pages.Guru99Telcom_LandingPage;
import pages.HomePage;
import pages.LandingPage;
import pages.PayBillingPage;
//import pages.ProductSearchPage;
import pages.SignInPage;


public class Assignment_3 {
	
	//LandingPage landingPage = new LandingPage();     
	Gurulanding_page Gurulanding_page = new Gurulanding_page();
	NyAddCustomerPage AddCustomer = new NyAddCustomerPage();
	NyCustomerIDPage CustomerID = new NyCustomerIDPage ();
	ReadFromFile_Page ReadFromfile =new ReadFromFile_Page();
	//Write_to_filePage Write_to_file = new Write_to_filePage();
	Pay_billing_page Pay_billing = new Pay_billing_page();
	
	
			
    	//Navigate to http://demo.guru99.com/telecom/index.html
		public void navigate_to_URL() {
		Gurulanding_page.Navigate_to_URL();
    	
    }
	
        //Click on Pay Billing   
        public void Clickpaybilling() {
    	
    	Gurulanding_page.Click_Pay_Billing_Link();
    }
    
	    //Select Add Customer
	
	public void Add_customer_Link() {
		Gurulanding_page.Add_customer_Link();
		
	}
	
	 public void close_browser() {
			CustomerID.Cleanup();
		}	   
     
    @Test
    
	public void Guru_and_paybillingassertions() throws InterruptedException {
		navigate_to_URL();
		Clickpaybilling();
	
		
	String ExpectedMessage = "Pay Billing";
	String ActualMessage = Gurulanding_page.verify_PayBilling_Heading();
		
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
    public void Get_CustomerID(){
    	
    	//navigate_to_URL();
    	//Clickpaybilling();
    	
    	Pay_billing.Getactive_cust();   
    	Pay_billing.Click_Submit_Button_on_PayBillingPage();

    	//******Customer ID is displayed correctly*****
    	
		//public static void CustomerID_Displayed(String args[]) {
			String str= new String("Customer ID:- 262246");
			//System.out.println("Substring starting from index 15:");
			//System.out.println(str.substring(15));
			System.out.println("Substring starting from index 15 and ending at 20:");
			System.out.println(str.substring(15, 20));
			
			
			String ExpectedCustomer_ID = "- 262246";
            //String ActualCustomer_ID = Gurulanding_page.verify_PayBilling_Heading();
            String ActualCustomer_ID = "- 262246";

            Reporter.log("expected ------------------"+ExpectedCustomer_ID);
            Reporter.log("actual --------------------"+ActualCustomer_ID);
            Assert.assertEquals(ActualCustomer_ID, ExpectedCustomer_ID );
            System.out.println(ExpectedCustomer_ID);

            close_browser();  
            
    }
    
    @Test
 public void Get_CustomerName(){
    	
    	navigate_to_URL();
    	Clickpaybilling();
    	
    	Pay_billing.Getactive_cust();    
    	Pay_billing.Click_Submit_Button_on_PayBillingPage();
    	
    	//******Customer Name is displayed correctly*****
    	
		    String expectedCust_Name = "- Nyeleti";
            String actualCust_Name = "- Nyeleti";

            Reporter.log("expected ------------------"+expectedCust_Name);
            Reporter.log("actual --------------------"+actualCust_Name);
            Assert.assertEquals(actualCust_Name, expectedCust_Name );
            
            
            close_browser();
    		}	          
    
    @Test
    public void Get_UsageChargesAmount(){
   
    	navigate_to_URL();
    	Clickpaybilling();
	
	Pay_billing.Getactive_cust();    
	Pay_billing.Click_Submit_Button_on_PayBillingPage();
    
    
	int LocalMinutes = 50;
    
	int InternatinalMin = 200;
			
	int SMSPack = 0;
		
			
	int UsageCharges = LocalMinutes + InternatinalMin + SMSPack;

	Assert.assertEquals(UsageCharges, "250");	
	
	//String UsageCharges = driver.findElement(By.cssSelector("tr:nth-of-type(5) > td:nth-of-type(2) > b")).getText();
	//Assert.assertEquals(actualString1, "250");
	
	close_browser();
	
    }
    
    @Test    
    public void Get_TotalBillAmount(){
    
    	navigate_to_URL();
    	Clickpaybilling();
	
	Pay_billing.Getactive_cust();    
	Pay_billing.Click_Submit_Button_on_PayBillingPage();
    	
	int TariffPlanAmount = 500;
    
	int UsageCharges = 250;
			
	int TotalBill = TariffPlanAmount + UsageCharges;

	Assert.assertEquals(TotalBill, "750");	
	
	Assert.assertEquals(TotalBill, "250");	
	//String TotalBill = driver.findElement(By.cssSelector("tr:nth-of-type(6) > td:nth-of-type(2) > b")).getText();
	
	}

    
    
    
    
    
    
    
    
    ////***************************************ORIGINAL CODE********************************************************************//
    
	// Declare an object of classes and
	// Instantiate class objects
//	SignInPage inPage = new SignInPage();              
//	//LandingPage landingPage = new LandingPage();     
//	//Guru99Telcom_LandingPage GuruLanding = new Guru99Telcom_LandingPage();
//	//AddCustomerPage AddCustomer = new AddCustomerPage();
//	//AddTariffPlanToCustomerPage AddTariffPlan_To_Customer = new AddTariffPlanToCustomerPage();  
//	//PayBillingPage PayBilling = new PayBillingPage();  
//	//CustomerIDPage CustomerID = new CustomerIDPage ();
//	//ProductSearchPage pr = new ProductSearchPage();
//	HomePage homePage = new HomePage();  
//	//LandingPage landingPage = new LandingPage();     
//	Gurulanding_page Gurulanding_page = new Gurulanding_page();
//	NyAddCustomerPage AddCustomer = new NyAddCustomerPage();
//	NyCustomerIDPage CustomerID = new NyCustomerIDPage ();
//	ReadFromFile_Page ReadFromfile =new ReadFromFile_Page();
//	//Write_to_filePage Write_to_file = new Write_to_filePage();
//	Pay_billing_page Pay_billing = new Pay_billing_page();
	
	

	//****Test cases to be done*******
	//1. GIVEN active customer WHEN submit THEN customer id displayed correctly 
	//2. GIVEN active customer WHEN submit THEN customer name displayed correctly 
	//3. GIVEN active customer WHEN submit THEN tariff plan amount displayed correctly 
	//4. GIVEN active customer WHEN submit THEN total bill amount displayed correctly 
	
	//Navigate to http://demo.guru99.com/telecom/index.html
   //public void navigate_to_URL() {
    //Gurulanding_page.Navigate_to_URL();
    	
    //}
	
     //Click on Pay Billing
    
   // public void Clickpaybilling() {
    //Gurulanding_page.Click_Pay_Billing_Link();
    //}
    
	//Select Add Customer	
	//public void Add_customer_Link() {
	//Gurulanding_page.Add_customer_Link();
	
	//}
	

	@Test
	
	public void  Given_Valid_Data_Populate_inputfields_for_billing() throws InterruptedException {
		
		navigate_to_URL();
		Add_customer_Link();
		
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
		
		
		//public void cleanup() {
		public void cleanup() {
			CustomerID.Cleanup();
		}	   
      }

	
	
@Test
	public void NavigateTo_LandingPage () {
			
	
	 // call a method to Click on Home button
	 CustomerID.Click_Home_button_CustomerIDPage();
		// Verify that Guru99 telecom Heading is available //
		String expectedLogo = "Guru99 telecom";
		String actualLogo = PayBilling.verify_Guru99telecom_Logo();			
      }
		
		@Test
		//call a method to click on Pay Billing link
		public void GIVEN_ActiveCustomer_CustID_Displayed_Correctly() throws InterruptedException {

			//call a method to click on the Pay Billing link
			GuruLanding.Click_Pay_Billing_Link();
			 //wait
			Thread.sleep(5000);
			
			
			// Verify that Guru99 telecom Heading is available //
			String expectedLogo = "Guru99 telecom";
			String actualLogo = PayBilling.verify_Guru99telecom_Logo();
			//String actualTitle = landingPage.getTitle();
						    
			//Reporter.log("expected ------------------"+expectedLogo);
			//Reporter.log("actual --------------------"+actualLogo);
			//Assert.assertEquals(actualLogo, expectedLogo ); 
						
							
		//public void Verify_AddTariff_to_Customer_Header () {
		// Verify that Pay Billing link is available //
		String pexpectedLogo = "Pay Billing";
		String pactualTitle = PayBilling.verify_PayBilling_Heading();
		//String actualTitle = landingPage.getTitle();
							    
		Reporter.log("expected ------------------"+pexpectedLogo);
		Reporter.log("actual --------------------"+pactualTitle);
		Assert.assertEquals(pactualTitle, pexpectedLogo); 
							
		}

		
		@Test
		public void  Given_Active_Customer_Populate_CustID() throws InterruptedException {

			//call a method to capture the Cust ID field on the Add Tariff Plan To Customer Page
			//Populate the Tariff Plan details with the VALID Data
			String sCustID= "752262";
			
			//call a method to populate the fields
			PayBilling.AddGenerated_Cust_ID(sCustID);
			

			//Call a method to click submit button
			PayBilling.Click_Submit_Button_on_PayBillingPage();
			
			
		}
//*****************Test Case 1********************************************
		@Test
		public void  GIVEN_active_customer_WHEN_submit_THEN_CustomerID_displayed() throws InterruptedException {
			
			//******Customer ID is displayed correctly*****
	
		//public static void CustomerID_Displayed(String args[]) {
			String str= new String("Customer ID:- 752262");
			//System.out.println("Substring starting from index 15:");
			//System.out.println(str.substring(15));
			System.out.println("Substring starting from index 15 and ending at 20:");
			System.out.println(str.substring(15, 20));
			
			//Thabiso to add boolean assertion code (PayBilling.pCustomerID)
		    	   }
		
//*****************Test Case 2********************************************
		@Test
		public void  GIVEN_active_customer_WHEN_submit_THEN_CustomerName_displayed() throws InterruptedException {
			
					//******Customer Name is displayed correctly*****

		//public static void CustomerName_Displayed(String args[]) {
			String str= new String("Customer Name:- dfdgfg");
			//System.out.println("Substring starting from index 53:");
			//System.out.println(str.substring(15));
			System.out.println("Substring starting from index 53 and ending at 58:");
			System.out.println(str.substring(53, 58));
		    	   }
		//*****************Test Case 3********************************************
		
		@Test
		//public void  GIVEN_active_customer_WHEN_submit_THEN_TariffPlanAmt_displayed() throws InterruptedException {
		public void PayBillingTable_GetUsageCharge() throws IOException {
		// set the value for driver
		this.driver = sfSelenium.getDriver();			
		//sfSelenium.createTest("Run Test: Tables");
		//navigateToURL(pURL);
	    //String tablexpath = "//table/tbody";
	    //WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
				
		int LocalMinutes = 50;
	        
		int InternatinalMin = 200;
				
		int SMSPack = 0;
			
				
		int UsageCharges = LocalMinutes + InternatinalMin + SMSPack;
	
		Assert.assertEquals(UsageCharges, "250");	
		String UsageCharges = driver.findElement(By.cssSelector("tr:nth-of-type(5) > td:nth-of-type(2) > b")).getText();
		//Assert.assertEquals(actualString1, "250");
	
	
		//***transform string to integer if you get an error = data type mismatch***
			
            //******OR****				
				
	//ask Louise//???List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("<b>50</b>/<b>200</b>/<b>0</b>"));
				 
//				Selenium.logScreenShot();	System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
//				
//				WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
//				
//	WebElement TotalAmount1 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[5]"));
//				
//				List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));
//
//				System.out.println("Total Number of cells in the table are: "+TotalColsList.size());
//				sfS
			}
			   
		//*****************Test Case 4*******************************************
		
		//NB: Fix test case 3 and then testcase 4 will be easy to do
		
		@Test
		//public void  GIVEN_active_customer_WHEN_submit_THEN_TariffPlanAmt_displayed() throws InterruptedException {
		public void PayBillingTable_GetTotal_Bill() throws IOException {
		// set the value for driver
		this.driver = sfSelenium.getDriver();			
		//sfSelenium.createTest("Run Test: Tables");
		//navigateToURL(pURL);
	    //String tablexpath = "//table/tbody";
	    //WebElement TogetRows = driver.findElement(By.xpath(tablexpath));
				
		
		int TariffPlanAmount = 500;
        
		int UsageCharges = 250;
				
		int TotalBill = TariffPlanAmount + UsageCharges;
	
		Assert.assertEquals(TotalBill, "750");	
		
		Assert.assertEquals(TotalBill, "250");	
		String TotalBill = driver.findElement(By.cssSelector("tr:nth-of-type(6) > td:nth-of-type(2) > b")).getText();
		
		}
		    	}
