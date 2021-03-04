package com.crm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.basepage.BasePage;
import org.apache.commons.io.FileUtils;

public class TestUtils extends BasePage {
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long Implicit_Wait=10;
	public static String test_sheet_path="../FreeCrmTestSuite/src/data/newcontact.xlsx";
	public static Workbook wb;
	public static Sheet sheet;
	static int rowcount;
	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream flib=null;
		try {
			flib=new FileInputStream(test_sheet_path);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		try {
			wb=	WorkbookFactory.create(flib);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=wb.getSheet(sheetname);
		rowcount=sheet.getLastRowNum();
		Object[][] data=new Object[rowcount][sheet.getRow(0).getLastCellNum()];
		for (int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(i).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
	File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir=System.getProperty("user.dir");
FileUtils.copyFile(scrFile, new File(currentDir+"/screeshots/"+System.currentTimeMillis()+".png"));
	}
}
