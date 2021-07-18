package MbhoniAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import frameworkclasses.BasePage;

public class ProductSearchPageAss extends BasePage{

    
    
    //method to return the product text





	public String getProductSearchResult() {
		// TODO Auto-generated method stub
		String result = driver.findElement(By.xpath("//div[@class='right-block']//a[@class='product-name']")).getText();
        return result;
	}

}