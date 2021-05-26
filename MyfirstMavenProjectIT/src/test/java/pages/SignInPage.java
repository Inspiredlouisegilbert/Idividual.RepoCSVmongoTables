package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import frameworkclasses.BasePage;
import frameworkclasses.Utilities;

public class SignInPage extends BasePage {
	
		Utilities uts = new Utilities();

		public void userSignIn(String email, String password) throws IOException {
			
			driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
			driver.findElement(By.id("email")).sendKeys(email);
	        driver.findElement(By.id("passwd")).sendKeys(password);
	        driver.findElement(By.id("SubmitLogin")).click();
	        //System.out.println("Working Directory = " + System.getProperty("user.reportsDirectory"));
	        String outttt = uts.getAppConfigProperties("build.timestamp");
	        System.out.println("Working Directory = " +  outttt);
	        
	        //String gettest = verifyInCorrectLogin();
	        //System.out.println(gettest);
	      
	        //return new HomePage();
	    }
		
		public String verifyInCorrectLogin() {
	        
	        String text = driver.findElement(By.xpath("//div[@id='center_column']/h1[@class='page-heading']")).getText();
	        
	        return text;
	    }
	
		public void cleanUp() {
			driver.quit();
		}
		

	}


