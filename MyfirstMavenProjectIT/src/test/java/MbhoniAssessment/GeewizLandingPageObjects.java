package MbhoniAssessment;

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

public class GeewizLandingPageObjects extends BasePage {
	
     public void searchProduct(String searchProducts) throws InterruptedException { 	 	
        //Enter text solar in the search text box
    	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.findElement(By.xpath("//input[@name=\"s\"]")).sendKeys(searchProducts);
        //driver.findElement(By.xpath("//input[@name=\"s\"]")).sendKeys("mbhoni");
        Thread.sleep(500);
    }
     
     public void openUrl () {
    	 String systemUnderTest = getDataConfigProperties("systemUnderTestAss");
    	 driver.get(systemUnderTest); 	 
     }
     
     public void clickSearchButton() throws InterruptedException {
    	 driver.findElement(By.xpath("//div[@id='search_widget']/form/button/i")).click();
    	 Thread.sleep(500);
     }
     
     public void clickDropDown() throws InterruptedException {
    	driver.findElement(By.xpath("//div[@id='js-product-list-top']/div/div[2]/div/div/div/button")).click();
    	Thread.sleep(500);
     }
     // -------------------------------------------------------------------
     // Over Load method
     
     public void selectFromDropDown() throws InterruptedException {
    	 Thread.sleep(3000);
    	 WebElement element = driver.findElement(By.xpath("//div[@id='js-product-list-top']/div/div[2]/div/div/div/div/a[5]"));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(500);
     }
     
     public void selectFromDropDownCsv(String selectSortBy) throws InterruptedException {
    	 Thread.sleep(4000);
    	 WebElement element = driver.findElement(By.xpath(selectSortBy));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(500);
     }
    // --------------------------------------------------------------------
     // Over Load method
     
     public void clickFirstResult () throws InterruptedException {
    	 Thread.sleep(4000);
    	 driver.findElement(By.cssSelector(".ajax_block_product:nth-child(1) .h3 > a")).click();
    	 Thread.sleep(2000);
     }
     
     public void clickFirstResultCsv(String selectFistResults) throws InterruptedException {
    	 Thread.sleep(3000);
    	 WebElement element = driver.findElement(By.cssSelector(selectFistResults));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(500);
     }
     // ----------------------------------------------------------------------
     public void enterQuanity(String enterQuanity) throws InterruptedException {
    	 driver.findElement(By.id("quantity_wanted")).clear();
    	 Thread.sleep(5000);
    	 driver.findElement(By.id("quantity_wanted")).sendKeys(enterQuanity);  
         Thread.sleep(500);
     }
     
     public void lowStockPopWindow() throws InterruptedException {
    	 //driver.findElement(By.cssSelector(".cancel-button > span")).clear();
    	 
    	 WebElement element = driver.findElement(By.cssSelector(".cancel-button > span"));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(2000);
     }
     
     public void addToCart() throws InterruptedException {
    	 Thread.sleep(2000);
    	 driver.findElement(By.cssSelector(".add-to-cart-geewiz")).click();
    	 Thread.sleep(2000);
     }
     
     public void clickContinueShopping() throws InterruptedException {
    	 Thread.sleep(2000);
    	 //check for  an element if is displayed
    	 driver.findElement(By.cssSelector(".cart-content-btn > .btn-secondary")).click();
    	 Thread.sleep(2000);
    	 System.out.println("Continue Shopping is clicked");
     }
     
     public void vaildateCartAmount() {
    	 driver.findElement(By.cssSelector(".title-cart")).click();
    	 String totalAmount = driver.findElement(By.cssSelector(".product-price:nth-child(1)")).getText();
    	 String totalAmountStrip = totalAmount.replaceAll(",", ""); 	 
    	 String s= totalAmountStrip.substring(1);  
    		
    	 float f=Float.parseFloat(s); 
    	 System.out.println(f);
    	 Assert.assertTrue(f > 10.0);
     }

	public void waitForClick(int elementWait,By pLocator) {
    	WebDriverWait wait = new WebDriverWait(BasePage.driver,elementWait);
    	wait.until(ExpectedConditions.elementToBeClickable(pLocator));
    }
	
}