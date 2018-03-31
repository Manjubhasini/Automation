package com.ai.qa.util;
import java.io.File; 
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenAI {
	private static Logger log = LogManager.getLogger(CaptureScreenAI.class.getName());
	 
	public static String capture(WebDriver driver, String screenshotname) throws IOException
	{
		String dest;
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = (File) ts.getScreenshotAs(OutputType.FILE);
		dest = System.getProperty("user.dir")+"/ErrorScreens/"+screenshotname+".png";
		System.out.println("Just Checking man   "+ dest);
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		log.info("Screen is captured for this test case");
		return dest;
	}
}