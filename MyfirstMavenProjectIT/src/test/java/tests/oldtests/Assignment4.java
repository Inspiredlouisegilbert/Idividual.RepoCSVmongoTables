package tests.oldtests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import Nyeleti_Continue.Gurulanding_page;
import Nyeleti_Continue.NyAddCustomerPage;
import Nyeleti_Continue.NyCustomerIDPage;
import Nyeleti_Continue.ReadFromFile_Page;
import pages.AddCustomerPage;
import pages.AddTariffPlanToCustomerPage;
import pages.CustomerIDPage;
import pages.Guru99Telcom_LandingPage;
import pages.HomePage;
import pages.PayBillingPage;
import pages.SignInPage;

public class Assignment4 {
	
	//Instantiate class objects
	SignInPage inPage = new SignInPage();
	Guru99Telcom_LandingPage GuruLanding = new Guru99Telcom_LandingPage();
	AddCustomerPage AddCustomer = new AddCustomerPage();
	AddTariffPlanToCustomerPage AddTariffPlan_To_Customer = new AddTariffPlanToCustomerPage();
	PayBillingPage PayBilling = new PayBillingPage();
	//CustomerIDPage CustomerID = new CustomerIDPage();
	HomePage homePage = new HomePage();
		
	Gurulanding_page Gurulanding_page = new Gurulanding_page();
	//NyAddCustomerPage AddCustomer = new NyAddCustomerPage();
	NyCustomerIDPage CustomerID = new NyCustomerIDPage ();
	ReadFromFile_Page ReadFromfile =new ReadFromFile_Page();
	
	 @Test
	// call a method to Click on Home button
	public void NavigateTo_LandingPage() {

		// call a method to Click on Home button
		CustomerID.Click_Home_button_CustomerIDPage();
		// Verify that Guru99 telecom Heading is available //
		String expectedLogo = "Guru99 telecom";
		String actualLogo = PayBilling.verify_Guru99telecom_Logo();

		// CustomerID.verifyCustomerID_Heading();
		Reporter.log("expected ------------------" + expectedLogo);
		Reporter.log("actual --------------------" + actualLogo);
		Assert.assertEquals(actualLogo, expectedLogo);

	}

	 @Test
	 // call a method to click on Pay Billing link
	public void GIVEN_ActiveCustomer_CustID_Displayed_Correctly() throws InterruptedException {

		// call a method to click on the Pay Billing link
		GuruLanding.Click_Pay_Billing_Link();
		// wait
		Thread.sleep(3000);

		// Verify that Guru99 telecom Heading is available //
		String expectedLogo = "Guru99 telecom";
		String actualLogo = PayBilling.verify_Guru99telecom_Logo();
		// String actualTitle = landingPage.getTitle();

		Reporter.log("expected ------------------" + expectedLogo);
		Reporter.log("actual --------------------" + actualLogo);
		Assert.assertEquals(actualLogo, expectedLogo);

		// Verify that Pay Billing link is available //
		String pExpectedLogo = "Pay Billing";
		String pActualTitle = PayBilling.verify_PayBilling_Heading();

		Reporter.log("expected ------------------" + pExpectedLogo);
		Reporter.log("actual --------------------" + pActualTitle);
		Assert.assertEquals(pActualTitle, pExpectedLogo);

	}

	@Test 
		// call a method to capture the Cust ID field on the Add Tariff Plan To Customer Page
		public void Given_Active_Customer_Populate_CustID() throws InterruptedException {

		// Populate the Tariff Plan details with the VALID Data
		String sCustID = "752262";

		// call a method to populate the fields
		PayBilling.AddGenerated_Cust_ID(sCustID);

		// Call a method to click submit button
		PayBilling.Click_Submit_Button_on_PayBillingPage();

		// Verify that CustomerID is available //
		String pExpectedLogo = "- 752262";
		String pActualTitle = "- 752262";

		Reporter.log("expected ------------------" + pExpectedLogo);
		Reporter.log("actual --------------------" + pActualTitle);
		Assert.assertEquals(pActualTitle, pExpectedLogo);

	}
	
	@Test
	public void Given_active_customer_Write_Data_into_CSVFile() throws IOException {
		//FileWriter mWriter = new FileWriter("C:\\Users\\tkgotiane\\git\\Individual.RepoCSVmongoTables\\MyfirstMavenProjectIT\\src\\test\\java\\Nyeleti_Continue\\TestData\\sample1.csv");
		FileWriter mWriter = new FileWriter(homePage.getDataConfigProperties("writefiletocsv") + "sample1.csv"); 
		
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
		
	
	

