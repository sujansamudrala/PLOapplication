package com.start.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.start.base.TestBase;

public class StartDashboardPg extends TestBase {

	//Identifier or username
	@FindBy(xpath = "//div[contains(text(),'Workshops')]")
	public WebElement lnkWorkshops;
	
	//Next button
	@FindBy(xpath = "//span[contains(text(),'next')]")
	public WebElement btnNext;
	
	//Identifier or username
	@FindBy(xpath = "//input[@id='password']")
	public WebElement inptPassword;
	
	@FindBy(xpath = "//span[contains(text(),'login')]")
	public WebElement btnLogin;
	
	@FindBy(xpath = "//span[contains(text(),'select')]")
	public WebElement btnSelect;
	

	// Initializing the page objects
	public StartDashboardPg() {
		PageFactory.initElements(driver, this);
	}
	
	public void Tile() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(lnkWorkshops));
		
		lnkWorkshops.click();
	}
}
