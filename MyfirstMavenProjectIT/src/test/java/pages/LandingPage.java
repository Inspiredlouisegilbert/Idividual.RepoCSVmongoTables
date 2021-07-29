package pages;

import org.openqa.selenium.By;

import frameworkclasses.BasePage;


public class LandingPage extends BasePage{
	
	//First Test. This title should be verified in LandingPageTest class
    public String getTitle() {
        return driver.getTitle();
		} 
    
    // example method that returns a config parameter value
    public String getSomethingFromConfigFile(String configParameter) {
    	return configParameter = getDataConfigProperties(configParameter);
		} 

    //Searching for a product at landing page returns (displays) product search page. Hence 
    //the return type is ProductSearchPage and return value is new ProductSearchPage() 
     public String ProductSearch () {
        //Enter text dress in the search text box
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        
        //Click on Search button
        driver.findElement(By.name("submit_search")).click();
        
        //Product search page is displayed
        return ProductSearch ();
       
    }
    
    //Click on Sign In button
    public SignInPage clickOnSignIn() {
        
    	driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
        
        //clicking on Sign In button will display Sign In page
        return new SignInPage();
    }
}