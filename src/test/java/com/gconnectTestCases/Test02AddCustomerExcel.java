//This is for creating test cases for AddCustomerPage with multiple Data. steps:
//1) Extend d class to TestBase which has before & after method.2)Create constructor with super key word.
//3)create Test to validate fields on AddCustPg (jut like for Test02).4)Create Test to access 2 dimensional/multiple 
//data set. Within this first access ExcelHelper by creating its obj & row count< then write syntax for rows & colms
// using for loop & writing data within it

package com.gconnectTestCases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.gconnectUtilities.Excelhelper;

public class Test02AddCustomerExcel extends TestBase{ 
	
	
	public Test02AddCustomerExcel()
	{
		super();// super keyword initializes d constructor present in d parent class i.e in 
		                    //Driver Script (3 lines of code within try & catch about loading of property file 
		
	}
		
	@Test(dataProvider="AddCustPage")//in 2 dimensional, we use annotation of DataProvider, giving some name to it
	public void validateAddCustomerFunctions(String FN,String LN, String EM, String Addr, String TelePh)
	{
	    hp.clickAddCustomer();// this method we created on HmPg, so can directly call by d var name.
		String actual = acp.validateAddCustomPgFunctionalities(FN, LN, EM, Addr, TelePh);
		System.out.println(actual); //CustId will b printed
		AssertJUnit.assertEquals(actual,"Customer ID");//we use assert.assertequal to compare actual with expected (boolean, boolean)..		
	}
	
	@Test
	@DataProvider(name="AddCustPage")
	public Object[][]testData()//this is method for using 2 dimensional/multiple data
	{
		Excelhelper xl = new Excelhelper("C:\\FrameWork\\com.gconnect\\gcTestdata\\GConnectData.xlsx");// we create an obj of ExcelHelper file & give file path within() where data is located  
	    int rows = xl.getRowCount(0);// we use syntax to get row count & we pass value of 0 & store it in a var (i.e. row)
	    System.out.println("Number of rows : " + rows);
	    
	    Object[][] data = new Object[rows][5];// This is syntax for using 2 dimensional method where we create an Object & name of d object is data & [] will have generic row & in 2nd [] will have 5 as column.
		
	    for (int i=0; i<rows; i++) //for loop to run 5 times the data in excel file.
	    {
	    	data[i][0]=xl.getCellData(0,i, 0);// syntax for getting cell values where 0 is sheet no; i is ??, 0-4 r column nos.
	    	data[i][1]=xl.getCellData(0,i, 1); 
	    	data[i][2]=xl.getCellData(0,i, 2); 
	    	data[i][3]=xl.getCellData(0,i, 3); 
	    	data[i][4]=xl.getCellData(0,i, 4); 
	    }
		return data;
	}	
}

