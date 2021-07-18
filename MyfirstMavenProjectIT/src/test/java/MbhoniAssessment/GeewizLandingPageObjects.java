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
    	 Thread.sleep(500);
    	 driver.findElement(By.xpath("//div[@id='search_widget']/form/button/i")).click();
     }
     
     public void clickDropDown() throws InterruptedException {
    	WebElement element = driver.findElement(By.xpath("//div[@id='js-product-list-top']/div/div[2]/div/div/div/button"));
    	Thread.sleep(2000);
     }
     
     
     public void selectFromDropDown() throws InterruptedException {
    	 WebElement element = driver.findElement(By.xpath("//div[@id='js-product-list-top']/div/div[2]/div/div/div/div/a[5]"));
    	 Actions actions = new Actions(driver);
    	 actions.moveToElement(element).click().perform();
    	 Thread.sleep(2000);
     }
	

}
