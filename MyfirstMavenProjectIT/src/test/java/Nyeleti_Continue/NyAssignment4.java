package Nyeleti_Continue;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.CSVWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
//import com.opencsv.CSVWriter;
import java.io.*;
import java.util.*;
//import com.opencsv.CSVWriter;

import frameworkclasses.SeleniumFunctions;
import pages.AddCustomerPage;
import pages.AddTariffPlanToCustomerPage;
import pages.CustomerIDPage;
import pages.Guru99Telcom_LandingPage;
import pages.HomePage;
import pages.PayBillingPage;
import pages.SignInPage;

public class NyAssignment4 {

	

private static final String Writer = null;
private static final String StoreBillingInfo = null;

//** Declare an object of classes and
   //** Instantiate class objects
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

		
		
		//Navigate to http://demo.guru99.com/telecom/index.html
		public void Navigate_to_URL() {
			GuruLanding.Navigate_to_URL();
		
		}
		
		//Select Add Customer
		public void Add_customer_Link() {
			GuruLanding.Add_customer_Link();
		
		}
		
		@Test
			
		//Assert  Add Customer Heading
		public void Verify_Addcust_Heading1() throws InterruptedException {
			Navigate_to_URL();
			Add_customer_Link();
			
		String ExpectedMessage = "Add Customer";
		String ActualMessage = GuruLanding.Verify_Addcust_Heading();
			
		Reporter.log("expected ------------------"+ExpectedMessage);
		Reporter.log("actual --------------------"+ActualMessage);
		Assert.assertEquals(ActualMessage, ExpectedMessage ); 
		
	    String expectedTitle = "Guru99 telecom";
	    String actualTitle = GuruLanding.Verify_Addcust_Heading();
	     
	    Reporter.log("expected ------------------"+expectedTitle);
	    Reporter.log("actual --------------------"+actualTitle);
	    Assert.assertEquals(actualTitle, expectedTitle ); 
	    
		}
		
		
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
		// call a method to Click on Home button
		public void NavigateTo_LandingPage () {
				
		
		 // call a method to Click on Home button
		 	CustomerID.Click_Home_button_CustomerIDPage();
			// Verify that Guru99 telecom Heading is available //
			String expectedLogo = "Guru99 telecom";
			String actualLogo = PayBilling.verify_Guru99telecom_Logo();	
			
			//CustomerID.verifyCustomerID_Heading(); 
			Reporter.log("expected ------------------"+expectedLogo);
			Reporter.log("actual --------------------"+actualLogo);
			Assert.assertEquals(actualLogo, expectedLogo );
			
	      }
	
			
	@Test
	//Run | Debug
			//call a method to click on Pay Billing link
			public void GIVEN_ActiveCustomer_CustID_Displayed_Correctly() throws InterruptedException {

				//call a method to click on the Pay Billing link
				GuruLanding.Click_Pay_Billing_Link();
				 //wait
				Thread.sleep(3000);
								
				// Verify that Guru99 telecom Heading is available //
				String expectedLogo = "Guru99 telecom";
				String actualLogo = PayBilling.verify_Guru99telecom_Logo();
				//String actualTitle = landingPage.getTitle();
							    
				Reporter.log("expected ------------------"+expectedLogo);
				Reporter.log("actual --------------------"+actualLogo);
				Assert.assertEquals(actualLogo, expectedLogo ); 
							
				// Verify that Pay Billing link is available //
				String pExpectedLogo = "Pay Billing";
				String pActualTitle = PayBilling.verify_PayBilling_Heading();
								    
				Reporter.log("expected ------------------"+pExpectedLogo);
				Reporter.log("actual --------------------"+pActualTitle);
				Assert.assertEquals(pActualTitle, pExpectedLogo); 
								
			}

			
			@Test
			//call a method to capture the Cust ID field on the Add Tariff Plan To Customer Page
			
			public void  Given_Active_Customer_Populate_CustID() throws InterruptedException {

				//Populate the Tariff Plan details with the VALID Data
				String sCustID= "752262";
				
				//call a method to populate the fields
				PayBilling.AddGenerated_Cust_ID(sCustID);
				

				//Call a method to click submit button
				PayBilling.Click_Submit_Button_on_PayBillingPage();
				
				
				// Verify that CustomerID is available //
				String pExpectedLogo = "- 752262";
				String pActualTitle = "- 752262";
								    
				Reporter.log("expected ------------------"+pExpectedLogo);
				Reporter.log("actual --------------------"+pActualTitle);
				Assert.assertEquals(pActualTitle, pExpectedLogo); 	
				
				
			}
			
	//*****************CSV Writer class********************************************
			@Test
			public void  GIVEN_active_customer_Wrete_Data_into_CSVFile() throws IOException {
				
				// initiating the CSV Writer class
				//CSVWriter writer = new CSVWriter(new FileWriter("TestData//sample1.csv"));
				
				//write table data to file
		        FileWriter myWriter = new FileWriter(("TestData//sample1.csv"));   //StoreBillingInfo.csv
		        myWriter.write(driver.findElement(By.cssSelector("tbody")).getText());
		        myWriter.close();
				
				// write  data into csv file by creating an array
				String set1[] = {"", "Free Usage Limit", "Actual Usage", "Over Free", "Usage Charges"};
				String set2[] = {"Local Minutes", "200", "220", "20", "50"};
				String set3[] = {"International Minutes", "100", "110", "10", "200"};		
				String set4[] = {"SMS Pack", "500", "400", "0", "0"};	
				String set5[] = {"", "", "", "Tariff Plan Amount", "500"};	
				String set6[] = {"", "", "", "Usage Charges", "250"};	
				String set7[] = {"", "", "", "Total Bill", "750"};
				
				
				/*//using writeNext method
				Writer.writeNext(set1);
				Writer.writeNext(set2);
				Writer.writeNext(set3);
				Writer.writeNext(set4);
				Writer.writeNext(set5);
				Writer.writeNext(set6);
				Writer.writeNext(set7);
				
				//flush data to create CSV file data
				Writer.flush();*/
				
				// arraylist to handle the data using the writeAll method and this method is the easy one
				List list = new ArrayList();
				
				list.add(set1);
				list.add(set2);
				list.add(set3);
				list.add(set4);
				list.add(set5);
				list.add(set6);
				list.add(set7);
				
				//write everything on the list into CSV file //writeAll(list);
				Writer.writeAll(list);
				//flush my dat into the csv file
				Writer.flush();
				
				
				System.out.println("data entered");
				
				
				}
}
				
			//*************************************************************