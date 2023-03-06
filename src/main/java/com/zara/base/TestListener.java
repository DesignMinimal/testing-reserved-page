package com.zara.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	Logger log;
	String testName;
	String testMethodName;

	//The method name of the class method; runs on each separated test method in a class
	@Override
	public void onTestStart(ITestResult result) {
		this.testMethodName = result.getMethod().getMethodName();
		log.info("[Starting " + testMethodName + "]");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("[Test " + testMethodName + " passed]");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		log.info("[Test " + testMethodName + " failed]");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	// this.testName = context.getCurrentXmlTest().getName(); -> this is the name of the test suite xml that is INSIDE the code ( <test name="AlertTest"> )
	//runs on start of the whole test suite once
	@Override
	public void onStart(ITestContext context) {
		this.testName = context.getCurrentXmlTest().getName();
		this.log = LogManager.getLogger(testName);
		log.info("[TEST " + testName + " STARTED]");
	}

	//runs at the end of the whole test suite once
	@Override
	public void onFinish(ITestContext context) {
		log.info("[ALL " + testName + " FINISHED]");
	}
}
