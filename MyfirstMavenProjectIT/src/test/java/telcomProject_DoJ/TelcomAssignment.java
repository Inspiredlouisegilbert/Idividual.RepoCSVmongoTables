package telcomProject_DoJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import frameworkclasses.SeleniumFunctions;

public class TelcomAssignment {

  public static void main(String[] args) {
      // TODO Auto-generated method stub

 }
                
                //DRIVER VARIABLE
                WebDriver driver;
                SeleniumFunctions sfSelenium = new SeleniumFunctions();
                // Set URL
                String pURL = "http://demo.guru99.com/telecom/index.html";
                
                //NAVIGATE TO URL
                public void navigateToURL(String pURL) {
                driver.get(pURL);
                sfSelenium.maximiseBrowserWindow();
                }
                                                
                //CLICK ON THE Add Customer
                public void clickAddCustomer() {
                sfSelenium.clickLink("Add Customer");
                                
                } 
                
    // Assert that the Heading is Guru 99 Telcom and Add Customer
    //Assert.assertEquals(actualTitle, expectedTitle);     
                
                
 //Test case 1: GIVEN invalid data entered  THEN warning message displayed
public void populateInpute(String pFisrtname ,String pLastName, String pEmail, String pAdress) {
                
                //sfSelenium.findElement(By.css("//label[@for=" + 'done' +  "]")).click();
                
                driver.findElement(By.cssSelector("[for='done']")).click();
                                
                sfSelenium.populateInputField(By.name("fname"), pFisrtname);
                
                sfSelenium.populateInputField(By.name("lname"), pLastName);
                
                sfSelenium.populateInputField(By.name("emailid"), pEmail);
                
                sfSelenium.populateInputField(By.name("addr"), pAdress);

                driver.findElement(By.name("submit")).click();
                
 }


	/*
	 * public void runTestReadFromFile () throws IOException, InterruptedException {
	 * 
	 * 
	 * sfSelenium.createTest("Run Test: Read From File"); // Input test Data String
	 * pQuantity = "3"; String pCardNumber = ""; String pExpMonth = ""; String
	 * pExpYear = ""; String pCVV = ""; String csvdir = getProperties("csvdir");
	 * 
	 * BufferedReader br = new BufferedReader(new FileReader(csvdir)); String line;
	 * while ((line = br.readLine()) != null) { if(line.length() > 0) { // use xx as
	 * separator. String[] cols = line.split(";"); System.out.println(cols[0]);
	 * pCardNumber = cols[0]; pCVV = cols[1]; pExpMonth = cols[2]; pExpYear =
	 * cols[3]; navigateToURL(pURL);
	 * 
	 * //clickPaymentGateway();
	 * 
	 * //selectQuantity(pQuantity);
	 * 
	 * // clickBuyNow();
	 * 
	 * // capturePaymentDetails(pCardNumber, pExpMonth, pExpYear, pCVV);
	 * 
	 * //clickPay(); } } // close the buffer br.close(); }
	 */

    private String getProperties(String string) {
    // TODO Auto-generated method stub
    return null;
}


     
}

