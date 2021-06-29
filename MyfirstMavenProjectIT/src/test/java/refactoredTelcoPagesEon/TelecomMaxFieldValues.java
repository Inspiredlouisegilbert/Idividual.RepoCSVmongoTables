package refactoredTelcoPagesEon;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.SignInPage;
import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Refactored.testsAssignment3;

public class TelecomMaxFieldValues extends BasePage{
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	testsAssignment3 clAssignment3 = new testsAssignment3();
	TelecomPayBilling clPayBilling = new TelecomPayBilling();
	String sClientID = "205621";
	
	//String pURL = "http://demo.guru99.com/telecom/assigntariffplantocustomer.php";

//	public void navigatetourl()
//	{
//		driver.get(pURL);
//	}
	
//	public void readfromfile() throws IOException, InterruptedException 
//	{
//		String readfromdir = getDataConfigProperties("readfromdir");
//		String pCustomerID = "";
//		
//		BufferedReader br = new BufferedReader(new FileReader(readfromdir)); 
//		String line;
//		while ((line = br.readLine()) != null) { 
//			if(line.length() > 0) {
//		    // use xx as separator.
//			    String[] cols = line.split(";"); 
//			    System.out.println(cols[0]); 
//				pCustomerID = cols[0];
//				
//				captureID(line);
//				submit();   
//				System.out.println("CustomerID successfully imported from selected CSV file");
//			}
//		}
//		// close the buffer
//		br.close();
//	}
	
//	public void captureID(String pClientID) throws InterruptedException {
//		//sfSelenium.populateInputField(By.cssSelector("#customer_id"), pClientID);
//		driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
//		submit();
//	}
//	
//	public void submit() throws InterruptedException {
//		this.driver.findElement(By.tagName("input")).click();
//	}
//	
	public void getMaxvaluesMonthlyRentals() throws ParseException, InterruptedException {
		 driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php"); 
		 driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
		 this.driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		 String max;
	     double m=0,r=0;
		 
	        //No. of Columns
	        List  col = driver.findElements(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[1]/tr[1]/td"));		//TOTAL COLUMNS
	        System.out.println("Total No of columns are : " +col.size());
	        
	        //No.of rows
	        List  rows = driver.findElements(By.xpath ("//section[@id='main']/div[@class='inner']/div//tr/td[1]"));		//TOTAL ROWS
	        System.out.println("Total No of rows are : " + rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
//	            max= driver.findElement(By.xpath("section[@id='main']/div[@class='inner']/div//tr[" + (i+1) + "]/td[1]")).getText();
	            max= driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[" + (i+1) + "]/tr/td[1]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum value is : "+ r);
	}
	
	public void getMaxvaluesLocalMinutes() throws ParseException, InterruptedException {
		 driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php"); 
		 driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
		 this.driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		 String max;
	     double m=0,r=0;
		 
	        //No. of Columns
	        List  col = driver.findElements(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[1]/tr[1]/td"));		//TOTAL COLUMNS
	        System.out.println("Total No of columns are : " +col.size());
	        
	        //No.of rows
	        List  rows = driver.findElements(By.xpath ("//section[@id='main']/div[@class='inner']/div//tr/td[1]"));		//TOTAL ROWS
	        System.out.println("Total No of rows are : " + rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
//	            max= driver.findElement(By.xpath("section[@id='main']/div[@class='inner']/div//tr[" + (i+1) + "]/td[1]")).getText();
	            max= driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[" + (i+1) + "]/tr/td[2]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum value is : "+ r);
	}
	
	public void getMaxvaluesInternationalMinutes() throws ParseException, InterruptedException {
		 driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php"); 
		 driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
		 this.driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		 String max;
	     double m=0,r=0;
		 
	        //No. of Columns
	        List  col = driver.findElements(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[1]/tr[1]/td"));		//TOTAL COLUMNS
	        System.out.println("Total No of columns are : " +col.size());
	        
	        //No.of rows
	        List  rows = driver.findElements(By.xpath ("//section[@id='main']/div[@class='inner']/div//tr/td[1]"));		//TOTAL ROWS
	        System.out.println("Total No of rows are : " + rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
//	            max= driver.findElement(By.xpath("section[@id='main']/div[@class='inner']/div//tr[" + (i+1) + "]/td[1]")).getText();
	            max= driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[" + (i+1) + "]/tr/td[3]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum value is : "+ r);
	}
	
	public void getMaxvaluesSMSPack() throws ParseException, InterruptedException {
		 driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php"); 
		 driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
		 this.driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		 String max;
	     double m=0,r=0;
		 
	        //No. of Columns
	        List  col = driver.findElements(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[1]/tr[1]/td"));		//TOTAL COLUMNS
	        System.out.println("Total No of columns are : " +col.size());
	        
	        //No.of rows
	        List  rows = driver.findElements(By.xpath ("//section[@id='main']/div[@class='inner']/div//tr/td[1]"));		//TOTAL ROWS
	        System.out.println("Total No of rows are : " + rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
//	            max= driver.findElement(By.xpath("section[@id='main']/div[@class='inner']/div//tr[" + (i+1) + "]/td[1]")).getText();
	            max= driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[" + (i+1) + "]/tr/td[4]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum value is : "+ r);
	}
	
	public void getMaxvaluesPerLocalMinutesCharges() throws ParseException, InterruptedException {
		 driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php"); 
		 driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
		 this.driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		 String max;
	     double m=0,r=0;
		 
	        //No. of Columns
	        List  col = driver.findElements(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[1]/tr[1]/td"));		//TOTAL COLUMNS
	        System.out.println("Total No of columns are : " +col.size());
	        
	        //No.of rows
	        List  rows = driver.findElements(By.xpath ("//section[@id='main']/div[@class='inner']/div//tr/td[1]"));		//TOTAL ROWS
	        System.out.println("Total No of rows are : " + rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
//	            max= driver.findElement(By.xpath("section[@id='main']/div[@class='inner']/div//tr[" + (i+1) + "]/td[1]")).getText();
	            max= driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[" + (i+1) + "]/tr/td[5]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum value is : "+ r);
	}
	
	public void getMaxvaluesPerInternationalMinutesCharges() throws ParseException, InterruptedException {
		 driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php"); 
		 driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
		 this.driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		 String max;
	     double m=0,r=0;
		 
	        //No. of Columns
	        List  col = driver.findElements(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[1]/tr[1]/td"));		//TOTAL COLUMNS
	        System.out.println("Total No of columns are : " +col.size());
	        
	        //No.of rows
	        List  rows = driver.findElements(By.xpath ("//section[@id='main']/div[@class='inner']/div//tr/td[1]"));		//TOTAL ROWS
	        System.out.println("Total No of rows are : " + rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
//	            max= driver.findElement(By.xpath("section[@id='main']/div[@class='inner']/div//tr[" + (i+1) + "]/td[1]")).getText();
	            max= driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[" + (i+1) + "]/tr/td[6]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum value is : "+ r);
	}
	
	public void getMaxvaluesPerSMSCharge() throws ParseException, InterruptedException {
		 driver.get("http://demo.guru99.com/telecom/assigntariffplantocustomer.php"); 
		 driver.findElement(By.xpath("//input[@id='customer_id']")).sendKeys(sClientID);
		 this.driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/form[@action='assigntariffplantocustomer.php']//input[@name='submit']")).click();
		 String max;
	     double m=0,r=0;
		 
	        //No. of Columns
	        List  col = driver.findElements(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[1]/tr[1]/td"));		//TOTAL COLUMNS
	        System.out.println("Total No of columns are : " +col.size());
	        
	        //No.of rows
	        List  rows = driver.findElements(By.xpath ("//section[@id='main']/div[@class='inner']/div//tr/td[1]"));		//TOTAL ROWS
	        System.out.println("Total No of rows are : " + rows.size());
	        
	        for (int i =1;i<rows.size();i++)
	        {    
//	            max= driver.findElement(By.xpath("section[@id='main']/div[@class='inner']/div//tr[" + (i+1) + "]/td[1]")).getText();
	            max= driver.findElement(By.xpath("//section[@id='main']/div[@class='inner']/div/table[@class='alt']/tbody[" + (i+1) + "]/tr/td[7]")).getText();
	            NumberFormat f =NumberFormat.getNumberInstance(); 
	            Number num = f.parse(max);
	            max = num.toString();
	            m = Double.parseDouble(max);
	            if(m>r)
	             {    
	                r=m;
	             }
	        }
	        System.out.println("Maximum value is : "+ r);
	}
}