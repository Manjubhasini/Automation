package com.ai.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGExecutionListner implements ITestListener {
	private static Logger log = LogManager.getLogger(TestNGExecutionListner.class.getName());
	  		public void onTestStart(ITestResult result) {
			log.info(result.getTestName()+" is started");
		}
		public void onTestSuccess(ITestResult result) {
			log.info(result.getTestName()+" is successful");
			
		}
		public void onTestFailure(ITestResult result) {
			log.info(result.getTestName()+" is failed");			
		}
		public void onTestSkipped(ITestResult result) {
			log.info(result.getTestName()+"  is skipped");
		}
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			log.info(result.getTestName()+" Failed within success % ");
			
		}
		public void onStart(ITestContext context) {
			log.info(context.getSuite()+" is executed");
		}
		public void onFinish(ITestContext context) {
			log.info(context.getSuite()+" is finished");
			
		}
		
	}

