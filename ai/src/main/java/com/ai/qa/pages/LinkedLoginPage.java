package com.ai.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ai.qa.base.TestBase;

public class LinkedLoginPage extends TestBase{
	private static Logger log = LogManager.getLogger(TestBase.class.getName());
	@FindBy(how = How.NAME, using = "session_key")
    WebElement username;
	@FindBy(how = How.NAME, using = "session_password")
    WebElement password;
	@FindBy(how = How.NAME, using = "authorize")
    WebElement authorize;
	@FindBy(how = How.CLASS_NAME, using = "cancel")
    WebElement cancel;
	
	public LinkedLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage processLogin(String datausername, String datapassword)
	{
		username.sendKeys(datausername);
		password.sendKeys(datapassword);
		authorize.click();
		log.debug("Username and Password entered and login clicked");
		return new HomePage();
	}
}
