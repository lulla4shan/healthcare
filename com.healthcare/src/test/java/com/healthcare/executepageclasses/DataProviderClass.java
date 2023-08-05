package com.healthcare.executepageclasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilityClasses.ExcelReadClass;

public class DataProviderClass {
 

  @DataProvider(name = "validLogin")
  public Object[][] dp() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.readStringData(2, 1), ExcelReadClass.readStringData(3, 1) }
      
    };
  }
  
  @DataProvider(name = "invalidLogin")
  public Object[][] dp1() throws IOException {
    return new Object[][] {
      new Object[] { ExcelReadClass.readStringData(2, 4), ExcelReadClass.readStringData(3, 4) },
      new Object[] { ExcelReadClass.readStringData(2, 5), ExcelReadClass.readStringData(3, 5) },
      new Object[] { ExcelReadClass.readStringData(2, 6), ExcelReadClass.readStringData(3, 6) }
    };
  }
}
