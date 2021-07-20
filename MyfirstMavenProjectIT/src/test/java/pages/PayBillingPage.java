package pages;

import org.openqa.selenium.By;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class PayBillingPage extends BasePage{
	
	//******TEST CASE 1******
	
	public String verify_Guru99telecom_Logo() {
	    
	    
		// Verify that Guru99 telecom Logo is available //
		String verifyTelcomLandingLogo = driver.findElement(By.cssSelector(".logo")).getText();
		Assert.assertEquals(verifyTelcomLandingLogo,"Guru99 telecom");

		return  verify_Guru99telecom_Logo(); 

		}
		 
		 public String verify_PayBilling_Heading() {
			 
			 
		//Verify that Pay Billing Heading is available //
			String actual_link = driver.findElement(By.cssSelector ("h1")).getText(); 
			//Assert.assertEquals(actual_link,"Pay Billing"); in test
		
			return  verify_PayBilling_Heading(); 

		}
		 public void AddGenerated_Cust_ID(String sCustID) {

			   // Add the generated Customer ID   
			   //String Cust_ID = driver.findElement(By.cssSelector("#customer_id")).getText();
			   populateInputField(By.name("#customer_id"),sCustID);
			 //Populate the billing details

			}

			private void populateInputField(By name, String sCustID) {
				// TODO Auto-generated method stub
			//use sendkeys line ..check examples in other projects
			}

			public void  Click_Submit_Button_on_PayBillingPage() {

			   //Click on Submit button 
			   driver.findElement(By.cssSelector("input[name='submit']")).click();

			}
			    
			public String Verify_ValidCustomerID() {

			//Verify that Customer ID is correctly displayed //
			String pCustomerID = driver.findElement(By.cssSelector ("h3")).getText(); 
			 //Assert.assertEquals(pCustomerID,"Customer ID:******"); in test
			//only return values in the page

			return pCustomerID;

			}
			//******TEST CASE 2******
			
			
			
			public String Verify_ValidCustomerName() {

				//Verify that Customer Name is correctly displayed //
				String pCustomerName = driver.findElement(By.cssSelector ("h3")).getText(); 
				Assert.assertEquals(pCustomerName,"Customer Name:******");

				return pCustomerName;

			}
			
			public String Table_LocalMinutes() {
			
				
			WebElement LocalMinutes = driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]"));
			
			return LocalMinutes();
			}
			
			public String Table_InternationalMin() {
				
			}
			WebElement InternationalMin = driver.findElement(By.xpath("//table/tbody/tr[2]/td[5]"));	
			
			return InternationalMinutes();
			
			}

			public String PayBillingTable_SMSPack() {
				
			WebElement SMSPack = driver.findElement(By.xpath("//table/tbody/tr[3/td[5]"));	
			
			return SMSPack;
			
			}
			
			public String PayBillingTable_UsageCharges() {
			
			WebElement UsageCharges = driver.findElement(By.xpath("//table/tbody/tr[5]/td[5]"));
			
			return UsageCharges;
			
			}
				
	int UsageCharges = LocalMinutes + IntMinutes + SMSPack;
	
	Expected_Usage_Charges = driver.findElement(By.xpath("//table/tbody/tr[5]/td[5]"));
	Assert.assertEquals(UsageCharges,"Customer ID:******");	
			
	String UsageCharges = driver.findElement(By.xpath("//label[.='Special characters are not allowed']")).getText();
	Assert.assertEquals(actualString1, "Special characters are not allowed");
			
	}
			
			
