package com.ai.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ai.qa.base.TestBase;

public class MyActivities extends TestBase {
	private static Logger log = LogManager.getLogger(MyActivities.class.getName());
	@FindBy(xpath="//li[@class='active']")
	WebElement path;
	@FindBy(xpath="//a[@class='startup']")
	WebElement myactivities;
	
	public MyActivities()
	{
		PageFactory.initElements(driver, this);
		
	}

		
}
