package com.ai.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ai.qa.base.TestBase;



public class LaunchPage extends TestBase {
	private static Logger log = LogManager.getLogger(LaunchPage.class.getName());
	@FindBy(how = How.XPATH, using = "//a[contains(@href,'login')]")
    WebElement login;
	
	public LaunchPage()
	{
		PageFactory.initElements(driver, this);
	}
	public LoginPage clickLogin()
	{
		login.click();
		log.info("Login Button is clicked");
		return new LoginPage();
	}
}
