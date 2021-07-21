package MbhoniAssessment;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import frameworkclasses.BasePage;
import pages.HomePage;

public class GeewizLandingPageObjectsReadFromCsv extends BasePage {
	boolean eleDisplayed;
	
     public void searchProduct(String searchProducts) throws InterruptedException { 
    	 Thread.sleep(500);
    	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//input[@name=\"s\"]")).sendKeys(searchProducts);
        Thread.sleep(500);
        System.out.println("Search For a Product With Data From CSV");
    }
     
     public void clickSearchButton() throws InterruptedException {
    	 Thread.sleep(500);
    	 driver.findElement(By.xpath("//div[@id='search_widget']/form/button/i")).click();
    	 Thread.sleep(500);
    	 System.out.println("Click The Magnifying Glass Button");
     }
     
     public void clickDropDown() throws InterruptedException {
    	 Thread.sleep(500);
    	driver.findElement(By.xpath("//div[@id='js-product-list-top']/div/div[2]/div/div/div/button")).click();
    	Thread.sleep(500);
    	System.out.println("Click The DropDown");
     }
     
     public void selectFromDropDownCsv(String selectSortBy) throws InterruptedException {
    	 Thread.sleep(5000);
    	 WebElement element = driver.findElement(By.xpath(selectSortBy));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(500);
    	 System.out.println("Select From DropDown With Data From CSV");
     }
     
     public void clickFirstResultCsv(String selectFistResults) throws InterruptedException {
    	 Thread.sleep(7000);
    	 WebElement element = driver.findElement(By.cssSelector(selectFistResults));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(500);
    	 System.out.println("First Product Clicked With Data From CSV");
     }

     public void enterQuanityCsv(String enterQuanity) throws InterruptedException {
    	 Thread.sleep(3000);
    	 driver.findElement(By.id("quantity_wanted")).clear();
    	 Thread.sleep(5000);
    	 driver.findElement(By.id("quantity_wanted")).sendKeys(enterQuanity);
    	 try {
				eleDisplayed = driver.findElement(By.id("quantity_wanted")).isDisplayed();
				System.out.println("Successful Inserted quantity: " + eleDisplayed);
				//sfSelenium.createTest("Successful Login");
			}
			catch(NoSuchElementException e) {
				System.out.println(e);
			}
         Thread.sleep(500);
     }
     
     public void lowStockPopWindow() throws InterruptedException {
    	 //driver.findElement(By.cssSelector(".cancel-button > span")).clear();
    	 
    	 WebElement element = driver.findElement(By.cssSelector(".cancel-button > span"));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(2000);
    	 System.out.println("Low Stock Pop Window Is Handled");
     }
     
     public void addToCart() throws InterruptedException {
    	 Thread.sleep(2000);
    	 driver.findElement(By.cssSelector(".add-to-cart-geewiz")).click();
    	 Thread.sleep(2000);
    	 System.out.println("Product Is Added To Cart");
     }
     
     public void clickContinueShopping() throws InterruptedException {
    	 Thread.sleep(2000);
    	 //check for  an element if is displayed
    	 driver.findElement(By.cssSelector(".cart-content-btn > .btn-secondary")).click();
    	 Thread.sleep(2000);
    	 System.out.println("Continue Shopping Is Clicked");
     }
     
     public void vaildateCartAmount() throws IOException {
    	 driver.findElement(By.cssSelector(".title-cart")).click();
    	 String totalAmount = driver.findElement(By.cssSelector(".cart-total > .value")).getText();
    	 
    	 String totalAmountStrip = totalAmount.replaceAll(",", ""); 	 
    	 String s= totalAmountStrip.substring(1);  	
    	 float f=Float.parseFloat(s); 
    	 System.out.println("Total Amount Is R " + f);

    	 boolean result = f > 100.0 ? true : false;
    	 Assert.assertTrue(result, "Total Amount is R " + f);
    	  
    	 int a= totalAmount.indexOf("R");
    	 FileWriter myWriter = new FileWriter("AddCartTotal.csv");
    	 myWriter.write(totalAmount);
    	 myWriter.close();
    	 System.out.println("Export The Cart Amount"); 
     }

	public void waitForClick(int elementWait,By pLocator) {
    	WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
    	wait.until(ExpectedConditions.elementToBeClickable(pLocator));
    }
	
}
