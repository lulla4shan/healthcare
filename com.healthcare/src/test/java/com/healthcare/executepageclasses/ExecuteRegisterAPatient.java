package com.healthcare.executepageclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.FindPatientRecordClass;
import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;
import com.healthcare.pageclasses.RegisterAPatient;

import utilityClasses.RandomDataUtility;

public class ExecuteRegisterAPatient extends BaseClass{
	
	LoginPageClass lp;
	HomePageClass hp;
	RegisterAPatient rp;
	FindPatientRecordClass fp;
/*	
  @Test(dataProviderClass = DataProviderClass.class, dataProvider = "validLogin", enabled = false)
  public void verifyRegisteraPatient(String username,String pass) {
	  lp = new LoginPageClass(driver);
	  lp.login(username, pass);
	  hp = new HomePageClass(driver);
	  hp.clickOnregisterApatient();
	  rp = new RegisterAPatient(driver);
	  rp.enterName("ansala", "lulla");
	  rp.clickOnNextBtn();
	  rp.selectGender(1);
	  rp.clickOnNextBtn();
	  rp.enterBirthDate("08", 4 , "1994");
	  rp.enterAddress("M S J Manzil", "Thokkadu PO, Narikkallumukku", "Varkala", "Kerala", "India", "695143");
	  rp.enterPhoneNumber("8111688442");
	  rp.selectRelationshipType(6);
	  rp.clickOnConfirmBtn();
	  rp.clickOnHomeBtn();
	  hp.clickOnfindPatientRecord();
	  fp = new FindPatientRecordClass(driver);
	  Boolean act = fp.isPatientNameFound("ansala");
	  Assert.assertTrue(act);
//	  String actRes = rp.getTextOfdiagnosesHeading();
//	  String expRes = "DIAGNOSES";
//	  Assert.assertEquals(actRes, expRes);
  }  */
  
  @Test(dataProviderClass = DataProviderClass.class, dataProvider = "validLogin")
  public void verifyRegisteraPatient1(String username,String pass) {
	  lp = new LoginPageClass(driver);
	  lp.login(username, pass);
	  hp = new HomePageClass(driver);
	  hp.clickOnregisterApatient();
	  rp = new RegisterAPatient(driver);
	  rp.enterName(rp.getFName(),rp.getLName());
	  rp.clickOnNextBtn();
	  rp.selectGender(1);
	  rp.clickOnNextBtn();
	  rp.enterBirthDate(rp.getBirthDayDate(),5,rp.getBirthDayYear());
	  rp.enterAddress(rp.getbuildingNo(), rp.getCityName(), rp.getStateName(), rp.getCountryName(), rp.getPostCode());
	  rp.enterPhoneNumber(rp.getPhoneNum());
	  rp.selectRelationshipType(6);
	  rp.clickOnConfirmBtn();
	    
	  String act =rp.getTextOfPatientName();
	  System.out.println(act);
	  String exp = RandomDataUtility.getfName();
	  System.out.println(exp);
  }
  
  
}
