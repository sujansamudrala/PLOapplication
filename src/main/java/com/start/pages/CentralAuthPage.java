package com.start.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.start.base.TestBase;



public class CentralAuthPage extends TestBase {

	//Identifier or username
	@FindBy(xpath = "//input[@id='identifier']")
	public WebElement inptIdentifier;
	
	//Next button
	@FindBy(xpath = "//span[contains(text(),'next')]")
	public WebElement btnNext;
	
	//Identifier or username
	@FindBy(xpath = "//input[@id='password']")
	public WebElement inptPassword;
	
	@FindBy(xpath = "//span[contains(text(),'login')]")
	public WebElement btnLoginAuth;
	
	@FindBy(xpath = "//span[contains(text(),'select')]")
	public WebElement btnSelect;
	

	// Initializing the page objects
	public CentralAuthPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Authenticate(String username,String password) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(inptIdentifier));
		inptIdentifier.sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(btnNext));
		btnNext.click();
		wait.until(ExpectedConditions.visibilityOf(inptPassword));
		inptPassword.sendKeys(password);
		wait.until(ExpectedConditions.visibilityOf(btnLoginAuth));
		btnLoginAuth.click();
		wait.until(ExpectedConditions.visibilityOf(btnSelect));
		btnSelect.click();
	}
}
