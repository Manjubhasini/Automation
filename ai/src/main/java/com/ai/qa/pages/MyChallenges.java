package com.ai.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ai.qa.base.TestBase;

public class MyChallenges extends TestBase {
	private static Logger log = LogManager.getLogger(MyChallenges.class.getName());
	@FindBy(xpath="//li[@class='active']")
	WebElement path;
	@FindBy(xpath="//a[@class='startup']")
	WebElement myactivities;
	
	public MyChallenges()
	{
		PageFactory.initElements(driver, this);
		
	}

		
}
