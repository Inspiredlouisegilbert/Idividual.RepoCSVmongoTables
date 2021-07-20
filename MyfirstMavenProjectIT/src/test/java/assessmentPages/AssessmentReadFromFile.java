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
	String pProductOneURL = "https://www.geewiz.co.za/batteries/5319-royal-delkor-ns70-65ah-battery-12-volt.html";
	String pProductTwoURL = "https://www.geewiz.co.za/homeware/115733-totally-washing-dryer-line.html";
	String pProductThreeURL = "https://www.geewiz.co.za/hand-tools/143450-carolus-socket-wrench-set-1-2-inch-24-piece.html";

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
		System.out.println("Product has been added to the cart");
		System.out.println("Product search from file completed successfully");
		Thread.sleep(5000);
		submit();
		driver.get(pURL);
		}
	
	public void submit() {
		driver.findElement(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]")).click();
	}
}