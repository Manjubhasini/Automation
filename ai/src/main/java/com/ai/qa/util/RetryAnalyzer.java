package com.ai.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ai.qa.base.TestBase;

public class RetryAnalyzer implements IRetryAnalyzer{
	private static Logger log = LogManager.getLogger(TestBase.class.getName());
	int counter =0;
	int retrylimit=0;
	public boolean retry(ITestResult result) {
		if(counter<retrylimit && result.getStatus()==ITestResult.FAILURE)
		{
		 log.debug("Test failed, trying retry analyzer "+counter+ "time");
		 counter++;
		 return true;
		}
		return false;
	}

}
