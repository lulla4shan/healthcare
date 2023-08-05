package com.healthcare.pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.GeneralUtilities;

public class HomePageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[contains(text(),'Logged in as')]")
	WebElement loginMsg;
	
	@FindBy(xpath = "//a[contains(@href,'/openmrs/registrationapp/registerPatient')]")
	WebElement registerApatient;
	
	@FindBy(xpath = "//a[contains(@href,'page?app=coreapps.findPatient')]")
	WebElement findPatientRecord;
	
	public String getTextOfLoginMsg() {
		return gl.getTextMethod(loginMsg);
	}
	
	public void clickOnregisterApatient() {
		gl.clickElement(registerApatient);
	}
	
	public void clickOnfindPatientRecord() {
		gl.clickElement(findPatientRecord);
	}


}
