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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import frameworkclasses.BasePage;
import frameworkclasses.DriverSetup;
import frameworkclasses.SeleniumFunctions;
import frameworkclasses.Utilities;

public class TechnicalLandingPage extends BasePage{

		String pURL = "http://automationpractice.com/index.php";
		String sProductsearch = "Solar";
		String sProductLowStock = "DJI Osmo Pocket Charging Case, Open Box";
		String sQuantity = "10";
		String sQuantityTwo = "1";
		boolean eleDisplayed;
		
		//SELENIUM FUNCTIOND INSTANTIATE
		static SeleniumFunctions sfSelenium = new SeleniumFunctions();
		Utilities uts = new Utilities();
		
		public void landingpage() {
			driver.get(pURL);
			
			
		}
		
		public void takescreenshot() {
			try {
				uts.takeSnapShot("onTestStart"+uts.timereturn()+".png");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void searchproduct() throws InterruptedException {
			
		}
		
		public void submit() throws InterruptedException {

		}
		
		public void viewcart() throws InterruptedException {
			
		}
		
		public void getcarttotal() throws IOException {

		}
}