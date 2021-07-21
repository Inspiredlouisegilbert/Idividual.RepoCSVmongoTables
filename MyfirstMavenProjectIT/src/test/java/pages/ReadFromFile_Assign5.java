package pages;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

import org.openqa.selenium.By;

public class ReadFromFile_Assign5 {
	
	public void populateInputField(By byClause, String inputValue) {
		driver.findElement(byClause).sendKeys(inputValue);
											
		}
		
		//Populate the billing details
		public void GIVEN_populate_biling_data(String sfname,String slname, String semailid,String saddr,String stelephoneno ) {

		populateInputField(By.name("fname"),sfname) ;
		populateInputField(By.name("lname"),slname);
		populateInputField(By.name("emailid"),semailid);
		populateInputField(By.name("addr"),saddr);
		populateInputField(By.name("telephoneno"),stelephoneno);
				
		}
		           

public void runTestReadFromFile () throws IOException, InterruptedException {


		sfSelenium.createTest("Run Test: Read From File");
            

            // Input test Data

            String sfname = "";

            String slname = "";

            String semailid = "";

            String saddr = "";

            String stelephoneno ="";
                   

           String csvdir = getProperties("csvdir");
                                        
            BufferedReader br = new BufferedReader(new FileReader(csvdir));

            String line;

            while ((line = br.readLine()) != null) {

                            if(line.length() > 0) {

                // use ; as separator.

                                String[] cols = line.split(";");

                                System.out.println(cols[0]);

                                sfname = cols[0];

                                slname = cols[1];

                                semailid = cols[2];

                                saddr = cols[3];

                                stelephoneno = cols[4];

                               

                                                               

            //select Done under Background Check

               driver.findElement(By.cssSelector("[for='done']")).click();

                              

             //populate details

              populateInputField(sfname , slname,  semailid,  saddr, stelephoneno);

             //take a screen shot

             sfSelenium.logScreenShot();  

             Thread.sleep(5000);
             
      


             
                            }
}
