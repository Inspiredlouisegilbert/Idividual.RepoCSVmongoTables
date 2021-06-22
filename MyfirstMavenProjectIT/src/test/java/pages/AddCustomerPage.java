package pages;

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


/*Strategy:
1. Let's deal with Pages
2. Fix the code into the Pages Errors and More
3. Framework classes - Add Utilities
4. Test
5. POM file 
6. Listeners
*/
public class AddCustomerPage extends BasePage{

	// function to populate an input field using multiple By clauses
	public void populateInputField(By byClause, String inputValue) {
	driver.findElement(byClause).sendKeys(inputValue);
										
	}
	
	public void  Given_Submit_button_isClicked() {
		//click on Submit
	     driver.findElement(By.name("submit")).click();
		
	}
	
		public void  Given_Done_radio_Option_button() {
		
		//Select On Done radio button
		driver.findElement(By.cssSelector("[for='done']")).click();
	}
	
	public void  Given_Reset_button_isClicked() {
	    //Click on Reset button to Clear the fields
	    driver.findElement(By.cssSelector("input[value='Reset']")).click();
		
	}
	
	 
	public void Given_verifyAddCustomerPage() throws InterruptedException {
	
	// Verify Add Customer Page
	String actualString = driver.findElement(By.cssSelector("h1")).getText();
	Assert.assertEquals(actualString, "Add Customer");
	
		//Select On Done radio button
		//driver.findElement(By.cssSelector("[for='done']")).click();

		   
	    // verify if the validation message displays below the field  // 
		String actualString1 = driver.findElement(By.xpath("//label[.='Special characters are not allowed']")).getText();
		Assert.assertEquals(actualString1, "Special characters are not allowed");
		
	  
	}
	
	
	
	
	  //==========================
	
	  	public void Given_Invalid_Data_When_submit_Button_IsPresedOn_Then_Alert() throws InterruptedException {
	  
		//click on Submit
	    // driver.findElement(By.name("submit")).click();
	      
	       //HANDLE UNSUCCESSFUL POPUP ALERT
	      sfSelenium.createTest("Run Alert Failure: Unsuccessful login popup text test"); // we need help on this function
	      String pExpectedMessage = "please fill all fields";
	      Alert alert = this.driver.switchTo().alert();
	      String sAlertMessage = alert.getText();
	      Assert.assertEquals(sAlertMessage, "please fill all fields");
	      //write to the console
	      System.out.println(sAlertMessage);
	    	      
	      //Click on OK button on the POP-UP
	      alert.accept();
	      Thread.sleep(5000);
	  
	  }

	
}
	

