package com.ai.qa.util;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportAI {
	private static Logger log = LogManager.getLogger(ExtentReportAI.class.getName());
	ExtentHtmlReporter htmlreporter;
	ExtentReports extentreport;
	ExtentTest extenttest;
	
	public void startreport()
	{
	   htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/first.html");
	   extentreport = new ExtentReports();
	   extentreport.attachReporter(htmlreporter);
	   extentreport.setSystemInfo("OS ", "Windows");
	   extentreport.setSystemInfo("Application ", "TestApplication");
	   extentreport.setSystemInfo("Environment ", "AFT");
	   htmlreporter.config().setDocumentTitle("Report for TestApplication testing");
	   htmlreporter.config().setReportName("TestApplication");
	   htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
	   htmlreporter.config().setTheme(Theme.DARK);
	    log.info("Extent Report information loaded");
	}
	public void initreport(String testname)
	{
	   extenttest=extentreport.createTest(testname);
	   log.info("Extent Report is initialized for "+testname);
	}
	
	public void putLog(ITestResult result, WebDriver driver, String screenshot) 
	{   
		String screenpath;
		if(result.getStatus()==ITestResult.FAILURE)
		{   
			extenttest.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" test case failed", ExtentColor.RED));
			extenttest.fail(result.getThrowable());
			try {
				screenpath = CaptureScreenAI.capture(driver, screenshot);
				if (screenpath !=null)
				{
					extenttest.fail("Snapshot below" +extenttest.addScreenCaptureFromPath(screenpath));
				log.error("Test case is failed and Screenshot is available");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else		
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			extenttest.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" test case passed", ExtentColor.GREEN));
		    try { screenpath = CaptureScreenAI.capture(driver, screenshot);
				if (screenpath !=null)
				{
					extenttest.pass("Snapshot below" +extenttest.addScreenCaptureFromPath(screenpath));
				log.debug("Test case is passed and Screenshot is available");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			log.error("Test case is skipped");
			extenttest.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" test case skipped", ExtentColor.YELLOW));
		}
	}
	
	public void printreport()
	{
		extentreport.flush();
		log.info("ExtentReport is generated");
	}
	

}

