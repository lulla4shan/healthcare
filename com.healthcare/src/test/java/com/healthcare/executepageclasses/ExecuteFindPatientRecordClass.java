package com.healthcare.executepageclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.healthcare.pageclasses.FindPatientRecordClass;
import com.healthcare.pageclasses.HomePageClass;
import com.healthcare.pageclasses.LoginPageClass;

public class ExecuteFindPatientRecordClass extends  BaseClass{
	
	LoginPageClass lp;
	HomePageClass hp;
	FindPatientRecordClass fp;
	
	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "validLogin")
	  public void verifySearchRegisteredPatient(String username,String pass) {
		  lp = new LoginPageClass(driver);
		  lp.login(username, pass);
		  hp = new HomePageClass(driver);
		  hp.clickOnfindPatientRecord();
		  fp = new FindPatientRecordClass(driver);
		  fp.enterNameOrId("ansala");
		  
		  Boolean actRes = fp.isPatientNameFound();
		  
		  Assert.assertTrue(actRes);
	  }
}
