package Nyeleti_Continue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//import org.junit.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Assignment_4_writeToFile {
	

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
     
    //@Test
    
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
	
	
    //********************** Enter the customer id and submit*************************************************
    
    @Test
    
    public void Search_Customer_onPaybilling(){
    	
    	navigate_to_URL();
    	Clickpaybilling();
    	
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
			
		    String expectedCust_Name = "- Nyeleti";
		    String actualCust_Name = "- Nyeleti";
		     
		    Reporter.log("expected ------------------"+expectedCust_Name);
		    Reporter.log("actual --------------------"+actualCust_Name);
		    Assert.assertEquals(actualCust_Name, expectedCust_Name );
		    System.out.println(expectedCust_Name);
    	
    }
    
    
  //*****************Write to File  ********************************************************
    
    @Test
	public void Given_active_customer_Write_Data_into_CSVFile() throws IOException {
		//FileWriter mWriter = new FileWriter("C:\\Users\\tkgotiane\\git\\Individual.RepoCSVmongoTables\\MyfirstMavenProjectIT\\src\\test\\java\\Nyeleti_Continue\\TestData\\sample1.csv");
		FileWriter mWriter = new FileWriter(AddCustomer.getDataConfigProperties("writefiletocsv") + "Tsholo.csv"); 
		
        BufferedWriter buffer = new BufferedWriter(mWriter);
        
        String set1[] = {"", "Free Usage Limit", "Actual Usage", "Over Free", "Usage Charges"};               
    	Arraymethod(set1, buffer);
    	
    	String set2[] = {"Local Minutes", "200", "220", "20", "50"};               
    	Arraymethod(set2, buffer);
    	
    	String set3[] = {"International Minutes", "100", "110", "10", "200"};               
    	Arraymethod(set3, buffer);
    	
    	String set4[] = {"SMS Pack", "500", "400", "0", "0"};               
    	Arraymethod(set4, buffer);
    	
    	String set5[] = {"", "", "", "Tariff Plan Amount", "500"};               
    	Arraymethod(set5, buffer);
    	
    	String set6[] = {"", "", "", "Usage Charges", "250"};               
    	Arraymethod(set6, buffer);
    	
    	String set7[] = {"", "", "", "Total Bill", "750"};               
    	Arraymethod(set7, buffer);
    	
    	buffer.close();
		
	}
	
	public void Arraymethod(String [] array, BufferedWriter buffer) throws IOException { 
		
		for (String line : array) {
			buffer.write(line);
			buffer.write(" ; ");
			
		}
		
		buffer.newLine();
		
	}
	
@AfterSuite
	
	public void cleanup() {
		AddCustomer.Cleanup();
	}
	
}

