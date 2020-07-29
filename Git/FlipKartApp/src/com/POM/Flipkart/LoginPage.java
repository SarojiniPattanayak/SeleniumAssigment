/**
 * 
 */
package com.POM.Flipkart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.Library.Flipkart.BasePage;
import com.Library.Flipkart.ExcellData;

/**
 * @author SPR
 *
 */
public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='_1XBjg- row']//input[@type='text']")
	WebElement uname;

	@FindBy(xpath="//div[@class='_1XBjg- row']//form//input[@type='password']")
	WebElement pwd;

	@FindBy(xpath = "//div[@class='_1XBjg- row']//form//button[@type='submit']")
	WebElement login;		
	
	
	public void Login_Flipkart() throws IOException  {
		String filePath = "D:\\Git\\FlipKartApp\\Excell";
		String unall=ExcellData.readExcel(filePath, "Data.xlsx", "Sheet1");
		int index = unall.indexOf(' ');
		String un = unall.substring(0, index);
		String pw = unall.substring(index+1,unall.length());
		uname.sendKeys(un);
		pwd.sendKeys(pw);
		login.click();
		Reporter.log("user is able to login the application");

	}


}
