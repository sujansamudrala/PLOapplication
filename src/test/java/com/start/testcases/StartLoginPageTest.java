package com.start.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.start.base.TestBase;
import com.start.pages.CentralAuthPage;
import com.start.pages.StartDashboardPg;
import com.start.pages.StartLoginPage;




public class StartLoginPageTest extends TestBase {
	StartLoginPage startloginpg;
	CentralAuthPage centralauthpg;
	StartDashboardPg startdashboardpg;
	
	public StartLoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setup() {
		intilization();
		startloginpg = new StartLoginPage();
		centralauthpg = new CentralAuthPage();
		startdashboardpg = new StartDashboardPg();
		
		startloginpg.LaunchURL(prop.getProperty("url"));
	}
	
	@Test(priority=1)
	public void loginPageTest() throws InterruptedException {
		startloginpg.LoginPageVerification();
		//centralauthpg.Authenticate("tier2.ka+user15@gmail.com", "88Portland!");
		Thread.sleep(10000);
	}
	
	@Test(priority=2)
	public void authentication() throws InterruptedException {
		
		centralauthpg.Authenticate("tier2.ka+user15@gmail.com", "88Portland!");
		Thread.sleep(10000);
	}
	
	@Test(priority=3)
	public void startDashboard() throws InterruptedException {
		
		startdashboardpg.Tile();
		Thread.sleep(10000);
	}
	
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
