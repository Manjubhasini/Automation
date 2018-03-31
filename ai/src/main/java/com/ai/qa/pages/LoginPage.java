package com.ai.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.ai.qa.base.TestBase;

public class LoginPage extends TestBase {
	private static Logger log = LogManager.getLogger(TestBase.class.getName());
	//@FindBy(how = How.XPATH, using = "//a[@title ='Login']")
    //WebElement linkedinlogin;
	
	@FindBy(how = How.XPATH, using = "//a[@class ='btn ripple-effect btn-primary linkedin-signup']")
    WebElement linkedinlogin;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LinkedLoginPage clickLinkedinLogin()
	{
		linkedinlogin.click();
		log.debug("Login through Linkedin clicked");
		return new LinkedLoginPage();
	}
}
