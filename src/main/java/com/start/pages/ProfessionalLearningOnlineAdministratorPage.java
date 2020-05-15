package com.start.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.start.base.TestBase;

public class ProfessionalLearningOnlineAdministratorPage extends TestBase{
	
	@FindBy(id="self-designate")
	public  WebElement designateauthorizedrepresentativebtn;
	
	@FindBy(css=" div:nth-child(5) > div > button")
	public  WebElement saveaddanotherbtn;
	
	@FindBy(id="firstName")
	public  WebElement firstnametext;
	
	@FindBy(id="lastName")
	public  WebElement lastnametext;
	
	@FindBy(id="email")
	public  WebElement emailtext;
	
	@FindBy(css="button.btn.secondary.btn-next")
	public  WebElement donecontinuebtn;
	
	@FindBy(css="#designated-users > span > span")
	public  WebElement currentlydesignatedvalue;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[3]/div[2]/div/div/div/div/div[1]/h3")
	public  WebElement pagename;
	
	//Initializing the page objects
			public ProfessionalLearningOnlineAdministratorPage() {
				PageFactory.initElements(driver, this);
			}
	
	
	public String pageName() {
		return pagename.getText();
	}
	
	public String getCurrentlyDesignated() {
		designateauthorizedrepresentativebtn.click();
		String str =currentlydesignatedvalue.getText();
		return str.toLowerCase().replaceAll(" ", "");
		
	}
	
	

	
}
