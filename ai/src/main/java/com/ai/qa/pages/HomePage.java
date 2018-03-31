package com.ai.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ai.qa.base.TestBase;


public class HomePage extends TestBase {
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	@FindBy(how = How.XPATH, using="//a[@type='button' and text()='CREATE A CHALLENGE']")
	WebElement createactivity;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	 public PostActivityPage clickCreateActivity()
    {   JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollTo(0,200)");
    	createactivity.click();
    	log.info("Window is scrolled and CreateChallenge is clicked");
    	return new PostActivityPage ();
    }
}
