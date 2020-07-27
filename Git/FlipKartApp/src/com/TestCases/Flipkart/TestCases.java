/**
 * 
 */
package com.TestCases.Flipkart;
import java.io.IOException;
import org.testng.annotations.Test;
import com.Library.Flipkart.BaseTest;
import com.POM.Flipkart.HomePage;
import com.POM.Flipkart.LoginPage;
import com.POM.Flipkart.LogoutPage;



/**
 * @author SPR
 *
 */
public class TestCases extends BaseTest {

	@Test
	public void checkLoginUser() throws InterruptedException, IOException {
		

	LoginPage loginpage=new LoginPage(driver);
	
	//call the method for login the application
	loginpage.Login_Flipkart();
	
	//create object for homepage
	HomePage homepage = new HomePage(driver);
	Thread.sleep(2000);
	
	//Enter value in search bar
	homepage.enterValueInSearch("dell laptops");
	
	//enter in search bar
	homepage.pressEnter();
	Thread.sleep(2000);
	
	//get the value from search page
	homepage.getTheValueFromSearchPage();	
	Thread.sleep(2000);
	
	
	homepage.performMousOver();
	homepage.clickUsingJavascriptExecutor(driver);
	Thread.sleep(2000);
	
	//handle the new window using window handler and add to cart
	homepage.windowHandler(driver);
	Thread.sleep(5000);
	
	//get the value from checkout page
	homepage.getTheValueFromcheckoutPage();
	
	//verify information in between two pages
	homepage.verifyInfoInSearchAndCheckoutPage();
	
	//Logout the application
	LogoutPage log=new LogoutPage(driver);
	log.clickMyaccount(driver);
	Thread.sleep(2000);
	log.logOut();
	
	}
}
	
	

