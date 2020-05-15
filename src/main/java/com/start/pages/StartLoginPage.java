package com.start.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.start.base.TestBase;

public class StartLoginPage extends TestBase {

	//Login button element
	@FindBy(xpath = "//a[@class='login-btn']")
	public WebElement btnLogin;
	
	@FindBy(xpath = "//button[contains(text(),'Advanced')]")
	public WebElement btnAdvanced;
	
	@FindBy(xpath = "//a[contains(text(),'unsafe')]")
	public WebElement lnkProceed;

	// Initializing the page objects
	public StartLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void LaunchURL(String Url) {
		
		driver.get(Url);
		btnAdvanced.click();
		lnkProceed.click();		
		
	}
	
	public void LoginPageVerification() {
		btnLogin.click();
	}
}
