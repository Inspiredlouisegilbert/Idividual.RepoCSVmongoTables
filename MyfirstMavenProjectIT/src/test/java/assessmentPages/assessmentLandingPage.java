package assessmentPages;

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

public class assessmentLandingPage extends BasePage{

		String pURL = "https://www.geewiz.co.za/";
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
			
			try {
			String sHotInfo = driver.findElement(By.xpath("/html//body[@id='index']/div[@class='hotinfo_top']/table//td/span/span")).getText();
			Reporter.log("expected ------------------"+ "Please note: Due to the nationwide civil unrest, there may be some unforeseen courier and/or stock delays. We apologise for the inconvenience and will do our best to try keep them to a minimum");
			Reporter.log("actual ------------------"+ sHotInfo);
			Assert.assertEquals("Please note: Due to the nationwide civil unrest, there may be some unforeseen courier and/or stock delays. We apologise for the inconvenience and will do our best to try keep them to a minimum", sHotInfo);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		public void takescreenshot() {
			try {
				uts.takeSnapShot("onTestStart"+uts.timereturn()+".png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void searchproduct() throws InterruptedException {
			driver.findElement(By.xpath("//div[@id='search_widget']/form[@action='//www.geewiz.co.za/search']/input[@name='s']")).sendKeys(sProductsearch);
			driver.findElement(By.xpath("//div[@id='search_widget']/form[@action='//www.geewiz.co.za/search']//i[@class='material-icons search']")).click();
			driver.findElement(By.xpath("/html//div[@id='js-product-list-top']/div[@class='row']//button[@class='btn-unstyle select-title']/i[.='']")).click();
			driver.findElement(By.linkText("PRICE, LOW TO HIGH")).click();
			takescreenshot();
			Thread.sleep(5000);
			driver.findElement(By.linkText("SwitchBot Curtain")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("/html//input[@id='quantity_wanted']")).clear();
			
			//IMPLICIT WAIT FOR ELEMENT VISIBE
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#quantity_wanted")));
			
			driver.findElement(By.xpath("/html//input[@id='quantity_wanted']")).sendKeys(sQuantity);
			takescreenshot();
			Thread.sleep(5000);
			
			//QUANTITY VALUE IN TABLE
			WebElement getQuantity = driver.findElement(By.xpath("//form[@id='add-to-cart-or-refresh']/section[@class='product-discounts']/table[@class='table-product-discounts']//td[.='5']"));
			System.out.println("Quantity: " + getQuantity.getText());
			
			//QUANTITY AMOUNT IN TABLE
			WebElement getAmount = driver.findElement(By.xpath("//form[@id='add-to-cart-or-refresh']/section[@class='product-discounts']/table[@class='table-product-discounts']//td[.='R2,255']"));
			System.out.println("Amount: " + getAmount.getText());
		
			//IMPLICITLY WAIT FOR ELEMENT
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			driver.findElement(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]")).click();
			Thread.sleep(5000);
			
//			//click on continue shopping
//			driver.findElement(By.xpath("/html//div[@id='product_confirmation_modal']/div[@class='actions']/button[1]/span")).click();
//			driver.findElement(By.xpath("/html//input[@id='quantity_wanted']")).clear();
//			driver.findElement(By.xpath("/html//input[@id='quantity_wanted']")).sendKeys(sQuantityTwo);
//			driver.findElement(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]")).click();
//			driver.findElement(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content-btn']/button[@type='button']")).click();
}
		
		public void submit() throws InterruptedException {
			driver.findElement(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]")).click();
			takescreenshot();
			Thread.sleep(5000);
		}
		
		public void viewcart() throws InterruptedException {
			
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html//form[@id='add-to-cart-or-refresh']//div[@class='add']/button[1]")).click();
		//driver.findElement(By.xpath("//div[@id='cart-block']//a[@href='//www.geewiz.co.za/cart?action=show']/i[@class='shopping-cart']")).click();
			
		//HANDLE POPUP NOT VALID FOR THIS ASSESSMENT
		//I USED ELEMENT DISPLAYED WITH BOOLEAN VALUE
		try {
				Alert alert = this.driver.switchTo().alert(); 
				String sAlertMessage = alert.getText();
				Assert.assertEquals("Please note the current stock status is:", sAlertMessage);
				System.out.println("Expected popup message: " + sAlertMessage); 
				alert.accept();  
			}
		catch(Exception e) {
				System.out.println(e);
			}
		
//			//QUANTITY VALUE IN TABLE
//			WebElement getQuantity = driver.findElement(By.xpath("//form[@id='add-to-cart-or-refresh']/section[@class='product-discounts']/table[@class='table-product-discounts']//td[.='5']"));
//			System.out.println("Quantity: " + getQuantity.getText());
//			
//			//QUANTITY AMOUNT IN TABLE
//			WebElement getAmount = driver.findElement(By.xpath("//form[@id='add-to-cart-or-refresh']/section[@class='product-discounts']/table[@class='table-product-discounts']//td[.='R2,255']"));
//			System.out.println("Amount: " + getAmount.getText());
			
			Thread.sleep(5000);
			eleDisplayed = driver.findElement(By.xpath("//div[@id='product_confirmation_modal']/div[@class='confirmations']/p")).isDisplayed();
			System.out.println("Expected text: IN STOCK AT OVERSEAS SUPPLIER - DISPATCHED/COLLECTION IN 14-20 DAYS " + eleDisplayed);
			Thread.sleep(5000);
			
			Reporter.log("expected ------------------" + "Expected text: IN STOCK AT OVERSEAS SUPPLIER - DISPATCHED/COLLECTION IN 14-20 DAYS");
		    Reporter.log("actual --------------------"+ eleDisplayed);
			
			//CLICK CONTINUE BUTTON
			driver.findElement(By.xpath("//div[@id='product_confirmation_modal']/div[@class='actions']/button[1]")).click();
			System.out.println("Product successfully added to to your shopping cart");
			Thread.sleep(5000);

			//LOW STOCK POPUP VISIBILE
			boolean bStock;
			try {
				bStock = driver.findElement(By.xpath("//p[contains(text(),'Please note the current stock status is:')]")).isDisplayed();
			}
			catch(Exception e){
				bStock = false;
			}
			
			if (bStock) {
				//HOME PAGE NAVIGATION
				driver.get("https://www.geewiz.co.za/");
			}
			else {
				//CLICK CHECKOUT
				driver.findElement(By.xpath("/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[3]/div[1]/div[2]/button[1]")).click();
				Thread.sleep(5000);
				//CLICK CONTINUE SHOPPING
				driver.findElement(By.xpath("//button[contains(text(),'Continue shopping')]")).click();
			}
		}
		
		public void getcarttotal() throws IOException {
			String scarttotal = driver.findElement(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content']/p[2]/span[@class='value']")).getText();
			int x= scarttotal.indexOf("R");
			String scarttotalstripped = scarttotal.replaceAll(",", "");
			String s = scarttotalstripped.substring(1);
			float f = Float.parseFloat(s);
			
			System.out.println("Cart total is: " + scarttotal);
			
			if (f > 100) {
				System.out.println("Cart total is greater than R100.00 cart amount is: " + scarttotal);
			}
			else
				System.out.println("Cart total is not greater than R100.00 cart amount is: " + scarttotal);
			
			driver.findElement(By.xpath("/html//div[@id='blockcart-modal']/div[@role='document']/div[@class='modal-content']//div[@class='cart-content-btn']/button[@type='button']")).click();
			
			//WRITE TO FILE
			FileWriter myWriter = new FileWriter("CartTotal.csv");
			myWriter.write(scarttotal);
			myWriter.close();
			System.out.println("Cart total has been exported to file: " + "CartTotal.csv");
			
			Reporter.log("expected ------------------" + "Greater than 100");
		    Reporter.log("actual --------------------"+ scarttotal);
		}
}