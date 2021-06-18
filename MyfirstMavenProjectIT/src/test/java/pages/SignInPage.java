package pages;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;

public class SignInPage extends BasePage {

		public void userSignIn(String email, String password) {
			
			driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
			driver.findElement(By.id("email")).sendKeys(email);
	        driver.findElement(By.id("passwd")).sendKeys(password);
	        driver.findElement(By.id("SubmitLogin")).click();
	        
	        //String gettest = verifyInCorrectLogin();
	        //System.out.println(gettest);
	      
	        //return new HomePage();
	    }
		
		public String verifyInCorrectLogin() {
	        
	        String text = driver.findElement(By.xpath("//div[@id='center_column']/h1[@class='page-heading']")).getText();
	       // String text = driver.findElement(By.linkText(text)
	        		
	        return text;
	    }
	
		public void cleanUp() {
			driver.quit();
		}
	}


,