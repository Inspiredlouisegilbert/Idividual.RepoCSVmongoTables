package Nyeleti_Continue;


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

	public class Pay_billing_page extends BasePage{
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
				    
				public void Getactive_cust() {
					
					driver.findElement(By.name("customer_id")).sendKeys("262246");

					
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
					
					
					
					public String GETSMSPack() {

				//Expected Result:Usage charge value is equal to local min and int min and sms pack usage charge amount

					

				int localmins= 50;
				int Intermins = 200;
				int smspack = 0;
				
				
				int usagecharge = localmins +  Intermins + smspack ;
				
				String Actual_usagecharge = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
				Assert.assertEquals(Actual_usagecharge, usagecharge);	
				
				return GETSMSPack();
				
					
			 }
								
				public String GetBillAmount() {

				//Expected Result:Total Bill amount displayed correctly

					
				int TarrifPlanAmt= 500;
				int UsageCharge = 200;
		
				
				
				int TotalBill = TarrifPlanAmt +  UsageCharge;
				
				String Actual_TotalBill = driver.findElement(By.xpath("//table/tbody/tr[6]/td[2]")).getText();
				Assert.assertEquals(Actual_TotalBill, TotalBill);	
				
				return GetBillAmount();
				
					
			}
				
				
					
					
	}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					

