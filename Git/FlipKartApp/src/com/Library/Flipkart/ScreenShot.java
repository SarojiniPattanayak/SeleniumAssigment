/**
 * 
 */
package com.Library.Flipkart;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;


/**
 * @author SPR
 *
 */
public class ScreenShot extends BaseTest{
	
	public static void getScreenshot(WebDriver driver ) throws IOException
	{

		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir")+"/Screenshots/screenshotchrome.png";
		File destination=new File(dest);
		FileUtils.copyFile(source, destination);
		

	}
}

	
