package assessmentPages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.SignInPage;
import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import frameworkclasses.ReusableFunctions;
import frameworkclasses.SeleniumFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Refactored.testsAssignment3;

public class AssessmentReadFromFile extends BasePage{
	
	SeleniumFunctions sfSelenium = new SeleniumFunctions();
	String pURL = "https://www.geewiz.co.za/";
	boolean eleDisplayed;

	public void navigatetourl()
	{
		driver.get(pURL);
	}
	
	public void readfromfile() throws IOException, InterruptedException 
	{
		String assessmentdir = getDataConfigProperties("assessmentdir");
		String pProduct = "";
		String pProductLinkText = "";
		String pQuantity = "";
		
		BufferedReader br = new BufferedReader(new FileReader(assessmentdir)); 
		String line;
		while ((line = br.readLine()) != null) { 
			if(line.length() > 0) {
		    // use xx as separator.
			    String[] cols = line.split(";"); 
			    System.out.println(cols[0]); 
			    pProduct = cols[0];
			    pProductLinkText = cols[1];
				pQuantity = cols[2];
				
			    searchProducts(pProduct, pProductLinkText, pQuantity);
			}
		}
		
		// close the buffer
		br.close();
	}
	
	public void searchProducts(String pProduct, String pProductLinkText, String pQuantity) throws InterruptedException {
		sfSelenium.populateInputField(By.cssSelector("input[name='s']"), pProduct);
		driver.findElement(By.xpath("//div[@id='search_widget']/form[@action='//www.geewiz.co.za/search']//i[@class='material-icons search']")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText(pProductLinkText)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#quantity_wanted")).clear();
		sfSelenium.populateInputField(By.cssSelector("#quantity_wanted"), pQuantity);
		System.out.println("Quantity updated successfully");
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]")).click();
		
		handlepopup();
		
		System.out.println("Product has been added to the cart");
		System.out.println("Product search from file completed successfully");
		Thread.sleep(5000);
		submit();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content-btn']/button[@type='button']")).click();
		driver.get(pURL);
		}
	
	public void handlepopup() throws InterruptedException {
		try {
		eleDisplayed = driver.findElement(By.xpath("//div[@id='product_confirmation_modal']/p[@class='heading']")).isDisplayed();
		if (eleDisplayed = true) {
			driver.findElement(By.xpath("//body[@id='product']/div[17]//a[@title='Close']")).click();
			Thread.sleep(5000);
			eleDisplayed = driver.findElement(By.xpath("//div[@id='product_confirmation_modal']/p[@class='heading']")).isDisplayed();
			System.out.println("Expected text: Please note the current stock status is: " + eleDisplayed);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@id='product_confirmation_modal']/div[@class='actions']/button[1]")).click();
			System.out.println("Product successfully added to to your shopping cart");
			Thread.sleep(5000);
			
			//CLICK CONTINUE SHOPPING
			driver.findElement(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content-btn']/button[@type='button']")).click();

		}
		else
			System.out.println("Popup not displayed");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void submit() throws InterruptedException {
		driver.findElement(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[@id='cart-block']//a[@href='//www.geewiz.co.za/cart?action=show']/i[@class='shopping-cart']")).click();
	}
	
	public void getcarttotal() {
		String scarttotal = driver.findElement(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content']/p[2]/span[@class='value']")).getText();
//		int x= scarttotal.indexOf("R");
		String scarttotalstripped = scarttotal.replaceAll(",", "");
		String s = scarttotalstripped.substring(1);
		float f = Float.parseFloat(s);
		
		System.out.println("Cart total is: " + scarttotal);
		
		if (f > 100) {
			System.out.println("Cart total is greater than R100.00 cart amount is: " + scarttotal);
		}
		else
			System.out.println("Cart total is not greater than R100.00 cart amount is: " + scarttotal);
		
		driver.findElement(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content-btn']/button[@type='button']")).click();
	}
}