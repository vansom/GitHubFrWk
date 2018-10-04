// we create test case for each page separate. This is for Home Page.steps:
//1) create constructor. 2)write keyword super.3)then create @BeforeMethod wherein we will call setUp method from
//Driver Script.4) Then create @Test  wherein we create a method for verifying all links on HoPg. For that, we need
// to create an Obj of HmPg & use Assert.assertTrue syntax to verify elements.4) Create @AfterMethod with code for 
//driver.close
//we use logger=extent.createTest to generate reports for this page. Then we use logger.log(Status., "makeup")
// after every step to generate report for each step
//

package com.gconnectTestCases;


//import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import com.gconnectBase_Parent_Generic.DriverScript;
//import com.gconnectPages_allAppliPages.HomePage;

public class Test01HomePgLinksVald extends TestBase{

	public Test01HomePgLinksVald()
	{
		super();// super keyword initializes d constructor present in d parent class i.e in 
		//Driver Script (3 lines of code within try & catch about loading of property file )
	}
	
	
	
	@Test
	public void testVerifyHmPgLinks()// create method to test HmPgLinks as a Test case name
	{
		logger=extent.createTest("Verifying Home Page Links"); //syntax to start report generation for HomePg links
		
		AssertJUnit.assertTrue(hp.verifyLogo());// We can directly use Assert.assertTrue(boolean,
		logger.log(Status.PASS, "verifyLogo"); //this syntax after every step to generate report for that functionality written witin ()
		AssertJUnit.assertTrue(hp.verifyAddCustomer());//args0)& replace within ()variable name.& choose all verifications
		logger.log(Status.PASS, "verifyAddCustomer");
		AssertJUnit.assertTrue(hp.verifyAddTariff()); //that we created on Home Page & run or we can write sysout to verify code passed or not
		logger.log(Status.PASS, "verifyAddTariff");
		AssertJUnit.assertTrue(hp.verifyAddTariffCustomer()); 
		logger.log(Status.PASS, "verifyAddTariffCustomer");
		AssertJUnit.assertTrue(hp.verifyPayBill());
		logger.log(Status.PASS, "verifyPayBill");
	}
	

		
		
	     
	
	
	
	
	
	
}
