//steps for creating Pages. All pages should have 1)Object Repository (where we inspect ,identify
// & store webElements), 2)Page Initialization(which will initialize identified webElements by using
// syntax of pageFactory.initElements(choose last option in it, it has 2 args: driver (means 
//Driver script) & page means (webElements on current page, so we replace it with word 'this'))
// & 3)Page Action(which will specify specific methods needed for initializing each webElement)
//Here AddCustPg is being created. 
//Steps for this page are: 1) extend class to Driver Script as Driver Script is a parent generic class & it will 
//auto import for it.2)create OjRepos by identifying elements using syntax of @FindBy(write value of id/name/
//xpath, etc. within ("")WebElement & write name of that WebElement (name should be meaningful & contain its type in d end ex.link,
// text, etc.3)Create constructor of d pg that uses pageFactory syntax 4)Then in PageAction, 
//we verify display of AddCustomer header & create AddCustomPgFunctionalities method to validate
//all functions on AddCustPg. Within (), we parameterize the field names with dt type & name
//Then we call d identified elements.click/sentkeys with parameterized the field names within()
//(Identifying with xpath is best to get results). Here we use Helper.hightLightWebElement with name of specific 
//functionalities in ()before each step so that when test is run, those fields get highlighted.
package com.gconnectPages_allAppliPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gconnectBase_Parent_Generic.DriverScript;
import com.gconnectUtilities.Helper;

public class AddCustomerPage extends DriverScript
{
	@FindBy(linkText="//a[text()='Add Customer']")WebElement AddCustText;
	@FindBy(xpath=".//*[@id='main']/div/form/div/div[1]/label")WebElement BackGrondCkRadioBt;
	@FindBy(id="fname")WebElement FirstNameTextBox;
	@FindBy(id="lname")WebElement LastNameTextBox;
	@FindBy(id="email")WebElement EmailTextBoxBox;
	@FindBy(xpath="//textarea[@id='message']")WebElement AddressTextBox;
	@FindBy(id="telephoneno")WebElement TelePhNoTextBox;
	@FindBy(name="submit")WebElement SubmitRadioBt;
	@FindBy(xpath="(//td[@align='center'])[1]")	WebElement CustIDText;


	public AddCustomerPage()// create constructor in Page Initialization & use pageFactory syntax
	{
		PageFactory.initElements(driver, this);	
	}
 
	public boolean verifyAddCustomer()// Page Action: create method to verify d display of d heading
	{
		return AddCustText.isDisplayed();
	}
	
	public String validateAddCustomPgFunctionalities(String FN,String LN, String EM, String Addr,String TelNo)// String EM, String Add, String Tele)//other actions do not involve display but validation of info as  text input 
                       //so method will b for validation of Add Customer page functionalities, all actions within
                       //same code block with void return type & within () we will pass d dt type & field generic name so that it can be parameterized for any application
	{
		
		Helper.highLightElement(BackGrondCkRadioBt);// we will write this syntax before each step on d pg to get it highlighted
		BackGrondCkRadioBt.click();
		Helper.highLightElement(FirstNameTextBox);
		FirstNameTextBox.sendKeys(FN);
		Helper.highLightElement(LastNameTextBox);
		LastNameTextBox.sendKeys(LN);
		Helper.highLightElement(EmailTextBoxBox);
		EmailTextBoxBox.sendKeys(EM);
		Helper.scrollPage(driver); // we call in here Helper to scroll d page after email text box(we write Helper.choose scrollPage with driver in ()
		Helper.highLightElement(AddressTextBox);
		AddressTextBox.sendKeys(Addr);
		Helper.highLightElement(TelePhNoTextBox);
		TelePhNoTextBox.sendKeys(TelNo);
		Helper.highLightElement(SubmitRadioBt);
		SubmitRadioBt.click();
		Helper.highLightElement(CustIDText);
		return CustIDText.getText(); // we r creating a return type now (till previous steps, it was all void)but now after
	                   //clicking submit button, we want to see/return d CustIDText.getText on next page, so public void method will change to public String 
	}
}