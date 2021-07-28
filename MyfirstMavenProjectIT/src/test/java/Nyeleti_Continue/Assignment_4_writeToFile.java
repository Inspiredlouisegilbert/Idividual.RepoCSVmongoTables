package Nyeleti_Continue;

//import org.junit.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assignment_4_writeToFile {
	

	//LandingPage landingPage = new LandingPage();     
	Gurulanding_page Gurulanding_page = new Gurulanding_page();
	NyAddCustomerPage AddCustomer = new NyAddCustomerPage();
	NyCustomerIDPage CustomerID = new NyCustomerIDPage ();
	ReadFromFile_Page ReadFromfile =new ReadFromFile_Page();
	Write_to_filePage Write_to_file = new Write_to_filePage();
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
     
    @Test
    
	public void Gurua_and_paybillingassertions() throws InterruptedException {
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
    //Create a customer who has done a credit check
    
    public void  Create_a_customer_who_has_done_a_credit_check () throws InterruptedException {
    	
    	navigate_to_URL();
	    Add_customer_Link();
	
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
		    
	}

    //********************** Enter the customer id and submit*************************************************
    
    @Test
    
    public void Search_Customer_onPaybilling(){
    	
    	navigate_to_URL();
    	Clickpaybilling();
    	
    	Pay_billing.Getactive_cust();
    	Pay_billing.Click_Submit_Button_on_PayBillingPage();
    	

    	//******Customer ID is displayed correctly*****
    	
		//public static void CustomerID_Displayed(String args[]) {
			String str= new String("Customer ID:- 501465");
			//System.out.println("Substring starting from index 15:");
			//System.out.println(str.substring(15));
			System.out.println("Substring starting from index 15 and ending at 20:");
			System.out.println(str.substring(15, 20));
    	
    }
    
    
}
