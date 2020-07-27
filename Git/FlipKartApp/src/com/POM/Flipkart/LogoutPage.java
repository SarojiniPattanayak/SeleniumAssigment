/**
 * 
 */
package com.POM.Flipkart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Library.Flipkart.BasePage;

/**
 * @author SPR
 *
 */
public class LogoutPage extends BasePage {
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[text()='My Account']")
	WebElement myaccount;
	@FindBy(xpath = "//a[@class='_2k68Dy']//div[text()='Logout']")
	WebElement logout;

	public void clickMyaccount1() {
		myaccount.click();
	}

	public void clickMyaccount(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", myaccount);
	}

	public void logOut() {
		logout.click();
	}
}
