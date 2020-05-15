package com.start.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StartLoginPageTestVerify {

	public WebDriver driver;
	public WebDriverWait wait;
	String usrname = "tier2.ka+user15@gmail.com";
	String pwd = "88Portland!";

	// Login button element
	@FindBy(xpath = "//a[@class='login-btn']")
	public WebElement btnLogin;

	@FindBy(xpath = "//button[contains(text(),'Advanced')]")
	public WebElement btnAdvanced;

	@FindBy(xpath = "//a[contains(text(),'unsafe')]")
	public WebElement lnkProceed;
	
	// Identifier or username
	@FindBy(xpath = "//input[@id='identifier']")
	public WebElement inptIdentifier;

	// Next button
	@FindBy(xpath = "//span[contains(text(),'next')]")
	public WebElement btnNext;

	// Identifier or username
	@FindBy(xpath = "//input[@id='password']")
	public WebElement inptPassword;

	@FindBy(xpath = "//span[contains(text(),'select')]")
	public WebElement btnSelect;

	// Identifier or Workshop tile link
	@FindBy(xpath = "//div[contains(text(),'Workshops')]")
	public WebElement lnkWorkshops;
	
	@FindBy(xpath = "//span[contains(text(),'login')]")
	public WebElement btnLoginAuth;
	
	/*@FindBy(xpath = "//span[contains(text(),'select')]")
	public WebElement btnSelect;*/

	
	@BeforeTest
	public void initialization() {		
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		//wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://start-stage.nwea.org/");	
		PageFactory.initElements(driver, this);
		
	}
	@Test
	public void authenticationTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		btnAdvanced.click();
		lnkProceed.click();
		btnLogin.click();		
		wait.until(ExpectedConditions.visibilityOf(inptIdentifier));
		inptIdentifier.sendKeys(usrname);
		wait.until(ExpectedConditions.visibilityOf(btnNext));
		btnNext.click();
		wait.until(ExpectedConditions.visibilityOf(inptPassword));
		inptPassword.sendKeys(pwd);
		wait.until(ExpectedConditions.visibilityOf(btnLoginAuth));
		btnLoginAuth.click();
		wait.until(ExpectedConditions.visibilityOf(btnSelect));
		btnSelect.click();
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOf(lnkWorkshops));
		lnkWorkshops.click();
		Thread.sleep(6000);
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
