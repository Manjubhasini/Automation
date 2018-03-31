package com.ai.qa.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ai.qa.base.TestBase;
import com.ai.qa.pages.HomePage;
import com.ai.qa.pages.LaunchPage;
import com.ai.qa.pages.LinkedLoginPage;
import com.ai.qa.pages.LoginPage;

public class LaunchLogin extends TestBase{
	private static Logger log = LogManager.getLogger(LaunchLogin.class.getName());
	LaunchPage l1;
	LoginPage lp;
	LinkedLoginPage ll;
	HomePage hp;
	public LaunchLogin()
	{
		super();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		initialization();
	    l1 = new LaunchPage();
	}
	
  @Test
  public void loginPageTest() {
	  log.debug("Login functionality Test started");
	  lp = l1.clickLogin();
	  ll=lp.clickLinkedinLogin();
	  hp=ll.processLogin("g","y");
	  boolean t = hp.getTitle().contains("Home");
	  Assert.assertTrue(t);
	  log.debug("Login functionality Test executed succesfully");
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
}
