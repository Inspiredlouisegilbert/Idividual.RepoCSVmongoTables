package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import frameworkclasses.BasePage;
import frameworkclasses.SeleniumFunctions;

public class TelcomLanding_Page {

	
	public String verifyTelcomLandingPage() {
        
        //String text = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
		
		//Instantiate Selenium Functions
		SeleniumFunctions sfSelenium = new SeleniumFunctions();
		String pURL = "http://demo.guru99.com/telecom/index.html";


		// driver variable
		WebDriver driver = null;
		//Temp
		boolean eleDisplayed;
		
		
		//String pURL;
		driver.get(pURL); 
		sfSelenium.maximiseBrowserWindow();
		

		//CLICK ON THE Add Customer
		//public void clickAddCustomer() {         
		//driver.findElement(By.class("logo")) >Guru99 telecom</a>);
		//span[@id='header']//a[@href='index.html']
		// Add customer xpath from guru.com 
		//section[@id='main']/div[@class='inner']//h1[.='Add Customer']
		//String actualString = driver.findElement(By.xpath("section[@id='main']/div[@class='inner']//h1[.='Add Customer']")).getText();
		//  assertTrue(actualString.contains("Add Customer"));  
		//}
		
		
        //return text;
		return pURL;
    }
	

}