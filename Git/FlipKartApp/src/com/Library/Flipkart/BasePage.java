/**
 * 
 */
package com.Library.Flipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author SPR
 *
 */
public class BasePage {
	
	public BasePage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

}
