package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddCustomer {

	
	//Populate the billing details
	public void populate_biling_data(String sfname,String slname, String semailid,String saddr,String stelephoneno ) {

	Object sfSelenium;
	sfSelenium.populateInputField(By.name("fname"),sfname);
	sfSelenium.populateInputField(By.name("lname"),slname);
	sfSelenium.populateInputField(By.name("emailid"),semailid);
	sfSelenium.populateInputField(By.name("addr"),saddr);
	sfSelenium.populateInputField(By.name("telephoneno"),stelephoneno);
	}

	 
	public void Given_Invalid_Data_Entered_Then_warning_message_Displayed() throws InterruptedException {

	
	// Click on Add Customer
	//By driver;
	driver.findElements(By.linkText("Add Customer")).click();

	Thread.sleep(1000);
	//String actualString = driver.findElement(By.cssSelector("h1")).getText();

		// Customer
	String actualString = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
	// assertTrue(actualString.contains("Add Customer"));
	Assert.assertEquals(actualString, "Add Customer");
	Reporter.log("The actual result is "+actualString);

	Reporter.log("The expected result is "+"Add Customer");	
}
	
}
