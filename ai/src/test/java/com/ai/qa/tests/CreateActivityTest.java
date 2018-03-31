package com.ai.qa.tests;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ai.qa.base.TestBase;
import com.ai.qa.pages.HomePage;
import com.ai.qa.pages.LaunchPage;
import com.ai.qa.pages.LinkedLoginPage;
import com.ai.qa.pages.LoginPage;
import com.ai.qa.pages.MyActivities;
import com.ai.qa.pages.PostActivityPage;
import com.ai.qa.util.ExcelData;
import com.ai.qa.util.ExtentReportAI;

public class CreateActivityTest extends TestBase{
	private static Logger log = LogManager.getLogger(CreateActivityTest.class.getName());
	LaunchPage l1;
	LoginPage lp;
	LinkedLoginPage ll;
	HomePage hp;
	PostActivityPage pc;
	MyActivities mc;
	ExcelData excel;
	ExtentReportAI extentobject;
	
	public CreateActivityTest()
	{
		super();
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		extentobject = new ExtentReportAI();
		extentobject.startreport();
	}
	@BeforeTest
	public void beforeTest()
	{   // Open Excel File to read data
		log.debug("Before Test method is called");
	    excel = new ExcelData(getExcelPath("qa1"));
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		initialization();
	    l1 = new LaunchPage();
	}
	
   @DataProvider(name="createActivityData")
   public Object[][] createActivityData()
   {
	 // Data is read from excel for createactivity test
	 return excel.getTestData("createactivity"); 
   }
   
   @Test(retryAnalyzer=com.ai.qa.util.RetryAnalyzer.class, dataProvider="createActivityData")
  public void createActivityTest(Map<Object,Object> testdata) {
	  extentobject.initreport("createActivityTest"); 
	  log.debug("Posting a new activity test is started");
	  lp = l1.clickLogin();
	  ll=lp.clickLinkedinLogin();
	  hp=ll.processLogin(testdata.get("username").toString(),testdata.get("password").toString());
	  boolean t = hp.getTitle().contains("Home");
	  Assert.assertTrue(t);
	  log.debug("In Home Page");
	   pc=hp.clickCreateActivity();
	   t=pc.getTitle().contains("Post a C");
	   Assert.assertTrue(t);
	   log.debug("In Post a activity Page");
	   pc.setActivityTitle(testdata.get("title").toString());
	   pc.setActivityDescription(testdata.get("description").toString());
	   pc.setTeamMember(Float.valueOf(testdata.get("teammember").toString()).intValue());
	   pc.setSetLink(testdata.get("linkurl").toString(),testdata.get("linkcode").toString());
	   pc.setAnonymousId(testdata.get("anonymousid").toString());
	   pc.setKeywords(Float.valueOf(testdata.get("keyword1").toString()).intValue(),Float.valueOf(testdata.get("keyword2").toString()).intValue(),Float.valueOf(testdata.get("keyword3").toString()).intValue());
	   mc=pc.submitPublish();
	   
	  
	   t=mc.getTitle().contains("My");
	   System.out.println("title is "+mc.getTitle()+"and it is "+ t);
	  // Assert.assertTrue(t);
	   log.debug("Posting a new activity test is completed successfully");
  }
  
   @AfterMethod
   public void afterTest(ITestResult result) {
   	     System.out.println(" Test "  +result.getStatus());
   	     extentobject.putLog(result, driver,getScreenPath());
	     log.info("Screen capture placed in extent report");
      }
   
   @AfterSuite
   public void afterSuite()
   {
   	extentobject.printreport();
   }
}
