package com.hybrid.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {

	    System.out.println(result.getName()+" test case started");					
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		 
	    System.out.println("The name of the testcase passed is :"+result.getName());					
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	    System.out.println("The name of the testcase failed is :"+result.getName());					
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	    System.out.println("The name of the testcase Skipped is :"+result.getName());					

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

        System.out.println("Test FailedButWithinSuccessPercentage >> " + result.getName());

	}

	@Override
	public void onStart(ITestContext context) {

        System.out.println("This is onStart method >> " + context.getOutputDirectory());

	}

	@Override
	public void onFinish(ITestContext context) {

        System.out.println("This is onFinish method >> " + context.getPassedTests());
        
        System.out.println("This is onFinish method >> " + context.getFailedTests());
        
	}

}
