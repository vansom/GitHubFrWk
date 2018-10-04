//This is for creating test cases for AddCustomer Page Page. steps:
//1) create constructor. 2)write keyword super.3)then create @BeforeMethod wherein we will call
//setUp method from Driver Script.4) Then create @Test  wherein create a method for 
//validating AddCustomerFunctions. For that, we need first create an obj of Home Page so as to
//use d var name to call clickAddCustomer function to got to AddCustPg. Then we create an obj 
// of AddCustPg & use d var name to call validateAddCustomerFunctions from that pg & within () we pass actual data 
// in place of parameters for various AddCustPg functions.4)We then store this code in a var 
//with return type & then out that var to check d code. 4)Create @AfterMethod with code for driver.close

package com.gconnectTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.annotations.Test;

public class Test02AddCustomer extends TestBase{ 
	
	public Test02AddCustomer()
	{
		super();// super keyword initializes d constructor present in d parent class i.e in 
		//Driver Script (3 lines of code within try & catch about loading of property file 
	}
		
	@Test
	public void validateAddCustomerFunctions()
	{
		
		//HomePage hp = new HomePage();// we first create an obj of HmPg as AddCustomerLink is present there only
		//hp.clickAddCustomer();// this method we created on HmPg, so can directly call by d var name.
		
		//AddCustomerPage acp = new AddCustomerPage();//then create obj for AddCustPg to validate elements n that pg
		hp.clickAddCustomer();// this method we created on HmPg, so can directly call by d var name.
		String actual = acp.validateAddCustomPgFunctionalities("Vanita", "Singh", "vs@gmail.com", "123BestWest", "123456789");
		System.out.println(actual); //CustId will b printed
		AssertJUnit.assertEquals(actual, "Customer ID");//we use assert.assertequal to compare actual with expected (boolean, boolean)..
		
	}
}

