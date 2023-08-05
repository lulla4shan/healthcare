package com.healthcare.executepageclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;

public class ExecuteLoginPageClass extends BaseClass{
	
	LoginPageClass lp;
	HomePageClass hp;
	
  @Test(dataProviderClass = DataProviderClass.class, dataProvider = "validLogin")
  public void verifySuccessfulLogin(String uname, String pass) {
	  lp = new LoginPageClass(driver);
	  lp.login(uname, pass);
	  hp = new HomePageClass(driver);
	  String actualRes = hp.getTextOfLoginMsg();
	  String expectedRes = "Logged in as Super User (admin) at Registration Desk.";
	  Assert.assertEquals(actualRes, expectedRes);
  }
  
  @Test(dataProviderClass = DataProviderClass.class, dataProvider = "invalidLogin")
  public void verifyUnsuccessfulLogin(String uname, String pass) {
	  lp = new LoginPageClass(driver);
	  lp.login(uname, pass);
	  String actualRes = lp.getTextOfErrorMsg();
	  String expectedRes = "Invalid username/password. Please try again.";
	  Assert.assertEquals(actualRes, expectedRes);
  }
}
