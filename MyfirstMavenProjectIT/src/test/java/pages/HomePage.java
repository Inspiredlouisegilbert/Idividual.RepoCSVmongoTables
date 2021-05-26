package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;

import frameworkclasses.BasePage;

public class HomePage extends BasePage{
	
	public String verifyCorrectLogin() {
        
        String text = driver.findElement(By.xpath("//a[@class='account']/span")).getText();
        return text;
    }
	

}
