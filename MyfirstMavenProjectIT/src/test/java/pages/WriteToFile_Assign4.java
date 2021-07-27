package pages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.testng.Assert;

public class WriteToFile_Assign4  { 

	
public String Verify_Guru99Telecom_logo() {
        

		// Verify that Guru99 telecom Heading is available //
		//String verifyTelcomLandingPage = driver.findElement(By.cssSelector("#header .logo")).getText();
	    //Assert.assertEquals(verifyTelcomLandingPage, "Guru99 telecom");
	    
	    return Verify_Guru99Telecom_logo();
	    			    
	}
			    
	/*
	 * public String Verify_Pay_billing_heading() {
	 * 
	 * //Verify that Pay billing heading is displayed String actual_link =
	 * driver.findElement(By.cssSelector("h1")).getText();
	 * Assert.assertEquals(actual_link, "Pay Billing");
	 * 
	 * return Verify_Pay_billing_heading();
	 * 
	 * }
	 */
	
	   // Get "Assert that the Heading is Guru 99 Telcom and Pay Billing" Code from Tsholo
	    
	   // Pay billing - pay billing Enter Cust ID
	
	    
	    
	    
	
	//write table data to file
	//FileWriter myWriter = new FileWriter("StoreBillingInfo.csv");
	public static void main(String[] args) throws IOException{
	
		FileWriter myWriter = new FileWriter("StoreBillingInfo.csv");
		
		
	File file = new File("StoreBillingInfo.csv");
	FileWriter fw = new FileWriter(file);
	PrintWriter pw = new PrintWriter(fw);
	File fl = new File("C:\\PayBill_table\\StoreBillingInfo.csv");
	
	//pw.println(driver.findElement(By.cssSelector(".alt")).getText());
    //pw.close();
	
	}
	}
		