package com.ai.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameUtility {
	
	public static int findFrameNumber(WebDriver driver,By byid)
	{   int totalframes = driver.findElements(By.tagName("iframe")).size();
		int i,count;
		for(i=0;i<totalframes;i++)
		{
			count = driver.findElements(byid).size();
			if(count>0)
				break;
		}
  return i;
}
}