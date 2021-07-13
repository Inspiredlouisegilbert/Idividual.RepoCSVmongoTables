	package pages;

	import org.openqa.selenium.By;
	import static org.junit.Assert.assertTrue;
	import static org.testng.Assert.fail;

	import java.io.IOException;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.Reporter;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.testng.asserts.Assertion;
	import org.testng.asserts.SoftAssert;

	import frameworkclasses.BasePage;
	import frameworkclasses.SeleniumFunctions;

	public class AddTariffPlanToCustomerPage extends BasePage{

	  
	public String verify_Guru99telecom_Logo() {
	    
	    
	// Verify that Guru99 telecom Logo is available //
	String verifyTelcomLandingLogo = driver.findElement(By.cssSelector(".logo")).getText();
	Assert.assertEquals(verifyTelcomLandingLogo,"Guru99 telecom");

	return  verify_Guru99telecom_Logo(); 

	}
	 
	 public String verify_Add_Tariff_PLan_to_Customer_Header() {
	//Verify that Add Tariff PLan to Customer Link is available //
		String actual_link = driver.findElement(By.cssSelector ("h1")).getText(); 
		Assert.assertEquals(actual_link, "Add Tariff PLan to Customer"); 
	
		return  verify_Add_Tariff_PLan_to_Customer_Header(); 

	}

	public void AddGenerated_Cust_ID(String sCustID) {

	   // Add the generated Customer ID   
	   //String Cust_ID = driver.findElement(By.cssSelector("#customer_id")).getText();
	   populateInputField(By.name("customer_id"),sCustID);
	 //Populate the billing details

	}

	private void populateInputField(By name, String sCustID) {
		// TODO Auto-generated method stub
		
	}

	public void  Click_Submit_Button_on_AddTrariffPlantoCustomer() {

	   //Click on Submit button 
	   driver.findElement(By.cssSelector("input[name='submit']")).click();

	}
	    
	public String Verify_CustomerActive() {

	//Verify that Customer is Active //
	String pCustActive = driver.findElement(By.cssSelector ("font")).getText(); 
	Assert.assertEquals(pCustActive,"ACTIVE");

	return pCustActive;

	}


	public String Verify_CustomerInActive() {

	//Verify that Customer is Active //
	String pCustInActive = driver.findElement(By.cssSelector ("font")).getText(); 
	Assert.assertEquals(pCustInActive,"INACTIVE");

	return pCustInActive;
	}


	//testcase3

	public boolean Generated_ApprovedTariffPlan() throws InterruptedException {


	    // Assert at least one approved tariff plan is displayed
	      boolean IntMinutes = driver.findElement(By.cssSelector("[method] [align='center']:nth-of-type(4) b")).isDisplayed();
	      //String actualSlength = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).getText();
	          
	      return IntMinutes;

	}


	public void  Given_Select_Tariff_Plan_radio_button_selected() {

	//Select approved tariff plan
	//Select On Pending radio button
	driver.findElement(By.cssSelector("[for]")).click();
	}


	public void  Click_AddTrariffPlantoCustomerButton() {
	//Click Add Tariff Plan to Customer
	  driver.findElement(By.cssSelector("input[name='submit']")).click();

	}

	public String Verify_SuccessMessage() {

	//Verify that success message is displayed //
	String pSuccess = driver.findElement(By.cssSelector ("h2")).getText(); 
	Assert.assertEquals(pSuccess,"Congratulation Tariff Plan assigned");

	return pSuccess;
	}

	

}
