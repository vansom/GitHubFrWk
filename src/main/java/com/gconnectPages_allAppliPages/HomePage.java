//steps for creating Pages. All pages should have 1)Object Repository (where we inspect ,identify
// & store webElements), 2)Page Initialization(which will initialize identified webElements by using
// syntax of pageFactory.initElements(choose last option in it, it has 2 args: driver (means 
//Driver script) & page means (webElements on current page, so we replace it with word 'this'))
// & 3)Page Action(which will specify specific methods needed for initializing each webElement). Here HomePg is
//being created. On HomPg,steps can b mainly for verifying display of webElements, so we get only 2 results 
//(true/false), so we use boolean as dt type & create method to verify all these with their syntax given below.
//Steps for this page are: 1) extend class to Driver Script as Driver Script is a parent generic class & it will 
//auto import for it.2)create OjRepos by identifying elements using syntax of @FindBy(write value of id/name/linkText/
//xpath, etc. within ("")WebElement & write name of that WebElement (name should be meaningful & contain its type in d end ex.link,
// text, etc.3)Create constructor of d pg that uses pageFactory syntax 4)Then in PageAction, 
//we create as many boolean methods as webElements to verify their display on HPg. We add
//another addCustomerLink method. In Inspect element, tagName with a (ex.<a) means it is a 
//link. (Identifying with xpath is best to get results).// Here we use Helper.hightLightWebElement with name of specific 
//functionalities in () before each step


package com.gconnectPages_allAppliPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gconnectBase_Parent_Generic.DriverScript;
import com.gconnectUtilities.Helper;

public class HomePage extends DriverScript{
	
	//Object Repository
	@FindBy(xpath="//a[@class='logo']")WebElement logoHeadingText;
	@FindBy(xpath="(//a[@href='addcustomer.php'])[1]")WebElement addCustomerLink;
	@FindBy(xpath="(//a[@href='addtariffplans.php'])[1]")WebElement addTarifPlLink;
	@FindBy(xpath="(//a[@href='assigntariffplantocustomer.php'])[1]")WebElement addTarifPlToCustLink;
	@FindBy(xpath="(//a[@href='billing.php'])[1]")WebElement payBillLink;
	
	//Page Initialization
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
         // Page Action
	
	public boolean verifyLogo() // we create a method to verify logo using boolean, 
	                            //it will throw error till we write return in 2nd step within {}
	{
		Helper.highLightElement(logoHeadingText);// we use this highlight syntax to highlight a specific function mentioned in ()
		return logoHeadingText.isDisplayed();// we write word 'return' copy d name of webElement
		                                  //identified in OR<put.<choose isDisplayed (error line will go away)
	}
	
	public boolean verifyAddCustomer()// do for all webElements like above to verify its display
	{
		Helper.highLightElement(addCustomerLink);
		return addCustomerLink.isDisplayed();
	}
	
	public boolean verifyAddTariff()
	{
		Helper.highLightElement(addTarifPlLink);
		return addTarifPlLink.isDisplayed();
	}
	
	public boolean verifyAddTariffCustomer()
	{   Helper.highLightElement(addTarifPlToCustLink);
		return addTarifPlToCustLink.isDisplayed();
	}
	
	public boolean verifyPayBill()
	{   Helper.highLightElement(payBillLink);
		return payBillLink.isDisplayed();
	}
	
	public void clickAddCustomer()//we created this void method for clicking on AddCustomLink (which we already have identified)so there will be no return type as clicking will lead to next step rather return something 
	{   Helper.highLightElement(addCustomerLink);
		addCustomerLink.click();
	}
}
