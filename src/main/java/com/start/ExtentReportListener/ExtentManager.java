package com.start.ExtentReportListener;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.start.base.TestBase;

public class ExtentManager extends TestBase {
	
	private static ExtentReports extent;
	
	public ExtentReports rep;
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			extent = new ExtentReports("D:\\sujan\\PLOnline\\ImplimentationSite\\test-output\\extentreports\\impl.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File("D:\\sujan\\PLOnline\\ImplimentationSite\\src\\main\\java\\com\\impl\\config\\ReportsConfig.xml"));
			
		}
		
		return extent;
		}
	
}
