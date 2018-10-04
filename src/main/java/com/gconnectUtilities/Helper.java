//Javascript executor is used for :scrolling down d webPage; when element is not clickable we can use javaScript 
//to make it clickable; for Highlighting the elements while framework is running; & for enabling 
//some disabled keys or buttons (ex.if some button is disabled, we can forcefully enter some dt
//using javascript executor.
//In Utilities package, we create a class Of Helper. In Helper we create codes that r reusable in any Framework
//like scrolling/screenshot/OpenReport, etc.:1) extend class to driverScript.2)create public static 
//scroll method with code for JavascriptExecutor js=driver(hover over driver, it will overcast
// with (JavascriptExecutor); then js.executeScript("scroll(0,500)")(you can pass any dimensions
//within (). This function we will call in AddCustomerPg as this will help d pg to scroll down.
//In Helper class, we also write highLightElement & pass WebElement using Cnt+space & then write web within() & then
// write 2 line Javascript syntax/command<then go to any created pg & call helper.highlightElement with specific 
// In Helper class, we will create another feature within try catch to take screen shots(syntax for it r not known
//properly but we can see in ExtentReportmp4 video within Selenium folder on Desktop.
//In Helper class, we also write code for opening automation report automatically in any default browser...don't have to
//open manually<within try , write src= "path of catch of html report"<create obj of File<code for Desktop<then we
//go to Test Base & after extent.flush, write Helper.OpenAutomationReport<
//

//
//
package com.gconnectUtilities;

import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.gconnectBase_Parent_Generic.DriverScript;

 public class Helper extends DriverScript{

	public static void scrollPage(WebDriver driver)//syntax for scrolling page
    {
	JavascriptExecutor js=(JavascriptExecutor) driver ;
	js.executeScript("scroll(0,500)");
}
	public static void highLightElement(WebElement ele)//syntax for highlighting
	{
		JavascriptExecutor js=(JavascriptExecutor) driver ;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border: 2px solide red;')", ele);
		
	}
	
	//need for code for screenshot here
	
	public static  void OpenAutomationReport()////syntax to open report automatically in any browser.
	{
		try // use try catch as we r trying to load/read a file that is outside of code
		{
			String src = "C:\\FrameWork\\com.gconnect\\gcReport\\FramewkReport.html";//path of html file
			File file = new File(src);// create file name by writing new fil(Cnt+Space)& choose 1st option & take sec as argument within()
		    Desktop.getDesktop().browse(file.toURI());//this syntax is needed for report generation;
		
		}
		
		
		catch (Exception e)// e is name of var..it can b anything
		{
			System.out.println(" Report not found"+ e.getMessage());// if path is not found,then it will catch & print this
			e.printStackTrace();// ???
		}
		}
	}

