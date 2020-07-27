
package com.POM.Flipkart;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.Library.Flipkart.BasePage;


/**
 * @author SPR
 *
 */
public class HomePage extends BasePage {

    Actions action;
    WebDriverWait wait;
    String substr;
    String substrC;
    String searchprice;
    String checkoutprice;
	
	public HomePage(WebDriver driver){
		super(driver);
		action=new Actions(driver);
	}
	
	@FindBy(xpath="//div[text()='My Account']")
	WebElement myaccount;
	
	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement searchforproduct;
	
	@FindBy(xpath="//span[contains(text(),'Electronics')]")
	WebElement electronics_menuname;
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div")
	WebElement searchImage;
	
	@FindBy(xpath="//div[text()='Dell G3 Core i7 9th Gen - (8 GB/1 TB HDD/512 GB SSD/Windows 10 Home/4 GB Graphics/NVIDIA Geforce GTX 1...']")
	WebElement sproductName;
	
	@FindBy(xpath="//*[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[2]/div[1]/div/div[1]")
	public static
	WebElement sproductPrice;
	
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement addToCart;
	
	@FindBy(xpath="//div[@class='_31gTpz _1RLi8m']//button//span[text()='Place Order']")
	WebElement placeOrderButton;
	
	@FindBy(xpath="//*[@id='container']/div/div[1]/div[1]/div[2]/div[5]/div/div/a/div")
	WebElement cartButton;
	
	@FindBy(xpath="//a[contains(text(), 'Dell G3 Core i7 9th Gen - (8 GB/1 TB HDD/512 GB SSD/Windows 10 Home/4 GB Graphics/NVIDIA Geforce GTX')]")
	WebElement cproductName;
	
	@FindBy(xpath="//*[@id='container']/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/span[1]")
	WebElement cproductPrice;
	
	@FindBy(xpath="//a[@class='_2k68Dy']//div[text()='Logout']")
	WebElement logout;
	
	//enter the value in search bar
	public void enterValueInSearch(String product){
		searchforproduct.click();
		searchforproduct.sendKeys(product);
		Reporter.log("User is able to enter search product");
	}
	
	//enter operation performing in search bar
	public void pressEnter(){
		action.sendKeys(Keys.ENTER).build().perform();
	}
	
	//over the mouse upto element
	public void performMousOver(){
		action.moveToElement(searchImage).build().perform();
		Reporter.log("User is able to mouseover the element");
	}
	
	//permorming click operation using javascript
	public void clickUsingJavascriptExecutor(WebDriver driver){
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", searchImage);
	}
	
	//handle the new window using window handler and clciking the add to cart button
	public void windowHandler(WebDriver driver) throws InterruptedException{
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.switchTo().window(tabs2.get(1));
	    Thread.sleep(6000);
	    try
	    {
			driver.navigate();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView();", addToCart);
			addToCart.click();
			Reporter.log("User is able to click add to cart");
	    }
	    catch (Exception e)
	    {
	    System.out.println(e);
	    }
	}
	
	// get the value from application and store in variable
	public void getTheValueFromSearchPage() {
		String searchname = sproductName.getText();
		substr = searchname.substring(0, 100);
		System.out.println("value is searchname..........." + substr);
		searchprice = HomePage.sproductPrice.getText();
		System.out.println("value is searchprice..........." + searchprice);

	}
	
	//get the value from checkout page
	public void getTheValueFromcheckoutPage(){
		String checkoutname = cproductName.getText();
		substrC = checkoutname.substring(0, 100);
		System.out.println("cart product name is: " + substrC);

		checkoutprice = cproductPrice.getText();
		System.out.println("cart product name is: " + checkoutprice);
	}
	//verify bot information
	public void verifyInfoInSearchAndCheckoutPage(){
		
		Assert.assertEquals(substr, substrC);
		Reporter.log("product name is matched");
		
		Assert.assertEquals(searchprice, checkoutprice);
		Reporter.log("product price is matched");
	}
	
	
	//validate the placeorder
	public void placeOrder(){
		if (placeOrderButton.isDisplayed()){
			Reporter.log("User is able to place order");
			Reporter.log("User is able to logout the application");
			
		} else {
			Reporter.log("User is able to place order");
			
		}
		
		
	}
	
	
	}

