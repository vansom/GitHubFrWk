//This test case is a copy of Test02<here we will write reports< we will make use of logger mentioned in Test Case
//to create test & give some name in () to d test<then use logger.log(Status.PASS, markup)syntax after every step
//markup means pass message about d step; in the end use same syntax with message for markup as"Customer Added Successfully"
// after Assert.assertEquals(actual, "Customer ID") line; <then in TestCase, add in afterMethod extent.flush()<
//run this test< after that refresh<we see html report under Reporter folder<RtClick<Open with Web Browser<Report 
//opens to b shared with everyone<copy d url & paste in Chrome/IE browser, it will open
//

package com.gconnectTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Test02AddCustomerWithReporter extends TestBase{ 
	
	public Test02AddCustomerWithReporter()
	{
		super();// super keyword initializes d constructor present in d parent class i.e in 
		//Driver Script (3 lines of code within try & catch about loading of property file 
	}
		
	@Test
	public void validateAddCustomerFunctions()
	{
		logger=extent.createTest("Add Customer Functionality");//this syntax will start to generate report for this page
		
		hp.clickAddCustomer();// first step for this page
		logger.log(Status.INFO, "Clicked on AddCustomerLink");//this syntax has to b repeated after every step in that pg, we do Status.INFO (i.e. this step needs no validation of dt but just informing that it is being clicked)& for makeup we give message about d step
		String actual = acp.validateAddCustomPgFunctionalities("Vanita", "Singh", "vs@gmail.com", "123BestWest", "123456789");
		System.out.println(actual); //CustId will b printed
		AssertJUnit.assertEquals(actual, "Customer ID");//we use assert.assertequal to compare actual with expected (boolean, boolean)..
		logger.log(Status.PASS, "Customer Added Successfully");//this should b last line after all steps r executed.. it means that after all dt is entered on this pg & assert is passed, then Status should b PASS & meakeup should b that Customer is added successfully
	}
}

