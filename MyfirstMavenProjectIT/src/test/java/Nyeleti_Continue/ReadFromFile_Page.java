package Nyeleti_Continue;

import java.io.IOException;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadFromFile_Page extends BasePage {
	
	public void populateInputField(By byClause, String inputValue) {
      driver.findElement(byClause).sendKeys(inputValue);
		}
				
	
	public void Getactive_cust() {
		
		driver.findElement(By.name("customer_id")).sendKeys("501465");

		
	}
			
			
	//Populate the billing details
	public void g_Fill_in(String sfname,String slname,String semailid,String saddr,String stelephoneno) {

	populateInputField(By.name("fname"),sfname) ;
	populateInputField(By.name("lname"),slname);
	populateInputField(By.name("emailid"),semailid);
	populateInputField(By.name("addr"),saddr);
	populateInputField(By.name("telephoneno"),stelephoneno);
					
	}
	
	
	public void runTestReadFromFile () throws IOException, InterruptedException {


		//createTest("Run Test: Read From File");
            
         // Input test Data

            String sfname = "";
            String slname = "";
            String semailid = "";
            String saddr = "";
            String stelephoneno ="";
            
                   
            String csvdir = getDataConfigProperties("csvdir");
            
                        
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

                                g_Fill_in(sfname , slname,  semailid,  saddr, stelephoneno);

                               //take a screen shot

                               //sfSelenium.logScreenShot();  

                               Thread.sleep(5000);
                            }
            }
	}
}
