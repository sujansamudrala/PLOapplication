package com.start.ExtentReportListener;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.start.util.TestUtil;


public class CustomListeners extends ExtentManager implements ITestListener,ISuiteListener {

	public 	String messageBody;
	public void onFinish(ITestContext context) {
		
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	rep =ExtentManager.getInstance();
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult context) {

		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, context.getName().toUpperCase()+" Failed with exception : "+context.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenshotName));
		
		Reporter.log("Click to see Screenshot");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=200 width=200></img></a>");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult context) {


		test.log(LogStatus.SKIP, context.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		rep.endTest(test);
		rep.flush();
		
	}


	public void onTestStart(ITestResult context) {
		
		test = rep.startTest(context.getName().toUpperCase());
		test.log(LogStatus.PASS, context.getName().toUpperCase()+" Started");
	
	}

	public void onTestSuccess(ITestResult context) {


		test.log(LogStatus.PASS, context.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onFinish(ISuite context) {
		
		/*MonitoringMail mail = new MonitoringMail();
		 
		try {
			messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
					+ ":8080/job/DataDrivenLiveProject/Extent_Reports/";
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
	}

	public void onStart(ISuite context) {
		// TODO Auto-generated method stub
				
	}

}
