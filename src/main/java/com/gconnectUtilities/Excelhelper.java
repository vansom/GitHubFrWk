//This Generic package has generic things needed to help working on Excel & other data stuff
//we create Excel Helper class by <copying d class from other Eclipse instance(SeleniumAutom)/generic package
//ExcelHelper<paste in this Eclipse under gconectUtilities package<move mouse pointed over it &change d package 
//name to gconectUtilities<then extend d ExcelHelper class to DriverScript<save it<Go to src/test/java<TestCase Package
//copy Testo2AddCust<paste it on Package<change d name to Testo2AddCustExcel<go to TestData folder<Right Click<
//Show in< System Explorer< GconnectData<Click & open xl file & type cloumns in A,B,C, D, E as FirstName,Secondname
//EmailId, Address, & MobileNo with 1 next to all of it<then select d cell & use + to drag down & add series till row10
//Save it<Then go to Previous Eclipse (SeleniumAutom)<Within excelHandling package<click on DtDrExcelFrameWork<
//copy the last piece of code from @DataProvider to return data<open TestO2AddCustExcel & paste d code<add imports
//change args within()for name from actiDemo to AddCust<then go to gConnect.xlsx file under gcTestdata folder<Right
//click <properties<copy d path<paste it on previous path for ExcelHelper<change all to \\forward slash<change Object
// (rows,5)i.e. we get rows from ExcelHelper & have created 5 columns<then if for loop, create  5 lines of getCelldt
// with index for row as i only but index for column starts from 0 till 4(i.e.  lines)<Then in same page, change
//@Test to @Test(dataProvider= "addCust")<then delete hard codes for validateAddCustomerFunctionalities within()
// in the For loop code<then in method for public voidvalidateAddCustomerFunctionalities syntax, parameterize d 
//args by writing within()String FN,String LN,String EM, String Addr,String MobNo<then pass FN,LN,EM,Addr,MobNo in
//d () for d For loop code <run it<it will open d browser  & url & enter values in 5 fields as many times as we 
//created d data in Excel ....Tips: In Excel sheet in d column for MobileNo., select 1st mobileNo in d cell,on left side next to first no. press single quote key(')
// & press enter,an icon pops up in that cell, copy it & paste it other cells below it, else will throw error.
//
//
package com.gconnectUtilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.gconnectTestCases.TestBase;
//import org.apache.poi.xssf.usermodel.extensions.XSSFCellBorder;

public class Excelhelper extends TestBase{ // this class helps to access d the excel file & explore information related to it
	
	FileInputStream fis; // we create global var using 2nd & 3rd lines of syntax given within try code but we have to then remove their type in the syntax while we can leave the obj name in syntax as well
	XSSFWorkbook wb;
	
	public Excelhelper (String xlpath)//we create a constructor that can b parameterized with String type for xlpath. This constructor will only load xl file
	{ 
		try                  //we use try catch when w r loading external files. If file is not found, it will throw an error.Here it is Checked Exception as we have sysout in d catch section
		{
			File src = new File(xlpath); // we create an Obj of XL file; we write xlpath instead of a specific file path as we want to parameterize it with several xl file paths later on
			 fis = new FileInputStream(src);
			  wb = new XSSFWorkbook(fis);// we create an obj of Workbook where XLfile is created
			 
		}
		catch (Exception e)
		{
			System.out.println("No File Found");
		}
	}
	 
	//Uptill now we created a method to load xl file. Now we will load data. So this method is to get rowCount.
	public int getRowCount(int sheetNumber)//we create a method (getRowCount) where we pass within () the int as return type & sheetNumber as from where we want d rowCount from
	{
	   int rowCount = wb.getSheetAt(sheetNumber).getLastRowNum();// we use wb.getSheetAt & pass word 'sheetNumber' rather specific sheet no as want to parameterize it; then use getLastRowNum to total no of rows.Then we store it in a var with int return type 
	   rowCount=rowCount+1;
	   return rowCount;
	
    }

	//Method to get value from the Cell
	public String getCellData(int sheetNumber, int row, int col)// this will take 3 argument: sheet no/row no/column no; 
	{
		XSSFSheet sheet = wb.getSheetAt(sheetNumber);//syntax to get the xl sheet where we don't mention any specific sheet no but just generic name as sheetNumber
		String data = sheet.getRow(row).getCell(col).getStringCellValue();// syntax to get d parameterized row & col & cell value
		return data; 
		
	}
	//Method Overloading as we r using same method but paramerts that v r using r diff(ex. this method is same as previous one but parameters r diff 
		    
		       public String getCellData (String sheetName, int row, int col)
		       {
		    	   XSSFSheet sheet = wb.getSheetAt(0);//syntax to get the xl sheet where we dont mention any specific sheet no but just generic name as sheetNumber
		   		String data = sheet.getRow(row).getCell(col).getStringCellValue();// syntax to get d parameterized row & col & cell value
		   		return data;
		    	   
		    	   
		    	   
		       }
			
}	




	

