package MbhoniAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import frameworkclasses.BasePage;

public class GeewizLandingPageObjects extends BasePage {
	
     public void searchProduct(String searchProducts) throws InterruptedException {
    	
        //Enter text solar in the search text box
        driver.findElement(By.xpath("//input[@name=\"s\"]")).sendKeys(searchProducts);  
        Thread.sleep(500);
    }
     
     public void clickSearchButton() throws InterruptedException {
    	 driver.findElement(By.xpath("//div[@id='search_widget']/form/button/i")).click();
    	 Thread.sleep(500);
     }
     
     public void clickDropDown() throws InterruptedException {
    	driver.findElement(By.xpath("//div[@id='js-product-list-top']/div/div[2]/div/div/div/button")).click();
    	Thread.sleep(500);
     }
     
     
     public void selectFromDropDown() throws InterruptedException {
    	 WebElement element = driver.findElement(By.xpath("//div[@id='js-product-list-top']/div/div[2]/div/div/div/div/a[5]"));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(500);
     }
     
     public void clickFirstResult () throws InterruptedException {
    	 Thread.sleep(2500);
    	 driver.findElement(By.cssSelector(".ajax_block_product:nth-child(2) .h3 > a")).click();
    	 Thread.sleep(2000);
     }
     
     public void enterQuanity(String enterQuanity) throws InterruptedException {
    	 driver.findElement(By.id("quantity_wanted")).clear();
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
    	 driver.findElement(By.cssSelector(".cart-content-btn > .btn-secondary")).clear();
    	 Thread.sleep(2000);
     }
     

}
