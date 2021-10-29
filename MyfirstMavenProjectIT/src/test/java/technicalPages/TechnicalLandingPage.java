package technicalPages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;

public class TechnicalLandingPage extends BasePage{

		String pURL = "http://automationpractice.com/index.php";
		String sProductsearch = "Printed Dress";
		String sInvalidProduct = "Cape town";
		String sEmailAddress = "email@gmail.com";
		String sorderNumber = "1234";
		String sMessage = "Message text here";
		boolean eleDisplayed;
		
		//SELENIUM FUNCTIOND INSTANTIATE
		static SeleniumFunctions sfSelenium = new SeleniumFunctions();
		Utilities uts = new Utilities();
		
		public void landingpage() throws InterruptedException {
			driver.get(pURL);
			driver.findElement(By.linkText("Women")).click();
			System.out.println("Test passed: Women link clicked");
			Thread.sleep(5000);
			driver.findElement(By.linkText("Tops")).click();
			Thread.sleep(5000);
			System.out.println("Test passed: Tops link clicked");
			driver.findElement(By.linkText("T-shirts")).click();
			Thread.sleep(5000);
			System.out.println("Test passed: T-shirsts link clicked");
			
			//IMPLICIT WAIT FOR ELEMENT VISIBE
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body.category.category-5.category-tshirts.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-9 div.content_scene_cat:nth-child(1) div.content_scene_cat_bg > div.cat_desc")));
	
			//IMPLICITLY WAIT FOR ELEMENT
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			
			//VERIFY WHETHER ELEMENT IS VISIBLE
			eleDisplayed = driver.findElement(By.xpath("//div[@id='center_column']//div[@class='content_scene_cat_bg']")).isDisplayed();
			System.out.println("Test passed: Element is visible");
		}
		
		public void takescreenshot() {
			try {
				uts.takeSnapShot("onTestStart"+uts.timereturn()+".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void searchproduct() throws InterruptedException {
			driver.get(pURL);
			driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(sProductsearch);	
			driver.findElement(By.xpath("//form[@id='searchbox']/button[@name='submit_search']")).click();
			eleDisplayed = driver.findElement(By.xpath("//div[@id='center_column']//span[@class='lighter']")).isDisplayed();
			System.out.println("Test passed: Text displayed as expected");
		}
		
		public void searchproductNegativeTest() throws InterruptedException {
			driver.get(pURL);
			driver.findElement(By.xpath("//input[@id='search_query_top']")).clear();
			driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(sInvalidProduct);	
			driver.findElement(By.xpath("//form[@id='searchbox']/button[@name='submit_search']")).click();
			eleDisplayed = driver.findElement(By.xpath("//p[contains(text(),'No results were found for your search \"cape town\"')]")).isDisplayed();
			System.out.println("Test passed: Text displayed as expected");
			
			//NAVIGATE BACK TO THE HOME PAGE
			driver.get(pURL);
		}
		
		public void ContactUs() throws InterruptedException {
			driver.get(pURL);
			Thread.sleep(5000);
			
			sfSelenium.clickLink("Contact us");
			Select objSelect = new Select(driver.findElement(By.cssSelector("#id_contact")));
			driver.findElement(By.xpath("//select[@id='id_contact']")).click();
			objSelect.selectByVisibleText("Customer Service");
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(sEmailAddress);
			driver.findElement(By.xpath("//input[@id='id_order']")).sendKeys(sorderNumber);
			driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(sMessage);
			
			//CLICK SUBMIT
			driver.findElement(By.cssSelector("body.contact.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 form.contact-form-box fieldset:nth-child(1) div.submit button.button.btn.btn-default.button-medium:nth-child(3) > span:nth-child(1)")).click();
		}
		
		public void registration() throws InterruptedException {
			driver.get(pURL);
			Thread.sleep(5000);
			sfSelenium.clickLink("Sign in");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(sEmailAddress);
			driver.findElement(By.cssSelector("body.authentication.hide-left-column.hide-right-column.lang_en:nth-child(2) div.columns-container div.container div.row:nth-child(3) div.center_column.col-xs-12.col-sm-12 div.row div.col-xs-12.col-sm-6:nth-child(1) form.box div.form_content.clearfix div.submit:nth-child(4) button.btn.btn-default.button.button-medium.exclusive:nth-child(2) > span:nth-child(1)")).click();
		}
}