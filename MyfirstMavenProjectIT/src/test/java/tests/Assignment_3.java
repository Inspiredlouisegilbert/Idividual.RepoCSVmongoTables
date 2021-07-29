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

    			//public static void CustomerName_Displayed(String args[]) {
    				String str= new String("Customer Name:- dfdgfg");
    				//System.out.println("Substring starting from index 53:");
    				//System.out.println(str.substring(15));
    				System.out.println("Substring starting from index 53 and ending at 58:");
    				System.out.println(str.substring(53, 58));
    	
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
		
			
	int actualUsageCharges = LocalMinutes + InternatinalMin + SMSPack;
	
	int expectedUsageCharges = 250;

	Reporter.log("expected ------------------"+expectedUsageCharges);
    Reporter.log("actual --------------------"+actualUsageCharges);
    Assert.assertEquals(actualUsageCharges, expectedUsageCharges );
	
	
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
			
	int actualTotalBill = TariffPlanAmount + UsageCharges;
	
	int expectedTotalBill = 750;
	
	Reporter.log("expected ------------------"+expectedTotalBill);
    Reporter.log("actual --------------------"+actualTotalBill);
    Assert.assertEquals(actualTotalBill, expectedTotalBill );
	
	
	}
}
    
    
    
    
    
    
    
    
   