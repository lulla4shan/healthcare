package com.healthcare.pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityClasses.ExplicitWait;
import utilityClasses.GeneralUtilities;
import utilityClasses.RandomDataUtility;

public class RegisterAPatient {
	
	WebDriver driver;
	GeneralUtilities gl = new GeneralUtilities();
	ExplicitWait wait = new ExplicitWait();
	
	public RegisterAPatient(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name  = "givenName")
	WebElement nameGiven;
	
	@FindBy(name = "familyName")
	WebElement familyName;
	
	@FindBy(id = "next-button")
	WebElement nextBtn;
	
	@FindBy(id = "gender-field")
	WebElement genderDP;
	
	@FindBy(name = "birthdateDay")
	WebElement birthdateDay;
	
	@FindBy(name = "birthdateMonth")
	WebElement birthdateMonth;
	
	@FindBy(name = "birthdateYear")
	WebElement birthdateYear;
	
	@FindBy(id = "address1")
	WebElement address1;
	
	@FindBy(id = "address2")
	WebElement address2;
	
	@FindBy(id = "cityVillage")
	WebElement cityVillage;
	
	@FindBy(id = "stateProvince")
	WebElement stateProvince;
	
	@FindBy(id = "country")
	WebElement country;
	
	@FindBy(id = "postalCode")
	WebElement postalCode;
	
	@FindBy(name = "phoneNumber")
	WebElement ph;
	
	@FindBy(id = "relationship_type")
	WebElement relationshipDP;
	
	@FindBy(id = "submit")
	WebElement confirmBtn;
	
	@FindBy(xpath =  "//h3[text()='DIAGNOSES']")
	WebElement diagnosesHeading;
	
	@FindBy(xpath = "//*[@class='PersonName-givenName']")
	WebElement ReisteredPatientName;
	
	@FindBy(xpath  = "//table[@id='patient-search-results-table']//tr")
	List<WebElement> row;
	
	@FindBy(xpath  = "//table[@id='patient-search-results-table']//th")
	List<WebElement> col;
	
	@FindBy(xpath = "//a[@href='/openmrs/index.htm']")
	WebElement homeBtn;
	
	public void enterName(String gname, String fname) {
		wait.presenceOfElementsLocatedByName(driver, "givenName");
		gl.typeText(nameGiven, gname);
		gl.typeText(familyName, fname);
	}
	public String getFName() {
		return RandomDataUtility.getfName();
		
	}
	public String getLName() {
		return RandomDataUtility.getlName();
		
	}
	public void clickOnNextBtn() {
		gl.clickByJS(driver, nextBtn);
	}
	public void selectGender(int index) {
		gl.selectByIndexDorpDown(genderDP, index);
	}
	
	public void enterBirthDate(String date, int index, String year) {
		gl.typeText(birthdateDay, date);
		gl.selectByIndexDorpDown(birthdateMonth, index);
		gl.clickElement(birthdateYear);
		gl.typeText(birthdateYear, year);
		gl.clickByJS(driver, nextBtn);
		
	}
	public String getBirthDayDate() {
		return RandomDataUtility.getBirthDayDate();
	}
	
	public String getBirthDayYear() {
		return RandomDataUtility.getBirthDayYear();
	}
	
	public void enterAddress(String add1,String city,String state,String contry,String postcode) {
		gl.typeText(address1, add1);
		gl.typeText(cityVillage, city);
		gl.typeText(stateProvince, state);
		gl.typeText(country, contry);
		gl.typeText(postalCode, postcode);
		gl.clickByJS(driver, nextBtn);
	}
	public String getbuildingNo() {
		return RandomDataUtility.getbuildingNoAndStreetAddress();
	}
	public String getCityName() {
		return RandomDataUtility.getCity();
	}
	public String getStateName() {
		return RandomDataUtility.getState();
	}
	public String getCountryName() {
		return RandomDataUtility.getCountry();
	}
	public String getPostCode() {
		return RandomDataUtility.getPostCode();
	}
	
	public void enterPhoneNumber(String phNo) {
		gl.typeText(ph, phNo);
		gl.clickByJS(driver, nextBtn);
	}
	public String getPhoneNum() {
		return RandomDataUtility.getRandomPhoneNumber1();
	}
	public void selectRelationshipType(int index) {
		gl.selectByIndexDorpDown(relationshipDP, index);
		gl.clickByJS(driver, nextBtn);
	}
	
	public void clickOnConfirmBtn() {
		gl.clickElement(confirmBtn);
	}
	
	public String getTextOfdiagnosesHeading() {
		return gl.getTextMethod(diagnosesHeading);
	}
	
	public boolean isPatientNameFound(String name) {
		
		int rowCount = row.size();   
		int colCount = col.size();	
		System.out.println(rowCount+"  "+colCount);   
		
		boolean flag = false;  
		
		for(int row = 1;row<rowCount;row++) {
			for(int col = 1;col<colCount;col++) {
				
				String actValue = driver.findElement(By.xpath("//table[@id='patient-search-results-table']//tr["+row+"]//td["+col+"]")).getText();
				if (actValue.equalsIgnoreCase(name)) {
					
					flag = true;  
					System.out.println(row+" : "+col); 
					break;
					
				}
			}
		}
		if (flag) {  
			return true;
		}
		return flag;
		
	}
	
	public void clickOnHomeBtn() {
		gl.clickElement(homeBtn);
		gl.clickElement(homeBtn);
	}
	public String getTextOfPatientName() {
		return gl.getTextMethod(ReisteredPatientName);
	}
	

}
