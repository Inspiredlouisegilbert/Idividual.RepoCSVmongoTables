package Nyeleti_Continue;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

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


public class NyAssignment_3 {
	

	// Declare an object of classes and
	// Instantiate class objects
	SignInPage inPage = new SignInPage();              
	//LandingPage landingPage = new LandingPage();     
	Guru99Telcom_LandingPage GuruLanding = new Guru99Telcom_LandingPage();
	AddCustomerPage AddCustomer = new AddCustomerPage();
	AddTariffPlanToCustomerPage AddTariffPlan_To_Customer = new AddTariffPlanToCustomerPage();  
	PayBillingPage PayBilling = new PayBillingPage();  
	CustomerIDPage CustomerID = new CustomerIDPage ();
	//ProductSearchPage pr = new ProductSearchPage();
	HomePage homePage = new HomePage();  
	// Selenium Functions 
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	// driver variable
	WebDriver driver;

	//****Test cases to be done*******
	//1. GIVEN active customer WHEN submit THEN customer id displayed correctly 
	//2. GIVEN active customer WHEN submit THEN customer name displayed correctly 
	//3. GIVEN active customer WHEN submit THEN tariff plan amount displayed correctly 
	//4. GIVEN active customer WHEN submit THEN total bill amount displayed correctly 
	
	
	@Test
	
	
	
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
		
			public void PayBillingTable() throws IOException {
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
			
	String UsageCharges1 = driver.findElement(By.xpath("//label[.='Special characters are not allowed']")).getText();
	Assert.assertEquals(actualString2, "Special characters are not allowed");
	
	
		//***transform string to integer if you get an error = data type mismatch***
			
            //******OR****				
				
	//ask Louise//???List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("<b>50</b>/<b>200</b>/<b>0</b>"));
				 
				System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
				
				WebElement ToGetColumns = driver.findElement(By.xpath(tablexpath));
				
	WebElement TotalAmount1 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[5]"));
				
				List<WebElement> TotalColsList = ToGetColumns.findElements(By.tagName("td"));

				System.out.println("Total Number of cells in the table are: "+TotalColsList.size());
				sfSelenium.logScreenShot();	
			}
			   
		//*****************Test Case 4*******************************************
		
		//NB: Fix test case 3 and then testcase 4 will be easy to do
		
		
		
		
		    	}
