//In Frameworks, we use scripts that r not hard coded so that it can be used with any 
//browser or url without changing much values. we need to first create DriverScript.Here in Driver Script we did not hard code 
//anything except d file path of d config property file as we need to reach that specific property file
// where various types of URLs & browser paths r stored. Steps in Driver Script:
//1). Create Class with no main method<within class create 1 WebDriver global var<then create
// a Constructor<within that, use try catch as we r reading an external excel file<within try
// create 3 lines of code:1) create obj of properties 2)create obj of FileInputStream as file 
//within that folder is stored here,so we paste d file path of d properties file within ()3)
//after folder & property file is located, last step is to load that file using load syntax
//<Then we want to make d return type of 2 objs that were created in previous step as global
//var so that we can use these var  to explore about properties in diff methods.<then we created
//public void setUp method where we want to use key value concept to get details about d property
// if Name of Browser/URL is key & the path of Browser/URL is d value, so write d key so that
//tool gives us d value<we write syntax for loading d file in a browser where we want to give 
//name "Browser"  as args within (). It is like a key. When tool runs it will pick whichever 
//browser name is written for..it will b like a value for that key.<then we use if else logic 
//where we want to say that if d value of browser in config file is ex.chrome, then use 
//System.setProperty to get path of that browser, else check for other browsers< need to create an obj
// for all d browsers in ifElse logic & use System.setProperty to access their paths< then 
//we write syntax for maximize, pageLoadTimeout, & Implicitly Wait< then write syntax for
//driver.get(prop.getProperty & the name of which URL(prod/preprod/dev)which we want to run
//then run


package com.gconnectBase_Parent_Generic;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class DriverScript 
{
	public static WebDriver driver;// declaring global var WebDriver with driver as reference; public means these var r accessible across packages
    //we use static so that we will not have to create object of that var each time we use it; it can b directly called using class nsme only.
	public static Properties prop;// created global var of the 2 return types 
									// that were created in try section & then removed it from 
	                                //there.these global var will allow us to use/call property files by various methods, hence they r global
	public static FileInputStream fis;//global var created
	
	public DriverScript() // creating a constructor
	{
		try // we are using try catch as we want to read/load external files; for
			// that we need to load d properties file under config folder; we
			// need 3 lines of code here 1) create an obj of folder(as java is
			// obj oriented programing lang, we need to create an Obj).2)
			// Navigate to d file within d folder through d given file path.3)
			// Load that file
		{
			prop = new Properties();// we create obj of properties folder
			fis = new FileInputStream("C:\\FrameWork\\com.gconnect\\gcConfig\\config1.properties");
			// we create obj of file within the config folder using fileInputStream as Excel is an external file
			// within () we give path of where that config file is loacted (rt click< copy<paste)
			prop.load(fis); // this is 3rd step required for loading external file ex. fis here using prop as a reference
		} 
		catch (Exception e) 
		{
			System.out.println("File Not Found");// we sysout in Exception if file is not found 
		}
	}

	@Test // we crate a test which will use setUp method & explore details about d property file
	public static void setUp()// we create a new setUp method to get details about d
						// property using key & value concept ex. if Name of
						// Browser/URL is key & the path of Browser/URL is d
						//value, so write d key so that tool gives us d value
	{
		String browser = prop.getProperty("Browser");// within this method, we r using this syntax with a keyword word 'Browser' within() 
		                                           //so that it can fetch its value (ex.here chrome) from property file & then store
		                                          //it in a var with a return type so that we can use that var in If Else statement
														
		if (browser.equalsIgnoreCase("chrome"))// we r using if logic that if browser is = to chrome,ignoring upper/lower case,
												// then give path of the browser(syntax for that given below)
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));// 
			driver = new ChromeDriver();// we create an Obj for browser drivers
		} 
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", prop.getProperty("iePath"));
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);// pageLoad will give 20 sec to load page
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS); // implicityWait will give 20 sec to load all webElements for getting path
													// of d browser,we use System.setProperty & write for key 'webdriver.chrome.driver' & value
													// 'prop.getProperty' & witin (), we write the key name eg.'chromePath' from prop file, so
													// that it can bring out its value i.e. path of the browser
		driver.get(prop.getProperty("URL")); //this gives the url as key so that tool can open this url(value)in d 
		                                     //correct browser.
	}

}
