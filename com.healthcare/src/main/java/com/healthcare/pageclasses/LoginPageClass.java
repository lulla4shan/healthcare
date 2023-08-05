package com.healthcare.pageclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.ExcelReadClass;
import utilityClasses.GeneralUtilities;



public class LoginPageClass {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	
	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath  = "//li[text()='Inpatient Ward']")
	WebElement inpatientWard;
	
	@FindBy(xpath = "//li[text()='Isolation Ward']")
	WebElement isolationWard;
	
	@FindBy(xpath = "//li[text()='Laboratory']")
	WebElement laboratory;
	
	@FindBy(xpath = "//li[text()='Outpatient Clinic']")
	WebElement outpatientClinic;
	
	@FindBy(xpath = "//li[text()='Pharmacy']")
	WebElement pharmacy;
	
	@FindBy(xpath = "//li[text()='Registration Desk']")
	WebElement registrationDesk;

	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	@FindBy(id = "error-message")
	WebElement errorMsg;

	
	
	public void login(String uname,String passwd) {
		gl.typeText(username, uname);
		gl.typeText(password, passwd);
		gl.clickElement(registrationDesk);
		gl.clickElement(loginButton);
	}
	public String readStringData(int r,int c) throws IOException {
		return ExcelReadClass.readStringData(r, c);
		
	}
	public String readIntegerData(int r,int c) throws IOException {
		return ExcelReadClass.readIntegerData(r, c);
	} 
	
	public String getTextOfErrorMsg() {
		return gl.getTextMethod(errorMsg);
	}
	

}
