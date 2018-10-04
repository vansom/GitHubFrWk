//we create testBase class within TestCase package. Here we will keep Before & After methods. Steps are:
//extend d Testbase class to driverScript<then copy @BeforeMethod & @AfterMethod from Test01HomePg & paste it here<then create
//Obj of HomePg & store it in a var(ex.hp)<then make d return type & d var a global var & delete it from d syntax
//Then go to Test01 & delete syntax for Obj of HomePage created<Then change extends of Test01/Test02 from DriverScript to
//Test Base as it will now call Before Method & AfterMethod from TestBase. Delete from test01 & test02 both Before & After
//Method, change extends to TestBase & delete Obj of HomePg created there. So TestBase we do few main things:
//1) create global var on basis of the pages.2)Add codes for Before & After Method. Within Before Method, we add 
//<to create an Obj of ExtentHTMLReporter(File path)(you can choose from options by writing Extent & Cont Space & give
//file path of Reporter folder & add some name to it in the end(ex.FramewkReport.html)& store it in some var with 
//return type & then make return type & var a global var & remove return type from here as local var else will give NullPoint Error.
//<then create an obj of ExtentReports & make a global var & delete type from here;<then write extent.attachReporter
//pass within ()htmlReport<write as global var ExtentTest logger;<then after creating Test02AddCustwithReporter,
//add here in afterMethod extent.flush()
//In TestBase class for screenShot, within() for public void postTest()in AfterMethod, we create an Interface(ITestResult result)
//& write a code(not sure right now what code it is but it is for Screenshot as Helper class has syntax for 
//screenShot. write ITestR & cntr+space & choose ITestResult from testNg. Screenshots are created for failed TCs
//that can b found in left panel as a new folder after running a failed Tc.<Refresh d project
//In AfterMethod, after extent.flush, write Helper.OpenAutomationReport for opening report automatically in a browser
//then run AddCustmPgReporter Tc<if we make some deliberately error, then d report will show in red the reason for 
//failure along with screenshot & highlight...but if it passed, it will b green & no screenshots, etc will b attached
//if it skips, it will b yellow; 

package com.gconnectTestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.gconnectBase_Parent_Generic.DriverScript;
import com.gconnectPages_allAppliPages.AddCustomerPage;
import com.gconnectPages_allAppliPages.HomePage;
import com.gconnectUtilities.Helper;

public class TestBase extends DriverScript { //this is multilevel inheritance i.e all test cases extend to TestBase & TestBase extends to Drivercript
	
	HomePage hp;//created global var of HomePg.
	AddCustomerPage acp;//created global var of AddCustPg.
	
	ExtentHtmlReporter htmlReport;//created global var of ExtentHtmlReporter htmlReport.
	ExtentReports extent; //created global var
	ExtentTest logger;
	
	@BeforeMethod
	public void preTest()
	{
		 htmlReport = new ExtentHtmlReporter("C:\\FrameWork\\com.gconnect\\gcReport\\FramewkReport.html"); 
		 extent = new ExtentReports();
		 extent.attachReporter(htmlReport);
		
		
		 setUp();// this will call all set up methods related to maximizing, wait, etc. present in DriverScript
		
		hp = new HomePage();// created Obj of Home pg & then deleted return type here to make it global vae
	    acp = new AddCustomerPage();// we create Obj of CustPg, make retrun type global var & delete it from here
		
	} 

	@AfterMethod
	public void postTest(ITestResult result)// instead of postTest, we can use industry standard : tearDown; for ScreenShot, we write ITestResult result within()
	{
		
		driver.close();
		extent.flush();
		Helper.OpenAutomationReport();
	}
}
