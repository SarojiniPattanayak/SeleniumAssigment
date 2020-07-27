/**
 * 
 */
package com.Library.Flipkart;

import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;


/**
 * @author SPR
 * This class basetest as a subclass inherting from the interface constants
 * This class defines set the property and open the application
 */

	public class BaseTest implements constants {
		
		public WebDriver driver;
		@BeforeMethod
		public void openBrowser(){
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com");
		}
		
		@AfterMethod
		public void closeBrowser(){
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.quit();
			Reporter.log("User is able to logout the application");
		}
		
		

}
