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

public class CustomerIDPage extends BasePage {
	
	public void  verifyCustomerID() {
		
	// verify that the Access Details to Guru99 Telecom Heading is displays //
	String actualHeading = driver.findElement(By.cssSelector("h1")).getText();
    //assertTrue(expectedString.contains("Customer ID"));
     Assert.assertEquals(actualHeading, "Access Details to Guru99 Telecom");
    
        
    // Asset for the Customer ID that keeps on Changing
      boolean actualString3 = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).isDisplayed();
      String actualSlength = driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/")).getText();
      System.out.println(actualSlength);
      
      Assert.assertTrue(actualSlength.length() > 0);
      Assert.assertEquals(actualString3, true);
      

	}
	
}

